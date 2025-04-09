package my.fbk.npc.effects;

import my.fbk.npc.AbstractClass.AbstractCharacter;

public class FreezingEffect extends Effect {


    public FreezingEffect(int effectDuration) {
        super(effectDuration);
    }

    @Override
    public void applyEffect(AbstractCharacter character) {
        character.setEffects(this);


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
        if (!(o instanceof FreezingEffect))
            return false;
        return true;
    }

}
