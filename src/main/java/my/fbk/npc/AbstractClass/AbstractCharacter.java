package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class AbstractCharacter {
    private int money;
    private int health;
    private int mana;


    public AbstractCharacter(int money, int health,int mana) {
        this.money = money;
        this.health = health;
        this.mana = mana;
    }


    public abstract void speak();

}
