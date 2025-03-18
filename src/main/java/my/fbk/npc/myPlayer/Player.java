package my.fbk.npc.myPlayer;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AbstractClass.AbstractPlayer;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends AbstractPlayer implements Inventory {

    private final Random rand = new Random();
    private List<ItemList> inventory;

    public Player(int money,int health) {
        super(money,health);
        inventory = new ArrayList<>();
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 5; i++) {
            inventory.add(itemArray[rand.nextInt(itemArray.length)]);
        }

    }

    @Override
    public void speak() {
        System.out.println("Hi");
    }
    @Override
    public void action() {

    }

    @Override
    public void openInventory() {
        System.out.println("*Player opens inventory*");
    }

    @Override
    public void closeInventory() {
        System.out.println("*Player closes inventory*");
    }

    @Override
    public void buyItem(ItemList item, AbstractNPC abstractNpc) {
        if (((Merchant) abstractNpc).getInventory().contains(item)) {
            inventory.add(item);
            ((Merchant) abstractNpc).removeItem(item);
            System.out.println("Player bought: " + item);
        } else {
            System.out.println("Item not available in Merchant's inventory.");
        }
    }

    @Override
    public void sellItem(ItemList item, AbstractNPC abstractNpc) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            ((Merchant) abstractNpc).addItem(item);
            System.out.println("You sold: " + item);
        } else {
            System.out.println("You don't have this item.");
        }
    }

    @Override
    public void showInventory() {
        System.out.println("Player's money: " + getMoney());
        System.out.println("\nPlayer Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (ItemList item : inventory) {
                System.out.println(item + " - " + item.getDescription() + " ($" + item.getPrice() + ")");
            }
        }
    }

    @Override
    public List<ItemList> getInventory() {
        return inventory;
    }

}
