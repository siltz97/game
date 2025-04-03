package my.fbk.npc.factories;

import lombok.Getter;
import lombok.Setter;
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

    public static Goblin makeGoblinWarrior() {
        Goblin goblinWarrior = new Goblin(75, 100, 0, 80, 11);
        goblinWarrior.setInventory(createInventory());
        return goblinWarrior;

    }

    public static Goblin makeGoblinMage() {
        Goblin goblinMage = new Goblin(75, 80, 100, 5, 11);
        goblinMage.setInventory(createInventory());
        return goblinMage;
    }

    public static Goblin makeGoblinBoss() {
        Goblin goblinBoss = new Goblin(200, 150, 100, 100, 11);
        goblinBoss.setInventory(createInventory());
        return goblinBoss;
    }

    public static Goblin makeRandomEnemy() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeGoblinWarrior();
        else
            return makeGoblinMage();
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
