package my.fbk.npc.Speak;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.AllNPC.Thief;

public class AggressiveSpeak implements SpeakBehavior {
    @Override
    public void speak(AbstractNPC npc) {
        if(npc instanceof Guard){
            System.out.println("omae wa mou shindeiru!");
        }else if(npc instanceof Peasant){
            System.out.println("dont speak with me!!!");
        }else if(npc instanceof Thief){
            System.out.println("Go away if you dont wanna die");
        }else if(npc instanceof Merchant){
            System.out.println("I won't sell you anything!!!!");
        }
    }
}
