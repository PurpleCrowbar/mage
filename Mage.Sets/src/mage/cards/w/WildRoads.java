package mage.cards.w;

import mage.abilities.Ability;
import mage.abilities.common.ActivateAsSorceryActivatedAbility;
import mage.abilities.common.EntersBattlefieldTappedUnlessAbility;
import mage.abilities.condition.Condition;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.mana.GreenManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.Predicates;
import mage.game.permanent.token.PilotSaddleCrewToken;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class WildRoads extends CardImpl {

    private static final FilterPermanent filter = new FilterControlledPermanent("you control a Mount or Vehicle");

    static {
        filter.add(Predicates.or(
                SubType.MOUNT.getPredicate(),
                SubType.VEHICLE.getPredicate()
        ));
    }

    private static final Condition condition = new PermanentsOnTheBattlefieldCondition(filter);

    public WildRoads(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.LAND}, "");


        // This land enters tapped unless you control a Mount or Vehicle.
        this.addAbility(new EntersBattlefieldTappedUnlessAbility(condition));

        // {T}: Add {G}.
        this.addAbility(new GreenManaAbility());

        // {1}{G}, {T}, Sacrifice this land: Create a 1/1 colorless Pilot creature token with "This token saddles Mounts and crews Vehicles as though its power were 2 greater." Activate only as a sorcery.
        Ability ability = new ActivateAsSorceryActivatedAbility(
                new CreateTokenEffect(new PilotSaddleCrewToken()), new ManaCostsImpl<>("{1}{G}")
        );
        ability.addCost(new TapSourceCost());
        ability.addCost(new SacrificeSourceCost());
        this.addAbility(ability);
    }

    private WildRoads(final WildRoads card) {
        super(card);
    }

    @Override
    public WildRoads copy() {
        return new WildRoads(this);
    }
}
