package my.fbk.npc.enemy;

public class Kobold extends AbstractEnemy {

    public Kobold(int experience, int health, int mana, int damage,int gold) {
        super(experience, health, mana,damage,gold);
    }

    @Override
    public void attack() {}


    @Override
    public String getName() {
        return "kobold";
    }
}
