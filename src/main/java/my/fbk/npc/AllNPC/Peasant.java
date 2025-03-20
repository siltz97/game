package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Speak.AggressiveSpeak;
import my.fbk.npc.Speak.FriendlySpeak;
import my.fbk.npc.Speak.NeutralSpeak;
import my.fbk.npc.Speak.SpeakBehavior;
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
}
