package my.fbk.npc;

import my.fbk.npc.inventory.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DBRowMaperTest {


    @Test
    public void itemRowMapperTest() throws SQLException {
        NpcDao npcDao = new NpcDao();
        Item bucket = npcDao.getItemList("bucket");
        System.out.println("Item retrieved: " + bucket.getName());
        Assertions.assertTrue(bucket.getName().equals("bucket"));

    }

    @Test
    public void itemRowMapperSelectAllItemsOfCharacter() throws SQLException {
        NpcDao npcDao = new NpcDao();
        npcDao.loadInventory("Goblin");
        Assertions.assertTrue(npcDao.loadInventory("Goblin").size() > 0,"Goblin inventory should not be empty.");
    }
}
