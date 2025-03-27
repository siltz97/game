package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class AbstractCharacter {
    private int health;
    private int mana;
    private int damage;


    public AbstractCharacter(int health,int mana, int damage) {
        this.health = health;
        this.mana = mana;
        this.damage = damage;
    }




}
