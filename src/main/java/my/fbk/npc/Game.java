package my.fbk.npc;

import my.fbk.npc.Rooms.AbstractRoom;
import my.fbk.npc.Rooms.BattleRoom;
import my.fbk.npc.Rooms.BossRoom;
import my.fbk.npc.Rooms.SafeRoom;
import my.fbk.npc.myPlayer.Player;

import java.util.Random;

public class Game {
    int choice = 0;
    Player player;
    Random rand = new Random();
    AbstractRoom currentRoom;
    BattleRoom battleRoom;
    SafeRoom safeRoom;
    BossRoom bossRoom;

    public Game() {
        player = new Player(100, 120, 100, 25, 0, 1);
        currentRoom = safeRoom;
        safeRoom = new SafeRoom(this);
        battleRoom = new BattleRoom(this);
        bossRoom = new BossRoom(this);
    }

    public void main(String[] args) {
        Game game = new Game();
        game.moveNext();
    }

    public void moveNext() {
        if (choice % 10 == 0 && choice != 0) {
            choice++;
            currentRoom = new BossRoom(this);
            bossRoom.setPlayer(player);
            System.out.println("You are in the room number: " + (choice - 1));
            bossRoom.battle();
        } else if (choice == 0 || choice % 5 == 0 || choice % 10 == 1 && choice != 1) {
            choice++;
            currentRoom = new SafeRoom(this);
            safeRoom.setPlayer(player);
            System.out.println("You are in the room number: " + (choice - 1));
            safeRoom.npcInteraction();
        } else  {
            choice++;
            currentRoom = new BattleRoom(this);
            battleRoom.setPlayer(player);
            System.out.println("You are in the room number: " + (choice - 1));
            battleRoom.battle();
        }


    }


}
