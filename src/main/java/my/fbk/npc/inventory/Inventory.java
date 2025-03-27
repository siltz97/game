package my.fbk.npc.inventory;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.myPlayer.Player;

public interface Inventory {

    void addItem(ItemList item);

    void removeItem(ItemList item);

    void openInventory(AbstractCharacter character);

    void closeInventory(AbstractCharacter character);

    void buyItem(ItemList item, AbstractNPC abstractNpc, Player player);

    void sellItem(ItemList item, AbstractNPC abstractNpc, Player player);

    void showInventory();

    void useItem(ItemList item);
}

