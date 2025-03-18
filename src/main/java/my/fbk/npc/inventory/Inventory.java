package my.fbk.npc.inventory;

import my.fbk.npc.AbstractClass.AbstractNPC;

import java.util.List;

public interface Inventory {
    void openInventory();

    void closeInventory();

    void buyItem(ItemList item, AbstractNPC abstractNpc);

    void sellItem(ItemList item, AbstractNPC abstractNpc);

    List<ItemList> getInventory();
    void showInventory();
}

