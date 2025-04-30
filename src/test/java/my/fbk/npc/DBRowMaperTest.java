package my.fbk.npc;

import my.fbk.npc.all_npc.Guard;
import my.fbk.npc.inventory.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBRowMaperTest {


    @Test
    public void itemRowMapperTest() throws SQLException {
        NpcDao npcDao = new NpcDao();
        Item bucket = npcDao.getItemByName("bucket");
        System.out.println("Item retrieved: " + bucket.getName());
        Assertions.assertTrue(bucket.getName().equals("bucket"));

    }

    @Test
    public void itemRowMapperSelectAllItemsOfCharacter() throws SQLException {
        NpcDao npcDao = new NpcDao();
        npcDao.loadInventory("goblin");
        Assertions.assertTrue(npcDao.loadInventory("Goblin").size() > 0, "Goblin inventory should not be empty.");
    }

    @Test
    public void insertNewRecordsInInventory() throws SQLException {
        Guard guard = new Guard(1, 1, 1, 1, 1, 1);
        List<String> items = Arrays.asList("silverring");
        NpcDao npcDao = new NpcDao();
        npcDao.insertItems(items, guard.getName());
        npcDao.loadInventory("guard");
        for (Item item : npcDao.loadInventory("guard")) {
            System.out.println(item.getName());
        }
    }

    @Test
    public void BuyItemsInDB() throws SQLException {
        NpcDao npcDao = new NpcDao();
        System.out.println("Before");
        for (Item item : npcDao.loadInventory("player"))
            System.out.println(item.getName());
        Assertions.assertTrue(
                npcDao.BuyItems("player", "goblin", "bucket"),
                "Trading does not fail."
        );
        System.out.println("After");
        for (Item item : npcDao.loadInventory("player")) {
            System.out.println(item.getName());

        }


    }
}
