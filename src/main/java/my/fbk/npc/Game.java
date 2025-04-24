package my.fbk.npc;

import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.rooms.AbstractRoom;
import my.fbk.npc.rooms.BattleRoom;
import my.fbk.npc.rooms.BossRoom;
import my.fbk.npc.rooms.SafeRoom;
import my.fbk.npc.my_player.Player;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Game {
    int choice = 0;
    Player player;
    AbstractRoom currentRoom;
    BattleRoom battleRoom;
    SafeRoom safeRoom;
    BossRoom bossRoom;


    public Game() {
        player = new Player(10000, 120, 100, 25, 0, 1);
        safeRoom = new SafeRoom(this);
        battleRoom = new BattleRoom(this);
        bossRoom = new BossRoom(this);


    }

    public void main(String[] args) {
        NpcDao npcDao = new NpcDao(make());
//        Game game = new Game();
//        game.moveNext();
        ItemList bucket = npcDao.getItemList("bucket");
        System.out.println("Item retrieved: " + bucket.getName());
        bucket.use(List.of(new Player(1, 1, 1, 1, 1, 1)));

    }

    public void moveNext() {
        if (choice % 10 == 0 && choice != 0) {
            choice++;
            currentRoom = new BossRoom(this);
            bossRoom.setPlayer(player);
            System.out.println("You are in the room number: " + (choice - 1));
            bossRoom.battle();
        } else if (choice == 0 || choice % 5 == 0 || choice % 10 == 1 && choice != 1) {
            choice++;
            currentRoom = new SafeRoom(this);
            safeRoom.setPlayer(player);
            System.out.println("You are in the room number: " + (choice - 1));
            safeRoom.npcInteraction();
        } else {
            choice++;
            currentRoom = new BattleRoom(this);
            battleRoom.setPlayer(player);
            System.out.println("You are in the room number: " + (choice - 1));
            battleRoom.battle();
        }


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
