package my.fbk.npc;


import my.fbk.npc.Mapper.ItemRowMapper;
import my.fbk.npc.Mapper.PlayerRowMapper;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.my_player.Player;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class NpcDao {


    private final JdbcClient jdbcClient;

    public NpcDao(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Player getPlayer(int id) {
        String sql = """
                SELECT *
                FROM [Test].[dbo].[aa_Player]
                Where id = ?
                """;
        return jdbcClient.sql((sql))
                .param(id)
                .query(new PlayerRowMapper())
                .single();
    }

    public int insertPlayer(int money, int health, int mana, int damage, int experience, int level) {
        String sql = """
                INSERT INTO [Test].[aa_Player] (money, health, mana, damage, experience, level)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcClient.sql((sql))
                .param(money)
                .param(health)
                .param(mana)
                .param(damage)
                .param(experience)
                .param(level)
                .update(generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();
    }

    public int insertEnemy(String race, String enemyType, int health, int mana, int damage, int money, int experience) {
        String sql = """
                INSERT INTO [Test].[aa_Enemy] (race, enemyType, money, health, mana, damage, experience)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcClient.sql((sql))
                .param(race)
                .param(enemyType)
                .param(health)
                .param(mana)
                .param(damage)
                .param(money)
                .param(experience)
                .update(generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();
    }

    public int insertNPC(String npcName, int health, int mana, int damage, int money, int experience, int reputation) {
        String sql = """
                INSERT INTO [Test].[aa_NPC] (npcName, health, mana, damage, money, experience, reputation)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcClient.sql((sql))
                .param(npcName)
                .param(health)
                .param(mana)
                .param(damage)
                .param(money)
                .param(experience)
                .param(reputation)
                .update(generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();
    }

    public int insertItems(String itemName, String description, int price, int durability, String specialEffect) {
        AbstractCharacter character = null;
        String characterName = character.getName();
        String sql = """
                Insert INTO [Test].[dbo].[aa_Inventory] (characterName, itemName, description, price, durability, specialEffect)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(sql)
                .param(characterName)
                .param(itemName)
                .param(description)
                .param(price)
                .param(durability)
                .param(specialEffect)
                .update(generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();
    }

    public int removeItemFromInventory(int characterId, int itemId) {
        String sql = """
                DELETE FROM [Test].[dbo].[aa_Inventory]
                WHERE characterId = ? AND itemId = ?
                """;
        return jdbcClient.sql(sql)
                .param(characterId)
                .param(itemId)
                .update();
    }

    public ItemList getItemList(String name) {
        String sql = """
                SELECT *
                FROM [Test].[dbo].[aa_Items]
                WHERE name = ?
                """;
        return jdbcClient.sql(sql)
                .param(name)
                .query(new ItemRowMapper())
                .single();
    }



}
