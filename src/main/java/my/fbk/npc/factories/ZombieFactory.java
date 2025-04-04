package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Zombie;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieFactory {

    private static final Random rand = new Random();
    static List<ItemList> list = new ArrayList<>();

    public static Zombie makeZombieWarrior() {
        Zombie zombieWarrior = new Zombie(75, 100, 0, 80, rand.nextInt(100)+20);
        zombieWarrior.setInventory(createInventory());
        return zombieWarrior;
    }

    public static Zombie makeZombieMage() {
        Zombie zombieMage = new Zombie(75, 80, 100, 5, rand.nextInt(100)+20);
        zombieMage.setInventory(createInventory());
        return zombieMage;
    }

    public static Zombie makeZombieBoss() {
        Zombie zombieBoss = new Zombie(200, 150, 100, 100, rand.nextInt(300)+50);
        zombieBoss.setInventory(createInventory());
        return zombieBoss;
    }

    public static Zombie MakeRandomEnemy() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeZombieWarrior();
        else
            return makeZombieMage();
    }

    public static Inventory createInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 2; i++) {
            inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
        }
        return inventory;
    }
}
