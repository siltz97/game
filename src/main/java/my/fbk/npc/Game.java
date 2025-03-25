package my.fbk.npc;

import my.fbk.npc.Rooms.SafeRoom;

public class Game {
    SafeRoom safeRoom = new SafeRoom();
    public void main(String[] args) {
        Game game = new Game();
        game.safeRoom.npcInteraction();
    }
}
