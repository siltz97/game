package my.fbk.npc.spells;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.effects.AbstractEffect;
import my.fbk.npc.effects.MindControlEffect;

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
        Optional<AbstractEffect> existingEffect = character.getEffects().stream()
                .filter(e -> e instanceof MindControlEffect)
                .findFirst();
        if (existingEffect.isPresent()) {
            MindControlEffect existing = (MindControlEffect) existingEffect.get();
            existing.setEffectDuration(existing.getEffectDuration() + 3);
        } else {
            MindControlEffect inv = new MindControlEffect(3);
            inv.applyEffect(character);
        }
    }
}
