package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thief extends AbstractNPC {

    public Thief(int money,int health,int reputation,int mana, int damage,int experience) {
        super(money, health, reputation, mana, damage,experience);
    }
    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }

    @Override
    public String getName(){
        return "thief";
    }
}