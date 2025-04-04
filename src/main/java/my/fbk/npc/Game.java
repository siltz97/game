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
        if (choice % 10 != 0 && choice != 0 && choice % 11 != 0 && choice % 5 != 0) {
            choice++;
            currentRoom = new BattleRoom(this);
            battleRoom.setPlayer(player);
            battleRoom.battle();

        } else if (choice == 0 || choice % 5 == 0 && choice % 10 != 0 && choice % 11 == 0) {
            choice++;
            currentRoom = new SafeRoom(this);
            safeRoom.setPlayer(player);
            safeRoom.npcInteraction();
        } else if (choice % 10 == 0) {
            choice++;
            currentRoom = new BossRoom(this);
            bossRoom.setPlayer(player);
            bossRoom.battle();
        }


    }


}
