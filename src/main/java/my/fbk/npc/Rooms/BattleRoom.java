package my.fbk.npc.Rooms;

import my.fbk.npc.Enemy.AbstractEnemy;
import my.fbk.npc.Enemy.Goblin;
import my.fbk.npc.Game;
import my.fbk.npc.inventory.ItemList;

import java.util.Scanner;

public class BattleRoom extends AbstractRoom {

    Scanner scan = new Scanner(System.in);
    AbstractEnemy goblin = new Goblin(100, 50, 0, 10);
    String input;

    public BattleRoom(Game game) {
        super(game);
    }

    public void battle() {
        System.out.println("You entered the battle room and you see an enemy. what do you do?");

        while (true) {
            System.out.println("What do you want to do? attack/useitem or 'next' to go to another room");
            action();
            if (input.equals("attack")) {
                player.attack();
                goblin.setHealth(goblin.getHealth() - player.getDamage());
                System.out.println("Goblin has " + goblin.getHealth() + " health");
                goblin.attack();
                player.setHealth(player.getHealth() - goblin.getDamage());
                System.out.println("Player has " + player.getHealth() + " health");
                if (player.getHealth() <= 0) {
                    System.out.println("Player died,game over");
                    break;
                } else if (goblin.getHealth() <= 0) {
                    System.out.println("goblin died,you can go on");
                    break;
                }
            } else if (input.equals("useitem")) {
                System.out.println("Select an item to use");
                player.showInventory();
                action();
                ItemList item = ItemList.valueOf(input.toUpperCase());
                player.useItem(item);

            } else if (input.equals("next")) {
                game.moveNext();
            }

        }
    }

    public void generateEnemy() {
        AbstractEnemy enemy = allEnemy.get(rand.nextInt(allEnemy.size()));
    }

    public void action() {
        input = scan.nextLine();
    }
}
