package mage.cards.p;

import mage.MageInt;
import mage.abilities.costs.common.PayLifeCost;
import mage.abilities.dynamicvalue.common.SourcePermanentPowerValue;
import mage.abilities.keyword.LifelinkAbility;
import mage.abilities.keyword.MenaceAbility;
import mage.abilities.keyword.PrototypeAbility;
import mage.abilities.keyword.WardAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class PhyrexianFleshgorger extends CardImpl {

    public PhyrexianFleshgorger(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT, CardType.CREATURE}, "{7}");

        this.subtype.add(SubType.PHYREXIAN);
        this.subtype.add(SubType.WURM);
        this.power = new MageInt(7);
        this.toughness = new MageInt(5);

        // Prototype {1}{B}{B} -- 3/3
        this.addAbility(new PrototypeAbility(this, "{1}{B}{B}", 3, 3));

        // Menace
        this.addAbility(new MenaceAbility(false));

        // Lifelink
        this.addAbility(LifelinkAbility.getInstance());

        // Ward--Pay life equal to Phyrexian Fleshgorger's power.
        this.addAbility(new WardAbility(new PayLifeCost(SourcePermanentPowerValue.NOT_NEGATIVE, "life equal to {this}'s power"), false));
    }

    private PhyrexianFleshgorger(final PhyrexianFleshgorger card) {
        super(card);
    }

    @Override
    public PhyrexianFleshgorger copy() {
        return new PhyrexianFleshgorger(this);
    }
}
