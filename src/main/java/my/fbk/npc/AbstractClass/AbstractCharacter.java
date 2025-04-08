package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.BasicSpells.Effects;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public abstract class AbstractCharacter {
    protected Inventory inventory = new InventoryInteraction();
    protected List<Effects> effects = new ArrayList<>();
    private int health;
    private int mana;
    private int damage;
    private int money;
    private int experience;


    public AbstractCharacter(int health,int mana, int damage,int money,int experience) {
        this.health = health;
        this.mana = mana;
        this.damage = damage;
        this.money = money;
        this.experience = experience;
    }
    public void setEffects(Effects effect){
        this.effects.add(effect);
    }
    public void setRemoveEffect(Effects effect) {
        this.effects.remove(effect);
    }

    public String getName(){
        return "";
    }

    public void speak(){}


    public void attack() {
    }
}
