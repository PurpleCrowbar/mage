package mage.cards.s;

import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.continuous.AddCardTypeTargetEffect;
import mage.abilities.effects.common.continuous.SetBasePowerToughnessTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.filter.StaticFilters;
import mage.target.TargetPermanent;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class SuitUp extends CardImpl {

    public SuitUp(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{2}{U}");

        // Until end of turn, target creature or Vehicle becomes an artifact creature with base power and toughness 4/5.
        this.getSpellAbility().addEffect(new AddCardTypeTargetEffect(
                Duration.EndOfTurn, CardType.ARTIFACT, CardType.CREATURE
        ).setText("until end of turn, target creature or Vehicle becomes an artifact creature"));
        this.getSpellAbility().addEffect(new SetBasePowerToughnessTargetEffect(
                4, 5, Duration.EndOfTurn
        ).setText("with base power and toughness 4/5"));
        this.getSpellAbility().addTarget(new TargetPermanent(StaticFilters.FILTER_PERMANENT_CREATURE_OR_VEHICLE));

        // Draw a card.
        this.getSpellAbility().addEffect(new DrawCardSourceControllerEffect(1).concatBy("<br>"));
    }

    private SuitUp(final SuitUp card) {
        super(card);
    }

    @Override
    public SuitUp copy() {
        return new SuitUp(this);
    }
}
