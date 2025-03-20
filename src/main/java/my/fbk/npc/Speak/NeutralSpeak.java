package my.fbk.npc.Speak;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.AllNPC.Thief;

public class NeutralSpeak implements SpeakBehavior {

    @Override
    public void speak(AbstractNPC npc) {
        if (npc instanceof Guard) {
            System.out.println("I'm watching you!");
        } else if (npc instanceof Peasant) {
            System.out.println("What do you want from me!?");
        } else if (npc instanceof Thief) {
            System.out.println("(-_-)");
        } else if (npc instanceof Merchant) {
            System.out.println("Try me bitch!");
        }
    }

}
