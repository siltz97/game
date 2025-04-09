package my.fbk.npc.effects;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;


@Getter
@Setter
public class InvisibilityEffect extends Effect {

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
        return "inv";
    }
    @Override
    public boolean equals(Object o) {
        if (o==null)
            return false;
        if (this == o)
            return true;
        if (!(o instanceof InvisibilityEffect))
            return false;
        return true;
    }

}
