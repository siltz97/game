package my.fbk.npc.Actions;

import my.fbk.npc.AllNPC.AbstractNPC;


public interface Effects {

    void applyEffect(AbstractNPC npc);

    default void removeEffect(AbstractNPC npc) {
    }
    default boolean hasEffect(AbstractNPC npc) {
        return npc.getEffects() != null;
    }
}
