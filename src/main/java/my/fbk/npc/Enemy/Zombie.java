package my.fbk.npc.Enemy;

public class Zombie extends AbstractEnemy {

    public Zombie(int experience, int health, int mana, int damage,int gold) {
        super(experience, health, mana, damage,gold);
    }

    @Override
    public void attack() {}

    @Override
    public Zombie createNew(int experience, int health, int mana, int damage,int gold) {
        return new Zombie(experience, health, mana, damage,gold);
    }
    @Override
    public String getName() {
        return "zombie";
    }
}
