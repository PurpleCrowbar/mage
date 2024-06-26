package mage.filter.predicate.mageobject;

import mage.MageObject;
import mage.cards.CardWithHalves;
import mage.cards.SplitCard;
import mage.constants.SpellAbilityType;
import mage.filter.predicate.Predicate;
import mage.game.Game;
import mage.game.stack.Spell;
import mage.util.CardUtil;

/**
 * @author North
 */
public class NamePredicate implements Predicate<MageObject> {

    private final String name;
    private final Boolean ignoreMtgRuleForEmptyNames; // NamePredicate uses at test and checks, it's must ignore that rules (empty names is not equals in mtg)

    /**
     * For cards/effects, must have a name to search
     *
     * @param name empty name for non-selected target/choice, e.g. return nothing
     */
    public NamePredicate(String name) {
        this(name, false);
    }

    /**
     * For tests only, can find face down permanents too
     *
     * @param name
     * @param ignoreMtgRuleForEmptyNames
     */
    public NamePredicate(String name, Boolean ignoreMtgRuleForEmptyNames) {
        this.name = name;
        this.ignoreMtgRuleForEmptyNames = ignoreMtgRuleForEmptyNames;
    }

    @Override
    public boolean apply(MageObject input, Game game) {
        if (name == null) {
            return false;
        }
        // If a player names a card, the player may name either half of a split card, but not both. 
        // A split card has the chosen name if one of its two names matches the chosen name.
        // This is NOT the same for double faced cards, where only the front side matches

        // Test of Talents ruling:
        // If the back face of a modal double-faced card is countered, you will not be able to exile any cards,
        // including the one that you countered, because those cards have only their front-face characteristics
        // (including name) in the graveyard, hand, and library. (2021-04-16)

        if (input instanceof SplitCard) {
            return CardUtil.haveSameNames(name, ((CardWithHalves) input).getLeftHalfCard().getName(), this.ignoreMtgRuleForEmptyNames) ||
                    CardUtil.haveSameNames(name, ((CardWithHalves) input).getRightHalfCard().getName(), this.ignoreMtgRuleForEmptyNames) ||
                    CardUtil.haveSameNames(name, input.getName(), this.ignoreMtgRuleForEmptyNames);
        } else if (input instanceof Spell && ((Spell) input).getSpellAbility().getSpellAbilityType() == SpellAbilityType.SPLIT_FUSED) {
            SplitCard card = (SplitCard) ((Spell) input).getCard();
            return CardUtil.haveSameNames(name, card.getLeftHalfCard().getName(), this.ignoreMtgRuleForEmptyNames) ||
                    CardUtil.haveSameNames(name, card.getRightHalfCard().getName(), this.ignoreMtgRuleForEmptyNames) ||
                    CardUtil.haveSameNames(name, card.getName(), this.ignoreMtgRuleForEmptyNames);
        } else if (input instanceof Spell && ((Spell) input).isFaceDown(game)) {
            // face down spells don't have names, so it's not equal, see https://github.com/magefree/mage/issues/6569
            return false;
        } else {
            if (name.contains(" // ")) {
                String leftName = name.substring(0, name.indexOf(" // "));
                String rightName = name.substring(name.indexOf(" // ") + 4);
                return CardUtil.haveSameNames(leftName, input.getName(), this.ignoreMtgRuleForEmptyNames) ||
                        CardUtil.haveSameNames(rightName, input.getName(), this.ignoreMtgRuleForEmptyNames);
            } else {
                return CardUtil.haveSameNames(name, input.getName(), this.ignoreMtgRuleForEmptyNames);
            }
        }
    }

    @Override
    public String toString() {
        return "Name (" + name + ')';
    }
}
