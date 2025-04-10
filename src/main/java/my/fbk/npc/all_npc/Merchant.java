package my.fbk.npc.all_npc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Merchant extends AbstractNPC {

    public Merchant(int money, int health, int reputation, int mana,int damage,int experience) {
        super(money, health, reputation, mana, damage,experience);
    }

    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }

    public void showInventory() {
        inventory.showInventory();
    }

    @Override
    public String getName() {
        return "merchant";
    }
}
