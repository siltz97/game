package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.NPC;

public class Peasant extends NPC {

    public Peasant(int money) {
        super(money);
    }
    @Override
    public void speak() {
        System.out.println("Nice day for fishing, ain't it?");

    }
}
