package my.fbk.npc.myPlayer;

import my.fbk.npc.AbstractClass.AbstractCharacter;

public abstract class AbstractPlayer extends AbstractCharacter {


    public AbstractPlayer(int money, int health,int mana) {
        super(money, health,mana);
    }

    @Override
    public void speak() {
    }
    abstract public void attack();

}
