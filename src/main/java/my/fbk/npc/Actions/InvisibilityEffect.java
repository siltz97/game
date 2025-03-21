package my.fbk.npc.Actions;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Speak.SilentSpeak;

public class InvisibilityEffect implements Effect {

    @Override
    public void applyEffect(AbstractNPC npc) {
        npc.setBehavior(new SilentSpeak());

    }
}
