package my.fbk.npc.Rooms;

import my.fbk.npc.Enemy.*;
import my.fbk.npc.Game;
import my.fbk.npc.factories.GoblinFactory;
import my.fbk.npc.factories.KoboldFactory;
import my.fbk.npc.factories.SkeletonFactory;
import my.fbk.npc.factories.ZombieFactory;
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
        System.out.println("Your stats: "+player.getHealth()+" HP "+player.getMana()+" MP "+player.getDamage()+" DMG");
        System.out.println("Enemy stats: "+enemy.getHealth()+" HP "+enemy.getMana()+" MP "+enemy.getDamage()+" DMG");

        while (true) {
            System.out.println("What do you want to do? attack/useitem or 'next' to go to another room");
            userInput();
            if (input.equals("attack")) {
                playerAttack();
                enemyAttack();
                if (player.getHealth() <= 0) {
                    System.out.println("Player died,game over");
                    return;
                } else if (enemy.getHealth() <= 0) {
                    player.setMoney(player.getMoney() + enemy.getGold());
                    System.out.println("Player earned: " + enemy.getGold() + "$  and now has: " + player.getMoney()+"$");
                    System.out.println("enemy died,you can go on");
                    game.moveNext();
                }
            } else if (input.equals("useitem")) {
                System.out.println("Select an item to use");
                player.showInventory();
                userInput();
                ItemList item = ItemList.valueOf(input.toUpperCase());
                player.useItem(item);


            } else if (input.equals("next")) {
                game.moveNext();
            }

        }
    }

    public void generateEnemy() {
        List<AbstractEnemy> enemyTypes = List.of(
                GoblinFactory.makeBoss(),
                KoboldFactory.makeKoboldBoss(),
                SkeletonFactory.makeSkeletonBoss(),
                ZombieFactory.makeZombieBoss()
        );
        enemy = enemyTypes.get(rand.nextInt(enemyTypes.size()));
        System.out.println("you see a giant " + enemy.getName().toUpperCase() + " Get ready to fight!");
    }

    public void userInput() {
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

