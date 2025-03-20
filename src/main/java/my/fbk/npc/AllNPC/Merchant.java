package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.NewInventory;
import my.fbk.npc.inventory.ItemList;

import java.util.Arrays;

public class Merchant extends AbstractNPC {
    NewInventory list = new NewInventory();

    public Merchant(int money, int health) {
        super(money,health);

        list.addAll(Arrays.asList(ItemList.values()));
    }

    @Override
    public void action() {

    }

    @Override
    public void speak() {
        System.out.println("Hello, adventurer! How can I help you?");
    }


    public Inventory getInventory() {
        return list;
    }
    public void openInventory() {
        list.openInventory(this);
    }
    public void closeInventory() {
        list.closeInventory(this);
    }
    public void showInventory() {
        list.showInventory();
    }
}
