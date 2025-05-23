package mage.cards;

import mage.MageObject;
import mage.Mana;
import mage.abilities.Abilities;
import mage.abilities.Ability;
import mage.abilities.SpellAbility;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.counters.Counter;
import mage.counters.Counters;
import mage.filter.FilterMana;
import mage.game.Game;
import mage.game.GameState;
import mage.game.Ownerable;
import mage.game.permanent.Permanent;
import mage.util.ManaUtil;
import mage.watchers.common.CommanderPlaysCountWatcher;

import java.util.List;
import java.util.UUID;

public interface Card extends MageObject, Ownerable {

    Rarity getRarity(); // null for tokens

    void setRarity(Rarity rarity);

    void setOwnerId(UUID ownerId);

    /**
     * For cards: return all basic and dynamic abilities
     * For permanents: return all basic and dynamic abilities
     *
     * @param game
     * @return
     */
    Abilities<Ability> getAbilities(Game game);

    void setSpellAbility(SpellAbility ability);

    SpellAbility getSpellAbility();

    List<String> getRules(); // gets base card rules

    List<String> getRules(Game game);  // gets card rules + in game modifications

    /**
     * Find ETB counters and apply it to permanent.
     * Warning, it's one time action, use it before a put to battlefield only.
     */
    void applyEnterWithCounters(Permanent permanent, Ability source, Game game);

    void setFaceDown(boolean value, Game game);

    boolean isFaceDown(Game game);

    boolean turnFaceUp(Ability source, Game game, UUID playerId);

    // TODO: need research, is it lost morph and other face down statuses?
    boolean turnFaceDown(Ability source, Game game, UUID playerId);

    boolean isFlipCard();

    String getFlipCardName();

    boolean isTransformable();

    Card getSecondCardFace();

    SpellAbility getSecondFaceSpellAbility();

    boolean isNightCard();

    default boolean meldsWith(Card card) {
        return false;
    }

    default Class<? extends Card> getMeldsToClazz() {
        return null;
    }

    default MeldCard getMeldsToCard() {
        return null;
    }

    /**
     * Is this an extra deck card? (such as contraptions and attractions)
     *
     * @return true if this is an extra deck card, false otherwise
     */
    default boolean isExtraDeckCard() {
        return false;
    }

    void assignNewId();

    void addInfo(String key, String value, Game game);

    // WARNING, don't add new move/remove methods (if you add then you must override it in all multi-part cards like Split or MDF)

    /**
     * Moves the card to the specified zone
     *
     * @param zone
     * @param source ability which calls that move, can be null
     * @param game
     * @param flag   If zone
     *               <ul>
     *               <li>LIBRARY: <ul><li>true - put on top</li><li>false - put on
     *               bottom</li></ul></li>
     *               <li>BATTLEFIELD: <ul><li>true - tapped</li><li>false -
     *               untapped</li></ul></li>
     *               </ul>
     * @return true if card was moved to zone
     */
    boolean moveToZone(Zone zone, Ability source, Game game, boolean flag);

    boolean moveToZone(Zone zone, Ability source, Game game, boolean flag, List<UUID> appliedEffects);

    /**
     * Moves the card to an exile zone
     *
     * @param exileId set to null for generic exile zone
     * @param name    used for exile zone with the specified exileId
     * @param source
     * @param game
     * @return true if card was moved to zone
     */
    boolean moveToExile(UUID exileId, String name, Ability source, Game game);

    boolean moveToExile(UUID exileId, String name, Ability source, Game game, List<UUID> appliedEffects);

    boolean cast(Game game, Zone fromZone, SpellAbility ability, UUID controllerId);

    // WARNING, don't add new move/remove methods (if you add then you must override it in all multi-parts card like Split Half or MDF Half)
    boolean removeFromZone(Game game, Zone fromZone, Ability source);

    boolean putOntoBattlefield(Game game, Zone fromZone, Ability source, UUID controllerId);

    boolean putOntoBattlefield(Game game, Zone fromZone, Ability source, UUID controllerId, boolean tapped);

    boolean putOntoBattlefield(Game game, Zone fromZone, Ability source, UUID controllerId, boolean tapped, boolean facedown);

    boolean putOntoBattlefield(Game game, Zone fromZone, Ability source, UUID controllerId, boolean tapped, boolean facedown, List<UUID> appliedEffects);

    void setZone(Zone zone, Game game);

    List<Mana> getMana();

    Counters getCounters(Game game);

    Counters getCounters(GameState state);

    void addAbility(Ability ability);

    void looseAllAbilities(Game game);

    boolean addCounters(Counter counter, Ability source, Game game);

    boolean addCounters(Counter counter, UUID playerAddingCounters, Ability source, Game game);

    boolean addCounters(Counter counter, UUID playerAddingCounters, Ability source, Game game, boolean isEffect);

    boolean addCounters(Counter counter, UUID playerAddingCounters, Ability source, Game game, List<UUID> appliedEffects);

    boolean addCounters(Counter counter, UUID playerAddingCounters, Ability source, Game game, List<UUID> appliedEffects, boolean isEffect);

    boolean addCounters(Counter counter, UUID playerAddingCounters, Ability source, Game game, List<UUID> appliedEffects, boolean isEffect, int maxCounters);

    /**
     * Remove {@param amount} counters of the specified kind.
     */
    default void removeCounters(String counterName, int amount, Ability source, Game game) {
        removeCounters(counterName, amount, source, game, false);
    }

    /**
     * Remove {@param amount} counters of the specified kind.
     *
     * @param isDamage if the counter removal is a result of being damaged (e.g. for Deification to work)
     * @return amount of counters removed
     */
    int removeCounters(String counterName, int amount, Ability source, Game game, boolean isDamage);

    default int removeCounters(Counter counter, Ability source, Game game) {
        return removeCounters(counter, source, game, false);
    }

    /**
     * Remove all counters of any kind.
     *
     * @param isDamage if the counter removal is a result of being damaged (e.g. for Deification to work)
     * @return amount of counters removed
     */
    int removeCounters(Counter counter, Ability source, Game game, boolean isDamage);

    /**
     * Remove all counters of any kind.
     *
     * @return the amount of counters removed this way.
     */
    default int removeAllCounters(Ability source, Game game) {
        return removeAllCounters(source, game, false);
    }

    /**
     * Remove all counters of any kind.
     *
     * @param isDamage if the counter removal is a result of being damaged (e.g. for Deification to work)
     * @return the amount of counters removed this way.
     */
    int removeAllCounters(Ability source, Game game, boolean isDamage);

    /**
     * Remove all counters of a specific kind. Return the amount of counters removed this way.
     *
     * @return the amount of counters removed this way.
     */
    default int removeAllCounters(String counterName, Ability source, Game game) {
        return removeAllCounters(counterName, source, game, false);
    }

    /**
     * Remove all counters of a specific kind. Return the amount of counters removed this way.
     *
     * @param isDamage if the counter removal is a result of being damaged (e.g. for Deification to work)
     * @return the amount of counters removed this way.
     */
    int removeAllCounters(String counterName, Ability source, Game game, boolean isDamage);

    @Override
    Card copy();

    /**
     * @return The main card of a split half card or adventure spell card,
     * otherwise the card itself is returned
     */
    Card getMainCard();

    /**
     * Gets the colors that are in the casting cost but also in the rules text
     * as far as not included in reminder text.
     *
     * @return
     */
    FilterMana getColorIdentity();

    List<UUID> getAttachments();

    boolean addAttachment(UUID permanentId, Ability source, Game game);

    boolean removeAttachment(UUID permanentId, Ability source, Game game);

    default boolean isOwnedBy(UUID controllerId) {
        return getOwnerId().equals(controllerId);
    }

    /**
     * Commander tax calculation. Tax logic can be changed (example: from {2} to life cost, see Liesa, Shroud of Dusk)
     *
     * @param game
     * @param source
     * @param abilityToModify
     * @return
     */
    default boolean commanderCost(Game game, Ability source, Ability abilityToModify) {
        CommanderPlaysCountWatcher watcher = game.getState().getWatcher(CommanderPlaysCountWatcher.class);
        int castCount = watcher.getPlaysCount(getMainCard().getId());
        if (castCount > 0) {
            abilityToModify.addManaCostsToPay(ManaUtil.createManaCost(2 * castCount, false));
        }
        return true;
    }

    List<CardType> getCardTypeForDeckbuilding();

    boolean hasCardTypeForDeckbuilding(CardType cardType);

    /**
     * Checking subtype in cards for deck and companion validation
     *
     * @param subType
     * @return
     */
    boolean hasSubTypeForDeckbuilding(SubType subType);
}
