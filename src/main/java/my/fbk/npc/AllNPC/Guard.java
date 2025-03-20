package my.fbk.npc.AllNPC;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Speak.AggressiveSpeak;
import my.fbk.npc.Speak.FriendlySpeak;
import my.fbk.npc.Speak.NeutralSpeak;
import my.fbk.npc.Speak.SpeakBehavior;
import my.fbk.npc.myPlayer.Player;


public class Guard extends AbstractNPC {


    public Guard(int money,int health,int reputation,int mana) {
        super(money,health,reputation,mana);


    }


    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }
}
