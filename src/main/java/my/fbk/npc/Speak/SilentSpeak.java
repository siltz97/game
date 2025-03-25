package my.fbk.npc.Speak;

import my.fbk.npc.AllNPC.AbstractNPC;

public class SilentSpeak implements SpeakBehavior {

    @Override
    public void speak(AbstractNPC npc) {
            System.out.println("...");
    }
}
