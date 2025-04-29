package my.fbk.npc.inventory;

import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.my_player.Player;

import java.util.List;

public interface Inventory {

    void addItemToInventory(Item item);

    void removeItemFromInventory(Item item);

    void buyItem(Item item, AbstractCharacter npc, Player player);

    void sellItem(Item item, AbstractCharacter npc, Player player);

    void showInventory();

    void useItem(Item item, AbstractCharacter character);

    int getInventorySize();

    void addAllItemsToInventory(List<Item> list);

    void takeLoot(Player player, AbstractCharacter enemy);

    boolean contains(Item item);

    void tradeBasedOnReputationBuy(AbstractCharacter character);

    void tradeBasedOnReputationSell(AbstractCharacter character, Player player);


}

