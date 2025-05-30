package mage.abilities.common;

import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.target.targetpointer.FixedTarget;

/**
 * @author LevelX2
 */
public class DrawCardOpponentTriggeredAbility extends TriggeredAbilityImpl {

    private final boolean setTargetPointer;

    public DrawCardOpponentTriggeredAbility(Effect effect, boolean optional, boolean setTargetPointer) {
        this(Zone.BATTLEFIELD, effect, optional, setTargetPointer);
    }

    public DrawCardOpponentTriggeredAbility(Zone zone, Effect effect, boolean optional, boolean setTargetPointer) {
        super(zone, effect, optional);
        this.setTargetPointer = setTargetPointer;
        setTriggerPhrase("Whenever an opponent draws a card, ");
    }

    protected DrawCardOpponentTriggeredAbility(final DrawCardOpponentTriggeredAbility ability) {
        super(ability);
        this.setTargetPointer = ability.setTargetPointer;
    }

    @Override
    public DrawCardOpponentTriggeredAbility copy() {
        return new DrawCardOpponentTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.DREW_CARD;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (!game.getPlayer(this.getControllerId()).hasOpponent(event.getPlayerId(), game)) {
            return false;
        }
        this.getEffects().setValue("playerDrew", event.getPlayerId());
        if (setTargetPointer) {
            this.getEffects().setTargetPointer(new FixedTarget(event.getPlayerId()));
        }
        return true;
    }
}
