package my.fbk.npc.BasicSpells;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AllNPC.AbstractNPC;

@Getter
@Setter
public class MindControlSpell implements Effects {
    int spellCost = 50;


    @Override
    public int spellCost() {
        return this.spellCost;
    }

    @Override
    public void applyEffect(AbstractCharacter character) {
        character.setEffects(this);
    }

    @Override
    public void removeEffect(AbstractCharacter character) {
        character.setRemoveEffect(this);
    }

    @Override
    public boolean hasEffect(AbstractCharacter character) {
        return character.getEffects() != null;
    }
    @Override
    public String getName() {
        return "mind";
    }
}
