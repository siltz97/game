package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.myPlayer.Player;


public class Thief extends AbstractNPC {
    Player player;

    public Thief(int money,int health) {
        super(money,health);
    }

    @Override
    public void action() {

    }

    @Override
    public void speak() {
//        if (player.useItem())
//            System.out.println("Get out!");
//        else
            System.out.println("(-_-)");

    }
}