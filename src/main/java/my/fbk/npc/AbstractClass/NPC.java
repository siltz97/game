package my.fbk.npc.AbstractClass;

public abstract class NPC extends Characters {

    public NPC(int money) {
        super(money);
    }

    @Override
    public abstract void speak();

}
