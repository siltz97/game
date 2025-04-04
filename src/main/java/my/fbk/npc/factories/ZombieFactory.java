package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Zombie;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.ItemList;

import java.util.Random;

public class ZombieFactory {

    private static final Random rand = new Random();
    private static final int baseWarriorHealth = 100;
    private static final int baseWarriorMana = 5;
    private static final int baseWarriorDamage = 25;
    private static final int baseMageHealth = 85;
    private static final int baseMageMana = 15;
    private static final int baseMageDamage = 18;
    private static final int baseBossHealth = 120;
    private static final int baseBossMana = 10;
    private static final int baseBossDamage = 30;

    public static Zombie makeZombieWarrior(int level) {
        Zombie zombieWarrior = new Zombie(30, 100, 5, 25, rand.nextInt(30)+20);
        zombieWarrior.setInventory(createInventory());
        zombieWarrior.setHealth((int) (baseWarriorHealth *(1 + 0.12 * (level-1))));
        zombieWarrior.setMana((int) (baseWarriorMana * (1 + 0.03 * (level-1))));
        zombieWarrior.setDamage((int) (baseWarriorDamage * (1 + 0.09 * (level-1))));
        return zombieWarrior;
    }

    public static Zombie makeZombieMage(int level) {
        Zombie zombieMage = new Zombie(29, 85, 15, 18, rand.nextInt(30)+20);
        zombieMage.setInventory(createInventory());
        zombieMage.setHealth((int) (baseMageHealth *(1 + 0.07 * (level-1))));
        zombieMage.setMana((int) (baseMageMana * (1 + 0.1 * (level-1))));
        zombieMage.setDamage((int) (baseMageDamage * (1 + 0.06 * (level-1))));
        return zombieMage;
    }

    public static Zombie makeZombieBoss(int level) {
        Zombie zombieBoss = new Zombie(88, 120, 10, 30, rand.nextInt(50)+50);
        zombieBoss.setInventory(createInventory());
        zombieBoss.setHealth((int) (baseBossHealth *(1 + 0.15 * (level-1))));
        zombieBoss.setMana((int) (baseBossMana * (1 + 0.08 * (level-1))));
        zombieBoss.setDamage((int) (baseBossDamage * (1 + 0.12 * (level-1))));
        return zombieBoss;
    }

    public static Zombie MakeRandomEnemy(int level) {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeZombieWarrior(level);
        else
            return makeZombieMage(level);
    }

    public static Inventory createInventory() {
        InventoryInteraction inventory = new InventoryInteraction();
        ItemList[] itemArray = ItemList.values();
        for (int i = 0; i < 1; i++) {
            inventory.addItemToInventory(itemArray[rand.nextInt(itemArray.length)]);
        }
        return inventory;
    }
}
