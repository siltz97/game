package my.fbk.npc.spells;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

@Getter
@Setter
public abstract class Spell {

    protected int cost = 0;

    Spell(int cost) {
        this.cost = cost;
    }

    public abstract String getName();

    public int spellCost() {
        return cost;
    }

    public abstract void print();

    public abstract void apply(AbstractCharacter character);
}
