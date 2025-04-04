package my.fbk.npc.myPlayer;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractPlayer extends AbstractCharacter {
    private int money;
    private int experience;
    int level;

    public AbstractPlayer(int money, int health, int mana, int damage, int experience, int level) {
        super(health, mana, damage);
        this.money = money;
        this.experience = experience;
        this.level = level;
    }


    public void speak() {
    }

    abstract public void attack();

}
