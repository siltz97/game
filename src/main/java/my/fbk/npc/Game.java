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
        safeRoom = new SafeRoom(this);
        battleRoom = new BattleRoom(this);
        currentRoom = safeRoom;
    }

    public void main(String[] args) {
        Game game = new Game();
        game.moveNext();
    }

    public void moveNext() {
        int choice = rand.nextInt(2);
        if (choice == 0) {
            currentRoom =new BattleRoom(this);
            battleRoom.setPlayer(player);
            System.out.println("Moved to: " + currentRoom.getClass().getSimpleName());
            battleRoom.battle();
        } else {
            currentRoom = new SafeRoom(this);
            safeRoom.setPlayer(player);
            System.out.println("Moved to: " + currentRoom.getClass().getSimpleName());
            safeRoom.npcInteraction();
        }

    }


}
