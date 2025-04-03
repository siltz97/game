package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Skeleton;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkeletonFactory {

    private static final Random rand = new Random();
    static List<ItemList> list = new ArrayList<>();

    public static Skeleton makeSkeletonWarrior() {
        Skeleton skeletonWarrior = new Skeleton(75, 100, 0, 80, rand.nextInt(100)+20);
        skeletonWarrior.setInventory(createInventory());
        return skeletonWarrior;
    }

    public static Skeleton makeSkeletonMage() {
        Skeleton skeletonMage = new Skeleton(75, 80, 100, 5, rand.nextInt(100)+20);
        skeletonMage.setInventory(createInventory());
        return skeletonMage;
    }

    public static Skeleton makeSkeletonBoss() {
        Skeleton skeletonBoss = new Skeleton(200, 150, 100, 100, rand.nextInt(300)+50);
        skeletonBoss.setInventory(createInventory());
        return skeletonBoss;
    }

    public static Skeleton makeRandomEnemy() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeSkeletonWarrior();
        else
            return makeSkeletonMage();
    }

    public static Inventory createInventory() {
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 2; i++) {
            list.add(itemArray[rand.nextInt(itemArray.length)]);

        }
        return (Inventory) list;
    }
}
