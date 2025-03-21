package my.fbk.npc;

import my.fbk.npc.AbstractClass.AbstractNPC;
import my.fbk.npc.Actions.InvisibilityEffect;
import my.fbk.npc.AllNPC.Guard;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.AllNPC.Peasant;
import my.fbk.npc.AllNPC.Thief;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.myPlayer.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Room {

    final Random rand = new Random();
    final Scanner scan = new Scanner(System.in);
    List<AbstractNPC> npcs = new ArrayList<>();


    AbstractNPC guard = new Guard(rand.nextInt(20), 1000, 60, 100);
    AbstractNPC peasant = new Peasant(rand.nextInt(10), 10, 100, 100);
    AbstractNPC merchant = new Merchant(rand.nextInt(99999), 50, 10, 100);
    AbstractNPC thief = new Thief(rand.nextInt(1), 100, 100, 100);
    Player player = new Player(rand.nextInt(100), 300, 100);


    public void Play() {
        npcs.add(guard);
        npcs.add(peasant);
        npcs.add(merchant);
        npcs.add(thief);
        while (true) {

            System.out.println("Choose a character to interact with: peasant, guard, merchant,thief or type 'exit' to quit.");
            String choice = scan.nextLine().toLowerCase();
            switch (choice) {

//peasant
                case "peasant":
                    System.out.print("Player: ");
                    player.speak();
                    System.out.print("Peasant: ");
                    peasant.speak();
                    break;
//thief
                case "thief":
                    System.out.print("Player: ");
                    player.speak();
                    System.out.print("Thief: ");
                    thief.speak();
                    break;
//guard
                case "guard":
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
//inventory
                    while (true) {
                        String s = scan.nextLine().toLowerCase();
                        if (s.equals("open")) {
                            player.openInventory();
                            player.showInventory();
                            ((Merchant) merchant).openInventory();
                            ((Merchant) merchant).showInventory();
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
//sell
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
