package my.fbk.npc.abstract_class;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.effects.AbstractEffect;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("All")
@Getter
@Setter
public abstract class AbstractCharacter {
    protected Inventory inventory = new InventoryInteraction();
    protected List<AbstractEffect> effects = new ArrayList<>();
    private int health;
    private int mana;
    protected int damage;
    private int money;
    private int experience;


    public AbstractCharacter(int health,int mana, int damage,int money,int experience) {
        this.health = health;
        this.mana = mana;
        this.damage = damage;
        this.money = money;
        this.experience = experience;
    }

    public boolean hasEffect(AbstractEffect abstractEffect) {
        if (abstractEffect == null) {
            return false;
        }else if(effects.contains(abstractEffect)){
            AbstractEffect selectedAbstractEffect = null;
            for(AbstractEffect e : effects){
                if(e.equals(abstractEffect)){
                    selectedAbstractEffect = abstractEffect;
                }
            }
            if(selectedAbstractEffect.getEffectDuration()==0){
                effects.remove(selectedAbstractEffect);
                return false;
            }
            return true;
        }
        return false;
    }

    public void setEffects(AbstractEffect abstractEffect){
        this.effects.add(abstractEffect);
    }
    public void removeEffect(AbstractEffect abstractEffect) {
        this.effects.remove(abstractEffect);
    }

    public String getName(){
        return "";
    }

    public void speak(){}


    public void attack() {
    }

}
