package mage.cards.s;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.triggers.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.common.ControlsPermanentsControllerTriggeredAbility;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.SacrificeSourceEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.filter.StaticFilters;
import mage.filter.common.FilterLandPermanent;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.common.TargetSacrifice;

import java.util.UUID;

/**
 * @author MarcoMarin
 */
public final class SerendibDjinn extends CardImpl {

    private static final FilterLandPermanent filter = new FilterLandPermanent("no lands");

    public SerendibDjinn(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{U}{U}");
        this.subtype.add(SubType.DJINN);
        this.power = new MageInt(5);
        this.toughness = new MageInt(6);

        // Flying
        this.addAbility(FlyingAbility.getInstance());
        // At the beginning of your upkeep, sacrifice a land. If you sacrifice an Island this way, Serendib Djinn deals 3 damage to you.
        this.addAbility(new BeginningOfUpkeepTriggeredAbility(new SerendibDjinnEffect()));
        // When you control no lands, sacrifice Serendib Djinn.
        this.addAbility(new ControlsPermanentsControllerTriggeredAbility(
                filter, ComparisonType.EQUAL_TO, 0,
                new SacrificeSourceEffect()));
    }

    private SerendibDjinn(final SerendibDjinn card) {
        super(card);
    }

    @Override
    public SerendibDjinn copy() {
        return new SerendibDjinn(this);
    }
}

class SerendibDjinnEffect extends OneShotEffect {

    SerendibDjinnEffect() {
        super(Outcome.Damage);
        this.staticText = "sacrifice a land. If you sacrifice an Island this way, {this} deals 3 damage to you";
    }

    private SerendibDjinnEffect(final SerendibDjinnEffect effect) {
        super(effect);
    }

    @Override
    public SerendibDjinnEffect copy() {
        return new SerendibDjinnEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            TargetSacrifice target = new TargetSacrifice(StaticFilters.FILTER_CONTROLLED_PERMANENT_LAND);
            if (target.canChoose(controller.getId(), source, game)) {
                controller.choose(Outcome.Sacrifice, target, source, game);
                Permanent permanent = game.getPermanent(target.getFirstTarget());
                if (permanent != null) {
                    permanent.sacrifice(source, game);
                    if (permanent.hasSubtype(SubType.ISLAND, game)) {
                        controller.damage(3, source.getSourceId(), source, game);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
