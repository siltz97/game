package my.fbk.npc.myPlayer;

import my.fbk.npc.AbstractClass.Characters;
import my.fbk.npc.interfaces.Inventory;

import java.util.ArrayList;
import java.util.List;

public class Player extends Characters implements Inventory {
    List<String> s = new ArrayList<>();
    public Player(int money) {
        super(money);
    }
    @Override
    public void speak() {
        System.out.println("Hi");
    }


    @Override
    public void openInventory() {
        System.out.println("Player opens inventory");
    }

    @Override
    public void closeInventory() {
        System.out.println("Player closes inventory");
    }

    @Override
    public void buyItem() {

    }

    @Override
    public void sellItem() {

    }
}
