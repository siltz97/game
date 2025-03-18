package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.NPC;
import my.fbk.npc.myPlayer.Player;


public class Guard extends NPC {
    Player player;


    public Guard(int money) {
        super(money);
    }

    @Override
    public void action() {


    }

    @Override
    public void speak() {
        System.out.println("For the peace in the Kingdom! For the Country!");
    }
}
