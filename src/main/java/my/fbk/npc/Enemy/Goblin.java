package my.fbk.npc.Enemy;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goblin extends AbstractEnemy {

    public Goblin(int experience, int health, int mana,int damage) {
        super(experience, health, mana,damage);
    }

    @Override
    public void attack() {
        System.out.println("goblin attacks");
    }

}
