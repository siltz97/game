package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Characters {
    private int money;

    public abstract void action();

    public Characters() {
    }

    public Characters(int money) {
        this.money = money;
    }

    public abstract void speak();
}
