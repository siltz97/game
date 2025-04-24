package my.fbk.npc.inventory;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemList {
    //        DOVAKIN_VOICE("FUS RO DAH!!! 1000 DMG", 9999, 9999, "") {
//        @Override
//        public void use(List<AbstractCharacter> character) {
//            System.out.println("You shout 'FUS RO DAH' and deal 1000 damage to all enemies!");
//        }
//    },
    public static SilverRing silverRing() {
        return new SilverRing("silverring","A ring with minor magical properties +20 MAX MANA ", 350, 1, "equipment");
    }

    public static class SilverRing extends ItemList {
        SilverRing(String name,String description, int price, int durability, String specialEffect) {
            super(name,description, price, durability, specialEffect);

        }

        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setMana(c.getMana() + 20);
                        System.out.println("Equipped Silver Ring! + 20 MP:  " + c.getMana());
                    });
        }
    }

    public static HealthPotion healthPotion() {
        return new HealthPotion("healthpotion","Restores +100 health", 50, 1, "");
    }

    public static class HealthPotion extends ItemList {
        HealthPotion(String name,String description, int price, int durability, String specialEffect) {
            super(name,description, price, durability, specialEffect);

        }

        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setHealth(c.getHealth() + 100);
                        System.out.println("You restored 100 HP!");
                    });
        }

    }

    public static FireScroll fireScroll() {
        return new FireScroll("firescroll","Deals 200 DMG", 300, 1, "");
    }

    public static class FireScroll extends ItemList {
        FireScroll(String name,String description, int price, int durability, String specialEffect) {
            super(name,description, price, durability, specialEffect);

        }

        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setHealth(c.getHealth() - 300);
                        System.out.println("Enemy recieved 300 damage: " + c.getHealth());
                    });
        }

    }

    public static ManaFlask manaFlask() {
        return new ManaFlask("manaflask","Restores +100 MP", 60, 1, "");
    }

    public static class ManaFlask extends ItemList {
        ManaFlask(String name,String description, int price, int durability, String specialEffect) {
            super(name,description, price, durability, specialEffect);

        }

        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setMana(c.getMana() + 100);
                        System.out.println("You restored 100 MP!");
                    });
        }

    }

    public static IronSword ironSword() {
        return new IronSword("ironsword","A basic but reliable sword. +20 DMG", 200, 1, "equipment");
    }

    public static class IronSword extends ItemList {
        IronSword(String name,String description, int price, int durability, String specialEffect) {
            super(name,description, price, durability, specialEffect);

        }

        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        c.setDamage(c.getDamage() + 20);
                        System.out.println("Equipped Iron Sword! + 20 DMG:  " + c.getDamage());
                    });
        }

    }

    public static Bucket bucket() {
        return new Bucket("bucket","It's, just a bucket", 1, 1, "equipment");
    }

    public static class Bucket extends ItemList {
        public Bucket(String name,String description, int price, int durability, String specialEffect) {
            super(name,description, price, durability, specialEffect);
        }

        @Override
        public void use(List<AbstractCharacter> character) {
            character.stream()
                    .forEach(c -> {
                        System.out.println("You put a bucket on your head, cool!  ");
                    });
        }

    }

    private final String description;
    private  int price;
    private int durability;
    private  String specialEffect;
    private final String name;

    // Constructor
    public ItemList(String name, String description, int price, int durability, String specialEffect) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.durability = durability;
        this.specialEffect = specialEffect;
    }

    public void use(List<AbstractCharacter> character){}

    public static List<ItemList> itemsHolder(){
        List<ItemList> items = new ArrayList<>();
        items.add(silverRing());
        items.add(healthPotion());
        items.add(fireScroll());
        items.add(manaFlask());
        items.add(ironSword());
        items.add(bucket());
        return items;
    }

}
