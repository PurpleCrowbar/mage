package mage.abilities.effects.keyword;

import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.constants.Outcome;
import mage.counters.CounterType;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.game.permanent.token.SpiritXXToken;
import mage.players.Player;
import mage.util.CardUtil;

/**
 * @author TheElk801
 */
public class EndureSourceEffect extends OneShotEffect {

    private final int amount;

    public EndureSourceEffect(int amount) {
        this(amount, "it");
    }

    public EndureSourceEffect(int amount, String selfText) {
        super(Outcome.Benefit);
        staticText = selfText + " endures " + amount;
        this.amount = amount;
    }

    private EndureSourceEffect(final EndureSourceEffect effect) {
        super(effect);
        this.amount = effect.amount;
    }

    @Override
    public EndureSourceEffect copy() {
        return new EndureSourceEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        if (player == null) {
            return false;
        }
        Permanent permanent = source.getSourcePermanentIfItStillExists(game);
        if (permanent != null && player.chooseUse(
                Outcome.BoostCreature, "Put " + CardUtil.numberToText(amount, "a") + " +1/+1 counter" +
                        (amount > 1 ? "s" : "") + " on " + permanent.getName() + " or create " +
                        CardUtil.addArticle("" + amount) + ' ' + amount + '/' + amount + " Spirit token?",
                null, "Add counters", "Create token", source, game
        )) {
            return permanent.addCounters(CounterType.P1P1.createInstance(amount), source, game);
        }
        return new SpiritXXToken(amount).putOntoBattlefield(1, game, source);
    }
}
