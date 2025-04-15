package my.fbk.npc.enemy;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.effects.FreezingEffect;

@Getter
@Setter
public abstract class AbstractEnemy extends AbstractCharacter {

    public AbstractEnemy(int experience, int health, int mana, int damage,int money) {
        super(health,mana,damage,money,experience);
    }

    public abstract void attack();
    public abstract String getName();

    public int getDamage(){
        if(this.effects.contains(new FreezingEffect(5))){
            return 0;
        }else
            return this.damage;
    }


}
