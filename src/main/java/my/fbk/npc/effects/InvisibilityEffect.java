package my.fbk.npc.effects;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.AbstractNPC;


@Getter
@Setter
public class InvisibilityEffect extends AbstractEffect {

    public InvisibilityEffect(int effectDuration) {
        super(effectDuration);
    }

    @Override
    public void applyEffect(AbstractCharacter character) {
        character.setEffects(this);
        if (character instanceof AbstractNPC) {
            ((AbstractNPC) character).think();
        }
    }

    @Override
    public void removeEffect(AbstractCharacter character) {
        if (hasEffect(character)) {
            if (this.effectDuration == 0) {
                character.removeEffect(this);
            }
        }
    }

    @Override
    public boolean hasEffect(AbstractCharacter character) {
        return character.getEffects() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (!(o instanceof InvisibilityEffect))
            return false;
        return true;
    }

}
