package my.fbk.npc.inventory;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.Merchant;
import my.fbk.npc.my_player.Player;

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
    public void buyItem(ItemList item, AbstractCharacter npc, Player player) {
        if (!(npc instanceof Merchant)) {
            return;
        }
        Merchant merchant = (Merchant) npc;
        InventoryInteraction merchantInventory = (InventoryInteraction) merchant.getInventory();
        if (merchantInventory.contains(item)) {
            inventory.add(item);
            merchantInventory.removeItemFromInventory(item);
            player.setMoney(player.getMoney() - item.getPrice());
            merchant.setMoney(merchant.getMoney() + item.getPrice());
            System.out.println("You bought " + item.getName() + " for " + item.getPrice() + " gold.");
            System.out.println("Your current money: " + player.getMoney());
        } else {
            System.out.println("Item not available in Merchant's inventory.");
        }
    }

    @Override
    public void sellItem(ItemList item, AbstractCharacter npc, Player player) {
        if (!(npc instanceof Merchant)) {
            return;
        }
        Merchant merchant = (Merchant) npc;
        InventoryInteraction merchantInventory = (InventoryInteraction) merchant.getInventory();
        if (inventory.contains(item)) {
            inventory.remove(item);
            merchantInventory.addItemToInventory(item);
            System.out.println("You sold " + item.getName() + " for " + item.getPrice() + " gold.");
            player.setMoney(player.getMoney() + item.getPrice());
            merchant.setMoney(merchant.getMoney() - item.getPrice());
        } else {
            System.out.println("Item not found in your inventory. Please check the spelling.");
        }
    }


    @Override
    public void showInventory() {
        System.out.println("\nInventory:");
        if (inventory.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (ItemList item : inventory) {
                System.out.println(item.getName() + " - " + item.getDescription() + " ($" + item.getPrice() + ")");
            }
        }

    }

    @Override
    public void useItem(ItemList item, AbstractCharacter character) {
        if (inventory.contains(item)) {
            item.use(List.of(character));
            item.setDurability((item.getDurability() - 1));
            if (item.getDurability() <= 0) {
                inventory.remove(item);
            }
        }
    }

    public void addAllItemsToInventory(List<ItemList> list) {
        inventory.addAll(list);
    }

    @Override
    public boolean contains(ItemList item) {
        return inventory.contains(item);
    }

    @Override
    public int getInventorySize() {
        return inventory.size();
    }

    @Override
    public void takeLoot(Player player, AbstractCharacter enemy) {
        InventoryInteraction enemyInventory = (InventoryInteraction) enemy.getInventory();
        enemyInventory.getInventory().stream().forEach(item -> player.getInventory().addItemToInventory(item));
        enemyInventory.inventory.clear();
    }



}
