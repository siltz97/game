package my.fbk.npc.Enemy;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.BasicSpells.Effects;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractEnemy extends AbstractCharacter {
    int experience;
    int gold;
    List<Effects> effects = new ArrayList<>();

    public AbstractEnemy(int experience, int health, int mana, int damage,int gold) {
        super(health,mana,damage);
        this.experience = experience;
        this.gold = gold;
    }

    public abstract void attack();
    public abstract String getName();


}
