package my.fbk.npc.Actions;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Thief;
import my.fbk.npc.myPlayer.Player;

public class BucketEffect {
    public static void applyBucket(Player player, AbstractNPC npc) {
        if (npc instanceof Guard) {
            System.out.println("something else");
        } else if (npc instanceof Thief) {
            System.out.println("something else thief");
        }
    }
}


