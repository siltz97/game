package my.fbk.npc;

import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.AllNPC.Thief;
import my.fbk.npc.Rooms.AbstractRoom;
import my.fbk.npc.Rooms.BattleRoom;
import my.fbk.npc.Rooms.BossRoom;
import my.fbk.npc.Rooms.SafeRoom;
import my.fbk.npc.myPlayer.Player;

import java.util.Arrays;
import java.util.Random;

public class Game {
    Player player;
    Random rand = new Random();
    AbstractRoom currentRoom;
    BattleRoom battleRoom;
    SafeRoom safeRoom;
    BossRoom bossRoom;

    public Game() {
        player = new Player(100, 100, 100, 20);
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
        int choice = rand.nextInt(5);
        if (choice == 0 || choice == 1) {
            currentRoom = new BattleRoom(this);
            battleRoom.setPlayer(player);

            battleRoom.battle();
        } else if (choice == 2 || choice == 3) {
            currentRoom = new SafeRoom(this);
            safeRoom.setPlayer(player);
            safeRoom.npcInteraction();
        } else {
            currentRoom = new BossRoom(this);
            bossRoom.setPlayer(player);

            bossRoom.battle();
        }

    }


}
