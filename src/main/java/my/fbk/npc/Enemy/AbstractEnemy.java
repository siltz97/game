package my.fbk.npc.Enemy;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractEnemy extends AbstractCharacter {
    int experience;
    int damage;

    public AbstractEnemy(int experience, int health, int mana, int damage) {
        super(mana, health);
        this.experience = experience;
        this.damage = damage;
    }

    public abstract void attack();

}
