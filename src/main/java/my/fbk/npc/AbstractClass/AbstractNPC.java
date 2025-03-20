package my.fbk.npc.AbstractClass;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.Speak.AggressiveSpeak;
import my.fbk.npc.Speak.FriendlySpeak;
import my.fbk.npc.Speak.NeutralSpeak;
import my.fbk.npc.Speak.SpeakBehavior;

@Getter
@Setter
public abstract class AbstractNPC extends AbstractCharacter {
    protected SpeakBehavior behavior;
    private int money;
    private int health;
    private int reputation;


    public AbstractNPC(int money, int health,int reputation) {
        super(money,health);
        this.reputation = reputation;
        behavior = new NeutralSpeak();

    }
    @Override
    public abstract void action();

    @Override
    public abstract void speak();
    public void think(){
        if(getReputation()>80){
            setBehavior(new FriendlySpeak());
        }else if(getReputation()>50 && getReputation()<80){
            setBehavior(new NeutralSpeak());
        }else if(getReputation()<50){
            setBehavior(new AggressiveSpeak());
        }
    }



}
