package my.fbk.npc;

import my.fbk.npc.AbstractClass.Characters;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.myPlayer.Player;

public class Room {
    Characters peasant = new Peasant(1);
    Characters player = new Player(100);
    public void exit(Characters caracter) {
        if(caracter instanceof Peasant) {
            player.speak();
            peasant.speak();
        }
    }
    public static void main(String[] args){
        Room room = new Room();
    }
}
