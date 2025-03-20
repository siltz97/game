package my.fbk.npc.myPlayer;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AbstractClass.AbstractPlayer;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.NewInventory;
import my.fbk.npc.inventory.ItemList;

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

    @Override
    public void speak() {
        System.out.println("Hi");
    }


    public void showInventory() {
      list.showInventory();
    }

    public Inventory getInventory() {
        return list;
    }

    public void seeMoney(){
        System.out.println("Player has: " + getMoney() + "$");

    }

}
