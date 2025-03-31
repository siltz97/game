package my.fbk.npc.Enemy;

public class Skeleton extends AbstractEnemy {

    public Skeleton(int experience, int health, int mana, int damage,int gold ) {
        super(experience, health, mana, damage,gold);
    }

    @Override
    public void attack() {}

    @Override
    public Skeleton createNew(int experience, int health, int mana, int damage,int gold) {
        return new Skeleton(experience, health, mana, damage,gold);
    }
    @Override
    public String getName() {
        return "skeleton";
    }
}
