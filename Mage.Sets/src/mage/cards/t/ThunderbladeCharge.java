package mage.cards.t;

import mage.ApprovingObject;
import mage.abilities.Ability;
import mage.abilities.common.OneOrMoreCombatDamagePlayerTriggeredAbility;
import mage.abilities.condition.common.SourceInGraveyardCondition;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.effects.common.DoIfCostPaid;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.SetTargetPointer;
import mage.constants.Zone;
import mage.filter.StaticFilters;
import mage.game.Game;
import mage.players.Player;
import mage.target.common.TargetAnyTarget;

import java.util.UUID;

/**
 * @author LevelX2
 */
public final class ThunderbladeCharge extends CardImpl {

    public ThunderbladeCharge(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{1}{R}{R}");

        // Thunderblade Charge deals 3 damage to any target.
        this.getSpellAbility().addEffect(new DamageTargetEffect(3));
        this.getSpellAbility().addTarget(new TargetAnyTarget());

        // Whenever one or more creatures you control deal combat damage to a player, 
        // if Thunderblade Charge is in your graveyard, you may pay {2}{R}{R}{R}. 
        // If you do, you may cast it without paying its mana cost.
        this.addAbility(new OneOrMoreCombatDamagePlayerTriggeredAbility(Zone.GRAVEYARD,
                new DoIfCostPaid(new ThunderbladeChargeCastEffect(), new ManaCostsImpl<>("{2}{R}{R}{R}")),
                StaticFilters.FILTER_PERMANENT_CREATURES, SetTargetPointer.NONE, false
        ).withInterveningIf(SourceInGraveyardCondition.instance));
    }

    private ThunderbladeCharge(final ThunderbladeCharge card) {
        super(card);
    }

    @Override
    public ThunderbladeCharge copy() {
        return new ThunderbladeCharge(this);
    }
}

class ThunderbladeChargeCastEffect extends OneShotEffect {

    ThunderbladeChargeCastEffect() {
        super(Outcome.PutCreatureInPlay);
        this.staticText = "you may cast it without paying its mana cost";
    }

    private ThunderbladeChargeCastEffect(final ThunderbladeChargeCastEffect effect) {
        super(effect);
    }

    @Override
    public ThunderbladeChargeCastEffect copy() {
        return new ThunderbladeChargeCastEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        Card sourceCard = game.getCard(source.getSourceId());
        if (controller != null
                && sourceCard != null
                && Zone.GRAVEYARD == game.getState().getZone(sourceCard.getId())) {
            game.getState().setValue("PlayFromNotOwnHandZone" + sourceCard.getId(), Boolean.TRUE);
            boolean cardWasCast = controller.cast(controller.chooseAbilityForCast(sourceCard, game, true),
                    game, true, new ApprovingObject(source, game));
            game.getState().setValue("PlayFromNotOwnHandZone" + sourceCard.getId(), null);
            return cardWasCast;
        }
        return false;
    }
}
