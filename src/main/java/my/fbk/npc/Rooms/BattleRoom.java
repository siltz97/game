package my.fbk.npc.Rooms;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.BattleSpells.FireBall;
import my.fbk.npc.BattleSpells.HolyHealing;
import my.fbk.npc.Enemy.AbstractEnemy;
import my.fbk.npc.Game;
import my.fbk.npc.factories.GoblinFactory;
import my.fbk.npc.factories.KoboldFactory;
import my.fbk.npc.factories.SkeletonFactory;
import my.fbk.npc.factories.ZombieFactory;
import my.fbk.npc.inventory.Inventory;
import my.fbk.npc.inventory.ItemList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("StringTemplateMigration")
public class BattleRoom extends AbstractRoom {


    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    AbstractCharacter enemy;

    public BattleRoom(Game game) {
        super(game);
    }

    public void battle() {
        System.out.println("You entered the BATTLE ROOM");
        generateEnemy();
        System.out.println("Your stats: " + player.getHealth() + " HP " + player.getMana() + " MP " + player.getDamage() + " DMG");
        System.out.println("Enemy stats: " + enemy.getHealth() + " HP " + enemy.getMana() + " MP " + enemy.getDamage() + " DMG");


        while (true) {
            if (player.getHealth() <= 0) {
                System.out.println("Player died,game over");
                return;
            } else if (enemy.getHealth() <= 0) {
                player.setMoney(player.getMoney() + enemy.getMoney());
                System.out.println("Player earned: " + enemy.getMoney() + "$  and now has: " + player.getMoney() + "$");
                System.out.print("enemy loot is: ");
                enemy.getInventory().showInventory();
                player.getInventory().takeLoot(player, enemy);
                player.setExperience(enemy.getExperience() + player.getExperience());
                System.out.println("Player experience is: " + player.getExperience());
                if (player.getExperience() >= 100) {
                    player.LevelUp();
                }
                System.out.println("enemy died, press any key to go on");
                userInput();
                game.moveNext();
            }
            System.out.println("What do you want to do? 'a' to attack/'i' to use item /'s' to use spell or 'next' to go to another room");

            userInput();
            try {
                if (input.equals("a")) {
                    playerAttack();
                    enemyAttack();
                } else if (input.equals("i")) {
                    while(true) {
                        System.out.println("Select an item to use or 'back'");
                        player.showInventory();
                        userInput();
                        if (input.equals("back")) {
                            break;
                        }
                        try {
                            ItemList item = ItemList.valueOf(input.toUpperCase());
                            player.getInventory().equals(item);
                            if (item.equals(ItemList.FIRE_SCROLL)) {
                                player.useItem(item, enemy);
                            } else
                                player.useItem(item, player);
                        } catch (IllegalArgumentException e) {
                            System.out.println("not a name,retry");
                        }
                    }

                } else if (input.equals("next")) {
                    game.moveNext();

                } else if (input.equals("s")) {
                    while(true) {
                        System.out.println("Player's MP is: " + player.getMana());
                        System.out.println("Select a spell to use: 'fire' for fireball(30MP) or 'heal' for healing(50MP) or 'back'");
                        userInput();
                        if (input.equals("fire")) {
                            FireBall fire = new FireBall(player, enemy);
                            fire.cast();
                        } else if (input.equals("heal")) {
                            HolyHealing heal = new HolyHealing(player, enemy);
                            heal.cast();
                        }else if(input.equals("back")) {
                            break;
                        }
                    }
                }
            }catch (IllegalArgumentException e) {
                System.out.println("wrong input, retry");
            }
        }
    }

    public void generateEnemy() {
        //the enemies are uselessly generated even if it is used only one of them
        List<AbstractCharacter> enemyTypes = List.of(
                GoblinFactory.makeRandomEnemy(player.getLevel()),
                KoboldFactory.makeRandomEnemy(player.getLevel()),
                SkeletonFactory.makeRandomEnemy(player.getLevel()),
                ZombieFactory.MakeRandomEnemy(player.getLevel())
        );
        enemy = enemyTypes.get(rand.nextInt(enemyTypes.size()));
        System.out.println("you see a " + enemy.getName().toUpperCase() + " Get ready to fight!");

    }

    public void userInput() {
        input = scan.nextLine();
    }

    public void playerAttack() {
        player.attack();
        enemy.setHealth(enemy.getHealth() - player.getDamage());
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " HP");
    }

    public void enemyAttack() {
        enemy.attack();
        player.setHealth(player.getHealth() - enemy.getDamage());
        System.out.println("Player has " + player.getHealth() + " HP");
    }


}
