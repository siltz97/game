package my.fbk.npc.inventory;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.my_player.Player;

import java.util.List;

public interface Inventory {

    void addItemToInventory(ItemList item);

    void removeItemFromInventory(ItemList item);

    void buyItem(ItemList item, AbstractCharacter npc, Player player);

    void sellItem(ItemList item, AbstractCharacter npc, Player player);

    void showInventory();

    void useItem(ItemList item, AbstractCharacter character);

    int getInventorySize();

    void addAllItemsToInventory(List<ItemList> list);

    void takeLoot(Player player, AbstractCharacter enemy);

    boolean contains(ItemList item);

    void tradeBasedOnReputationBuy(AbstractCharacter character);

    void tradeBasedOnReputationSell(AbstractCharacter character, Player player);


}

