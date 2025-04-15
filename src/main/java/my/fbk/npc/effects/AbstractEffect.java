package my.fbk.npc.effects;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractEffect {


    protected int effectDuration ;

    public AbstractEffect(int effectDuration) {
        this.effectDuration = effectDuration;
    }
    //npc
    public abstract void applyEffect(AbstractCharacter character);

     public abstract void removeEffect(AbstractCharacter character);

    boolean hasEffect(AbstractCharacter character) {
        return character.getEffects() != null;
    }




}
