package my.fbk.npc.DamageSpells;

import my.fbk.npc.Enemy.AbstractEnemy;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.myPlayer.Player;

public class Spell {
    ItemList item;
    Player player;
    AbstractEnemy enemy;
    public Spell(ItemList item, Player player, AbstractEnemy enemy) {
        this.item = item;
        this.player = player;
        this.enemy = enemy;
    }
    public void useFireScroll() {
        if(item.equals(ItemList.FIRE_SCROLL)){
            System.out.println("You used the Fire Scroll");
            enemy.setHealth(enemy.getHealth() - 300);
        }

    }
}
