package my.fbk.npc.Rooms;

import my.fbk.npc.Enemy.*;
import my.fbk.npc.Game;
import my.fbk.npc.inventory.ItemList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("StringTemplateMigration")
public class BattleRoom extends AbstractRoom {

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    AbstractEnemy enemy;

    public BattleRoom(Game game) {
        super(game);
    }

    public void battle() {
        System.out.println("You entered the BATTLE ROOM");
        generateEnemy();
        System.out.println("Your stats: "+player.getHealth()+" HP "+player.getMana()+" MP "+player.getDamage()+" DMG");
        System.out.println("Enemy stats: "+enemy.getHealth()+" HP "+enemy.getMana()+" MP "+enemy.getDamage()+" DMG");

        while (true) {
            System.out.println("What do you want to do? attack/useitem or 'next' to go to another room");
            action();
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
                action();
                ItemList item = ItemList.valueOf(input.toUpperCase());
                player.useItem(item);


            } else if (input.equals("next")) {
                game.moveNext();
            }

        }
    }

    public void generateEnemy() {
        int experience = rand.nextInt(50) + 10;
        int mana = rand.nextInt(30) + 10;
        int health = rand.nextInt(100) + 50;
        int damage = rand.nextInt(20) + 5;
        int gold = rand.nextInt(40) + 10;

        List<AbstractEnemy> enemyTypes = List.of(
                new Goblin(0, 0, 0, 0,0),
                new Skeleton(0, 0, 0, 0,0),
                new Kobold(0, 0, 0, 0,0),
                new Zombie(0, 0, 0, 0,0)
        );
        AbstractEnemy template = enemyTypes.get(rand.nextInt(enemyTypes.size()));
        enemy = template.createNew(experience, health, mana, damage, gold);
        System.out.println("you see a " + enemy.getName().toUpperCase() + " Get ready to fight!");

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
