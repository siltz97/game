package my.fbk.npc.Enemy;

public class Skeleton extends AbstractEnemy {

    public Skeleton(int experience, int health, int mana, int damage) {
        super(experience, health, mana, damage);
    }

    @Override
    public void attack() {}
}
