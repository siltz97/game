package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class AbstractCharacter {
    private int health;
    private int mana;


    public AbstractCharacter(int health,int mana) {
        this.health = health;
        this.mana = mana;
    }




}
