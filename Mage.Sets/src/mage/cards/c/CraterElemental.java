package mage.cards.c;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.ActivateIfConditionActivatedAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.condition.common.FormidableCondition;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.effects.common.continuous.SetBasePowerSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AbilityWord;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.target.common.TargetCreaturePermanent;

import java.util.UUID;

/**
 * @author fireshoes
 */
public final class CraterElemental extends CardImpl {

    public CraterElemental(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{R}");
        this.subtype.add(SubType.ELEMENTAL);
        this.power = new MageInt(0);
        this.toughness = new MageInt(6);

        // {R}, {T}, Sacrifice Crater Elemental: Crater Elemental deals 4 damage to target creature.
        Ability ability = new SimpleActivatedAbility(
                new DamageTargetEffect(4, "it"), new ManaCostsImpl<>("{R}")
        );
        ability.addCost(new TapSourceCost());
        ability.addCost(new SacrificeSourceCost());
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);

        // <i>Formidable</i> &mdash; {2}{R}: Crater Elemental has base power 8 until end of turn. Activate this ability only if creatures you control have total power 8 or greater.
        this.addAbility(new ActivateIfConditionActivatedAbility(
                new SetBasePowerSourceEffect(8, Duration.EndOfTurn),
                new ManaCostsImpl<>("{2}{R}"), FormidableCondition.instance
        ).setAbilityWord(AbilityWord.FORMIDABLE));
    }

    private CraterElemental(final CraterElemental card) {
        super(card);
    }

    @Override
    public CraterElemental copy() {
        return new CraterElemental(this);
    }
}
