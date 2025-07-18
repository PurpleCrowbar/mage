package mage.cards.g;

import mage.Mana;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.common.TapTargetCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.mana.SimpleManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.filter.StaticFilters;
import mage.game.permanent.token.GreenAndWhiteElementalToken;

import java.util.UUID;

/**
 * @author LevelX2
 */
public final class GroveOfTheGuardian extends CardImpl {

    public GroveOfTheGuardian(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.LAND}, "");

        // {T}: Add {C}.
        this.addAbility(new SimpleManaAbility(Zone.BATTLEFIELD, Mana.ColorlessMana(1), new TapSourceCost()));

        // {3}{G}{W}, {T}, Tap two untapped creatures you control, Sacrifice Grove of the Guardian: Create an 8/8 green and white Elemental creature token with vigilance.
        Ability ability = new SimpleActivatedAbility(new CreateTokenEffect(new GreenAndWhiteElementalToken(), 1), new ManaCostsImpl<>("{3}{G}{W}"));
        ability.addCost(new TapSourceCost());
        ability.addCost(new TapTargetCost(2, StaticFilters.FILTER_CONTROLLED_UNTAPPED_CREATURES));
        ability.addCost(new SacrificeSourceCost());
        this.addAbility(ability);
    }

    private GroveOfTheGuardian(final GroveOfTheGuardian card) {
        super(card);
    }

    @Override
    public GroveOfTheGuardian copy() {
        return new GroveOfTheGuardian(this);
    }
}
