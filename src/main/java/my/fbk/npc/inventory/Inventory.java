package my.fbk.npc.inventory;

import my.fbk.npc.AllNPC.Merchant;

import java.util.List;

public interface Inventory {
    void openInventory();

    void closeInventory();

    void buyItem(ItemList item, Merchant merchant);

    void sellItem(ItemList item, Merchant merchant);

    List<ItemList> getInventory();
    void showInventory();
}
