package my.fbk.npc.effects;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

@Getter
@Setter
public abstract class Effect {

    protected int effectDuration = 0;
    //npc
    public abstract void applyEffect(AbstractCharacter character);

     public abstract void removeEffect(AbstractCharacter character);

    boolean hasEffect(AbstractCharacter character) {
        return character.getEffects() != null;
    }

    public abstract String getName();


}
