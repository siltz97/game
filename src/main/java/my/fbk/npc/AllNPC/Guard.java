package my.fbk.npc.AllNPC;


public class Guard extends AbstractNPC {


    public Guard(int money,int health,int reputation,int mana) {
        super(money,health,reputation,mana);


    }


    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }
}
