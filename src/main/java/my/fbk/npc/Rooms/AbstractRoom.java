package my.fbk.npc.Rooms;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.myPlayer.Player;

abstract class AbstractRoom {
    @Getter @Setter
    Player player = null;
    public abstract void moveNext();
}
