package my.fbk.npc.myPlayer;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.Random;
@Getter
@Setter
public class Player extends AbstractPlayer  {
    private final Random rand = new Random();

    public Player(int money, int health, int mana, int damage) {
        super(money, health, mana,damage);
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 3; i++) {
            inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
        }

    }
    public void buyItem(ItemList item, AbstractNPC abstractNpc) {
        inventory.buyItem(item, abstractNpc,this);
    }
    public void sellItem(ItemList item,AbstractNPC abstractNpc){
        inventory.sellItem(item, abstractNpc,this);
    }

    public void showInventory() {
        inventory.showInventory();
    }

    @Override
    public void speak() {
        System.out.println("Hi");
    }

    @Override
    public void attack() {
        System.out.println("Player attacks");
    }
    public void useItem(ItemList item) {
        this.inventory.useItem(item,this);
    }

    public void seeMoney(){
        //noinspection StringTemplateMigration
        System.out.println("Player has: " + getMoney() + "$");

    }



}
