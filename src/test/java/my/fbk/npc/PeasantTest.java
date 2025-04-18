package my.fbk.npc;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.Peasant;
import my.fbk.npc.effects.InvisibilityEffect;
import my.fbk.npc.rooms.SafeRoom;
import my.fbk.npc.speak.SilentSpeak;

import my.fbk.npc.my_player.Player;
import my.fbk.npc.spells.AbstractSpell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

public class PeasantTest {

    @Test
    public void peasantTestPositive() {
        Peasant peasant = new Peasant(1,100,100,2,1,0);
        peasant.speak();
    }
    @Test
    public void peasantTestNeutral() {
        Peasant peasant = new Peasant(1,100,61,2,1,0);
        peasant.speak();
    }
    @Test
    public void peasantTestAggressive() {
        Peasant peasant = new Peasant(1,100,40,2,1,0);
        peasant.speak();
    }
    @Test
    public void peasantTestSilent() {
        Peasant peasant = new Peasant(1,100,100,2,1,0);
        peasant.setEffects(new InvisibilityEffect(5));
        peasant.speak();
        Assertions.assertTrue(peasant.getBehavior() instanceof SilentSpeak);
    }
    @Test
    @DisplayName("Mind Control Test")
    public void peasantEffectTestUseMindControl() {
        Player player = new Player(10,10,100,100,10,10);
        SafeRoom safeRoom = new SafeRoom(new Game());
        safeRoom.setPlayer(player);
        safeRoom.generateNPC();
        Optional<AbstractCharacter> peasantOpt = safeRoom.getAllCharacters().stream().filter(e -> e instanceof Peasant).findFirst();
        Assertions.assertTrue(peasantOpt.isPresent(), "peasant not found");
        AbstractCharacter peasant = peasantOpt.get();

        String spell = "mind";
//effects
        Optional<AbstractSpell> spells = safeRoom.selectSpell(spell);
        Assertions.assertTrue(spells.isPresent(), "Effect not found!");
//target
        AbstractSpell selectedSpell = spells.get();
        Optional<AbstractCharacter> target = safeRoom.getTarget(peasant.getName());
        Assertions.assertTrue(target.isPresent(), "Target not found!");
//target spell
        String input = "use";
        safeRoom.targetSpell(selectedSpell, target.get(), input);
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
        System.out.println(expectedResponse);
// Assert that the printed output matches the expected response
        Assertions.assertEquals(expectedResponse, printedOutput, "Peasant's response does not match!");
    }

}
