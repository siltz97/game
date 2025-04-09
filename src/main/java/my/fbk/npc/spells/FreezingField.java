package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.effects.FreezingEffect;

public class FreezingField extends Spell {
    public FreezingField(int cost) {
        super(cost);
    }

    @Override
    public String getName() {
        return "";
    }
    @Override
    public void print(){
        System.out.println("You Casted Freezing Field");
    }

    @Override
    public void apply(AbstractCharacter character) {
        FreezingEffect effect = new FreezingEffect(5);
        effect.applyEffect(character);
    }

    @Override
    public boolean equals(Object o) {
        if (o==null)
            return false;
        if (this == o)
            return true;
        if (!(o instanceof FreezingField))
            return false;
        return true;
    }
}
