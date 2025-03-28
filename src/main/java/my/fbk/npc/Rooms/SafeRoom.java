package my.fbk.npc.Rooms;

import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.Game;
import my.fbk.npc.inventory.ItemList;

import java.util.Scanner;

public class SafeRoom extends AbstractRoom {


    final Scanner scan = new Scanner(System.in);

    public SafeRoom(Game game) {
        super(game);
    }


    public void npcInteraction() {
        while (true) {
            String input;
            castSpell();
            while (true) {

                System.out.println("Choose a character to interact with: peasant, guard, merchant,thief or type 'exit' to quit or 'back' to change effects or 'open' to see the inventory");
                input = scan.nextLine().toLowerCase();
                if (input.equals("back")) {
                    break;
                }
                switch (input) {
                    case "open":
                        player.showInventory();
                        System.out.println(player.getMoney() + "$");
                        break;
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

//                    if (!selectedEffectOpt2.isEmpty() && merchant.hasEffect(selectedEffectOpt2.get()) || merchant.getReputation() < 50) {
//                        break;
//                    }
                        System.out.println("Type 'open' to open inventory, 'close' to close, 'buy'/'sell' or 'back' to choose another character");
//inventory
                        while (true) {
                            input = scan.nextLine().toLowerCase();
                            if (input.equals("open")) {
                                player.openInventory();
                                player.showInventory();
                                ((Merchant) merchant).openInventory();
                                ((Merchant) merchant).showInventory();
                            } else if (input.equals("close")) {
                                player.closeInventory();
                                ((Merchant) merchant).closeInventory();
//buy
                            } else if (input.equals("buy")) {
                                while (true) {
                                    ((Merchant) merchant).showInventory();
                                    System.out.println("Player's money: " + player.getMoney());
                                    System.out.println("Enter item name to buy or 'back' to exit");
                                    input = scan.nextLine().toUpperCase();
                                    if (input.equals("BACK")) {
                                        break;
                                    }
                                    try {
                                        ItemList item = ItemList.valueOf(input);// Assuming ItemList has a method to get item by name
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
                            else if (input.equals("sell")) {
                                try {
                                    player.showInventory();
                                    System.out.println("Enter item name to sell:");
                                    input = scan.nextLine().toUpperCase();
                                    if (input.equals("BACK")) {
                                        continue;
                                    }
                                    ItemList item = ItemList.valueOf(input);
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
                            } else if (input.equals("back")) {
                                break; // Go back to character selection
                            }
                        }
                        break;

                    case "next":
                        game.moveNext();
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
    }


}

