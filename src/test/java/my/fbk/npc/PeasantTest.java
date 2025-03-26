package my.fbk.npc;

import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.BasicSpells.Effects;
import my.fbk.npc.BasicSpells.InvisibilitySpell;
import my.fbk.npc.Rooms.SafeRoom;
import my.fbk.npc.Speak.SilentSpeak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

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
    @Test
    public void peasantEffectTestUseMindControl() {
        SafeRoom safeRoom = new SafeRoom();
        Optional<AbstractNPC> peasantOpt = safeRoom.getAllNPC().stream().filter(e -> e instanceof Peasant).findFirst();
        Assertions.assertTrue(peasantOpt.isPresent(), "peasant not found");
        AbstractNPC peasant = peasantOpt.get();

        String effect = "mind";

        Optional<Effects> effects = safeRoom.selectEffect(effect);
        Assertions.assertTrue(effects.isPresent(), "Effect not found!");

        Effects selectedEffect = effects.get();
        Optional<AbstractNPC> target = safeRoom.getTarget(peasant.getName());
        Assertions.assertTrue(target.isPresent(), "Target not found!");

        String input = "use";
        safeRoom.targetSpell(selectedEffect, target.get(), input);

        //output test
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call speak(), which prints to System.out
        peasant.speak();

        // Restore original System.out
        System.setOut(originalOut);

        // Get the printed output and trim any extra spaces or new lines
        String printedOutput = outputStream.toString().trim();

        // Expected response
        String expectedResponse = "What do you want my lord?";

        // Assert that the printed output matches the expected response
        Assertions.assertEquals(expectedResponse, printedOutput, "Peasant's response does not match!");
    }

}
