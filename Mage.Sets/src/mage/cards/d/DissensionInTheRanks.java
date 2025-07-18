package mage.cards.d;

import mage.abilities.effects.common.FightTargetsEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.other.AnotherTargetPredicate;
import mage.filter.predicate.permanent.BlockingPredicate;
import mage.target.TargetPermanent;

import java.util.UUID;

/**
 * @author LevelX2
 */
public final class DissensionInTheRanks extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("blocking creature");
    private static final FilterCreaturePermanent filter2 = new FilterCreaturePermanent("another target blocking creature");

    static {
        filter.add(BlockingPredicate.instance);
        filter2.add(new AnotherTargetPredicate(2));
        filter2.add(BlockingPredicate.instance);
    }

    public DissensionInTheRanks(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{3}{R}{R}");

        // Target blocking creature fights another target blocking creature.
        this.getSpellAbility().addEffect(new FightTargetsEffect(false));
        this.getSpellAbility().addTarget(new TargetPermanent(filter).setTargetTag(1));
        this.getSpellAbility().addTarget(new TargetPermanent(filter2).setTargetTag(2));
    }

    private DissensionInTheRanks(final DissensionInTheRanks card) {
        super(card);
    }

    @Override
    public DissensionInTheRanks copy() {
        return new DissensionInTheRanks(this);
    }
}
