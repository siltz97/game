package my.fbk.npc.Enemy;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractEnemy extends AbstractCharacter {
    int experience;

    public AbstractEnemy(int experience, int health, int mana, int damage) {
        super(mana, health,damage);
        this.experience = experience;
    }

    public abstract void attack();

}
