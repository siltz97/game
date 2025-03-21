package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.Actions.Effect;
import my.fbk.npc.Actions.InvisibilityEffect;
import my.fbk.npc.Speak.*;


@Getter
@Setter
public abstract class AbstractNPC extends AbstractCharacter {
    protected SpeakBehavior behavior;
    protected Effect effect;
    private int reputation;



    public AbstractNPC(int money, int health,int reputation,int mana) {
        super(money,health,mana);
        this.reputation = reputation;
        behavior = new NeutralSpeak();

    }

    @Override
    public abstract void speak();
    public void think(){
        if(effect instanceof InvisibilityEffect){
            setBehavior(new SilentSpeak());
        }else {
            if (getReputation() > 80) {
                setBehavior(new FriendlySpeak());
            } else if (getReputation() > 50 && getReputation() < 80) {
                setBehavior(new NeutralSpeak());
            } else if (getReputation() < 50) {
                setBehavior(new AggressiveSpeak());
            }
        }
    }



}
