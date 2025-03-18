package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.NPC;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merchant extends NPC implements Inventory {
    private List<ItemList> inventory;

    public Merchant(int money) {
        super(money);
        inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(ItemList.values()));
    }

    @Override
    public void action() {

    }

    @Override
    public void speak() {
        System.out.println("Hello, adventurer! How can I help you?");
    }

    @Override
    public List<ItemList> getInventory() {
        return inventory;
    }

    @Override
    public void openInventory() {
        System.out.println("*Merchant opens inventory*");
    }

    @Override
    public void closeInventory() {
        System.out.println("*Merchant closes inventory*");
    }

    @Override
    public void buyItem(ItemList item, Merchant merchant) {
    }

    @Override
    public void sellItem(ItemList item, Merchant merchant) {
    }

    public void addItem(ItemList item) {
        inventory.add(item);
    }

    public void removeItem(ItemList item) {
        inventory.remove(item);
    }
    @Override
    public void showInventory() {
        System.out.println("\nMerchant Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (ItemList item : inventory) {
                System.out.println(item + " - " + item.getDescription() + " ($" + item.getPrice() + ")");
            }
        }
    }
}
