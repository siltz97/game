package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.NPC;
import my.fbk.npc.interfaces.Inventory;

import java.util.List;

public class Merchant extends NPC implements Inventory {

    public Merchant(int money) {
        super(money);
    }
    @Override
    public void speak() {
        System.out.println("Hello, adventurer! How can I help you?");
    }

    @Override
    public void openInventory() {
        System.out.println("Merchant opens inventory");
    }

    @Override
    public void closeInventory() {
        System.out.println("Merchant closes inventory");
    }

    @Override
    public void buyItem() {

    }

    @Override
    public void sellItem() {

    }
}
