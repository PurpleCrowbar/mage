package mage.game.command.emblems;

import mage.abilities.triggers.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.effects.common.DamageControllerEffect;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.game.command.Emblem;

/**
 * @author TheElk801
 */
public final class ChandraAwakenedInfernoEmblem extends Emblem {

    /**
     * Emblem with "At the beginning of your upkeep, this emblem deals 1 damage
     * to you."
     */

    public ChandraAwakenedInfernoEmblem() {
        super("Emblem Chandra");
        this.getAbilities().add(new BeginningOfUpkeepTriggeredAbility(
                Zone.COMMAND, TargetController.YOU, new DamageControllerEffect(1, "this emblem"),
                false
        ));
    }

    private ChandraAwakenedInfernoEmblem(final ChandraAwakenedInfernoEmblem card) {
        super(card);
    }

    @Override
    public ChandraAwakenedInfernoEmblem copy() {
        return new ChandraAwakenedInfernoEmblem(this);
    }
}
