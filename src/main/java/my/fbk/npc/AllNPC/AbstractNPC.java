package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.BasicSpells.Effects;
import my.fbk.npc.BasicSpells.InvisibilitySpell;
import my.fbk.npc.BasicSpells.MindControlSpell;
import my.fbk.npc.Speak.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public abstract class AbstractNPC extends AbstractCharacter {
    protected SpeakBehavior behavior;
    List<Effects> effects = new ArrayList<>();
    private int reputation;
    private int money;

    public AbstractNPC(int money, int health, int reputation, int mana,int damage) {
        super(health, mana,damage);
        this.money = money;
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
        for (Effects e : effects) {
            if (e != null && e instanceof InvisibilitySpell) {
                setBehavior(new SilentSpeak());
            }else if(e != null && e instanceof MindControlSpell) {
                setBehavior(new MindControllSpeak());
            }
        }
    }

    public boolean hasEffect(Effects effect) {
        return effect != null && effects.contains(effect);
    }

    public void setEffects(Effects effect) {
        effects.add(effect);
    }

    public void setRemoveEffect(Effects effect) {
        effects.remove(effect);
    }


    abstract public String getName();

}
