package my.fbk.npc.BasicSpells;

import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.Enemy.AbstractEnemy;

import java.util.ArrayList;
import java.util.List;


public interface Effects {

    int spellCost();
    default void applyEffect(AbstractNPC npc){}

    default void removeEffect(AbstractNPC npc) {}
    default boolean hasEffect(AbstractNPC npc) {
        return npc.getEffects() != null;
    }
    default void applyEffect(AbstractEnemy enemy){}

    default void removeEffect(AbstractEnemy enemy) {}
    default boolean hasEffect(AbstractEnemy enemy) {
        return enemy.getEffects() != null;
    }
     String getName();

}
