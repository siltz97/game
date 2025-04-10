package my.fbk.npc.speak;

import my.fbk.npc.all_npc.AbstractNPC;
import my.fbk.npc.all_npc.Guard;
import my.fbk.npc.all_npc.Merchant;
import my.fbk.npc.all_npc.Peasant;
import my.fbk.npc.all_npc.Thief;

public class FriendlySpeak implements SpeakBehavior {

    @Override
    public void speak(AbstractNPC npc) {
        if(npc instanceof Guard){
            System.out.println("For the peace in the Kingdom! For the Country!");
        }else if(npc instanceof Peasant){
            System.out.println("Nice day for fishing, ain't it?");
        }else if(npc instanceof Thief){
            System.out.println("Do you know someone to rob?");
        }else if(npc instanceof Merchant){
            System.out.println("Hello, adventurer! How can I help you?");
        }
    }
}
