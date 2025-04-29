package my.fbk.npc.factories;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.all_npc.*;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.Item;

import java.util.Arrays;
import java.util.Random;

@Getter
@Setter
public class NPCFactory {
    public static final Random rand = new Random();

    public static Thief makeThief(){
       Thief thief = new Thief(rand.nextInt(50), 150, 100, 10, 40,0);
        thief.setInventory(createNPCInventory());
        return thief;
    }
    public static Peasant makePeasant(){
        Peasant peasant = new Peasant(rand.nextInt(20), 30, 100, 0, 5,0);
        peasant.setInventory(createNPCInventory());
        return peasant;
    }
    public static Guard makeGuard(){
        Guard guard = new Guard(rand.nextInt(50), 300, 100, 10, 50,0);
        guard.setInventory(createNPCInventory());
        return guard;
    }
    public static Merchant makeMerchant(){
        Merchant merchant = new Merchant(99999, 60, 100, 0, 10,0);
        merchant.setInventory(createMerchantInventory());
        return merchant;
    }

        public static Inventory createNPCInventory() {
            InventoryInteraction inventory = new InventoryInteraction();
            Item[] itemArray = Item.itemsHolder().toArray(new Item[0]);
            for (int i = 0; i < 1; i++) {
                inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
            }
            return inventory;
        }

    public static Inventory createMerchantInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        inventory.addAllItemsToInventory(Arrays.asList(Item.itemsHolder().toArray(new Item[0])));
        return inventory;
    }

}
