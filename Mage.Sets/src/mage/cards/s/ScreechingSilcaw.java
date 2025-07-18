package mage.cards.s;

import mage.MageInt;
import mage.abilities.common.DealsCombatDamageToAPlayerTriggeredAbility;
import mage.abilities.condition.common.MetalcraftCondition;
import mage.abilities.effects.common.MillCardsTargetEffect;
import mage.abilities.hint.common.MetalcraftHint;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AbilityWord;
import mage.constants.CardType;
import mage.constants.SubType;

import java.util.UUID;

/**
 * @author ayratn
 */
public final class ScreechingSilcaw extends CardImpl {

    public ScreechingSilcaw(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{U}");
        this.subtype.add(SubType.BIRD);
        this.power = new MageInt(1);
        this.toughness = new MageInt(2);

        // Flying
        this.addAbility(FlyingAbility.getInstance());

        //"<i>Metalcraft</i> &mdash; Whenever Screeching Silcaw deals combat damage to a player, if you control three or more artifacts, that player puts the top four cards of their library into their graveyard.
        this.addAbility(new DealsCombatDamageToAPlayerTriggeredAbility(
                new MillCardsTargetEffect(4), false, true
        ).withInterveningIf(MetalcraftCondition.instance).setAbilityWord(AbilityWord.METALCRAFT).addHint(MetalcraftHint.instance));
    }

    private ScreechingSilcaw(final ScreechingSilcaw card) {
        super(card);
    }

    @Override
    public ScreechingSilcaw copy() {
        return new ScreechingSilcaw(this);
    }
}
