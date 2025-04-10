package mage.cards.p;

import mage.MageObject;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.costadjusters.ImprintedManaValueXCostAdjuster;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AbilityWord;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.filter.StaticFilters;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.game.permanent.token.Token;
import mage.players.Player;
import mage.target.TargetCard;
import mage.util.functions.CopyTokenFunction;

import java.util.UUID;

/**
 * @author nantuko
 */
public final class PrototypePortal extends CardImpl {

    public PrototypePortal(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "{4}");

        // Imprint - When Prototype Portal enters the battlefield, you may exile an artifact card from your hand.
        this.addAbility(new EntersBattlefieldTriggeredAbility(
                new PrototypePortalEffect(), true)
                .setAbilityWord(AbilityWord.IMPRINT)
        );

        // {X}, {T}: Create a token that's a copy of the exiled card. X is the converted mana cost of that card.
        Ability ability = new SimpleActivatedAbility(new PrototypePortalCreateTokenEffect(), new ManaCostsImpl<>("{X}"));
        ability.addCost(new TapSourceCost());
        ability.setCostAdjuster(ImprintedManaValueXCostAdjuster.instance);
        this.addAbility(ability);
    }

    private PrototypePortal(final PrototypePortal card) {
        super(card);
    }

    @Override
    public PrototypePortal copy() {
        return new PrototypePortal(this);
    }
}

class PrototypePortalEffect extends OneShotEffect {

    PrototypePortalEffect() {
        super(Outcome.Benefit);
        staticText = "exile an artifact card from your hand";
    }

    private PrototypePortalEffect(PrototypePortalEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        MageObject sourceObject = game.getObject(source);
        if (controller != null && sourceObject != null) {
            if (!controller.getHand().isEmpty()) {
                TargetCard target = new TargetCard(Zone.HAND, StaticFilters.FILTER_CARD_ARTIFACT);
                controller.choose(Outcome.Benefit, controller.getHand(), target, source, game);
                Card card = controller.getHand().get(target.getFirstTarget(), game);
                if (card != null) {
                    controller.moveCardsToExile(card, source, game, true, source.getSourceId(), sourceObject.getIdName() + " (Imprint)");
                    Permanent permanent = game.getPermanent(source.getSourceId());
                    if (permanent != null) {
                        permanent.imprint(card.getId(), game);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public PrototypePortalEffect copy() {
        return new PrototypePortalEffect(this);
    }

}

class PrototypePortalCreateTokenEffect extends OneShotEffect {

    PrototypePortalCreateTokenEffect() {
        super(Outcome.PutCreatureInPlay);
        this.staticText = "Create a token that's a copy of the exiled card. X is the mana value of that card";
    }

    private PrototypePortalCreateTokenEffect(final PrototypePortalCreateTokenEffect effect) {
        super(effect);
    }

    @Override
    public PrototypePortalCreateTokenEffect copy() {
        return new PrototypePortalCreateTokenEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent permanent = game.getPermanent(source.getSourceId());
        if (permanent == null) {
            return false;
        }

        if (!permanent.getImprinted().isEmpty()) {
            Card card = game.getCard(permanent.getImprinted().get(0));
            if (card != null) {
                Token token = CopyTokenFunction.createTokenCopy(card, game);
                token.putOntoBattlefield(1, game, source, source.getControllerId());
                return true;
            }
        }

        return false;
    }

}
