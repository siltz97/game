package my.fbk.npc.speak;

import my.fbk.npc.all_npc.AbstractNPC;

public class MindControllSpeak implements SpeakBehavior{
    @Override
    public void speak(AbstractNPC npc) {
        System.out.println("What do you want my lord?");
    }
}
