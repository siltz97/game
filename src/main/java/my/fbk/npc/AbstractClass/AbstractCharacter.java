package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.effects.Effect;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.InventoryInteraction;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("All")
@Getter
@Setter
public abstract class AbstractCharacter {
    protected Inventory inventory = new InventoryInteraction();
    protected List<Effect> effects = new ArrayList<>();
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

    public boolean hasEffect(Effect effect) {
        if (effect == null) {
            return false;
        }else if(effects.contains(effect)){
            Effect selectedEffect = null;
            for(Effect e : effects){
                if(e.equals(effect)){
                    selectedEffect = effect;
                }
            }
            if(selectedEffect.getEffectDuration()==0){
                effects.remove(selectedEffect);
                return false;
            }
            return true;
        }
        return false;
    }

    public void setEffects(Effect effect){
        this.effects.add(effect);
    }
    public void setRemoveEffect(Effect effect) {
        this.effects.remove(effect);
    }

    public String getName(){
        return "";
    }

    public void speak(){}


    public void attack() {
    }

}
