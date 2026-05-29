package org.mage.test.cards.abilities.flicker;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 * @author PurpleCrowbar
 */
public class TokenCopyFlickerTest extends CardTestPlayerBase {

    // {1} Instant: Exile target creature you control, then return that card to the battlefield under your control.
    private static final String flicker = "Cloudshift";
    // {1}{W/U} Instant: Exile target creature. Return that card to the battlefield under its owner's control at the beginning of the next end step.
    private static final String slowFlicker = "Turn to Mist";
    // 1/1 Zombie with "Whenever another Zombie you control enters, put a +1/+1 counter on this creature".
    private static final String cotp = "Champion of the Perished";

    /**
     * Tests that a token (which isn't a copy of any other permanent) is correctly removed from the game when flickered.
     */
    @Test
    public void testNonCopyTokenFlicker() {
        setStrictChooseMode(true);

        addCard(Zone.BATTLEFIELD, playerA, cotp);
        addCard(Zone.BATTLEFIELD, playerA, "Swamp", 3);
        addCard(Zone.BATTLEFIELD, playerA, "Plains", 3);
        addCard(Zone.HAND, playerA, "Reap the Seagraf"); // {2}{B} Sorcery: Create a 2/2 black Zombie creature token.
        addCard(Zone.HAND, playerA, flicker);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Reap the Seagraf");
        waitStackResolved(1, PhaseStep.PRECOMBAT_MAIN);
        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, flicker, "Zombie Token");

        setStopAt(1, PhaseStep.POSTCOMBAT_MAIN);
        execute();

        assertPermanentCount(playerA, "Zombie Token", 0);
        assertPowerToughness(playerA, cotp, 2, 2); // only one +1/+1 counter added
    }
}
