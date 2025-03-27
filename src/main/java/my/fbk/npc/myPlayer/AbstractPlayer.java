package my.fbk.npc.myPlayer;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
@Getter
@Setter
public abstract class AbstractPlayer extends AbstractCharacter {
    int money;


    public AbstractPlayer(int money, int health,int mana,int damage) {
        super(health,mana,damage);
        this.money = money;
    }


    public void speak() {
    }
    abstract public void attack();

}
