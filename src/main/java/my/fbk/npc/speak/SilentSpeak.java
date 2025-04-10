package my.fbk.npc.speak;

import my.fbk.npc.all_npc.AbstractNPC;

public class SilentSpeak implements SpeakBehavior {

    @Override
    public void speak(AbstractNPC npc) {
            System.out.println("...");
    }
}
