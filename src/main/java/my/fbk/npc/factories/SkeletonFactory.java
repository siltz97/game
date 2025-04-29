package my.fbk.npc.factories;

import my.fbk.npc.enemy.Skeleton;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.Item;

import java.util.Random;

public class SkeletonFactory {

    private static final Random rand = new Random();
    private static final int baseWarriorHealth = 90;
    private static final int baseWarriorMana = 18;
    private static final int baseWarriorDamage = 24;
    private static final int baseMageHealth = 75;
    private static final int baseMageMana = 28;
    private static final int baseMageDamage = 20;
    private static final int baseBossHealth = 110;
    private static final int baseBossMana = 22;
    private static final int baseBossDamage = 30;

    public static Skeleton makeSkeletonWarrior(int level) {
        Skeleton skeletonWarrior = new Skeleton(28, 90, 18, 24, rand.nextInt(30)+20);
        skeletonWarrior.setInventory(createInventory());
        skeletonWarrior.setHealth((int) (baseWarriorHealth *(1 + 0.12 * (level-1))));
        skeletonWarrior.setMana((int) (baseWarriorMana * (1 + 0.03 * (level-1))));
        skeletonWarrior.setDamage((int) (baseWarriorDamage * (1 + 0.09 * (level-1))));
        return skeletonWarrior;
    }

    public static Skeleton makeSkeletonMage(int level) {
        Skeleton skeletonMage = new Skeleton(30, 75, 28, 20, rand.nextInt(30)+20);
        skeletonMage.setInventory(createInventory());
        skeletonMage.setHealth((int) (baseMageHealth *(1 + 0.07 * (level-1))));
        skeletonMage.setMana((int) (baseMageMana * (1 + 0.1 * (level-1))));
        skeletonMage.setDamage((int) (baseMageDamage * (1 + 0.06 * (level-1))));
        return skeletonMage;
    }

    public static Skeleton makeSkeletonBoss(int level) {
        Skeleton skeletonBoss = new Skeleton(85, 110, 22, 30, rand.nextInt(50)+50);
        skeletonBoss.setInventory(createInventory());
        skeletonBoss.setHealth((int) (baseBossHealth *(1 + 0.15 * (level-1))));
        skeletonBoss.setMana((int) (baseBossMana * (1 + 0.08 * (level-1))));
        skeletonBoss.setDamage((int) (baseBossDamage * (1 + 0.12 * (level-1))));
        return skeletonBoss;
    }

    public static Skeleton makeRandomEnemy(int level) {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeSkeletonWarrior(level);
        else
            return makeSkeletonMage(level);
    }

    public static Inventory createInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        Item[] itemArray = Item.itemsHolder().toArray(new Item[0]);
        for (int i = 0; i < 1; i++) {
            inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
        }
        return inventory;
    }
}
