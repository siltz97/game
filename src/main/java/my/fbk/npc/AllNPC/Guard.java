package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.myPlayer.Player;


public class Guard extends AbstractNPC {



    public Guard(int money,int health) {
        super(money,health);

    }

    @Override
    public void action() {


    }

    @Override
    public void speak() {
            System.out.println("For the peace in the Kingdom! For the Country!");
    }
}
