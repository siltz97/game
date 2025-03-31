package my.fbk.npc.Enemy;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.BasicSpells.Effects;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractEnemy extends AbstractCharacter {
    int experience;
    List<Effects> effects = new ArrayList<>();

    public AbstractEnemy(int experience, int health, int mana, int damage) {
        super(mana, health,damage);
        this.experience = experience;
    }

    public abstract void attack();
    public abstract AbstractEnemy createNew(int experience, int health, int mana, int damage);
    public abstract String getName();


}
