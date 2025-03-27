package my.fbk.npc.Rooms;


import my.fbk.npc.Enemy.AbstractEnemy;
import my.fbk.npc.Enemy.Goblin;
import my.fbk.npc.myPlayer.Player;

import java.util.Random;
import java.util.Scanner;

public class BattleRoom extends AbstractRoom {
    AbstractEnemy goblin = new Goblin(100, 50, 0, 10);
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    String input;


    @Override
    public void moveNext() {
    }

    public void battle() {
        System.out.println("You entered the battle room and you see an enemy. what do you do?");

        while (true) {
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
                player.showInventory();

            }


        }
    }

    public void action() {
        input = scan.nextLine();
    }

}
