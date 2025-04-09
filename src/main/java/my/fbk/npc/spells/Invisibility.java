package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.effects.InvisibilityEffect;

public class Invisibility extends Spell {

    public Invisibility(int cost) {
        super(cost);
    }

    @Override
    public String getName() {
        return "inv";
    }

    @Override
    public void print() {
        System.out.println("You casted Invisibility");
    }

    @Override
    public void apply(AbstractCharacter character) {
      InvisibilityEffect inv =  new InvisibilityEffect();
      inv.applyEffect(character);
      inv.setEffectDuration(5);
    }
}
