package my.fbk.npc.AllNPC;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Speak.AggressiveSpeak;
import my.fbk.npc.Speak.FriendlySpeak;
import my.fbk.npc.Speak.NeutralSpeak;
import my.fbk.npc.Speak.SpeakBehavior;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.NewInventory;
import my.fbk.npc.inventory.ItemList;

import java.util.Arrays;

@Getter
@Setter
public class Merchant extends AbstractNPC {
    NewInventory list = new NewInventory();

    public Merchant(int money, int health,int reputation) {
        super(money,health,reputation);


        list.addAll(Arrays.asList(ItemList.values()));
    }

    @Override
    public void action() {

    }

    @Override
    public void speak() {
        think();
        behavior.speak(this);
    }


    public Inventory getInventory() {
        return list;
    }
    public void openInventory() {
        list.openInventory(this);
    }
    public void closeInventory() {
        list.closeInventory(this);
    }
    public void showInventory() {
        list.showInventory();
    }
}
