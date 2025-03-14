package my.fbk.npc.AbstractClass;

public abstract class Characters {
    private int money;
    public Characters(int money) {
        this.money = money;
    }

    public abstract void speak();
}
