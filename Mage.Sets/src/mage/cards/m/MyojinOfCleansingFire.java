
package mage.cards.m;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.CastFromHandSourcePermanentCondition;
import mage.abilities.condition.common.SourceHasCounterCondition;
import mage.abilities.costs.common.RemoveCountersSourceCost;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.common.DestroyAllEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.keyword.IndestructibleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.counters.CounterType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;
import mage.watchers.common.CastFromHandWatcher;

/**
 * @author Loki
 */
public final class MyojinOfCleansingFire extends CardImpl {
    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("other creatures");

    static {
        filter.add(AnotherPredicate.instance);
    }

    public MyojinOfCleansingFire(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{5}{W}{W}{W}");
        this.supertype.add(SuperType.LEGENDARY);
        this.subtype.add(SubType.SPIRIT);

        this.power = new MageInt(4);
        this.toughness = new MageInt(6);

        this.getSpellAbility().addWatcher(new CastFromHandWatcher());

        // Myojin of Cleansing Fire enters the battlefield with a divinity counter on it if you cast it from your hand.
        this.addAbility(new EntersBattlefieldAbility(new ConditionalOneShotEffect(new AddCountersSourceEffect(CounterType.DIVINITY.createInstance()), CastFromHandSourcePermanentCondition.instance, ""), "with a divinity counter on it if you cast it from your hand"));
        // Myojin of Cleansing Fire has indestructible as long as it has a divinity counter on it.
        this.addAbility(new SimpleStaticAbility(new ConditionalContinuousEffect(new GainAbilitySourceEffect(IndestructibleAbility.getInstance(), Duration.WhileOnBattlefield),
                new SourceHasCounterCondition(CounterType.DIVINITY), "{this} has indestructible as long as it has a divinity counter on it")));
        // Remove a divinity counter from Myojin of Cleansing Fire: Destroy all other creatures.
        this.addAbility(new SimpleActivatedAbility(new DestroyAllEffect(filter), new RemoveCountersSourceCost(CounterType.DIVINITY.createInstance())));
    }

    private MyojinOfCleansingFire(final MyojinOfCleansingFire card) {
        super(card);
    }

    @Override
    public MyojinOfCleansingFire copy() {
        return new MyojinOfCleansingFire(this);
    }
}
