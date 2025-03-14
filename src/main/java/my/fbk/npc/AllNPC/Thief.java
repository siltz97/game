package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.NPC;

public class Thief extends NPC {
    Thief(int money) {
        super(money);
    }

    @Override
    public void speak() {
        System.out.println("(-_-)");

    }
}
