package mage.target;

import mage.MageObject;
import mage.abilities.Ability;
import mage.cards.Card;
import mage.constants.AbilityType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.TargetEvent;
import mage.game.permanent.Permanent;
import mage.game.stack.Spell;
import mage.players.Player;
import mage.util.CardUtil;
import mage.util.RandomUtil;

import java.util.*;

/**
 * @author BetaSteward_at_googlemail.com
 */
public abstract class TargetImpl implements Target {

    protected final Map<UUID, Integer> targets = new LinkedHashMap<>();
    protected final Map<UUID, Integer> zoneChangeCounters = new HashMap<>();

    protected String targetName;
    protected Zone zone; // all targets will be filtered by that zone, don't use "multi-zone" filter
    protected int maxNumberOfTargets;
    protected int minNumberOfTargets;
    protected boolean required = true;
    protected boolean requiredExplicitlySet = false;
    /**
     * Simple chosen state due selected and require targets count
     * Complex targets must override isChosen method or set chosen value manually
     * For "up to" targets it will be false before first choose dialog:
     * - chosen = false - player do not make a choice yet
     * - chosen = true, targets.size = 0 - player choose 0 targets in "up to" and it's valid
     * - chosen = true, targets.size >= 1 - player choose some targets and it's valid
     */
    protected boolean chosen = false;

    // is the target handled as targeted spell/ability (notTarget = true is used for not targeted effects like e.g. sacrifice)
    protected boolean notTarget = false;
    protected boolean atRandom = false; // for inner choose logic
    protected UUID targetController = null; // if null the ability controller is the targetController
    protected UUID abilityController = null; // only used if target controller != ability controller

    protected int targetTag; // can be set if other target check is needed (AnotherTargetPredicate)
    protected String chooseHint = null; // UI choose hints after target name
    protected boolean shouldReportEvents = true; // generates TARGET and TARGETED events (can be disabled in non targeting mode, e.g. on target change)

    @Override
    public abstract TargetImpl copy();

    protected TargetImpl() {
        this(false);
    }

    protected TargetImpl(boolean notTarget) {
        this.notTarget = notTarget;
    }

    protected TargetImpl(final TargetImpl target) {
        this.targetName = target.targetName;
        this.zone = target.zone;
        this.maxNumberOfTargets = target.maxNumberOfTargets;
        this.minNumberOfTargets = target.minNumberOfTargets;
        this.required = target.required;
        this.requiredExplicitlySet = target.requiredExplicitlySet;
        this.chosen = target.chosen;
        this.targets.putAll(target.targets);
        this.zoneChangeCounters.putAll(target.zoneChangeCounters);
        this.atRandom = target.atRandom;
        this.notTarget = target.notTarget;
        this.targetController = target.targetController;
        this.abilityController = target.abilityController;
        this.targetTag = target.targetTag;
        this.chooseHint = target.chooseHint;
        this.shouldReportEvents = target.shouldReportEvents;
    }

    @Override
    public int getMinNumberOfTargets() {
        return this.minNumberOfTargets;
    }

    @Override
    public int getMaxNumberOfTargets() {
        return this.maxNumberOfTargets;
    }

    @Override
    public void setMinNumberOfTargets(int minNumberOftargets) {
        this.minNumberOfTargets = minNumberOftargets;
    }

    @Override
    public void setMaxNumberOfTargets(int maxNumberOftargets) {
        this.maxNumberOfTargets = maxNumberOftargets;
    }

    @Override
    public String getDescription() {
        // target description for ability text
        StringBuilder sb = new StringBuilder();
        int min = getMinNumberOfTargets();
        int max = getMaxNumberOfTargets();
        String targetName = getTargetName();
        if (min > 0 && max == Integer.MAX_VALUE) {
            sb.append(CardUtil.numberToText(min));
            sb.append(" or more ");
        } else if (!targetName.startsWith("X ") && !targetName.startsWith("up to ") && (min != 1 || max != 1)) {
            targetName = targetName.replace("another", "other"); //If non-singular, use "other" instead of "another"

            if (getUseAnyNumber()) {
                sb.append(("any number of "));
            } else {
                if (min < max && max != Integer.MAX_VALUE) {
                    if (min == 1 && max == 2) {
                        sb.append("one or ");
                    } else if (min == 1 && max == 3) {
                        sb.append("one, two, or ");
                    } else {
                        sb.append("up to ");
                    }
                }
                sb.append(CardUtil.numberToText(max));
                sb.append(' ');
            }
        }
        boolean addTargetWord = false;
        if (!isNotTarget()) {
            addTargetWord = true;
            if (targetName.contains("target ")) {
                addTargetWord = false;
            } else if (targetName.endsWith("any target")
                    || targetName.endsWith("any other target")
                    || targetName.endsWith("targets")) {
                addTargetWord = false;
            }
            // endsWith needs to be specific.
            // e.g. "spell with a single target" => need to prefix with "target ".
        }
        if (addTargetWord) {
            sb.append("target ");
        }
        if (isNotTarget() && min == 1 && max == 1) {
            sb.append(CardUtil.addArticle(targetName));
        } else {
            sb.append(targetName);
        }
        return sb.toString();
    }

    /**
     * Used for generating text description. Needed so that subclasses may override.
     */
    protected boolean getUseAnyNumber() {
        int min = getMinNumberOfTargets();
        int max = getMaxNumberOfTargets();
        return min == 0 && max == Integer.MAX_VALUE;
    }

    @Override
    public String getMessage(Game game) {
        // UI choose message
        String suffix = "";
        if (this.chooseHint != null) {
            suffix = " (" + this.chooseHint + ")";
        }
        if (getMaxNumberOfTargets() != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Select ").append(targetName);
            sb.append(" (selected ").append(targets.size());
            if (getMaxNumberOfTargets() > 0 && getMaxNumberOfTargets() != Integer.MAX_VALUE) {
                sb.append(" of ").append(getMaxNumberOfTargets());
            }
            if (getMinNumberOfTargets() > 0) {
                sb.append(", min ").append(getMinNumberOfTargets());
            }
            sb.append(')');
            sb.append(suffix);
            return sb.toString();
        }
        if (getMinNumberOfTargets() == 0 && getMaxNumberOfTargets() == 1) {
            return "Select up to one " + targetName + suffix;
        }
        return "Select " + CardUtil.addArticle(targetName) + suffix;
    }

    @Override
    public boolean isNotTarget() {
        return notTarget;
    }

    @Override
    public String getTargetName() {
        return targetName + (isRandom() ? " chosen at random" : "");
    }

    @Override
    public TargetImpl withTargetName(String name) {
        this.targetName = name;
        return this;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public boolean isRequired(UUID sourceId, Game game) {
        MageObject object = game.getObject(sourceId);
        if (!requiredExplicitlySet && object instanceof Ability) {
            return isRequired((Ability) object);
        } else {
            return isRequired();
        }
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public boolean isRequired(Ability ability) {
        return ability == null
                || ability.isActivated()
                || !(ability.getAbilityType() == AbilityType.SPELL || ability.getAbilityType().isActivatedAbility());
    }

    @Override
    public void setRequired(boolean required) {
        this.required = required;
        this.requiredExplicitlySet = true;
    }

    @Override
    public boolean isChosen(Game game) {
        // min = max = 0 - for abilities with X=0, e.g. nothing to choose
        if (getMaxNumberOfTargets() == 0 && getMinNumberOfTargets() == 0) {
            return true;
        }

        // limit by max amount
        if (getMaxNumberOfTargets() > 0 && targets.size() > getMaxNumberOfTargets()) {
            return false;
        }

        // limit by min amount
        if (getMinNumberOfTargets() > 0 && targets.size() < getMinNumberOfTargets()) {
            return false;
        }

        // all fine
        return chosen || (targets.size() >= getMinNumberOfTargets() && targets.size() <= getMaxNumberOfTargets());
    }

    @Override
    public boolean isChoiceCompleted(UUID abilityControllerId, Ability source, Game game) {
        // make sure target request called one time minimum (for "up to" targets)
        // choice is selected after any addTarget call (by test, AI or human players)
        if (!isChoiceSelected()) {
            return false;
        }

        // make sure selected targets are valid
        if (!isChosen(game)) {
            return false;
        }

        // make sure to auto-finish on all targets selection
        // - human player can select and deselect targets until fill all targets amount or press done button
        // - AI player can select all new targets as much as possible
        if (getMaxNumberOfTargets() > 0) {
            if (getMaxNumberOfTargets() == Integer.MAX_VALUE) {
                if (abilityControllerId != null && source != null) {
                    // any amount - nothing to choose
                    return this.getSize() >= this.possibleTargets(abilityControllerId, source, game).size();
                } else {
                    // any amount - any selected
                    return this.getSize() > 0;
                }
            } else {
                // check selected limit
                return this.getSize() >= getMaxNumberOfTargets();
            }
        }

        // all other use cases are fine
        return true;
    }

    @Override
    public void clearChosen() {
        targets.clear();
        zoneChangeCounters.clear();
        chosen = false;
    }

    @Override
    public boolean isChoiceSelected() {
        // min = max = 0 - for abilities with X=0, e.g. nothing to choose
        return chosen || getMaxNumberOfTargets() == 0 && getMinNumberOfTargets() == 0;
    }

    @Override
    public void add(UUID id, Game game) {
        if (getMaxNumberOfTargets() == 0 || targets.size() < getMaxNumberOfTargets()) {
            if (!targets.containsKey(id)) {
                targets.put(id, 0);
                rememberZoneChangeCounter(id, game);
                chosen = isChosen(game);
            }
        }
    }

    @Override
    public void remove(UUID id) {
        if (targets.containsKey(id)) {
            targets.remove(id); // TODO: miss chosen update here?
            zoneChangeCounters.remove(id);
        }
    }

    @Override
    public void addTarget(UUID id, Ability source, Game game) {
        addTarget(id, source, game, notTarget);
    }

    @Override
    public void addTarget(UUID id, Ability source, Game game, boolean skipEvent) {
        //20100423 - 113.3
        if (getMaxNumberOfTargets() == 0 || targets.size() < getMaxNumberOfTargets()) {
            if (!targets.containsKey(id)) {
                if (source != null && !skipEvent && shouldReportEvents) {
                    if (!game.replaceEvent(new TargetEvent(id, source))) {
                        targets.put(id, 0);
                        rememberZoneChangeCounter(id, game);
                        chosen = isChosen(game);
                        if (!skipEvent && shouldReportEvents) {
                            game.addSimultaneousEvent(GameEvent.getEvent(GameEvent.EventType.TARGETED, id, source, source.getControllerId()));
                        }
                    }
                } else {
                    targets.put(id, 0);
                    rememberZoneChangeCounter(id, game);
                    chosen = isChosen(game);
                }
            }
        }
    }

    @Override
    public void updateTarget(UUID id, Game game) {
        rememberZoneChangeCounter(id, game);
    }

    private void rememberZoneChangeCounter(UUID id, Game game) {
        Card card = game.getCard(id);
        if (card != null) {
            zoneChangeCounters.put(id, card.getZoneChangeCounter(game));
        }
    }

    @Override
    public void addTarget(UUID id, int amount, Ability source, Game game) {
        addTarget(id, amount, source, game, false);
    }

    @Override
    public void addTarget(UUID id, int amount, Ability source, Game game, boolean skipEvent) {
        if (targets.containsKey(id)) {
            amount += targets.get(id);
        }
        if (source != null && !skipEvent && shouldReportEvents) {
            if (!game.replaceEvent(GameEvent.getEvent(GameEvent.EventType.TARGET, id, source, source.getControllerId()))) {
                targets.put(id, amount);
                rememberZoneChangeCounter(id, game);
                chosen = isChosen(game);
                if (!skipEvent && shouldReportEvents) {
                    game.fireEvent(GameEvent.getEvent(GameEvent.EventType.TARGETED, id, source, source.getControllerId()));
                }
            }
        } else {
            // AI targets simulation
            targets.put(id, amount);
            rememberZoneChangeCounter(id, game);
            chosen = isChosen(game);
        }
    }

    @Override
    public boolean choose(Outcome outcome, UUID playerId, UUID sourceId, Ability source, Game game) {
        Player targetController = getTargetController(game, playerId);
        if (targetController == null) {
            return false;
        }

        UUID abilityControllerId = this.getAffectedAbilityControllerId(playerId);

        chosen = false;
        do {
            int prevTargetsCount = this.getTargets().size();

            // stop by disconnect
            if (!targetController.canRespond()) {
                break;
            }

            // stop by cancel/done
            if (!targetController.choose(outcome, this, source, game)) {
                break;
            }

            // TODO: miss auto-choose code? see chooseTarget below
            // TODO: miss random code? see chooseTarget below

            chosen = isChosen(game);

            // stop by full complete
            if (isChoiceCompleted(abilityControllerId, source, game)) {
                break;
            }

            // stop by nothing to use (actual for human and done button)
            if (prevTargetsCount == this.getTargets().size()) {
                break;
            }

            // can select next target
        } while (true);

        chosen = isChosen(game);
        return chosen && !this.getTargets().isEmpty();
    }

    @Override
    public boolean chooseTarget(Outcome outcome, UUID playerId, Ability source, Game game) {
        Player targetController = getTargetController(game, playerId);
        if (targetController == null) {
            return false;
        }

        UUID abilityControllerId = this.getAffectedAbilityControllerId(playerId);

        List<UUID> randomPossibleTargets = new ArrayList<>(possibleTargets(playerId, source, game));

        chosen = false;
        do {
            int prevTargetsCount = this.getTargets().size();

            // stop by disconnect
            if (!targetController.canRespond()) {
                break;
            }

            // MAKE A CHOICE
            if (isRandom()) {
                // random choice

                // stop on nothing to choose
                if (randomPossibleTargets.isEmpty()) {
                    break;
                }

                // add valid random target one by one
                while (!randomPossibleTargets.isEmpty()) {
                    UUID possibleTarget = RandomUtil.randomFromCollection(randomPossibleTargets);
                    if (this.canTarget(playerId, possibleTarget, source, game) && !this.contains(possibleTarget)) {
                        this.addTarget(possibleTarget, source, game);
                        randomPossibleTargets.remove(possibleTarget);
                        break;
                    } else {
                        randomPossibleTargets.remove(possibleTarget);
                    }
                }
                // continue to next target
            } else {
                // player's choice

                UUID autoChosenId = tryToAutoChoose(playerId, source, game);
                if (autoChosenId != null && !this.contains(autoChosenId)) {
                    // auto-choose
                    addTarget(autoChosenId, source, game);
                    // continue to next target (example: auto-choose must fill min/max = 2 from 2 possible cards)
                } else {
                    // manual

                    // stop by cancel/done
                    if (!targetController.chooseTarget(outcome, this, source, game)) {
                        break;
                    }

                    // continue to next target
                }
            }

            chosen = isChosen(game);

            // stop by full complete
            if (isChoiceCompleted(abilityControllerId, source, game)) {
                break;
            }

            // stop by nothing to choose (actual for human and done button?)
            if (prevTargetsCount == this.getTargets().size()) {
                break;
            }

            // can select next target
        } while (true);

        chosen = isChosen(game);
        return chosen && !this.getTargets().isEmpty();
    }

    @Override
    public boolean isLegal(Ability source, Game game) {
        //20101001 - 608.2b
        Set<UUID> illegalTargets = new HashSet<>();
        for (UUID targetId : targets.keySet()) {
            Card card = game.getCard(targetId);
            if (card != null) {
                // if a permanent, verify it is phased in, otherwise it is illegal
                Permanent p = game.getPermanent(targetId);
                if (p != null
                        && !p.isPhasedIn()) {
                    illegalTargets.add(targetId);
                    continue; // it's not legal so continue to have a look at other targeted objects
                }
                // check if the card moved to another zone
                if (zoneChangeCounters.containsKey(targetId)
                        && zoneChangeCounters.get(targetId) != card.getZoneChangeCounter(game)) {
                    illegalTargets.add(targetId);
                    continue; // it's not legal so continue to have a look at other targeted objects
                }
            }
            if (!notTarget && game.replaceEvent(new TargetEvent(targetId, source))) {
//                replacedTargets++;
                illegalTargets.add(targetId);
                continue;
            }
            if (!stillLegalTarget(source.getControllerId(), targetId, source, game)) {
                illegalTargets.add(targetId);
            }
        }
        // remove illegal targets, needed to handle if only a subset of targets was illegal
        for (UUID targetId : illegalTargets) {
            targets.remove(targetId);
        }
        if (targets.isEmpty()) {
            // If all targets that were set before are illegal now, the target is no longer legal
            if (!illegalTargets.isEmpty()) {
                return false;
            }
            // if no targets have to be set and no targets are set, that's legal
            if (getMinNumberOfTargets() == 0) {
                return true;
            }
        }

        return !targets.isEmpty();
    }

    @Override
    public List<? extends TargetImpl> getTargetOptions(Ability source, Game game) {
        List<TargetImpl> options = new ArrayList<>();
        List<UUID> possibleTargets = new ArrayList<>();
        possibleTargets.addAll(possibleTargets(source.getControllerId(), source, game));
        possibleTargets.removeAll(getTargets());

        // get the length of the array
        // e.g. for {'A','B','C','D'} => N = 4
        int N = possibleTargets.size();
        // not enough targets, return no option
        if (N < getMinNumberOfTargets()) {
            return options;
        }
        // not target but that's allowed, return one empty option
        if (N == 0) {
            TargetImpl target = this.copy();
            options.add(target);
            return options;
        }
        int maxK = getMaxNumberOfTargets() - getTargets().size();
        if (maxK > 5) { // Prevent endless iteration with targets set to INTEGER.maxvalue
            maxK = 5;
            if (N > 10) { // not more than 252 combinations
                maxK = 4;
            }
            if (N > 20) { // not more than 4845 combinations
                maxK = 3;
            }
        }
        if (N < maxK) { // less possible targets than the maximum allowed so reduce the max
            maxK = N;
        }
        int minK = getMinNumberOfTargets();
        if (getMinNumberOfTargets() == 0) { // add option without targets if possible
            TargetImpl target = this.copy();
            options.add(target);
            minK = 1;
        }
        for (int K = minK; K <= maxK; K++) {
            // get the combination by index
            // e.g. 01 --> AB , 23 --> CD
            int[] combination = new int[K];

            // position of current index
            //  if (r = 1)              r*
            //  index ==>        0   |   1   |   2
            //  element ==>      A   |   B   |   C
            int r = 0;
            int index = 0;

            while (r >= 0) {
                // possible indexes for 1st position "r=0" are "0,1,2" --> "A,B,C"
                // possible indexes for 2nd position "r=1" are "1,2,3" --> "B,C,D"

                // for r = 0 ==> index < (4+ (0 - 2)) = 2
                if (index <= (N + (r - K))) {
                    combination[r] = index;

                    // if we are at the last position print and increase the index
                    if (r == K - 1) {
                        //add the new target option
                        TargetImpl target = this.copy();
                        for (int i = 0; i < combination.length; i++) {
                            target.addTarget(possibleTargets.get(combination[i]), source, game, true);
                        }
                        options.add(target);
                        index++;
                    } else {
                        // select index for next position
                        index = combination[r] + 1;
                        r++;
                    }
                } else {
                    r--;
                    if (r > 0) {
                        index = combination[r] + 1;
                    } else {
                        index = combination[0] + 1;
                    }
                }
            }
        }
        return options;
    }

    @Override
    public List<UUID> getTargets() {
        return new ArrayList<>(targets.keySet());
    }

    @Override
    public int getTargetAmount(UUID targetId) {
        if (targets.containsKey(targetId)) {
            return targets.get(targetId);
        }
        return 0;
    }

    @Override
    public UUID getFirstTarget() {
        if (!targets.isEmpty()) {
            return targets.keySet().iterator().next();
        }
        return null;
    }

    @Override
    public boolean stillLegalTarget(UUID controllerId, UUID id, Ability source, Game game) {
        return canTarget(controllerId, id, source, game);
    }

    @Override
    public TargetImpl withNotTarget(boolean notTarget) {
        this.notTarget = notTarget;
        return this;
    }

    @Override
    public boolean isRandom() {
        return this.atRandom;
    }

    @Override
    public void setRandom(boolean atRandom) {
        this.atRandom = atRandom;
    }

    @Override
    public void setTargetController(UUID playerId) {
        this.targetController = playerId;
    }

    @Override
    public UUID getTargetController() {
        return targetController;
    }

    @Override
    public void setAbilityController(UUID playerId) {
        this.abilityController = playerId;
    }

    @Override
    public UUID getAbilityController() {
        return abilityController;
    }

    @Override
    public UUID getAffectedAbilityControllerId(UUID choosingPlayerId) {
        // controller hints:
        // - target.getTargetController(), this.getId(), choosingPlayerId -- player that must makes choices (must be same with this.getId)
        // - target.getAbilityController(), abilityControllerId -- affected player/controller for all actions/filters
        // - affected controller can be different from target controller (another player makes choices for controller)
        // sometimes a target selection can be made from a player that does not control the ability
        UUID abilityControllerId = choosingPlayerId;
        if (this.getAbilityController() != null) {
            abilityControllerId = this.getAbilityController();
        }
        return abilityControllerId;
    }

    @Override
    public Player getTargetController(Game game, UUID playerId) {
        if (getTargetController() != null) {
            return game.getPlayer(getTargetController());
        } else {
            return game.getPlayer(playerId);
        }
    }

    @Override
    public boolean isRequiredExplicitlySet() {
        return requiredExplicitlySet;
    }

    @Override
    public int getTargetTag() {
        return targetTag;
    }

    /**
     * Is used to be able to check, that another target is selected within the
     * group of targets of the ability with a target tag > 0.
     *
     * @param targetTag
     */
    @Override
    public TargetImpl setTargetTag(int targetTag) {
        this.targetTag = targetTag;
        return this;
    }

    @Override
    public Target getOriginalTarget() {
        return this;
    }

    @Override
    public void setTargetAmount(UUID targetId, int amount, Game game) {
        targets.put(targetId, amount);
        rememberZoneChangeCounter(targetId, game);
        chosen = isChosen(game);
    }

    @Override
    public Target withChooseHint(String chooseHint) {
        this.chooseHint = chooseHint;
        return this;
    }

    @Override
    public String getChooseHint() {
        return chooseHint;
    }

    @Override
    public void setEventReporting(boolean shouldReport) {
        this.shouldReportEvents = shouldReport;
    }

    @Override
    public int getSize() {
        return targets.size();
    }

    @Override
    public boolean contains(UUID targetId) {
        return targets.containsKey(targetId);
    }

    @Override
    public UUID tryToAutoChoose(UUID abilityControllerId, Ability source, Game game) {
        Set<UUID> possibleTargets = possibleTargets(abilityControllerId, source, game);
        possibleTargets.removeAll(this.targets.keySet());
        return tryToAutoChoose(abilityControllerId, source, game, possibleTargets);
    }

    @Override
    public UUID tryToAutoChoose(UUID abilityControllerId, Ability source, Game game, Collection<UUID> possibleTargets) {
        if (possibleTargets == null || game == null || source == null) {
            return null;
        }

        Player player = game.getPlayer(abilityControllerId);
        if (player == null) {
            return null;
        }
        int playerAutoTargetLevel;
        if (player.isHuman() && player.getControllingPlayersUserData(game) != null) { // Ensure that non-strictChooseMode ComputerPlayer will still use this ability
            playerAutoTargetLevel = player.getControllingPlayersUserData(game).getAutoTargetLevel();
        } else {
            playerAutoTargetLevel = 2;
        }

        // freeze protection on disconnect - auto-choice works for online players only
        boolean isOnline = player.canRespond();
        if (!player.isGameUnderControl()) {
            Player controllingPlayer = game.getPlayer(player.getTurnControlledBy());
            if (player.isHuman()) {
                isOnline = controllingPlayer.canRespond();
            }
        }

        String abilityText = source.getRule(true).toLowerCase();
        boolean strictModeEnabled = player.getStrictChooseMode();
        boolean canAutoChoose = this.getMinNumberOfTargets() == this.getMaxNumberOfTargets() // Targets must be picked
                && isOnline
                && possibleTargets.size() == this.getMinNumberOfTargets() - this.getSize() // Available targets are equal to the number that must be picked
                && !strictModeEnabled  // Test AI is not set to strictChooseMode(true)
                && playerAutoTargetLevel > 0 // Human player has enabled auto-choose in settings
                && !abilityText.contains("search"); // Do not autochoose for any effects which involve searching


        if (canAutoChoose) {
            boolean autoTargetAll = playerAutoTargetLevel == 2;
            for (UUID possibleChooseId : possibleTargets) {
                // Don't pick a target that's already been chosen, this will lead to an infinite loop of
                // choosen and unchoosing the same target.
                if (this.targets.containsKey(possibleChooseId)) {
                    continue;
                }
                if (autoTargetAll) { // No need for further checks since all targeting is to be automated
                    return possibleChooseId;
                }

                // Check if you control the target (or own the card)
                boolean targetingOwnThing;
                if (possibleChooseId == abilityControllerId) {
                    targetingOwnThing = true;
                } else {
                    Permanent targetPermanent = game.getPermanent(possibleChooseId);
                    Card targetCard = game.getCard(possibleChooseId);
                    Spell targetSpell = game.getSpell(possibleChooseId);
                    if (targetPermanent != null) {
                        targetingOwnThing = abilityControllerId == targetPermanent.getControllerId();
                    } else if (targetCard != null) {
                        targetingOwnThing = abilityControllerId == targetCard.getOwnerId();
                    } else if (targetSpell != null) {
                        targetingOwnThing = abilityControllerId == targetSpell.getControllerId();
                    } else {
                        // No point further checking
                        continue;
                    }
                }

                // If you control (or own the card) the target, check if it's one of the feel-bad effects.
                if (targetingOwnThing) {
                    if (abilityText.contains("discard")
                            || abilityText.contains("sacrifice")
                            || abilityText.contains("destroy")
                            || abilityText.contains("exile")) {
                        continue;
                    }
                    // Otherwise return the target with the return statement below.
                }

                // If we get here then it means that the target UUID passes the checks.
                return possibleChooseId;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + ", from " + this.getMinNumberOfTargets()
                + " to " + this.getMaxNumberOfTargets()
                + ", " + this.getDescription()
                + ", selected " + this.getTargets().size();
    }
}
