package mage.cards.r;

import mage.abilities.Ability;
import mage.abilities.triggers.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.dynamicvalue.common.CountersSourceCount;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.counters.CounterType;
import mage.filter.FilterPermanent;
import mage.target.TargetPermanent;
import mage.target.targetadjustment.TargetsCountAdjuster;

import java.util.UUID;

/**
 *
 * @author TheElk801
 */
public final class RumblingCrescendo extends CardImpl {

    private static final FilterPermanent filter = new FilterPermanent("up to X target lands, where X is the number of verse counters on {this}");

    static {
        filter.add(CardType.LAND.getPredicate());
    }

    public RumblingCrescendo(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{3}{R}{R}");

        // At the beginning of your upkeep, you may put a verse counter on Rumbling Crescendo.
        this.addAbility(new BeginningOfUpkeepTriggeredAbility(
                new AddCountersSourceEffect(CounterType.VERSE.createInstance(), true), true));

        // {R}, Sacrifice Rumbling Crescendo: Destroy up to X target lands, where X is the number of verse counters on Rumbling Crescendo.        
        Effect effect = new DestroyTargetEffect(true);
        effect.setText("Destroy up to X target lands, where X is the number of verse counters on {this}.");
        Ability ability = new SimpleActivatedAbility(effect, new ManaCostsImpl<>("{R}"));
        ability.addCost(new SacrificeSourceCost());
        ability.addTarget(new TargetPermanent(0, 0, filter, false));
        ability.setTargetAdjuster(new TargetsCountAdjuster(new CountersSourceCount(CounterType.VERSE)));
        this.addAbility(ability);
    }

    private RumblingCrescendo(final RumblingCrescendo card) {
        super(card);
    }

    @Override
    public RumblingCrescendo copy() {
        return new RumblingCrescendo(this);
    }
}
