package my.fbk.npc.Enemy;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractEnemy extends AbstractCharacter {

    public AbstractEnemy(int experience, int health, int mana, int damage,int money) {
        super(health,mana,damage,money,experience);
    }

    public abstract void attack();
    public abstract String getName();


}
