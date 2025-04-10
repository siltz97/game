package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.effects.Effect;
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
        setEnemyDamage(character,effect);
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

    public int setEnemyDamage(AbstractCharacter character, Effect effect) {
        if(character.hasEffect(effect)) {
            return 0;
        }else
            return character.getDamage();
    }
}
