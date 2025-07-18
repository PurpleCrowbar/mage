package mage.cards.g;

import mage.MageInt;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.condition.Condition;
import mage.abilities.condition.common.CardsInControllerGraveyardCondition;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.StaticFilters;

import java.util.UUID;

/**
 * @author weirddan455
 */
public final class GaeasCourser extends CardImpl {

    private static final Condition condition
            = new CardsInControllerGraveyardCondition(3, StaticFilters.FILTER_CARD_CREATURES);

    public GaeasCourser(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{4}{G}");

        this.subtype.add(SubType.CENTAUR);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(4);
        this.toughness = new MageInt(5);

        // Whenever Gaea's Courser attacks, if there are three or more creature cards in your graveyard, draw a card.
        this.addAbility(new AttacksTriggeredAbility(new DrawCardSourceControllerEffect(1)).withInterveningIf(condition));
    }

    private GaeasCourser(final GaeasCourser card) {
        super(card);
    }

    @Override
    public GaeasCourser copy() {
        return new GaeasCourser(this);
    }
}
