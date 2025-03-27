package my.fbk.npc.myPlayer;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.NewInventory;
import my.fbk.npc.inventory.ItemList;

import java.util.Random;
@Getter
@Setter
public class Player extends AbstractPlayer  {
    private int damage;
    private final NewInventory list = new NewInventory();
    private final Random rand = new Random();

    public Player(int money, int health, int mana, int damage) {
        super(money, health, mana,damage);
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

    @Override
    public void attack() {
        System.out.println("Player attacks");
    }
    public void useItem(ItemList item) {
        this.list.useItem(item,this);
    }

    public void seeMoney(){
        //noinspection StringTemplateMigration
        System.out.println("Player has: " + getMoney() + "$");

    }


}
