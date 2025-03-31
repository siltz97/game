package my.fbk.npc.Enemy;

public class Zombie extends AbstractEnemy {

    public Zombie(int experience, int health, int mana, int damage) {
        super(experience, health, mana, damage);
    }

    @Override
    public void attack() {}

    @Override
    public Zombie createNew(int experience, int health, int mana, int damage) {
        return new Zombie(experience, health, mana, damage);
    }
    @Override
    public String getName() {
        return "zombie";
    }
}
