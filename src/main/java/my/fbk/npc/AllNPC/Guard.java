package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.NPC;

public class Guard extends NPC {
    Guard(int money) {
        super(money);
    }

    @Override
    public void speak() {
        System.out.println("For the peace in the Kingdom! For the Country!");
    }
}
