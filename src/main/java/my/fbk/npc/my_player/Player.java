package my.fbk.npc.my_player;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.AbstractNPC;
import my.fbk.npc.effects.AbstractEffect;
import my.fbk.npc.effects.InvisibilityEffect;
import my.fbk.npc.effects.MindControlEffect;
import my.fbk.npc.inventory.InventoryInteraction;
import my.fbk.npc.inventory.Item;
import my.fbk.npc.spells.AbstractSpell;

import java.util.*;

@SuppressWarnings("ALL")
@Getter
@Setter
public class Player extends AbstractPlayer {
    private final Random rand = new Random();
    private Scanner scan = new Scanner(System.in);
    AbstractCharacter character;
    List<Item> equipment = new ArrayList<>();
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
            inventory.addItemToInventory(Item.healthPotion());
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

    public void buyItem(Item item, AbstractNPC abstractNpc) {
        inventory.buyItem(item, abstractNpc, this);
    }

    public void sellItem(Item item, AbstractNPC abstractNpc) {
        inventory.sellItem(item, abstractNpc, this);
    }

    public void showInventory() {
        inventory.showInventory();
    }

    public void updateMaxStats() {
        setMaxHealth(getHealth() + addedHealth);
        setMaxMana(getMana() + addedMana);
    }

    public void useItem(Item item, AbstractCharacter character) {

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
            for (Item item : equipment) {
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

    public void robNPC(AbstractNPC npc) {
        Optional<AbstractEffect> existingEffect = npc.getEffects().stream()
                .filter(e -> e instanceof InvisibilityEffect || e instanceof MindControlEffect)
                .findFirst();
        if (existingEffect.isPresent()) {
            InventoryInteraction npcInventory = (InventoryInteraction) npc.getInventory();
            npcInventory.showInventory();
            System.out.println("What item do you want do rob");
            String s = scan.nextLine();
            Item itemToRob = null;
            for (Item item : ((InventoryInteraction) npc.getInventory()).getInventory()) {
                if (item.getName().equalsIgnoreCase(s)) {
                    itemToRob = item;
                    break;
                }
            }
            this.getInventory().addItemToInventory(itemToRob);
            npc.getInventory().removeItemFromInventory(itemToRob);
            System.out.println("You successfully stole " + itemToRob.getName());
            npc.setReputation(npc.getReputation() -15);
            System.out.println("And you lost the reputation of the npc: " + npc.getReputation());

        } else {
            npc.setReputation(npc.getReputation() - 30);
            System.out.print("You wasn't able to rob this npc. ");
            System.out.println("And now the reputation of the npc is: " + npc.getReputation());


        }
    }
}
