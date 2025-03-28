package mage.cards.w;

import mage.MageInt;
import mage.Mana;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.common.TargetPlayerGainControlSourceEffect;
import mage.abilities.effects.mana.BasicManaEffect;
import mage.abilities.keyword.SwampwalkAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.target.common.TargetOpponent;

import java.util.UUID;

/**
 *
 * @author fireshoes
 */
public final class WitchEngine extends CardImpl {

    public WitchEngine(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{5}{B}");
        this.subtype.add(SubType.HORROR);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Swampwalk
        this.addAbility(new SwampwalkAbility());

        // {T}: Add {B}{B}{B}{B}. Target opponent gains control of Witch Engine. (Activate this ability only any time you could cast an instant.)
        Ability ability = new SimpleActivatedAbility(new BasicManaEffect(Mana.BlackMana(4)), new TapSourceCost());
        ability.addEffect(new TargetPlayerGainControlSourceEffect());
        ability.addTarget(new TargetOpponent());
        this.addAbility(ability);
    }

    private WitchEngine(final WitchEngine card) {
        super(card);
    }

    @Override
    public WitchEngine copy() {
        return new WitchEngine(this);
    }
}
