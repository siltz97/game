package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.Arrays;

@Getter
@Setter
public class Merchant extends AbstractNPC {

    public Merchant(int money, int health, int reputation, int mana,int damage) {
        super(money, health, reputation, mana, damage);
    }

    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }

    public void showInventory() {
        inventory.showInventory();
    }

    public String getName() {
        return "merchant";
    }
}
