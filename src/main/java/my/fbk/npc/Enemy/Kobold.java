package my.fbk.npc.Enemy;

public class Kobold extends AbstractEnemy {

    public Kobold(int experience, int health, int mana, int damage,int gold) {
        super(experience, health, mana,damage,gold);
    }

    @Override
    public void attack() {}

    @Override
    public Kobold createNew(int experience, int health, int mana, int damage,int gold) {
        return new Kobold(experience, health, mana, damage,gold);
    }
    @Override
    public String getName() {
        return "kobold";
    }
}
