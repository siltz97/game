package my.fbk.npc.Enemy;


public class Goblin extends AbstractEnemy {

    public Goblin(int experience, int health, int mana, int damage) {
        super(experience, health, mana, damage);
    }

    @Override
    public int attack(int damage) {
        return damage;
    }
}
