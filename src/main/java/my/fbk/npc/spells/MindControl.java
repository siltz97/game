package my.fbk.npc.spells;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.effects.AbstractEffect;
import my.fbk.npc.effects.MindControlAbstractEffect;

import java.util.Optional;

public class MindControl extends AbstractSpell {

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
        Optional<AbstractEffect> existingEffect = character.getAbstractEffects().stream()
                .filter(e -> e instanceof MindControlAbstractEffect)
                .findFirst();
        if (existingEffect.isPresent()) {
            MindControlAbstractEffect existing = (MindControlAbstractEffect) existingEffect.get();
            existing.setEffectDuration(existing.getEffectDuration() + 3);
        } else {
            MindControlAbstractEffect inv = new MindControlAbstractEffect(3);
            inv.applyEffect(character);
        }
    }
}
