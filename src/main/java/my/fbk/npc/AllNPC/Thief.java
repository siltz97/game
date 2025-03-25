package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thief extends AbstractNPC {

    public Thief(int money,int health,int reputation,int mana) {
        super(money, health, reputation, mana);

    }
    @Override
    public void speak() {
        think();
        behavior.speak(this);

    }
}