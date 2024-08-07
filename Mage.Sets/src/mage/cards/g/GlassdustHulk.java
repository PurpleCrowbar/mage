package mage.cards.g;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldControlledTriggeredAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.combat.CantBeBlockedSourceEffect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.keyword.CyclingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterArtifactPermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;

/**
 *
 * @author Loki
 */
public final class GlassdustHulk extends CardImpl {

    private static final FilterPermanent filter = new FilterArtifactPermanent("another artifact");

    static {
        filter.add(AnotherPredicate.instance);
    }

    public GlassdustHulk(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT,CardType.CREATURE},"{3}{W}{U}");
        this.subtype.add(SubType.GOLEM);

        this.power = new MageInt(3);
        this.toughness = new MageInt(4);

        // Whenever another artifact you control enters, Glassdust Hulk gets +1/+1 until end of turn and can't be blocked this turn.
        Ability ability = new EntersBattlefieldControlledTriggeredAbility(new BoostSourceEffect(1, 1, Duration.EndOfTurn), filter);
        ability.addEffect(new CantBeBlockedSourceEffect(Duration.EndOfTurn).setText("and can't be blocked this turn"));
        this.addAbility(ability);

        this.addAbility(new CyclingAbility(new ManaCostsImpl<>("{W/U}")));
    }

    private GlassdustHulk(final GlassdustHulk card) {
        super(card);
    }

    @Override
    public GlassdustHulk copy() {
        return new GlassdustHulk(this);
    }
}
