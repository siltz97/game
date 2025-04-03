package my.fbk.npc.inventory;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.myPlayer.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class InventoryInteraction implements Inventory {
    public List<ItemList> inventory = new ArrayList<>();

    @Override
    public void addItemToInventory(ItemList item) {
        inventory.add(item);
    }

    @Override
    public void removeItemFromInventory(ItemList item) {
        inventory.remove(item);
    }

    @Override
    public void buyItem(ItemList item, AbstractNPC abstractNpc, Player player) {
        if (!(abstractNpc instanceof Merchant)) {
            return;
        }
        Merchant merchant = (Merchant) abstractNpc;
        InventoryInteraction merchantInventory = (InventoryInteraction) merchant.getInventory();
        if (merchantInventory.contains(item)) {
            inventory.add(item);
            merchantInventory.removeItemFromInventory(item);
            System.out.println("Player bought: " + item);
        } else {
            System.out.println("Item not available in Merchant's inventory.");
        }
    }

    @Override
    public void sellItem(ItemList item, AbstractNPC abstractNpc, Player player) {
        if (!(abstractNpc instanceof Merchant)) {
            return;
        }
        Merchant merchant = (Merchant) abstractNpc;
        InventoryInteraction merchantInventory = (InventoryInteraction) merchant.getInventory();
        if (inventory.contains(item)) {
            inventory.remove(item);
            merchantInventory.addItemToInventory(item);
            System.out.println("You sold: " + item);
        } else {
            System.out.println("You don't have this item.");
        }
    }


    @Override
    public void showInventory() {
        System.out.println("\nInventory:");
        if (inventory.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (ItemList item : inventory) {
                System.out.println(item + " - " + item.getDescription() + " ($" + item.getPrice() + ")");
            }
        }

    }

    @Override
    public void useItem(ItemList item,AbstractCharacter character) {
        if (inventory.contains(item)) {
            item.use(List.of(character));
            item.setDurability((item.getDurability() - 1));
            if (item.getDurability() == 0) {
                inventory.remove(item);
            }
        }
    }

    public void addAllItemsToInventory(List<ItemList> list) {
        inventory.addAll(list);
    }

    public boolean contains(ItemList item) {
        return inventory.contains(item);
    }
    @Override
    public int getInventorySize(){
        return inventory.size();
    }


}
