package my.fbk.npc.Enemy;

public abstract class AbstractEnemy {
    int experience;
    int health;
    int mana;
    int damage;

    public AbstractEnemy(int experience, int health, int mana, int damage) {
        this.experience = experience;
        this.health = health;
        this.mana = mana;
        this.damage = damage;
    }
    public abstract int attack(int damage);

}
