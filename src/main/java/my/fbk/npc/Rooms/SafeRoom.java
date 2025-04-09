package my.fbk.npc.Rooms;

import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.Game;
import my.fbk.npc.factories.NPCFactory;
import my.fbk.npc.inventory.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SuppressWarnings("StringOperationCanBeSimplified")
public class SafeRoom extends AbstractRoom {

    Scanner scan = new Scanner(System.in);


    public SafeRoom(Game game) {
        super(game);
        allCharacters = new ArrayList<>();
    }

    public void npcInteraction() {
        generateNPC();
        System.out.println("You are now in a SAFE ROOM. Take a rest and interact with some npc if you want.");
        while (true) {
            System.out.println(" Type 'sp' to apply some effects on npc or 's' to interact with npc");
            userInput();
            if (input.equals("sp")) {
                castSpell();
            } else if (input.equals("s")) {
                System.out.println("");
            }
            while (true) {
                System.out.println("Choose a character to interact with: peasant, guard, merchant,thief ; type 'exit' to quit ; 'b' to change effects ; 'open' to see the inventory or 'n' to move forward");
                userInput();
                try {
                    if (input.toLowerCase().equals("b")) {
                        break;
                    } else if (input.toLowerCase().equals("n")) {
                        game.moveNext();
                        break;
                    } else if (input.equals("exit")) {
                        System.out.println("Exiting game...");
                        scan.close();
                        return;
                    } else if (input.equals("open")) {
                        player.showInventory();
                        System.out.println(player.getMoney() + "$");
                        System.out.println("Do you want to use an item? y/n");
                        userInput();
                        if (input.toLowerCase().equals("y")) {
                            System.out.println("Select an item");
                            userInput();
                            ItemList item = ItemList.valueOf(input.toUpperCase());
                            player.useItem(item, player);
                        } else if (input.equals("n")) {
                            break;
                        }
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("wrong input, retry");
                }

                Optional<AbstractCharacter> npc = allCharacters.stream().filter(n -> n.getName().equals(input)).findFirst();
                if (npc.isEmpty()) {
                    System.out.println("error");
                    continue;
                }
                AbstractCharacter speaker = npc.get();
                switch (input) {
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

                        if (!merchant.getEffects().isEmpty() || merchant.getReputation() < 50) {
                            break;
                        }
                        System.out.println("Type 'open' to open inventory, 'close' to close, 'buy'/'sell' or 'back' to choose another character");
//inventory
                        while (true) {
                            userInput();
                            if (input.toLowerCase().equals("open")) {
                                player.showInventory();
                                System.out.println();
                                merchant.showInventory();
//buy
                            } else if (input.equals("buy")) {
                                while (true) {
                                    merchant.showInventory();
                                    System.out.println("Player's money: " + player.getMoney());
                                    System.out.println("Enter item name to buy or 'b' to exit");
                                    userInput();
                                    if (input.toUpperCase().equals("B")) {
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
                                while (true) {
                                    try {
                                        player.showInventory();
                                        System.out.println("Enter item name to sell:");
                                        userInput();
                                        if (input.toUpperCase().equals("B")) {
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
                                }
                            } else if (input.equals("b")) {
                                break; // Go back to character selection
                            }

                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");

                }
            }

        }
    }

    public void generateNPC() {
        List<AbstractCharacter> npcTypes = List.of(
                NPCFactory.makeGuard(),
                NPCFactory.makePeasant(),
                NPCFactory.makeThief(),
                NPCFactory.makeMerchant()
        );
        setAllCharacters(npcTypes);
    }

    public void userInput() {
        input = scan.nextLine();
    }
}

