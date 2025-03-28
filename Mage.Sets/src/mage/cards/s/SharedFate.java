package mage.cards.s;

import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.AsThoughEffectImpl;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.game.ExileZone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.players.PlayerList;
import mage.target.common.TargetOpponent;
import mage.util.CardUtil;

import java.util.UUID;

/**
 * @author emerald000 / HCrescent
 */
public final class SharedFate extends CardImpl {

    public SharedFate(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{4}{U}");

        // If a player would draw a card, that player exiles the top card of one of their opponents' libraries face down instead.
        this.addAbility(new SimpleStaticAbility(new SharedFateReplacementEffect()));

        // Each player may look at and play cards they exiled with Shared Fate.
        this.addAbility(new SimpleStaticAbility(new SharedFatePlayEffect()));
        this.addAbility(new SimpleStaticAbility(new SharedFateLookEffect()));
    }

    private SharedFate(final SharedFate card) {
        super(card);
    }

    @Override
    public SharedFate copy() {
        return new SharedFate(this);
    }

    static String prepareExileKey(Game game, Ability source, Permanent sourcePermanent, UUID affectedControllerId) {
        return String.format("%s_%d_%s",
                source.getSourceId().toString(),
                sourcePermanent == null ? 0 : sourcePermanent.getZoneChangeCounter(game),
                affectedControllerId.toString()
        );
    }
}

class SharedFateReplacementEffect extends ReplacementEffectImpl {

    SharedFateReplacementEffect() {
        super(Duration.WhileOnBattlefield, Outcome.Neutral);
        this.staticText = "If a player would draw a card, that player exiles the top card of one of their opponents' libraries face down instead";
    }

    private SharedFateReplacementEffect(final SharedFateReplacementEffect effect) {
        super(effect);
    }

    @Override
    public SharedFateReplacementEffect copy() {
        return new SharedFateReplacementEffect(this);
    }

    @Override
    public boolean replaceEvent(GameEvent event, Ability source, Game game) {
        Permanent sourcePermanent = game.getPermanent(source.getSourceId());
        Player playerToDraw = game.getPlayer(event.getPlayerId());
        Player controller = game.getPlayer(source.getControllerId());
        PlayerList playersInRange = game.getState().getPlayersInRange(source.getControllerId(), game);
        if (sourcePermanent == null || playerToDraw == null || controller == null
                || !playersInRange.contains(playerToDraw.getId())) {
            return false;
        }

        TargetOpponent target = new TargetOpponent(true);
        if (!playerToDraw.choose(Outcome.DrawCard, target, source, game)) {
            return false;
        }

        Player chosenPlayer = game.getPlayer(target.getFirstTarget());
        if (chosenPlayer == null) {
            return false;
        }

        if (!playersInRange.contains(chosenPlayer.getId())) {
            game.informPlayers(
                    "Nothing exiled. " + playerToDraw.getLogName()
                            + " chose to exile from " + chosenPlayer.getLogName() + "'s library. "
                            + "That player is outside of " + controller.getLogName() + "'s range of influence."
            );
            return false;
        }

        game.informPlayers(playerToDraw.getLogName() + " chose to exile from " + chosenPlayer.getLogName() + "' library.");

        Card card = chosenPlayer.getLibrary().getFromTop(game);
        if (card == null) {
            return false;
        }

        UUID exileId = CardUtil.getExileZoneId(SharedFate.prepareExileKey(game, source, sourcePermanent, playerToDraw.getId()), game);
        String exileName = sourcePermanent.getIdName() + "-" + sourcePermanent.getZoneChangeCounter(game) + " (" + playerToDraw.getName() + ')';
        playerToDraw.moveCardsToExile(card, source, game, false, exileId, exileName);
        card.setFaceDown(true, game);
        return true;
    }

    @Override
    public boolean checksEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.DRAW_CARD;
    }

    @Override
    public boolean applies(GameEvent event, Ability source, Game game) {
        return true;
    }
}

class SharedFatePlayEffect extends AsThoughEffectImpl {

    SharedFatePlayEffect() {
        super(AsThoughEffectType.PLAY_FROM_NOT_OWN_HAND_ZONE, Duration.WhileOnBattlefield, Outcome.Benefit);
        staticText = "Each player may look at and play cards they exiled with {this}";
    }

    private SharedFatePlayEffect(final SharedFatePlayEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        return true;
    }

    @Override
    public SharedFatePlayEffect copy() {
        return new SharedFatePlayEffect(this);
    }

    @Override
    public boolean applies(UUID objectId, Ability source, UUID affectedControllerId, Game game) {
        if (game.getState().getZone(objectId) == Zone.EXILED) {
            Permanent sourcePermanent = game.getPermanentOrLKIBattlefield(source.getSourceId());
            UUID exileId = CardUtil.getExileZoneId(SharedFate.prepareExileKey(game, source, sourcePermanent, affectedControllerId), game);
            ExileZone exileZone = game.getExile().getExileZone(exileId);
            return exileZone != null && exileZone.contains(objectId);
        }
        return false;
    }
}

class SharedFateLookEffect extends AsThoughEffectImpl {

    SharedFateLookEffect() {
        super(AsThoughEffectType.LOOK_AT_FACE_DOWN, Duration.WhileOnBattlefield, Outcome.Benefit);
        staticText = "Each player may look at the cards exiled with {this}";
    }

    private SharedFateLookEffect(final SharedFateLookEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        return true;
    }

    @Override
    public SharedFateLookEffect copy() {
        return new SharedFateLookEffect(this);
    }

    @Override
    public boolean applies(UUID objectId, Ability source, UUID affectedControllerId, Game game) {
        if (game.getState().getZone(objectId) == Zone.EXILED) {
            Permanent sourcePermanent = game.getPermanentOrLKIBattlefield(source.getSourceId());
            UUID exileId = CardUtil.getExileZoneId(SharedFate.prepareExileKey(game, source, sourcePermanent, affectedControllerId), game);
            ExileZone exileZone = game.getExile().getExileZone(exileId);
            if (exileZone != null && exileZone.contains(objectId)) {
                Card card = game.getCard(objectId);
                return card != null && game.getState().getZone(objectId) == Zone.EXILED;
            }
        }
        return false;
    }
}
