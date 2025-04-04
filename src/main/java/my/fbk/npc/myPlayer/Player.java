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
    int basicHealth = 120;
    int basicMana = 100;
    int basicDamage = 25;
    public Player(int money, int health, int mana, int damage,int experience, int level) {
        super(money, health, mana,damage,experience,level);
        for (int i = 0; i < 2; i++) {
            inventory.addItemToInventory(ItemList.HEALTH_POTION);

        }

    }
    @Override
    public void speak() {
        System.out.println("Hi");
    }
    @Override
    public void attack() {
        System.out.println("Player attacks");
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
    public void useItem(ItemList item) {
        this.inventory.useItem(item,this);
    }

    public void seeMoney(){
        //noinspection StringTemplateMigration
        System.out.println("Player has: " + getMoney() + "$");

    }
    public void LevelUp(){
        System.out.println("Player leveled up!");
            setLevel(getLevel()+1);
            setExperience(getExperience()-100);
            setHealth((int) (getBasicHealth() * (1 + 0.14 * (getLevel()-1))));
            setMana((int) (getBasicMana() * (1 + 0.12 * (getLevel()-1))));
            setDamage((int) (getBasicDamage() * (1 + 0.1 * (getLevel()-1))));

    }



}
