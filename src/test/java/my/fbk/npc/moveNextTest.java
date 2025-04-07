package my.fbk.npc;

import my.fbk.npc.Rooms.AbstractRoom;
import my.fbk.npc.Rooms.BattleRoom;
import my.fbk.npc.Rooms.BossRoom;
import my.fbk.npc.Rooms.SafeRoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class moveNextTest {
    int choice = 0;
    AbstractRoom currentRoom = null;

    @Test
    @DisplayName("BattleRoomSelect")
    public void moveNextBattleRoomTest() {
        //'choice' is always 1 ahead from current room
        while (choice < 13) {
            if (choice % 10 == 0 && choice != 0) {
                choice++;
                currentRoom = new BossRoom(new Game());
            } else if (choice == 0 || choice % 5 == 0 || choice % 10 == 1 && choice != 1) {
                choice++;
                currentRoom = new SafeRoom(new Game());
            } else {
                choice++;
                currentRoom = new BattleRoom(new Game());
            }
        }
        System.out.println(choice);
        Assertions.assertTrue(choice == 13 && currentRoom instanceof BattleRoom, "not right room");

    }

    @Test
    @DisplayName("SafeRoomSelect")
    public void moveNextSafeRoomTest() {
        //'choice' is always 1 ahead from current room
        while (choice < 12) {
            if (choice % 10 == 0 && choice != 0) {
                choice++;
                currentRoom = new BossRoom(new Game());
            } else if (choice == 0 || choice % 5 == 0 || choice % 10 == 1 && choice != 1) {
                choice++;
                currentRoom = new SafeRoom(new Game());
            } else {
                choice++;
                currentRoom = new BattleRoom(new Game());;
            }
        }
        System.out.println(choice);
        Assertions.assertTrue(choice == 12 && currentRoom instanceof SafeRoom,"not right room");


    }
    @Test
    @DisplayName("BossRoomSelect")
    public void moveNextBossRoomTest() {
        //'choice' is always 1 ahead from current room
        while (choice < 11) {
            if (choice % 10 == 0 && choice != 0) {
                choice++;
                currentRoom = new BossRoom(new Game());
            } else if (choice == 0 || choice % 5 == 0 || choice % 10 == 1 && choice != 1) {
                choice++;
                currentRoom = new SafeRoom(new Game());
            } else {
                choice++;
                currentRoom = new BattleRoom(new Game());;
            }
        }
        System.out.println(choice);
        Assertions.assertTrue(choice == 11 && currentRoom instanceof BossRoom,"not right room");


    }

}
