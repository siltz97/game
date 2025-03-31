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

import java.util.List;
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
        if (choice == 0) {
            currentRoom = new BattleRoom(this);
            battleRoom.setPlayer(player);
            System.out.println("Moved to: " + currentRoom.getClass().getSimpleName());
            battleRoom.battle();
        } else if (choice == 1 || choice == 3 || choice == 4) {
            currentRoom = new SafeRoom(this);
            safeRoom.setPlayer(player);
            safeRoom.setAllNPC(List.of(
                    new Peasant(1, 1, 1, 1, 1),
                    new Guard(1, 1, 1, 1, 1),
                    new Thief(1, 1, 1, 1, 1),
                    new Merchant(99999, 1, 1, 1, 1))
            );
            System.out.println("Moved to: " + currentRoom.getClass().getSimpleName());
            safeRoom.npcInteraction();
        } else if (choice == 2) {
            currentRoom = new BossRoom(this);
            bossRoom.setPlayer(player);
            System.out.println("Moved to: " + currentRoom.getClass().getSimpleName());
            bossRoom.battle();
        }

    }


}
