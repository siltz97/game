package my.fbk.npc.Enemy;

public class Skeleton extends AbstractEnemy {

    public Skeleton(int experience, int health, int mana, int damage,int gold ) {
        super(experience, health, mana, damage,gold);
    }

    @Override
    public void attack() {}

    @Override
    public String getName() {
        return "skeleton";
    }
}
