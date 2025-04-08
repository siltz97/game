package my.fbk.npc.BasicSpells;

import my.fbk.npc.AbstractClass.AbstractCharacter;


public interface Effects {

    //npc
    default void applyEffect(AbstractCharacter character) {
    }

    default void removeEffect(AbstractCharacter character) {
    }

    default boolean hasEffect(AbstractCharacter character) {
        return character.getEffects() != null;
    }

    String getName();

    int spellCost();

}
