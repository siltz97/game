package my.fbk.npc;


import my.fbk.npc.Mapper.CharacterRowMapper;
import my.fbk.npc.inventory.InventoryRowEntity;
import my.fbk.npc.Mapper.ItemRowMapper;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.inventory.Item;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Repository
public class NpcDao {


    private final JdbcClient jdbcClient;

    public NpcDao() {
        jdbcClient = make();
    }

    private JdbcClient make() {

        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            // Load the properties file
            properties.load(input);

            // Access properties
            String url = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");
            if (jdbcClient != null)
                return jdbcClient;
            else {
                return
                        JdbcClient.create(
                                DataSourceBuilder.create().url(url).username(username).password(password).build()
                        );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AbstractCharacter getCharacterByName(String name) {
        String sql = """
                SELECT *
                FROM [Test].[dbo].[aa_Character]
                WHERE [name] = ?
                """;
        return jdbcClient.sql(sql)
                .param(name)
                .query(new CharacterRowMapper())
                .single();
    }

    public List<AbstractCharacter> getAllCharacters() {
        String sql = """
                SELECT *
                FROM [Test].[dbo].[aa_Character]
                """;
        return jdbcClient.sql(sql)
                .query(new CharacterRowMapper())
                .list();
    }

    public int removeItemFromInventory(
            String character,
            String item
    ) {
        String sql = """
                DELETE FROM [Test].[dbo].[aa_Inventory]
                WHERE character = ? AND item = ?
                """;
        return jdbcClient.sql(sql)
                .param(character)
                .param(item)
                .update();
    }

    public Item getItemByName(String name) {
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

    /**
     * This method returns all items from the database.
     */
    public List<Item> getItems() {
        String sql = """
                SELECT *
                FROM [Test].[dbo].[aa_Items]
                """;
        return jdbcClient.sql(sql)
                .query(new ItemRowMapper())
                .list();
    }


    /**
     * This method returns the list of object associated to the input character.
     */
    public List<Item> loadInventory(String character) {
        String sql = """
                SELECT Items.*
                From [Test].[dbo].[aa_Inventory] AS [Inventory]
                INNER JOIN [Test].[dbo].[aa_Items] as [Items]
                ON Items.name = inventory.item
                WHERE [character] = ?
                """;
        return jdbcClient.sql(sql)
                .param(character)
                .query(new ItemRowMapper())
                .list();

    }

    /**
     * This method associates a list of items to a given character.
     */
    public void insertItems(List<String> items, String character) {
        items
                .stream()
                .forEach(item -> insertItems(character, item));
    }

    public void insertItems(String character, String item) {

        String sql = """
                INSERT INTO [Test].[dbo].[aa_Inventory]
                VALUES (?, ?)
                """;
        jdbcClient.sql(sql)
                .param(character)
                .param(item)
                .update();
    }

    public boolean BuyItems(String whoBuys, String whoSells, String item) {
        String sql1 = """
                SELECT TOP(1) *
                FROM [Test].[dbo].[aa_Inventory]
                WHERE [character] = ? AND [item] = ?
                """;
        InventoryRowEntity soldItem = jdbcClient.sql(sql1)
                .param(whoSells)
                .param(item)
                .query(InventoryRowEntity.class)
                .single();
        if (soldItem == null)
            return false;

        String sql = """
                Update [Test].[dbo].[aa_Inventory]
                SET [character] = ?
                where [item] = ? AND [character] = ? AND id = ?
                """;
        return jdbcClient.sql(sql)
                       .param(whoBuys)
                       .param(item)
                       .param(whoSells)
                       .param(soldItem.getId())
                       .update() == 1;


    }


}
