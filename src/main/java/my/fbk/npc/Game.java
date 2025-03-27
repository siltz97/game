package my.fbk.npc;

import my.fbk.npc.Rooms.BattleRoom;
import my.fbk.npc.Rooms.InteractRoom;
import my.fbk.npc.myPlayer.Player;

public class Game {
    Player player;
    InteractRoom interactRoom = new InteractRoom();
    BattleRoom battleRoom = new BattleRoom();
    public void main(String[] args) {

        player = new Player(100, 100, 100, 20);

        Game game = new Game();
        game.interactRoom.setPlayer(player);
        game.interactRoom.npcInteraction();
        //game.battleRoom.setPlayer(player);
        //game.battleRoom.battle();
    }
}
