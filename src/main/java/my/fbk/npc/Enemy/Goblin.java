package my.fbk.npc.Enemy;


import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.List;

@Getter
@Setter
public class Goblin extends AbstractEnemy {

    public Goblin(int experience, int health, int mana,int damage,int gold) {
        super(experience, health, mana,damage,gold);
    }

    @Override
    public void attack() {
        System.out.println("goblin attacks");
    }


    @Override
    public String getName() {
        return "goblin";
    }

}
