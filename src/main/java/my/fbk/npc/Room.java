package my.fbk.npc;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Actions.BucketEffect;
import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.AllNPC.Thief;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.myPlayer.Player;

import java.util.Random;
import java.util.Scanner;

public class Room {
    final Random rand = new Random();
    final Scanner scan = new Scanner(System.in);


    AbstractNPC guard = new Guard(rand.nextInt(20), 1000,30);
    AbstractNPC peasant = new Peasant(rand.nextInt(10), 10,10);
    AbstractNPC merchant = new Merchant(rand.nextInt(99999), 50,10);
    AbstractNPC thief = new Thief(rand.nextInt(1), 100,100);
    Player player = new Player(rand.nextInt(100), 300);


    public void Play() {

        System.out.println("Choose a character to interact with: peasant, guard, merchant,thief or type 'exit' to quit.");
        while (true) {
            String choice = scan.nextLine().toLowerCase();
            switch (choice) {
//peasant
                case "peasant":
                    System.out.print("Player: ");
                    player.speak();
                    System.out.print("Peasant: ");
                    peasant.speak();
                    break;
//guard
                case "thief":
                    System.out.print("Player: ");
                    player.speak();
                    System.out.print("Thief: ");
                    thief.speak();
                    break;

                case "guard":
                    BucketEffect.applyBucket(player, guard);
                    System.out.print("Player: ");
                    player.speak();
                    System.out.print("Guard: ");
                    guard.speak();

                    break;
//merchant
                case "merchant":
                    System.out.print("Player: ");
                    player.speak();
                    System.out.print("Merchant: ");
                    merchant.speak();
                    System.out.println("Merchant interaction: Type 'open' to open inventory, 'close' to close, 'back' to choose another character or 'buy'/'sell'");
                    /*inventory*/
                    while (true) {
                        String s = scan.nextLine().toLowerCase();
                        if (s.equals("open")) {
                            System.out.println("Which inventory you want to open?");
                            System.out.println("1: Player; 2:Merchant; 3:Both");
                            String open = scan.nextLine();
                            switch (open) {
                                case "1":
                                    player.openInventory();
                                    player.showInventory();
                                    break;
                                case "2":
                                    ((Merchant) merchant).openInventory();
                                    ((Merchant) merchant).showInventory();
                                    break;
                                case "3":
                                    player.openInventory();
                                    player.showInventory();
                                    ((Merchant) merchant).openInventory();
                                    ((Merchant) merchant).showInventory();
                                    break;
                            }

                        } else if (s.equals("close")) {
                            player.closeInventory();
                            ((Merchant) merchant).closeInventory();
//buy

                        } else if (s.equals("buy")) {
                            while (true) {
                                ((Merchant) merchant).showInventory();
                                System.out.println("Player's money: " + player.getMoney());
                                System.out.println("Enter item name to buy or 'back' to exit");
                                String itemName = scan.nextLine().toUpperCase();
                                if (itemName.equals("BACK")) {
                                    break;
                                }
                                try {
                                    ItemList item = ItemList.valueOf(itemName);// Assuming ItemList has a method to get item by name
                                    if (player.getMoney() >= item.getPrice()) {
                                        player.buyItem(item, merchant);
                                        player.setMoney(player.getMoney() - item.getPrice());
                                        merchant.setMoney(merchant.getMoney() + item.getPrice());
                                        player.seeMoney();
                                    } else {
                                        System.out.println("Not enough money.");
                                    }

                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid item. Retry");
                                }
                            }
                        }
                        /*sell*/
                        else if (s.equals("sell")) {
                            try {
                                player.showInventory();
                                System.out.println("Enter item name to sell:");
                                String itemName = scan.nextLine().toUpperCase();
                                if (itemName.equals("BACK")) {
                                    continue;
                                }
                                ItemList item = ItemList.valueOf(itemName);
                                if (merchant.getMoney() >= item.getPrice()) {
                                    player.sellItem(item, merchant);
                                    player.setMoney(player.getMoney() + item.getPrice());
                                    merchant.setMoney(merchant.getMoney() - item.getPrice());
                                    player.seeMoney();
                                } else {
                                    System.out.println("Not enough money.");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid item. Retry");
                            }
                        } else if (s.equals("back")) {
                            break; // Go back to character selection
                        }
                    }
                    break;
//thief
                case "exit":
                    System.out.println("Exiting game...");
                    scan.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        Room r = new Room();
        r.Play();
    }

}
