package my.fbk.npc.BattleSpells;

import my.fbk.npc.Enemy.AbstractEnemy;
import my.fbk.npc.myPlayer.Player;

public class FireBall implements PlayerSpellsInterface {

    Player player;
    AbstractEnemy enemy;

    public FireBall(Player player, AbstractEnemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    @Override
    public void cast() {
        if (player.getMana() >= 30) {
            System.out.println("🔥 You cast Fireball!");
            enemy.setHealth(enemy.getHealth() - 50);
            player.setMana(player.getMana() - 30);
            System.out.println("Enemy now has " + enemy.getHealth() + " HP");
            System.out.println("Your MP is now " + player.getMana());
        } else {
            System.out.println("❌ You don't have enough MP!");
        }
    }
}
