package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.Actions.Effects;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractCharacter {
    private int money;
    private int health;

    public AbstractCharacter(int money, int health) {
        this.money = money;
        this.health = health;
    }

    public abstract void speak();

    protected List<Effects> effects = new ArrayList<>();
    public boolean hasEffect(Effects effect) {
        return effects.contains(effect);
    }

    public void useEffect(Effects effect) {
        effects.add(effect);
    }

    public void removeEffect(Effects effect) {
        effects.remove(effect);
    }

    public abstract void action();
}
