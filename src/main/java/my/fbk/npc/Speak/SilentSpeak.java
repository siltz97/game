package my.fbk.npc.Speak;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.AllNPC.Thief;

public class SilentSpeak implements SpeakBehavior {

    @Override
    public void speak(AbstractNPC npc) {
        System.out.println("...");
    }
}
