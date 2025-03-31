package my.fbk.npc.Rooms;

import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.Game;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

@SuppressWarnings("StringOperationCanBeSimplified")
public class SafeRoom extends AbstractRoom {

    Scanner scan = new Scanner(System.in);


    public SafeRoom(Game game) {
        super(game);
        allNPC = new ArrayList<>();
    }

    public void npcInteraction() {
        System.out.println("You are now in a SAFE ROOM. Take a rest and interact with some npc if you want.");
        while (true) {
            System.out.println(" Type 'use spell'/'speak'");
            action();
            if (input.equals("use spell")) {
                castSpell();
            } else if (input.equals("speak")) {
            }
            while (true) {
                System.out.println("Choose a character to interact with: peasant, guard, merchant,thief ; type 'exit' to quit ; 'back' to change effects ; 'open' to see the inventory or 'next' to move forward");
                action();
                if (input.toLowerCase().equals("back")) {
                    break;
                } else if (input.toLowerCase().equals("next")) {
                    game.moveNext();
                    break;
                }
                Optional<AbstractNPC> npc = allNPC.stream().filter(n -> n.getName().equals(input)).findFirst();
                if (npc.isEmpty()) {
                    System.out.println("error");
                    continue;
                }
                AbstractNPC speaker = npc.get();
                switch (input) {
                    case "open":
                        player.showInventory();
                        System.out.println(player.getMoney() + "$");
                        System.out.println("Do you want to use an item? yes/no");
                        action();
                        if (input.toLowerCase().equals("yes")) {
                            System.out.println("Select an item");
                            action();
                            ItemList item = ItemList.valueOf(input.toUpperCase());
                            player.useItem(item);
                        } else if (input.equals("no")) {
                            break;
                        }
                        break;
//peasant
                    case "peasant":
                        System.out.print("Player: ");
                        player.speak();
                        System.out.print("Peasant: ");
                        speaker.speak();
                        break;
//thief
                    case "thief":
                        System.out.print("Player: ");
                        player.speak();
                        System.out.print("Thief: ");
                        speaker.speak();
                        break;
//guard
                    case "guard":
                        System.out.print("Player: ");
                        player.speak();
                        System.out.print("Guard: ");
                        speaker.speak();
                        break;
//merchant
                    case "merchant":
                        Merchant merchant = (Merchant) speaker;
                        System.out.print("Player: ");
                        player.speak();
                        System.out.print("Merchant: ");
                        merchant.speak();

                        if (!selectedEffectOpt2.isEmpty() && merchant.hasEffect(selectedEffectOpt2.get()) || merchant.getReputation() < 50) {
                            break;
                        }
                        System.out.println("Type 'open' to open inventory, 'close' to close, 'buy'/'sell' or 'back' to choose another character");
//inventory
                        while (true) {
                            action();
                            if (input.toLowerCase().equals("open")) {
                                player.openInventory();
                                player.showInventory();
                                System.out.println();
                                merchant.openInventory();
                                merchant.showInventory();
                            } else if (input.equals("close")) {
                                player.closeInventory();
                                merchant.closeInventory();
//buy
                            } else if (input.equals("buy")) {
                                while (true) {
                                    merchant.showInventory();
                                    System.out.println("Player's money: " + player.getMoney());
                                    System.out.println("Enter item name to buy or 'back' to exit");
                                    action();
                                    if (input.toUpperCase().equals("BACK")) {
                                        break;
                                    }
                                    try {
                                        ItemList item = ItemList.valueOf(input.toUpperCase());// Assuming ItemList has a method to get item by name
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
                                    action();
                                    if (input.toUpperCase().equals("BACK")) {
                                        continue;
                                    }
                                    ItemList item = ItemList.valueOf(input.toUpperCase());
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

    public void action() {
        input = scan.nextLine();
    }
}

