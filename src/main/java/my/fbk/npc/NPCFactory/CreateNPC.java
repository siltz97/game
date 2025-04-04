package my.fbk.npc.NPCFactory;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AllNPC.*;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.ItemList;

import java.util.Arrays;
import java.util.Random;

@Getter
@Setter
public class CreateNPC {
    public static final Random rand = new Random();

    public static AbstractNPC makeThief(){
       Thief thief = new Thief(rand.nextInt(50), 150, 100, 10, 40);
        thief.setInventory(createNPCInventory());
        return thief;
    }
    public static Peasant makePeasant(){
        Peasant peasant = new Peasant(rand.nextInt(20), 30, 100, 0, 5);
        peasant.setInventory(createNPCInventory());
        return peasant;
    }
    public static Guard makeGuard(){
        Guard guard = new Guard(rand.nextInt(50), 300, 100, 10, 50);
        guard.setInventory(createNPCInventory());
        return guard;
    }
    public static Merchant makeMerchant(){
        Merchant merchant = new Merchant(99999, 60, 100, 0, 10);
        merchant.setInventory(createMerchantInventory());
        return merchant;
    }

    public static Inventory createNPCInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 1; i++) {
            inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
        }
        return inventory;
    }
    public static Inventory createMerchantInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        inventory.addAllItemsToInventory(Arrays.asList(ItemList.values()));
        return inventory;
    }

}
