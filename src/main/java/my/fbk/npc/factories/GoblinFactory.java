package my.fbk.npc.factories;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.Enemy.Goblin;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Produces goblins. */
@Getter
@Setter
public class GoblinFactory {

    private static final Random rand = new Random();
    private static final int baseWarriorHealth = 80;
    private static final int baseWarriorMana = 15;
    private static final int baseWarriorDamage = 22;
    private static final int baseMageHealth = 70;
    private static final int baseMageMana = 20;
    private static final int baseMageDamage = 18;
    private static final int baseBossHealth = 100;
    private static final int baseBossMana = 25;
    private static final int baseBossDamage = 28;

    public static Goblin makeGoblinWarrior(int level) {
        Goblin goblinWarrior = new Goblin(30, 80, 15, 22, 21);
        goblinWarrior.setInventory(createInventory());
        goblinWarrior.setHealth((int) (baseWarriorHealth *(1 + 0.12 * (level-1))));
        goblinWarrior.setMana((int) (baseWarriorMana * (1 + 0.03 * (level-1))));
        goblinWarrior.setDamage((int) (baseWarriorDamage * (1 + 0.09 * (level-1))));
        return goblinWarrior;

    }

    public static Goblin makeGoblinMage(int level) {
        Goblin goblinMage = new Goblin(20, 70, 20, 18, 18);
        goblinMage.setInventory(createInventory());
        goblinMage.setHealth((int) (baseMageHealth *(1 + 0.07 * (level-1))));
        goblinMage.setMana((int) (baseMageMana * (1 + 0.1 * (level-1))));
        goblinMage.setDamage((int) (baseMageDamage * (1 + 0.06 * (level-1))));
        return goblinMage;
    }

    public static Goblin makeGoblinBoss(int level) {
        Goblin goblinBoss = new Goblin(80, 100, 25, 28, 60);
        goblinBoss.setInventory(createInventory());
        goblinBoss.setHealth((int) (baseBossHealth *(1 + 0.15 * (level-1))));
        goblinBoss.setMana((int) (baseBossMana * (1 + 0.08 * (level-1))));
        goblinBoss.setDamage((int) (baseBossDamage * (1 + 0.12 * (level-1))));
        return goblinBoss;
    }

    public static Goblin makeRandomEnemy(int level) {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeGoblinWarrior(level);
        else
            return makeGoblinMage(level);
    }

    public static Inventory createInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 1; i++) {
            inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
        }
        return inventory;
    }




}
