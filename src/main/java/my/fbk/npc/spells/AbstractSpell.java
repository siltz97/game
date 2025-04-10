package my.fbk.npc.spells;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractSpell {

    protected int cost = 0;

    AbstractSpell(int cost) {
        this.cost = cost;
    }

    public abstract String getName();


    public abstract void print();

    public abstract void apply(AbstractCharacter character);
}
