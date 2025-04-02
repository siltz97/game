package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.inventory.InventoryInteraction;


@Getter
@Setter
public abstract class AbstractCharacter {
    protected final InventoryInteraction list = new InventoryInteraction();
    private int health;
    private int mana;
    private int damage;


    public AbstractCharacter(int health,int mana, int damage) {
        this.health = health;
        this.mana = mana;
        this.damage = damage;
    }




}
