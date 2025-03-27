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
public class NewInventory implements Inventory {
    private List<ItemList> inventory = new ArrayList<>();

    @Override
    public void addItem(ItemList item) {
        inventory.add(item);
    }

    @Override
    public void removeItem(ItemList item) {
        inventory.remove(item);
    }

    @Override
    public void buyItem(ItemList item, AbstractNPC abstractNpc, Player player) {
        if (!(abstractNpc instanceof Merchant)) {
            return;
        }
        Merchant merchant = (Merchant) abstractNpc;
        NewInventory merchantInventory = (NewInventory) merchant.getInventory();
        if (merchantInventory.contains(item)) {
            inventory.add(item);
            merchantInventory.removeItem(item);
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
        NewInventory merchantInventory = (NewInventory) merchant.getInventory();
        if (inventory.contains(item)) {
            inventory.remove(item);
            merchantInventory.addItem(item);
            System.out.println("You sold: " + item);
        } else {
            System.out.println("You don't have this item.");
        }
    }

    @Override
    public void openInventory(AbstractCharacter character) {
        if (character instanceof Merchant) {
            System.out.println("*Merchant opens Inventory*");
        } else if (character instanceof Player) {
            System.out.println("*Player opens Inventory*");
        }
    }

    @Override
    public void closeInventory(AbstractCharacter character) {
        if (character instanceof Merchant) {
            System.out.println("*Merchant closes Inventory*");
        } else if (character instanceof Player) {
            System.out.println("*Player closes Inventory*");
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
    public void useItem(ItemList item) {
        if (inventory.contains(item)) {

            item.setDurability((item.getDurability() - 1));
            if (item.getDurability() == 0) {
                inventory.remove(item);
            }
        }
    }

    public void addAll(List<ItemList> list) {
        inventory.addAll(list);
    }

    public boolean contains(ItemList item) {
        return inventory.contains(item);
    }


}
