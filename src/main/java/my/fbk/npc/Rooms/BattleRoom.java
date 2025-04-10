package my.fbk.npc.Rooms;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.spells.FireBall;
import my.fbk.npc.spells.FreezingField;
import my.fbk.npc.spells.HolyHealing;
import my.fbk.npc.Game;
import my.fbk.npc.factories.GoblinFactory;
import my.fbk.npc.factories.KoboldFactory;
import my.fbk.npc.factories.SkeletonFactory;
import my.fbk.npc.factories.ZombieFactory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
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
        allCharacters = new ArrayList<>();
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
            System.out.println("What do you want to do? 'a' to attack/'i' to use item /'s' to use spell/'e' to see the equipment or 'inv' to use invisibility and skip the room(50MP)");

            userInput();
            try {
                if (input.equals("a")) {
//attack
                    playerAttack();
                    enemyAttack();
                    decrementEffectDuration(List.of(enemy));
                } else if (input.equals("i")) {
//inventory
                    while (true) {
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

                } else if (input.equals("inv")) { // invisibility
//                    if (player.getMana() >= 50) {
//                        System.out.println("You casted invisibility, and now you can pass through the enemy");
//                        player.setMana(player.getMana() - 50);
//                        System.out.println("Player's MP: " + player.getMana() + "\n");
                        game.moveNext();
//                    }
//                }else {
//                        System.out.println("Player has not enough mana, you should battle for survive or regenerate mana");
//                    }

                } else if (input.equals("s")) {
//spells
                    while (true) {
                        System.out.println("Player's MP is: " + player.getMana());
                        System.out.println("Select a spell to use: 'fire' for fireball(30MP) or 'heal' for healing(50MP) or 'field' for freezing field(70MP) or 'back'");
                        userInput();
                        if (input.equals("fire")) {
                            FireBall fire = new FireBall(30);
                            player.cast(fire,List.of(enemy));
                        } else if (input.equals("heal")) {
                            HolyHealing heal = new HolyHealing(30);
                            player.cast(heal,List.of(player));
                        }else if(input.equals("field")) {
                            FreezingField freezingField = new FreezingField(30);
                            player.cast(freezingField,List.of(enemy));
                        } else if (input.equals("back")) {
                            break;
                        }
                    }
//equipment
                }else if(input.equals("e")) {
                    player.showEquipment();
                }
            } catch (IllegalArgumentException e) {
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
