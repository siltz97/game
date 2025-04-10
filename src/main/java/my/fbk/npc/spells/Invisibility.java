package my.fbk.npc.spells;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.effects.AbstractEffect;
import my.fbk.npc.effects.InvisibilityAbstractEffect;

import java.util.Optional;

public class Invisibility extends AbstractSpell {

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
        Optional<AbstractEffect> existingEffect = character.getAbstractEffects().stream()
                .filter(e -> e instanceof InvisibilityAbstractEffect)
                .findFirst();
        if (existingEffect.isPresent()) {
            InvisibilityAbstractEffect existing = (InvisibilityAbstractEffect) existingEffect.get();
            existing.setEffectDuration(existing.getEffectDuration() + 3);
        } else {
            InvisibilityAbstractEffect inv = new InvisibilityAbstractEffect(3);
            inv.applyEffect(character);
        }
    }
}
