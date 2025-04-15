package my.fbk.npc.my_player;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.AbstractNPC;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.spells.AbstractSpell;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ALL")
@Getter
@Setter
public class Player extends AbstractPlayer {
    private final Random rand = new Random();
    AbstractCharacter character;
    List<ItemList> equipment = new ArrayList<>();
    int basicHealth = 120;
    int basicMana = 100;
    int basicDamage = 25;

    int addedDamage = 0;
    int addedMana = 0;
    int addedHealth = 0;

    int maxHealth = basicHealth;
    int maxMana = basicMana;

    public Player(int money, int health, int mana, int damage, int experience, int level) {
        super(money, health, mana, damage, experience, level);
        for (int i = 0; i < 2; i++) {
            inventory.addItemToInventory(ItemList.healthPotion());
        }
    }


    @Override
    public void speak() {
        System.out.println("Hi");
    }

    @Override
    public void attack() {
        System.out.println("Player attacks");
    }

    public void buyItem(ItemList item, AbstractNPC abstractNpc) {
        inventory.buyItem(item, abstractNpc, this);
    }

    public void sellItem(ItemList item, AbstractNPC abstractNpc) {
        inventory.sellItem(item, abstractNpc, this);
    }

    public void showInventory() {
        inventory.showInventory();
    }

    public void updateMaxStats() {
        setMaxHealth(getHealth() + addedHealth);
        setMaxMana(getMana() + addedMana);
    }

    public void useItem(ItemList item, AbstractCharacter character) {

        if (item.getName().equals("ironsword")) {
            boolean hasWeaponEquipped = equipment.stream()
                    .anyMatch(equip -> equip.getName().equals("ironsword"));

            if (hasWeaponEquipped) {
                System.out.println("❌You you can't equip more than one weapon!❌\n");
                return;
            }
            this.equipment.add(item);
            this.inventory.removeItemFromInventory(item);
            setAddedDamage(getAddedDamage() + 20);
            setDamage(getDamage() + getAddedDamage());
            System.out.println("You successfully equipped: " + item.getName() + " and now your damage is: " + getDamage());
        } else if (item.getName().equals("silverring")) {
            this.equipment.add(item);
            this.inventory.removeItemFromInventory(item);
            setAddedMana(getAddedMana() + 20);
            setMana(getMana() + getAddedMana());
            System.out.println("You successfully equipped: " + item.getName() + "and now your mana is: " + getMana());
        } else {
            this.inventory.useItem(item, character);
            updateMaxStats();
            if (getHealth() > maxHealth) {
                setHealth(maxHealth);
                System.out.println("HP: " + getHealth());
            } else if (getMana() > maxMana) {
                setMana(maxMana);
                System.out.println("MP: " + getMana());
            }
        }
    }


    public void seeMoney() {
        //noinspection StringTemplateMigration
        System.out.println("Player has: " + getMoney() + "$");

    }

    public void LevelUp() {
        setLevel(getLevel() + 1);
        System.out.println("Player leveled up! " + getLevel() + " LVL");
        setExperience(getExperience() - 100);
        setHealth((int) (getBasicHealth() * (1 + 0.14 * (getLevel() - 1))) + addedHealth);
        setMana((int) (getBasicMana() * (1 + 0.12 * (getLevel() - 1))) + addedMana);
        setDamage((int) (getBasicDamage() * (1 + 0.1 * (getLevel() - 1))) + addedDamage);
        updateMaxStats();
    }

    public void showEquipment() {
        if (equipment.isEmpty()) {
            System.out.println("No equipment!");
        } else {
            System.out.println("Your equipment is:");
            for (ItemList item : equipment) {
                System.out.println(item);
            }
        }
    }

    public void cast(AbstractSpell spell, List<AbstractCharacter> targets) {
        if (getMana() >= spell.getCost()) {
            setMana(getMana() - spell.getCost());
            spell.print();
            for (AbstractCharacter target : targets) {
                spell.apply(target);
            }
            System.out.println("Your MP is now " + getMana());
        } else {
            System.out.println("❌ You don't have enough MP! ❌");
        }
    }
}
