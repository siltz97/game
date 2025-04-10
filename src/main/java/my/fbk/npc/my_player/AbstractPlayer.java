package my.fbk.npc.my_player;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;

@Getter
@Setter
public abstract class AbstractPlayer extends AbstractCharacter {
    int level;

    public AbstractPlayer(int money, int health, int mana, int damage, int experience, int level) {
        super(health, mana, damage, money,experience);
        this.level = level;
    }

    abstract public void attack();

}
