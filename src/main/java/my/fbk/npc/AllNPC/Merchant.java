package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.inventory.NewInventory;

import java.util.Arrays;

@Getter
@Setter
public class Merchant extends AbstractNPC {
    NewInventory list = new NewInventory();

    public Merchant(int money, int health, int reputation, int mana,int damage) {
        super(money, health, reputation, mana, damage);
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

    public String getName() {
        return "merchant";
    }
}
