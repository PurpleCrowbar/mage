package mage.server;

import mage.cards.decks.Deck;
import mage.constants.ManaType;
import mage.constants.TableState;
import mage.game.Table;
import mage.game.draft.DraftPlayer;
import mage.game.result.ResultProtos;
import mage.game.tournament.TournamentPlayer;
import mage.interfaces.callback.ClientCallback;
import mage.interfaces.callback.ClientCallbackMethod;
import mage.players.net.UserData;
import mage.server.draft.DraftSession;
import mage.server.game.GameController;
import mage.server.game.GameSessionPlayer;
import mage.server.managers.ManagerFactory;
import mage.server.rating.GlickoRating;
import mage.server.rating.GlickoRatingSystem;
import mage.server.record.UserStats;
import mage.server.record.UserStatsRepository;
import mage.server.tournament.TournamentController;
import mage.server.tournament.TournamentSession;
import mage.server.util.ServerMessagesUtil;
import mage.utils.SystemUtil;
import mage.view.TableClientMessage;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author BetaSteward_at_googlemail.com, JayDi85
 */
public class User {

    private static final Logger logger = Logger.getLogger(User.class);

    public static final String ADMIN_NAME = "Admin"; // if you change here then change in SessionImpl too

    public enum UserState {
        Created, // Used if user is created an not connected to the session
        Connected, // Used if user is correctly connected
        Disconnected, // Used if the user lost connection
        Offline // Used if user was disconnected too long, offline users removes from users list by service routines
    }

    private final ManagerFactory managerFactory;
    private final UUID userId;
    private final String userName;
    private final String host;
    private final Date connectionTime;
    private final Map<UUID, Table> tables;
    private final List<UUID> tablesToDelete;
    private final Map<UUID, GameSessionPlayer> gameSessions;
    private final Map<UUID, DraftSession> draftSessions;
    private final Map<UUID, UUID> userTournaments; // playerId, tournamentId
    private final Map<UUID, TournamentSession> constructing;
    private final Map<UUID, Deck> sideboarding;
    private final List<UUID> watchedGames;
    private String sessionId;
    private String restoreSessionId; // keep sessionId for possible restore on reconnect
    private String pingInfo = "";
    private Date lastActivity;
    private UserState userState;
    private UserData userData;
    private UserStats userStats;
    private Date chatLockedUntil;
    private boolean active;
    private Date lockedUntil;
    private final AuthorizedUser authorizedUser;
    private String clientVersion;
    private String userIdStr;

    public User(ManagerFactory managerFactory, String userName, String host, AuthorizedUser authorizedUser) {
        this.managerFactory = managerFactory;
        this.userId = UUID.randomUUID();
        this.userName = userName;
        this.host = host;
        this.userState = UserState.Created;
        this.connectionTime = new Date();
        this.lastActivity = new Date();
        if (authorizedUser != null) {
            this.active = authorizedUser.active;
            this.chatLockedUntil = authorizedUser.chatLockedUntil;
            this.lockedUntil = authorizedUser.lockedUntil;
            this.authorizedUser = authorizedUser;
            updateAuthorizedUser();
        } else {
            this.active = true;
            this.chatLockedUntil = null;
            this.lockedUntil = null;
            this.authorizedUser = null;
        }

        this.tables = new ConcurrentHashMap<>();
        this.gameSessions = new ConcurrentHashMap<>();
        this.draftSessions = new ConcurrentHashMap<>();
        this.userTournaments = new ConcurrentHashMap<>();
        this.constructing = new ConcurrentHashMap<>();
        this.sideboarding = new ConcurrentHashMap<>();
        this.watchedGames = new ArrayList<>();
        this.tablesToDelete = new ArrayList<>();
        this.sessionId = "";
        this.clientVersion = "";
        this.userIdStr = "";
    }

    public String getName() {
        return userName;
    }

    public UUID getId() {
        return userId;
    }

    public String getHost() {
        return host;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getRestoreSessionId() {
        return restoreSessionId;
    }

    public Date getChatLockedUntil() {
        return chatLockedUntil;
    }

    public boolean isActive() {
        return active;
    }

    public Date getLockedUntil() {
        return lockedUntil;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setRestoreSessionId(String restoreSessionId) {
        this.restoreSessionId = restoreSessionId;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getUserIdStr() {
        return this.userIdStr;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setChatLockedUntil(Date chatLockedUntil) {
        this.chatLockedUntil = chatLockedUntil;
        updateAuthorizedUser();
    }

    public void setActive(boolean active) {
        this.active = active;
        updateAuthorizedUser();
    }

    public void setLockedUntil(Date lockedUntil) {
        this.lockedUntil = lockedUntil;
        updateAuthorizedUser();
    }

    /**
     * Shared code for any user disconnection
     * <p>
     * Full user instance remove will be done by reconnect or by server health check
     *
     * @param reason
     */
    public void onLostConnection(DisconnectReason reason) {
        // stats for bad connections only
        if (reason != DisconnectReason.DisconnectedByUser
                && reason != DisconnectReason.DisconnectedByUserButKeepTables) {
            ServerMessagesUtil.instance.incLostConnection();
        }

        // chats restored on reconnection from a scrach by game panels - so don't keep it
        managerFactory.chatManager().removeUser(userId, reason);

        // watched games don't get restored after reconnection call - so don't keep it
        for (Iterator<UUID> iterator = watchedGames.iterator(); iterator.hasNext(); ) {
            UUID gameId = iterator.next();
            managerFactory.gameManager().stopWatching(gameId, userId);
            iterator.remove();
        }

        // game tables
        if (reason.isRemoveUserTables) {
            // full disconnection
            removeUserFromAllTables(reason); // it's duplicates some chat/watch code inside, but it ok
            setUserState(UserState.Offline);
            managerFactory.userManager().removeUser(getId());
        } else {
            setUserState(UserState.Disconnected);
        }

        // kill active session
        String oldSessionId = sessionId;
        setSessionId("");
        managerFactory.sessionManager().disconnect(oldSessionId, reason, false);
    }

    public boolean isConnected() {
        return userState == UserState.Connected;
    }

    public String getDisconnectDuration() {
        //long secondsDisconnected = getSecondsDisconnected();
        //int minutes = (int) secondsDisconnected / 60;
        //int seconds = (int) secondsDisconnected % 60;
        //return Integer.toString(minutes) + ':' + (seconds > 9 ? seconds : '0' + Integer.toString(seconds));
        return getSecondsDisconnected() + " secs";
    }

    public long getSecondsDisconnected() {
        return SystemUtil.getDateDiff(lastActivity, new Date(), TimeUnit.SECONDS);
    }

    public Date getConnectionTime() {
        return connectionTime;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public String getConnectionDuration() {
        int minutes = (int) SystemUtil.getDateDiff(connectionTime, new Date(), TimeUnit.SECONDS) / 60;
        int hours = 0;
        if (minutes > 59) {
            hours = minutes / 60;
            minutes = minutes - (hours * 60);
        }
        String connTime = hours + ":" + (minutes > 9 ? Integer.toString(minutes) : '0' + Integer.toString(minutes));

        int lastSecs = (int) SystemUtil.getDateDiff(lastActivity, new Date(), TimeUnit.SECONDS);

        return " (online: " + connTime + "; seen: " + lastSecs + " sec ago)";
    }

    public void fireCallback(final ClientCallback call) {
        if (isConnected()) {
            managerFactory.sessionManager().getSession(sessionId).ifPresent(session
                    -> session.fireCallback(call)
            );
        }
    }

    public void ccJoinedTable(final UUID roomId, final UUID currentTableId, final UUID parentTableId, boolean isTournament) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.JOINED_TABLE,
                currentTableId,
                new TableClientMessage().withRoom(roomId).withTable(currentTableId, parentTableId).withFlag(isTournament)
        ));
    }

    public void ccGameStarted(final UUID currentTableId, final UUID parentTableId, final UUID gameId, final UUID playerId) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.START_GAME,
                gameId,
                new TableClientMessage().withTable(currentTableId, parentTableId).withGame(gameId).withPlayer(playerId)
        ));
    }

    public void ccDraftStarted(final UUID tableId, final UUID draftId, final UUID playerId) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.START_DRAFT,
                draftId,
                new TableClientMessage().withTable(tableId, null).withPlayer(playerId)
        ));
    }

    public void ccTournamentStarted(final UUID tableID, final UUID tournamentId, final UUID playerId) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.START_TOURNAMENT,
                tournamentId,
                new TableClientMessage().withTable(tableID, null).withPlayer(playerId)
        ));
    }

    public void ccSideboard(final Deck deck, final UUID currentTableId, final UUID parentTableId, final int time, boolean limited) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.SIDEBOARD,
                currentTableId,
                new TableClientMessage().withDeck(deck).withTable(currentTableId, parentTableId).withTime(time).withFlag(limited)
        ));
        sideboarding.put(currentTableId, deck);
    }

    public void ccViewLimitedDeck(final Deck deck, final UUID currentTableId, final UUID parentTableId, final int time, boolean limited) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.VIEW_LIMITED_DECK,
                currentTableId,
                new TableClientMessage().withDeck(deck).withTable(currentTableId, parentTableId).withTime(time).withFlag(limited)
        ));
    }

    public void ccViewSideboard(final UUID tableId, final UUID gameId, final UUID targetPlayerId) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.VIEW_SIDEBOARD,
                tableId,
                new TableClientMessage().withGame(gameId).withPlayer(targetPlayerId)
        ));
    }

    public void ccConstruct(final Deck deck, final UUID currentTableId, final UUID parentTableId, final int time) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.CONSTRUCT,
                currentTableId,
                new TableClientMessage().withDeck(deck).withTable(currentTableId, parentTableId).withTime(time)
        ));
    }

    public void ccShowTournament(final UUID tableId, final UUID tournamentId) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.SHOW_TOURNAMENT,
                tournamentId,
                new TableClientMessage().withTable(tableId, null)
        ));
    }

    public void showUserMessage(final String title, String message) {
        List<String> messageData = new LinkedList<>();
        messageData.add(title);
        messageData.add(message);
        fireCallback(new ClientCallback(ClientCallbackMethod.SHOW_USERMESSAGE, null, messageData));
    }

    public boolean ccWatchGame(final UUID currentTableId, final UUID parentTableId, final UUID gameId) {
        fireCallback(new ClientCallback(
                ClientCallbackMethod.WATCHGAME,
                gameId,
                new TableClientMessage().withTable(currentTableId, parentTableId)
        ));
        return true;
    }

    public void ccReplayGame(final UUID gameId) {
        fireCallback(new ClientCallback(ClientCallbackMethod.REPLAY_GAME, gameId));
    }

    public void sendPlayerUUID(final UUID gameId, final UUID data) {
        lastActivity = new Date();
        managerFactory.gameManager().sendPlayerUUID(gameId, userId, data);
    }

    public void sendPlayerString(final UUID gameId, final String data) {
        lastActivity = new Date();
        managerFactory.gameManager().sendPlayerString(gameId, userId, data);
    }

    public void sendPlayerManaType(final UUID gameId, final UUID playerId, final ManaType data) {
        lastActivity = new Date();
        managerFactory.gameManager().sendPlayerManaType(gameId, playerId, userId, data);
    }

    public void sendPlayerBoolean(final UUID gameId, final Boolean data) {
        lastActivity = new Date();
        managerFactory.gameManager().sendPlayerBoolean(gameId, userId, data);
    }

    public void sendPlayerInteger(final UUID gameId, final Integer data) {
        lastActivity = new Date();
        managerFactory.gameManager().sendPlayerInteger(gameId, userId, data);
    }

    public void updateLastActivity(String pingInfo) {
        if (pingInfo != null) {
            this.pingInfo = pingInfo;
        }
        lastActivity = new Date();
        setUserState(UserState.Connected);
    }

    public boolean isExpired(Date expired) {
        if (lastActivity.before(expired)) {
            logger.trace(userName + " is expired!");
            return true;
        }
        logger.trace("isExpired: User " + userName + " lastActivity: " + lastActivity + " expired: " + expired);
        return false;

    }

    /**
     * Restore all active tables and another data
     */
    public void onReconnect() {
        // TODO: research tables restore - it's old code, so check table state, timers, actions, ?concede?, ?skips?
        ServerMessagesUtil.instance.incReconnects();

        // active tables
        for (Entry<UUID, Table> entry : tables.entrySet()) {
            ccJoinedTable(entry.getValue().getRoomId(), entry.getValue().getId(), entry.getValue().getParentTableId(), entry.getValue().isTournament());
        }

        // active tourneys
        for (Iterator<Entry<UUID, UUID>> iterator = userTournaments.entrySet().iterator(); iterator.hasNext(); ) {
            Entry<UUID, UUID> next = iterator.next();
            Optional<TournamentController> tournamentController = managerFactory.tournamentManager().getTournamentController(next.getValue());
            if (tournamentController.isPresent()) {
                ccTournamentStarted(tournamentController.get().getTableId(), next.getValue(), next.getKey());
                tournamentController.get().rejoin(next.getKey());
            } else {
                iterator.remove(); // tournament has ended meanwhile
            }
        }

        // active games
        for (Entry<UUID, GameSessionPlayer> entry : gameSessions.entrySet()) {
            GameController gameController = managerFactory.gameManager().getGameController().getOrDefault(entry.getValue().getGameId(), null);
            if (gameController != null) {
                Table table = managerFactory.tableManager().getTable(gameController.getTableId());
                if (table != null) {
                    ccGameStarted(table.getId(), table.getParentTableId(), entry.getValue().getGameId(), entry.getKey());
                    entry.getValue().init();
                    managerFactory.gameManager().sendPlayerString(entry.getValue().getGameId(), userId, "");
                }
            }
        }

        // active drafts
        for (Entry<UUID, DraftSession> entry : draftSessions.entrySet()) {
            ccDraftStarted(entry.getValue().getDraft().getTableId(), entry.getValue().getDraft().getId(), entry.getKey());
            entry.getValue().init();
            entry.getValue().update();

            // on reconnect must resend booster data to new player
            // TODO: there are possible rare race conditions and user can get draft panel without game info, miss tourney panel, etc
            // TODO: client side - it must show active panel like current game or draft instead tourney panel
            DraftPlayer draftPlayer = entry.getValue().getDraftPlayer();
            if (draftPlayer != null) {
                draftPlayer.setBoosterNotLoaded();
                entry.getValue().getDraft().boosterSendingStart();
            }
        }

        // active constructing
        for (Entry<UUID, TournamentSession> entry : constructing.entrySet()) {
            entry.getValue().construct(0); // TODO: Check if this is correct
        }

        // active sideboarding
        for (Entry<UUID, Deck> entry : sideboarding.entrySet()) {
            TableController controller = managerFactory.tableManager().getController(entry.getKey()).orElse(null);
            if (controller != null) {
                ccSideboard(entry.getValue(), controller.getTable().getId(), controller.getTable().getParentTableId(), controller.getRemainingTime(), controller.getOptions().isLimited());
            } else {
                // Table is missing after connection was lost during sideboard.
                // Means other players were removed or conceded the game?
                logger.debug(getName() + " reconnects during sideboarding but tableId not found: " + entry.getKey());
            }
        }
    }

    public void addGame(UUID playerId, GameSessionPlayer gameSession) {
        gameSessions.put(playerId, gameSession);
    }

    public void removeGame(UUID playerId) {
        gameSessions.remove(playerId);
    }

    public void addDraft(UUID playerId, DraftSession draftSession) {
        draftSessions.put(playerId, draftSession);
    }

    public void removeDraft(UUID playerId) {
        draftSessions.remove(playerId);
    }

    public void addTournament(UUID playerId, UUID tournamentId) {
        userTournaments.put(playerId, tournamentId);
    }

    public void removeTournament(UUID playerId) {
        userTournaments.remove(playerId);
    }

    public void addTable(UUID playerId, Table table) {
        tables.put(playerId, table);
    }

    public void removeTable(UUID playerId) {
        tables.remove(playerId);
    }

    public void addConstructing(UUID playerId, TournamentSession tournamentSession) {
        constructing.put(playerId, tournamentSession);
    }

    public void removeConstructing(UUID playerId) {
        constructing.remove(playerId);
    }

    public void removeSideboarding(UUID tableId) {
        sideboarding.remove(tableId);
    }

    public void removeUserFromAllTables(DisconnectReason reason) {
        logger.trace("REMOVE " + userName + " Draft sessions " + draftSessions.size());
        for (DraftSession draftSession : draftSessions.values()) {
            draftSession.setKilled();
        }
        draftSessions.clear();
        logger.trace("REMOVE " + userName + " Tournament sessions " + userTournaments.size());
        for (UUID tournamentId : userTournaments.values()) {
            managerFactory.tournamentManager().quit(tournamentId, userId);
        }
        userTournaments.clear();
        constructing.clear();
        logger.trace("REMOVE " + userName + " Tables " + tables.size());
        for (Entry<UUID, Table> entry : tables.entrySet()) {
            logger.debug("-- leave tableId: " + entry.getValue().getId());
            managerFactory.tableManager().leaveTable(userId, entry.getValue().getId());
        }
        tables.clear();
        sideboarding.clear();
        logger.trace("REMOVE " + userName + " Game sessions: " + gameSessions.size());
        for (GameSessionPlayer gameSessionPlayer : gameSessions.values()) {
            logger.debug("-- kill game session of gameId: " + gameSessionPlayer.getGameId());
            managerFactory.gameManager().quitMatch(gameSessionPlayer.getGameId(), userId);
            gameSessionPlayer.quitGame();
        }
        gameSessions.clear();
        logger.trace("REMOVE " + userName + " watched Games " + watchedGames.size());
        for (Iterator<UUID> it = watchedGames.iterator(); it.hasNext(); ) { // Iterator to prevent ConcurrentModificationException
            UUID gameId = it.next();
            managerFactory.gameManager().stopWatching(gameId, userId);
        }
        watchedGames.clear();
        logger.trace("REMOVE " + userName + " Chats ");
        managerFactory.chatManager().removeUser(userId, reason);
    }

    public void setUserData(UserData userData) {
        if (this.userData != null) {
            this.userData.update(userData);
        } else {
            this.userData = userData;
            resetUserStats();
        }
    }

    public UserData getUserData() {
        if (userData == null) {// default these to avaiod NPE -> will be updated from client short after
            return UserData.getDefaultUserDataView();
        }
        return this.userData;
    }

    public String getGameInfo() {
        StringBuilder sb = new StringBuilder();

        int draft = 0, match = 0, sideboard = 0, tournament = 0, construct = 0, waiting = 0;

        for (Map.Entry<UUID, Table> tableEntry : tables.entrySet()) {
            if (tableEntry != null) {
                Table table = tableEntry.getValue();
                if (table != null) {
                    if (table.isTournament()) {
                        if (tableEntry.getKey() != null) {
                            TournamentPlayer tournamentPlayer = table.getTournament().getPlayer(tableEntry.getKey());
                            if (tournamentPlayer != null) {
                                if (!tournamentPlayer.isEliminated()) {
                                    switch (table.getState()) {
                                        case WAITING:
                                        case STARTING:
                                        case READY_TO_START:
                                            waiting++;
                                            break;
                                        case CONSTRUCTING:
                                            construct++;
                                            break;
                                        case DRAFTING:
                                            draft++;
                                            break;
                                        case DUELING:
                                            tournament++;
                                            break;
                                    }
                                    switch (getUserState()) {
                                        case Disconnected:
                                            tournamentPlayer.setDisconnectInfo(" (discon. " + getDisconnectDuration() + ')');
                                            break;
                                        case Offline:
                                            tournamentPlayer.setDisconnectInfo(" Offline");
                                            break;
                                        default:
                                            tournamentPlayer.setDisconnectInfo("");
                                    }
                                }
                            } else {
                                // can happen if tournamet has just ended
                                logger.debug(userName + " tournament player missing - tableId:" + table.getId(), null);
                                tablesToDelete.add(tableEntry.getKey());
                            }
                        } else {
                            logger.error(userName + " tournament key missing - tableId: " + table.getId(), null);
                        }
                    } else {
                        switch (table.getState()) {
                            case WAITING:
                            case STARTING:
                            case READY_TO_START:
                                waiting++;
                                break;
                            case SIDEBOARDING:
                                sideboard++;
                                break;
                            case DUELING:
                                match++;
                                break;
                        }
                    }
                }
            }
        }
        if (!tablesToDelete.isEmpty()) {
            for (UUID keyId : tablesToDelete) {
                removeTable(keyId);
            }
            tablesToDelete.clear();
        }
        if (waiting > 0) {
            sb.append("Wait: ").append(waiting).append(' ');
        }
        if (match > 0) {
            sb.append("Match: ").append(match).append(' ');
        }
        if (sideboard > 0) {
            sb.append("Sideb: ").append(sideboard).append(' ');
        }
        if (draft > 0) {
            sb.append("Draft: ").append(draft).append(' ');
        }
        if (construct > 0) {
            sb.append("Const: ").append(construct).append(' ');
        }
        if (tournament > 0) {
            sb.append("Tourn: ").append(tournament).append(' ');
        }
        if (!watchedGames.isEmpty()) {
            sb.append("Watch: ").append(watchedGames.size()).append(' ');
        }
        return sb.length() == 0 ? "not active" : sb.toString();
    }

    public void addGameWatchInfo(UUID gameId) {
        watchedGames.add(gameId);
    }

    public void removeGameWatchInfo(UUID gameId) {
        watchedGames.remove(gameId);
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public String getPingInfo() {
        switch (getUserState()) {
            case Disconnected:
                return " (discon. " + getDisconnectDuration() + ')';
            case Offline:
                return " Offline";
            default:
                return pingInfo + " " + getConnectionDuration();
        }
    }

    public void resetUserStats() {
        if (userData == null) {
            return;
        }
        userStats = UserStatsRepository.instance.getUser(this.userName);
        if (userStats != null) {
            ResultProtos.UserStatsProto userStatsProto = userStats.getProto();

            userData.setMatchHistory(userStatsToMatchHistory(userStatsProto));
            userData.setMatchQuitRatio(userStatsToMatchQuitRatio(userStatsProto));
            userData.setTourneyHistory(userStatsToTourneyHistory(userStatsProto));
            userData.setTourneyQuitRatio(userStatsToTourneyQuitRatio(userStatsProto));
            userData.setGeneralRating(userStatsToGeneralRating(userStatsProto));
            userData.setConstructedRating(userStatsToConstructedRating(userStatsProto));
            userData.setLimitedRating(userStatsToLimitedRating(userStatsProto));
        } else {
            userData.setMatchHistory("0");
            userData.setMatchQuitRatio(0);
            userData.setTourneyHistory("0");
            userData.setTourneyQuitRatio(0);
            userData.setGeneralRating(GlickoRatingSystem.getDefaultDisplayedRating());
            userData.setConstructedRating(GlickoRatingSystem.getDefaultDisplayedRating());
            userData.setLimitedRating(GlickoRatingSystem.getDefaultDisplayedRating());
        }
    }

    public String getMatchHistory() {
        if (userData != null) {
            return userData.getMatchHistory();
        }
        return "<not available>";
    }

    public int getMatchQuitRatio() {
        if (userData != null) {
            return userData.getMatchQuitRatio();
        }
        return 0;
    }

    public String getTourneyHistory() {
        if (userData != null) {
            return userData.getTourneyHistory();
        }
        return "<not available>";
    }

    public static String userStatsToHistory(ResultProtos.UserStatsProto proto) {
        // todo: add preference to hide rating?
        return "Matches:" + userStatsToMatchHistory(proto)
                + ", Tourneys: " + userStatsToTourneyHistory(proto)
                + ", Constructed Rating: " + userStatsToConstructedRating(proto)
                + ", Limited Rating: " + userStatsToLimitedRating(proto);
    }

    public int getTourneyQuitRatio() {
        if (userData != null) {
            return userData.getTourneyQuitRatio();
        }
        return 0;
    }

    public static String userStatsToMatchHistory(ResultProtos.UserStatsProto proto) {
        StringBuilder builder = new StringBuilder();
        builder.append(proto.getMatches());
        List<String> quit = new ArrayList<>();
        if (proto.getMatchesIdleTimeout() > 0) {
            quit.add("I:" + proto.getMatchesIdleTimeout());
        }
        if (proto.getMatchesTimerTimeout() > 0) {
            quit.add("T:" + proto.getMatchesTimerTimeout());
        }
        if (proto.getMatchesQuit() > 0) {
            quit.add("Q:" + proto.getMatchesQuit());
        }
        if (!quit.isEmpty()) {
            builder.append(" (");
            joinStrings(builder, quit, " ");
            builder.append(')');
        }
        return builder.toString();
    }

    public static int userStatsToMatchQuitRatio(ResultProtos.UserStatsProto proto) {
        int matches = proto.getMatches();
        if (matches == 0) {
            return 0;
        }
        int quits = proto.getMatchesIdleTimeout()
                + proto.getMatchesTimerTimeout()
                + proto.getMatchesQuit();
        return 100 * quits / matches;
    }

    public static String userStatsToTourneyHistory(ResultProtos.UserStatsProto proto) {
        StringBuilder builder = new StringBuilder();
        builder.append(proto.getTourneys());
        List<String> quit = new ArrayList<>();
        if (proto.getTourneysQuitDuringDrafting() > 0) {
            quit.add("D:" + proto.getTourneysQuitDuringDrafting());
        }
        if (proto.getTourneysQuitDuringConstruction() > 0) {
            quit.add("C:" + proto.getTourneysQuitDuringConstruction());
        }
        if (proto.getTourneysQuitDuringRound() > 0) {
            quit.add("R:" + proto.getTourneysQuitDuringRound());
        }
        if (!quit.isEmpty()) {
            builder.append(" (");
            joinStrings(builder, quit, " ");
            builder.append(')');
        }
        return builder.toString();
    }

    public static int userStatsToTourneyQuitRatio(ResultProtos.UserStatsProto proto) {
        int tourneys = proto.getTourneys();
        if (tourneys == 0) {
            return 0;
        }
        int quits = proto.getTourneysQuitDuringDrafting()
                + proto.getTourneysQuitDuringConstruction()
                + proto.getTourneysQuitDuringRound();
        return 100 * quits / tourneys;
    }

    private static int userStatsToGeneralRating(ResultProtos.UserStatsProto proto) {
        GlickoRating glickoRating;
        if (proto.hasGeneralGlickoRating()) {
            ResultProtos.GlickoRatingProto glickoRatingProto = proto.getGeneralGlickoRating();
            glickoRating = new GlickoRating(
                    glickoRatingProto.getRating(),
                    glickoRatingProto.getRatingDeviation(),
                    glickoRatingProto.getLastGameTimeMs());
        } else {
            glickoRating = GlickoRatingSystem.getInitialRating();
        }
        return GlickoRatingSystem.getDisplayedRating(glickoRating);
    }

    private static int userStatsToConstructedRating(ResultProtos.UserStatsProto proto) {
        GlickoRating glickoRating;
        if (proto.hasConstructedGlickoRating()) {
            ResultProtos.GlickoRatingProto glickoRatingProto = proto.getConstructedGlickoRating();
            glickoRating = new GlickoRating(
                    glickoRatingProto.getRating(),
                    glickoRatingProto.getRatingDeviation(),
                    glickoRatingProto.getLastGameTimeMs());
        } else {
            glickoRating = GlickoRatingSystem.getInitialRating();
        }
        return GlickoRatingSystem.getDisplayedRating(glickoRating);
    }

    private static int userStatsToLimitedRating(ResultProtos.UserStatsProto proto) {
        GlickoRating glickoRating;
        if (proto.hasLimitedGlickoRating()) {
            ResultProtos.GlickoRatingProto glickoRatingProto = proto.getLimitedGlickoRating();
            glickoRating = new GlickoRating(
                    glickoRatingProto.getRating(),
                    glickoRatingProto.getRatingDeviation(),
                    glickoRatingProto.getLastGameTimeMs());
        } else {
            glickoRating = GlickoRatingSystem.getInitialRating();
        }
        return GlickoRatingSystem.getDisplayedRating(glickoRating);
    }

    private static void joinStrings(StringBuilder joined, List<String> strings, String separator) {
        for (int i = 0; i < strings.size(); ++i) {
            if (i > 0) {
                joined.append(separator);
            }
            joined.append(strings.get(i));
        }
    }

    public int getNumberOfNotStartedTables() {
        int number = 0;
        for (Table table : tables.values()) {
            if (table.getState() == TableState.WAITING || table.getState() == TableState.STARTING) {
                number++;
            }
        }
        return number;
    }

    public int getNumberOfNotFinishedTables() {
        int number = 0;
        for (Table table : tables.values()) {
            if (table.getState() == TableState.FINISHED) {
                number++;
            } else {
                Optional<TableController> tableController = managerFactory.tableManager().getController(table.getId());
                if (!tableController.isPresent()) {
                    logger.error("table not found : " + table.getId());
                } else if (tableController.get().isUserStillActive(userId)) {
                    number++;
                }
            }
        }
        return number;
    }

    public String getEmail() {
        if (authorizedUser != null) {
            return authorizedUser.email;
        }
        return "";
    }

    private void updateAuthorizedUser() {
        if (authorizedUser != null) {
            authorizedUser.lastConnection = this.connectionTime;
            authorizedUser.chatLockedUntil = this.chatLockedUntil;
            authorizedUser.lockedUntil = this.lockedUntil;
            authorizedUser.active = this.active;
            AuthorizedUserRepository.getInstance().update(authorizedUser);
        }
    }

    public boolean isOnlineUser() {
        return this.getUserState() != User.UserState.Offline
                && !this.getName().equals(User.ADMIN_NAME);
    }
}
