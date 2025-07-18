package mage.cards.u;

import mage.ApprovingObject;
import mage.MageObjectReference;
import mage.abilities.Ability;
import mage.abilities.SpellAbility;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SpellCastControllerTriggeredAbility;
import mage.abilities.condition.Condition;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.ContinuousEffectImpl;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.effects.common.counter.RemoveCounterSourceEffect;
import mage.abilities.triggers.BeginningOfUpkeepTriggeredAbility;
import mage.cards.*;
import mage.constants.*;
import mage.counters.CounterType;
import mage.filter.StaticFilters;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.players.Player;
import mage.target.TargetCard;
import mage.target.common.TargetCardInHand;
import mage.util.CardUtil;

import java.util.Objects;
import java.util.UUID;

/**
 * @author TheElk801
 */
public final class UvildaDeanOfPerfection extends ModalDoubleFacedCard {

    public UvildaDeanOfPerfection(UUID ownerId, CardSetInfo setInfo) {
        super(
                ownerId, setInfo,
                new SuperType[]{SuperType.LEGENDARY}, new CardType[]{CardType.CREATURE}, new SubType[]{SubType.DJINN, SubType.WIZARD}, "{2}{U}",
                "Nassari, Dean of Expression",
                new SuperType[]{SuperType.LEGENDARY}, new CardType[]{CardType.CREATURE}, new SubType[]{SubType.EFREET, SubType.SHAMAN}, "{3}{R}{R}"
        );

        // 1.
        // Uvilda, Dean of Perfection
        // Legendary Creature - Djinn Wizard
        this.getLeftHalfCard().setPT(2, 2);

        // {T}: You may exile an instant or sorcery card from your hand and put three hone counters on it. It gains "At the beginning of your upkeep, if this card is exiled, remove a hone counter from it" and "When the last hone counter is removed from this card, if it's exiled, you may cast it. It costs {4} less to cast this way."
        this.getLeftHalfCard().addAbility(new SimpleActivatedAbility(
                new UvildaDeanOfPerfectionEffect(), new TapSourceCost()
        ));

        // 2.
        // Nassari, Dean of Expression
        // Legendary Creature - Efreet Shaman
        this.getRightHalfCard().setPT(4, 4);

        // At the beginning of your upkeep, exile the top card of each opponent's library. Until end of turn, you may cast spells from among those exiled cards, and you many spend mana as though it were mana of any color to cast those spells.
        this.getRightHalfCard().addAbility(new BeginningOfUpkeepTriggeredAbility(new NassariDeanOfExpressionEffect()));

        // Whenever you cast a spell from exile, put a +1/+1 counter on Nassari, Dean of Expression.
        this.getRightHalfCard().addAbility(SpellCastControllerTriggeredAbility.createWithFromZone(
                new AddCountersSourceEffect(CounterType.P1P1.createInstance()),
                null, false, Zone.EXILED
        ));
    }

    private UvildaDeanOfPerfection(final UvildaDeanOfPerfection card) {
        super(card);
    }

    @Override
    public UvildaDeanOfPerfection copy() {
        return new UvildaDeanOfPerfection(this);
    }
}

class UvildaDeanOfPerfectionEffect extends OneShotEffect {

    UvildaDeanOfPerfectionEffect() {
        super(Outcome.Benefit);
        staticText = "you may exile an instant or sorcery card from your hand and put three hone counters on it. " +
                "It gains \"At the beginning of your upkeep, if this card is exiled, " +
                "remove a hone counter from it\" and \"When the last hone counter is removed from this card, " +
                "if it's exiled, you may cast it. It costs {4} less to cast this way.\"";
    }

    private UvildaDeanOfPerfectionEffect(final UvildaDeanOfPerfectionEffect effect) {
        super(effect);
    }

    @Override
    public UvildaDeanOfPerfectionEffect copy() {
        return new UvildaDeanOfPerfectionEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        if (player == null || player.getHand().count(
                StaticFilters.FILTER_CARD_INSTANT_OR_SORCERY, game
        ) < 1) {
            return false;
        }
        TargetCard target = new TargetCardInHand(
                0, 1, StaticFilters.FILTER_CARD_INSTANT_OR_SORCERY
        );
        player.choose(outcome, player.getHand(), target, source, game);
        Card card = game.getCard(target.getFirstTarget());
        if (card == null) {
            return false;
        }
        player.moveCards(card, Zone.EXILED, source, game);
        if (game.getState().getZone(card.getId()) != Zone.EXILED) {
            return false;
        }
        card.addCounters(CounterType.HONE.createInstance(3), source.getControllerId(), source, game);
        game.addEffect(new UvildaDeanOfPerfectionGainAbilityEffect(card, game), source);
        return true;
    }
}

class UvildaDeanOfPerfectionGainAbilityEffect extends ContinuousEffectImpl {

    private final MageObjectReference mor;

    UvildaDeanOfPerfectionGainAbilityEffect(Card card, Game game) {
        super(Duration.Custom, Layer.AbilityAddingRemovingEffects_6, SubLayer.NA, Outcome.AddAbility);
        this.mor = new MageObjectReference(card, game);
    }

    private UvildaDeanOfPerfectionGainAbilityEffect(final UvildaDeanOfPerfectionGainAbilityEffect effect) {
        super(effect);
        this.mor = effect.mor;
    }

    @Override
    public UvildaDeanOfPerfectionGainAbilityEffect copy() {
        return new UvildaDeanOfPerfectionGainAbilityEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Card card = mor.getCard(game);
        if (card == null) {
            discard();
            return true;
        }
        Ability ability = new BeginningOfUpkeepTriggeredAbility(
                Zone.EXILED, TargetController.YOU,
                new RemoveCounterSourceEffect(CounterType.HONE.createInstance())
                        .setText("remove a hone counter from it"), false
        ).withInterveningIf(UvildaDeanOfPerfectionCondition.instance);
        ability.setSourceId(card.getId());
        ability.setControllerId(source.getControllerId());
        game.getState().addOtherAbility(card, ability);
        ability = new UvildaDeanOfPerfectionTriggeredAbility();
        ability.setSourceId(card.getId());
        ability.setControllerId(source.getControllerId());
        game.getState().addOtherAbility(card, ability);
        return true;
    }
}

enum UvildaDeanOfPerfectionCondition implements Condition {
    instance;

    @Override
    public boolean apply(Game game, Ability source) {
        return game.getState().getZone(source.getSourceId()) == Zone.EXILED;
    }

    @Override
    public String toString() {
        return "this card is exiled";
    }
}

class UvildaDeanOfPerfectionTriggeredAbility extends TriggeredAbilityImpl {

    UvildaDeanOfPerfectionTriggeredAbility() {
        super(Zone.EXILED, new UvildaDeanOfPerfectionCastEffect());
    }

    private UvildaDeanOfPerfectionTriggeredAbility(final UvildaDeanOfPerfectionTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.COUNTERS_REMOVED;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        Card card = getSourceCardIfItStillExists(game);
        return event.getTargetId().equals(this.getSourceId())
                && card != null
                && card.getCounters(game).getCount(CounterType.HONE) == 0
                && event.getAmount() > 0
                && event.getData().equals(CounterType.HONE.getName());
    }

    @Override
    public boolean checkInterveningIfClause(Game game) {
        return game.getState().getZone(getSourceId()) == Zone.EXILED;
    }

    @Override
    public UvildaDeanOfPerfectionTriggeredAbility copy() {
        return new UvildaDeanOfPerfectionTriggeredAbility(this);
    }

    @Override
    public String getRule() {
        return "When the last hone counter is removed from this card, if it's exiled, " +
                "you may cast it. It costs {4} less to cast this way.";
    }
}

class UvildaDeanOfPerfectionCastEffect extends OneShotEffect {

    UvildaDeanOfPerfectionCastEffect() {
        super(Outcome.Benefit);
    }

    private UvildaDeanOfPerfectionCastEffect(final UvildaDeanOfPerfectionCastEffect effect) {
        super(effect);
    }

    @Override
    public UvildaDeanOfPerfectionCastEffect copy() {
        return new UvildaDeanOfPerfectionCastEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        Card card = source.getSourceCardIfItStillExists(game);
        if (player == null || card == null) {
            return false;
        }
        if (!player.chooseUse(outcome, "Cast " + card.getName() + '?', source, game)) {
            return false;
        }
        SpellAbility spellAbility = player.chooseAbilityForCast(card, game, true);
        if (spellAbility == null) {
            return false;
        }
        CardUtil.reduceCost(spellAbility, 4);
        game.getState().setValue("PlayFromNotOwnHandZone" + card.getId(), Boolean.TRUE);
        player.cast(spellAbility, game, false, new ApprovingObject(source, game));
        game.getState().setValue("PlayFromNotOwnHandZone" + card.getId(), null);
        return true;
    }
}

class NassariDeanOfExpressionEffect extends OneShotEffect {

    NassariDeanOfExpressionEffect() {
        super(Outcome.Benefit);
        staticText = "exile the top card of each opponent's library. Until end of turn, " +
                "you may cast spells from among those exiled cards, and you may spend mana " +
                "as though it were mana of any color to cast those spells";
    }

    private NassariDeanOfExpressionEffect(final NassariDeanOfExpressionEffect effect) {
        super(effect);
    }

    @Override
    public NassariDeanOfExpressionEffect copy() {
        return new NassariDeanOfExpressionEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        if (player == null) {
            return false;
        }
        Cards cards = new CardsImpl();
        game.getOpponents(source.getControllerId(), true)
                .stream()
                .map(game::getPlayer)
                .filter(Objects::nonNull)
                .map(Player::getLibrary)
                .map(p -> p.getFromTop(game))
                .forEach(cards::add);
        player.moveCards(cards, Zone.EXILED, source, game);
        cards.retainZone(Zone.EXILED, game);
        if (cards.isEmpty()) {
            return false;
        }
        for (Card card : cards.getCards(game)) {
            CardUtil.makeCardPlayable(game, source, card, true, Duration.EndOfTurn, true);
        }
        return true;
    }
}
