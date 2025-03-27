package my.fbk.npc.BasicSpells;

import my.fbk.npc.AllNPC.AbstractNPC;

import java.util.ArrayList;
import java.util.List;


public interface Effects {

    int spellCost();
    default void applyEffect(AbstractNPC npc){}

    default void removeEffect(AbstractNPC npc) {}
    default boolean hasEffect(AbstractNPC npc) {
        return npc.getEffects() != null;
    }
     String getName();

}
