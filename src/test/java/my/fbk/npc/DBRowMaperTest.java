package my.fbk.npc;

import my.fbk.npc.Mapper.ItemRowMapper;
import my.fbk.npc.inventory.ItemList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DBRowMaperTest {


    @Test
    public void itemRowMapperTest() throws SQLException {
        NpcDao npcDao = new NpcDao(make());
        ItemList bucket = npcDao.getItemList("bucket");
        System.out.println("Item retrieved: " + bucket.getName());
        Assertions.assertTrue(bucket.getName().equals("bucket"));

    }

    public JdbcClient make() {

        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            // Load the properties file
            properties.load(input);

            // Access properties
            String url = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");


            return
                    JdbcClient.create(
                            DataSourceBuilder.create().url(url).username(username).password(password).build()
                    );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
