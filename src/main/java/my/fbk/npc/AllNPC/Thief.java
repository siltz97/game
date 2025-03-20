package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Speak.AggressiveSpeak;
import my.fbk.npc.Speak.FriendlySpeak;
import my.fbk.npc.Speak.NeutralSpeak;
import my.fbk.npc.Speak.SpeakBehavior;
import my.fbk.npc.myPlayer.Player;

@Getter
@Setter
public class Thief extends AbstractNPC {

    public Thief(int money,int health,int reputation) {
        super(money,health,reputation);
    }

    @Override
    public void action() {

    }

    @Override
    public void speak() {
        think();
        behavior.speak(this);

    }
}