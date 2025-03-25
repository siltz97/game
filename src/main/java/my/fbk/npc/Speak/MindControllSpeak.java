package my.fbk.npc.Speak;

import my.fbk.npc.AllNPC.AbstractNPC;

public class MindControllSpeak implements SpeakBehavior{
    @Override
    public void speak(AbstractNPC npc) {
        System.out.println("What do you want my lord?");
    }
}
