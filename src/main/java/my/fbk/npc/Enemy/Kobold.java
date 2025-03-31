package my.fbk.npc.Enemy;

public class Kobold extends AbstractEnemy {

    public Kobold(int experience, int health, int mana, int damage) {
        super(experience, health, mana, damage);
    }

    @Override
    public void attack() {}

    @Override
    public Kobold createNew(int experience, int health, int mana, int damage) {
        return new Kobold(experience, health, mana, damage);
    }
    @Override
    public String getName() {
        return "kobold";
    }
}
