package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Kobold;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KoboldFactory {

    static List<ItemList> list = new ArrayList<>();
    private static final int baseWarriorHealth = 70;
    private static final int baseWarriorMana = 20;
    private static final int baseWarriorDamage = 19;
    private static final int baseMageHealth = 55;
    private static final int baseMageMana = 35;
    private static final int baseMageDamage = 14;
    private static final int baseBossHealth = 90;
    private static final int baseBossMana = 30;
    private static final int baseBossDamage = 27;

    private static final Random rand = new Random();

    public static Kobold makeKoboldWarrior(int level) {
        Kobold koboldWarrior = new Kobold(35, 70, 20, 19, rand.nextInt(30)+20);
        koboldWarrior.setInventory(createInventory());
        koboldWarrior.setHealth((int) (baseWarriorHealth *(1 + 0.12 * (level-1))));
        koboldWarrior.setMana((int) (baseWarriorMana * (1 + 0.03 * (level-1))));
        koboldWarrior.setDamage((int) (baseWarriorDamage * (1 + 0.09 * (level-1))));
        return koboldWarrior;
    }

    public static Kobold makeKoboldMage(int level) {
        Kobold koboldMage = new Kobold(30, 55, 35, 14, rand.nextInt(30)+20);
        koboldMage.setInventory(createInventory());
        koboldMage.setHealth((int) (baseMageHealth *(1 + 0.07 * (level-1))));
        koboldMage.setMana((int) (baseMageMana * (1 + 0.1 * (level-1))));
        koboldMage.setDamage((int) (baseMageDamage * (1 + 0.06 * (level-1))));
        return koboldMage;
    }

    public static Kobold makeKoboldBoss(int level) {
        Kobold koboldBoss = new Kobold(85, 90, 30, 27, rand.nextInt(50)+50);
        koboldBoss.setInventory(createInventory());
        koboldBoss.setHealth((int) (baseBossHealth *(1 + 0.15 * (level-1))));
        koboldBoss.setMana((int) (baseBossMana * (1 + 0.08 * (level-1))));
        koboldBoss.setDamage((int) (baseBossDamage * (1 + 0.12 * (level-1))));
        return koboldBoss;
    }

    public static Kobold makeRandomEnemy(int level) {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeKoboldWarrior(level);
        else
            return makeKoboldMage(level);
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
