package my.fbk.npc;

import my.fbk.npc.Rooms.AbstractRoom;
import my.fbk.npc.Rooms.BattleRoom;
import my.fbk.npc.Rooms.SafeRoom;
import my.fbk.npc.myPlayer.Player;

import java.util.Random;

public class Game {
    Player player;
    Random rand = new Random();
    SafeRoom safeRoom;
    BattleRoom battleRoom;
    AbstractRoom currentRoom;

    public Game() {
        player = new Player(100, 100, 100, 20);
        currentRoom = safeRoom;
        safeRoom = new SafeRoom(this);
        battleRoom = new BattleRoom(this);
    }

    public void main(String[] args) {


        Game game = new Game();
        game.moveNext();
//        game.safeRoom.setPlayer(player);
//        game.safeRoom.npcInteraction();
//        game.battleRoom.setPlayer(player);
//        game.battleRoom.battle();
    }

    public void moveNext() {
        int choice = rand.nextInt(2);
        if (choice == 0) {
            currentRoom = battleRoom;
            battleRoom.setPlayer(player);
            battleRoom.battle();
        } else {
            currentRoom = safeRoom;
            safeRoom.setPlayer(player);
            safeRoom.npcInteraction();
        }
        System.out.println("Moved to: " + currentRoom.getClass().getSimpleName());

    }


}
