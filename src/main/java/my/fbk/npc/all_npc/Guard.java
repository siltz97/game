package my.fbk.npc.all_npc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Guard extends AbstractNPC {


    public Guard(int money, int health, int reputation, int mana, int damage,int experience) {
        super(money, health, reputation, mana, damage,experience);
    }

    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }

    @Override
    public String getName() {
        return "guard";

    }

}
