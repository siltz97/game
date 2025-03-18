package my.fbk.npc.AbstractClass;

public abstract class AbstractNPC extends AbstractCharacter {
    private int money;
    private int health;

    public AbstractNPC(int money, int health) {
        super(money,health);

    }
    @Override
    public abstract void action();

    @Override
    public abstract void speak();

}
