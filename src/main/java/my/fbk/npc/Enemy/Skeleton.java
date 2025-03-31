package my.fbk.npc.Enemy;

public class Skeleton extends AbstractEnemy {

    public Skeleton(int experience, int health, int mana, int damage) {
        super(experience, health, mana, damage);
    }

    @Override
    public void attack() {}

    @Override
    public Skeleton createNew(int experience, int health, int mana, int damage) {
        return new Skeleton(experience, health, mana, damage);
    }
    @Override
    public String getName() {
        return "skeleton";
    }
}
