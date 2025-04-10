package my.fbk.npc.effects;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

import java.util.List;

@Getter
@Setter
public abstract class Effect {


    protected int effectDuration ;

    public Effect(int effectDuration) {
        this.effectDuration = effectDuration;
    }
    //npc
    public abstract void applyEffect(AbstractCharacter character);

     public abstract void removeEffect(AbstractCharacter character);

    boolean hasEffect(AbstractCharacter character) {
        return character.getEffects() != null;
    }




}
