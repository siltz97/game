package my.fbk.npc.effects;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;


@Getter
@Setter
public class InvisibilityAbstractEffect extends AbstractEffect {

    public InvisibilityAbstractEffect(int effectDuration) {
        super(effectDuration);
    }

    @Override
    public void applyEffect(AbstractCharacter character) {
            character.setAbstractEffects(this);
    }

    @Override
    public void removeEffect(AbstractCharacter character) {
        if(hasEffect(character)) {
            if (this.effectDuration == 0) {
                character.removeEffect(this);
            }
        }
    }
    @Override
    public boolean hasEffect(AbstractCharacter character) {
        return character.getAbstractEffects() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null)
            return false;
        if (this == o)
            return true;
        if (!(o instanceof InvisibilityAbstractEffect))
            return false;
        return true;
    }

}
