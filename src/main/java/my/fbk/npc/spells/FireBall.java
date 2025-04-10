package my.fbk.npc.spells;

import my.fbk.npc.abstract_class.AbstractCharacter;

public class FireBall extends AbstractSpell {
    int spellCost = 30;
    int damage = 30;

    public FireBall(int cost) {
        super(cost);
    }

    @Override
    public String getName() {
        return "";
    }

    public void print() {
        System.out.println("🔥 You cast Fireball!");
    }

    @Override
    public void apply(AbstractCharacter character) {
        character.setHealth(character.getHealth() - damage);
        System.out.println("Now enemy has " + character.getHealth() + "HP");
    }
}
