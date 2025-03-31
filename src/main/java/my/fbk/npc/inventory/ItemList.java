package my.fbk.npc.inventory;


import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;

import java.util.List;

@SuppressWarnings("NonFinalFieldInEnum")
@Getter
public enum ItemList {
//    FIRE_SCROLL("A magic scroll that casts fire (300 DMG)", 300, 1, "") {
//        @Override
//        public void use(List<AbstractCharacter> character) {
//            System.out.println("You cast a fire spell! Deals 300 damage.");
//            // You can add logic to apply damage to an enemy
//        }
//    },
//    DOVAKIN_VOICE("FUS RO DAH!!! 1000 DMG", 9999, 9999, "") {
//        @Override
//        public void use(List<AbstractCharacter> character) {
//            System.out.println("You shout 'FUS RO DAH' and deal 1000 damage to all enemies!");
//        }
//    },
    HEALTH_POTION("Restores +100 health", 50, 1, "") {
        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setHealth(c.getHealth() + 100);
                        System.out.println("You restored 100 HP! Current HP: " + c.getHealth());
                    });
        }
    },
    MANA_FLASK("Restores +100 mana", 60, 1, "") {
        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setMana(c.getMana() + 100);
                        System.out.println("You restored 100 MP! Current MP: " + c.getMana());
                    });
        }
    },
    IRON_SWORD("A basic but reliable sword. +40 DMG", 200, 1, "") {
        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setDamage(c.getDamage() + 40);
                        System.out.println("Equipped Iron Sword! + 40 DMG:  " + c.getDamage());
                    });
        }
    },
    BUCKET("It's just a bucket. What did you expect?", 1, 1, "") {
        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        System.out.println("You put the bucket on your head... Cool.");
                    });
        }
    };


    private final String description;
    private final int price;
    @Setter
    private int durability;
    private final String specialEffect;

    // Constructor
    ItemList(String description, int price, int durability, String specialEffect) {
        this.description = description;
        this.price = price;
        this.durability = durability;
        this.specialEffect = specialEffect;
    }

    // Abstract method (each item must implement this)
    public abstract void use(List<AbstractCharacter> character);

}
