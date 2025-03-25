package my.fbk.npc;

import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.BasicSpells.InvisibilitySpell;
import my.fbk.npc.Speak.SilentSpeak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeasantTest {

    @Test
    public void peasantTestPositive() {
        Peasant peasant = new Peasant(1,100,100,2);
        peasant.speak();
    }
    @Test
    public void peasantTestNeutral() {
        Peasant peasant = new Peasant(1,100,61,2);
        peasant.speak();
    }
    @Test
    public void peasantTestAggressive() {
        Peasant peasant = new Peasant(1,100,40,2);
        peasant.speak();
    }
    @Test
    public void peasantTestSilent() {
        Peasant peasant = new Peasant(1,100,100,2);
        peasant.setEffects(new InvisibilitySpell());
        peasant.speak();
        Assertions.assertTrue(peasant.getBehavior() instanceof SilentSpeak);
    }

}
