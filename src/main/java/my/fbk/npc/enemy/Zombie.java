package my.fbk.npc.enemy;

public class Zombie extends AbstractEnemy {

    public Zombie(int experience, int health, int mana, int damage,int gold) {
        super(experience, health, mana, damage,gold);
    }

    @Override
    public void attack() {}

    @Override
    public String getName() {
        return "zombie";
    }
}
