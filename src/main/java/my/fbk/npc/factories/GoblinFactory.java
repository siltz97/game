package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Goblin;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Produces goblins. */
public class GoblinFactory {
    ItemList item;
    static List<ItemList> list = new ArrayList<>();

    private static Random rand = new Random();

    public static Goblin makeWarrior() {
        Goblin goblin = new Goblin(75, 100, 0, 80, 11);
        goblin.setInventory(createInventory());
        return goblin;

    }

    public static Goblin makeMage() {
        Goblin goblin = new Goblin(75, 80, 100, 5, 11);
        goblin.setInventory(createInventory());
        return goblin;
    }

    public static Goblin makeBoss() {
        Goblin goblin = new Goblin(200, 150, 100, 100, 11);
        goblin.setInventory(createInventory());
        return goblin;
    }

    public static Goblin random() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeWarrior();
        else
            return makeMage();
    }

    public static Inventory createInventory() {
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 2; i++) {
            list.add(itemArray[rand.nextInt(itemArray.length)]);

        }
        return (Inventory) list;
    }


}
