package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.effects.Effect;
import my.fbk.npc.effects.InvisibilityEffect;
import my.fbk.npc.effects.MindControlEffect;
import my.fbk.npc.Speak.*;


@Getter
@Setter
public abstract class AbstractNPC extends AbstractCharacter {
    protected SpeakBehavior behavior;
    private int reputation;

    public AbstractNPC(int money, int health, int reputation, int mana, int damage, int experience) {
        super(health, mana, damage, money, experience);
        this.reputation = reputation;
        behavior = new NeutralSpeak();
    }


    public abstract void speak();

    public void think() {
        if (getReputation() > 80) {
            setBehavior(new FriendlySpeak());
        } else if (getReputation() > 50 && getReputation() < 80) {
            setBehavior(new NeutralSpeak());
        } else if (getReputation() < 50) {
            setBehavior(new AggressiveSpeak());
        }
        for (Effect e : effects) {
            if (e != null && e instanceof InvisibilityEffect) {
                setBehavior(new SilentSpeak());
            } else if (e != null && e instanceof MindControlEffect) {
                setBehavior(new MindControllSpeak());
            }
        }
    }


    public void removeEffect(Effect effect) {
        effects.remove(effect);
    }

    public String getName() {
        return "";
    }

}
