package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.effects.Effect;
import my.fbk.npc.effects.InvisibilityEffect;

import java.util.Optional;

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
        Optional<Effect> existingEffect = character.getEffects().stream()
                .filter(e -> e instanceof InvisibilityEffect)
                .findFirst();
        if (existingEffect.isPresent()) {
            InvisibilityEffect existing = (InvisibilityEffect) existingEffect.get();
            existing.setEffectDuration(existing.getEffectDuration() + 3);
        } else {
            InvisibilityEffect inv = new InvisibilityEffect(3);
            inv.applyEffect(character);
        }
    }
}
