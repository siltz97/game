package my.fbk.npc.inventory;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.myPlayer.Player;

public interface Inventory {

    void addItemToInventory(ItemList item);

    void removeItemFromInventory(ItemList item);

    void buyItem(ItemList item, AbstractNPC abstractNpc, Player player);

    void sellItem(ItemList item, AbstractNPC abstractNpc, Player player);

    void showInventory();

    void useItem(ItemList item,AbstractCharacter character);

    int getInventorySize();
}

