package my.fbk.npc.spells;

import my.fbk.npc.AbstractClass.AbstractCharacter;

public class HolyHealing extends Spell {
    public HolyHealing(int cost) {
        super(cost);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void print() {
        System.out.println("You casted Holy Healing");
    }

    @Override
    public void apply(AbstractCharacter character) {
        character.setHealth(character.getHealth() + 50);
        System.out.println("You restored 50 HP: " + character.getHealth());
    }


//    public void cast() {
//        if (player.getMana() >= 30) {
//            player.setMana(player.getMana() - 30);
//            player.setHealth(player.getHealth() + 50);
//            System.out.println("You restored 50 HP: " + player.getHealth());
//            System.out.println("Your MP is now: " + player.getMana());
//        } else
//            System.out.println("❌ You don't have enough MP ❌");
//    }
}
