package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Peasant extends AbstractNPC {

    public Peasant(int money,int health,int reputation,int mana) {
        super(money,health,reputation,mana);
    }


    @Override
    public void speak() {
        think();
       behavior.speak(this);
    }
    public String getName(){
        return "peasant";

    }
}
