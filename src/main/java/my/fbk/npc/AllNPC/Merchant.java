package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.NewInventory;
import my.fbk.npc.inventory.ItemList;

import java.util.Arrays;

@Getter
@Setter
public class Merchant extends AbstractNPC {
    NewInventory list = new NewInventory();

    public Merchant(int money,int health,int reputation,int mana) {
        super(money,health,reputation,mana);


        list.addAll(Arrays.asList(ItemList.values()));
    }


    @Override
    public void speak() {
        think();
        behavior.speak(this);
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
