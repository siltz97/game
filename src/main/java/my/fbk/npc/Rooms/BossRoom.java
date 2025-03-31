package my.fbk.npc.Rooms;

import my.fbk.npc.Enemy.*;
import my.fbk.npc.Game;
import my.fbk.npc.inventory.ItemList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("StringTemplateMigration")
public class BossRoom extends AbstractRoom {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    AbstractEnemy enemy;

    public BossRoom(Game game) {
        super(game);
    }

    public void battle() {
        System.out.println("You entered the BOSS ROOM");
        generateEnemy();

        while (true) {
            System.out.println("What do you want to do? attack/useitem or 'next' to go to another room");
            action();
            if (input.equals("attack")) {
                playerAttack();
                enemyAttack();
                if (player.getHealth() <= 0) {
                    System.out.println("Player died,game over");
                    break;
                } else if (enemy.getHealth() <= 0) {
                    System.out.println("enemy died,you can go on");
                    game.moveNext();
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
        int experience = rand.nextInt(250) + 60;
        int health = rand.nextInt(150) + 150;
        int mana = rand.nextInt(60) + 30;
        int damage = rand.nextInt(40) + 20;

        List<AbstractEnemy> enemyTypes = List.of(
                new Goblin(0, 0, 0, 0),
                new Skeleton(0, 0, 0, 0),
                new Kobold(0, 0, 0, 0),
                new Zombie(0, 0, 0, 0)
        );
        AbstractEnemy template = enemyTypes.get(rand.nextInt(enemyTypes.size()));
        enemy = template.createNew(experience, health, mana, damage);
        System.out.println("you see a giant " + enemy.getName().toUpperCase() + " Get ready to fight!");

    }

    public void action() {
        input = scan.nextLine();
    }

    public void playerAttack() {
        player.attack();
        enemy.setHealth(enemy.getHealth() - player.getDamage());
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health");
    }

    public void enemyAttack() {
        enemy.attack();
        player.setHealth(player.getHealth() - enemy.getDamage());
        System.out.println("Player has " + player.getHealth() + " health");
    }
}

