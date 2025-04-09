package my.fbk.npc;

import my.fbk.npc.Enemy.Goblin;
import my.fbk.npc.Rooms.BattleRoom;
import my.fbk.npc.factories.GoblinFactory;
import my.fbk.npc.myPlayer.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoblinTest {
    Goblin enemy;
    Player player = new Player(100, 100, 100, 25, 10, 1);

    @Test
    public void goblinInventoryTest() {
        Goblin warrior = GoblinFactory.makeGoblinWarrior(1);
        Assertions.assertTrue(warrior.getInventory().getInventorySize() == 1);
    }

    @Test
    public void goblinDieVsPlayer() {
        enemy = GoblinFactory.makeGoblinWarrior(1);
        BattleRoom battleRoom = new BattleRoom(new Game());
        battleRoom.setPlayer(player);
        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            player.attack();
            enemy.setHealth(enemy.getHealth() - player.getDamage());
            enemy.attack();
            player.setHealth(player.getHealth() - enemy.getDamage());

        }
        System.out.println("Player has " + player.getHealth() + " HP");
        System.out.println("Enemy has " + enemy.getHealth() + " HP");
        Assertions.assertTrue(player.getHealth() > 0 && enemy.getHealth()<=0,"nonononono");
    }
}
