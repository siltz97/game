package my.fbk.npc.enemy;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goblin extends AbstractEnemy {

    public Goblin(int experience, int health, int mana,int damage,int gold) {
        super(experience, health, mana,damage,gold);
    }

    @Override
    public void attack() {
        System.out.println("goblin attacks");
    }


    @Override
    public String getName() {
        return "goblin";
    }

}
