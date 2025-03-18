package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.myPlayer.Player;

public class Peasant extends AbstractNPC {
    Player player;

    public Peasant(int money,int health) {
        super(money,health);
    }

    @Override
    public void action() {

    }

    @Override
    public void speak() {
//        if (player.useItem())
//            System.out.println("I'M BLIND!!!");
//        else
            System.out.println("Nice day for fishing, ain't it?");

    }
}
