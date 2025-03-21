package my.fbk.npc.myPlayer;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AbstractClass.AbstractPlayer;
import my.fbk.npc.Actions.Effect;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.NewInventory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends AbstractPlayer  {

    private final NewInventory list = new NewInventory();
    private final Random rand = new Random();

    public Player(int money, int health,int mana) {
        super(money, health, mana);
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 5; i++) {
            list.addItem(itemArray[rand.nextInt(itemArray.length)]);
        }

    }
    public void buyItem(ItemList item, AbstractNPC abstractNpc) {
        list.buyItem(item, abstractNpc,this);
    }
    public void sellItem(ItemList item,AbstractNPC abstractNpc){
        list.sellItem(item, abstractNpc,this);
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

    public Inventory getInventory() {
        return list;
    }

    @Override
    public void speak() {
        System.out.println("Hi");
    }


    public void seeMoney(){
        //noinspection StringTemplateMigration
        System.out.println("Player has: " + getMoney() + "$");

    }

}
