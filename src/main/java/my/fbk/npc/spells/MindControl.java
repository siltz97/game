package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.effects.MindControlEffect;

public class MindControl extends Spell {

    public MindControl(int cost) {
        super(cost);
    }

    @Override
    public String getName() {
        return "mind";
    }

    @Override
    public void print() {
        System.out.println("Player casts a mind control spell");
    }

    @Override
    public void apply(AbstractCharacter character) {
        MindControlEffect effect = new MindControlEffect(5);
        effect.applyEffect(character);
    }
}
