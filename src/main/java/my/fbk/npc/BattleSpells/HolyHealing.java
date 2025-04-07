package my.fbk.npc.BattleSpells;

import my.fbk.npc.Enemy.AbstractEnemy;
import my.fbk.npc.myPlayer.Player;

public class HolyHealing implements PlayerSpellsInterface{

    Player player;
    AbstractEnemy enemy;

    public HolyHealing(Player player, AbstractEnemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void cast() {
        if(player.getMana()>=50){
            player.setMana(player.getMana()-50);
            player.setHealth(player.getHealth()+50);
            System.out.println("You restored 50 health: "+player.getHealth());
        }
    }
}
