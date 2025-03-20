package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractCharacter {
    private int money;
    private int health;


    public AbstractCharacter(int money, int health) {
        this.money = money;
        this.health = health;
    }

    public abstract void action();

    public abstract void speak();

}
