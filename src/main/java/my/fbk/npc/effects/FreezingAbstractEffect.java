package my.fbk.npc.effects;

import my.fbk.npc.abstract_class.AbstractCharacter;

public class FreezingAbstractEffect extends AbstractEffect {


    public FreezingAbstractEffect(int effectDuration) {
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
    public boolean equals(Object o) {
        if (o==null)
            return false;
        if (this == o)
            return true;
        if (!(o instanceof FreezingAbstractEffect))
            return false;
        return true;
    }

}
