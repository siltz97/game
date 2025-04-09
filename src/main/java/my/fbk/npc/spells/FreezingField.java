package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;

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
        character.setDamage(0);
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
