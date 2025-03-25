package my.fbk.npc.BasicSpells;

import my.fbk.npc.AllNPC.AbstractNPC;

import java.util.List;


public interface Effects {

    default void applyEffect(AbstractNPC npc){}

    default void removeEffect(AbstractNPC npc) {}
    default boolean hasEffect(AbstractNPC npc) {
        return npc.getEffects() != null;
    }
     String getName();

}
