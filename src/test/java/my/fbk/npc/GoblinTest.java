package my.fbk.npc;

import my.fbk.npc.Enemy.Goblin;
import my.fbk.npc.factories.GoblinFactory;
import my.fbk.npc.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoblinTest {

    @Test
    public void goblinInventoryTest() {
        Goblin warrior = GoblinFactory.makeGoblinWarrior();
        Assertions.assertTrue(warrior.getInventory().getInventorySize()==2);

    }
}
