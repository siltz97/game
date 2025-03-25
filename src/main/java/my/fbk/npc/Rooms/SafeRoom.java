package my.fbk.npc.Rooms;

import my.fbk.npc.AllNPC.*;
import my.fbk.npc.BasicSpells.Effects;
import my.fbk.npc.BasicSpells.InvisibilitySpell;
import my.fbk.npc.BasicSpells.MindControlSpell;
import my.fbk.npc.Speak.AggressiveSpeak;
import my.fbk.npc.Speak.MindControllSpeak;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.myPlayer.Player;

import java.util.*;

public class SafeRoom {

    final Random rand = new Random();
    final Scanner scan = new Scanner(System.in);
    List<AbstractNPC> allNPC = new ArrayList<>();
    List<Effects> effects = new ArrayList<>();

    AbstractNPC guard = new Guard(rand.nextInt(20), 1000, 60, 100);
    AbstractNPC peasant = new Peasant(rand.nextInt(10), 10, 100, 100);
    AbstractNPC merchant = new Merchant(rand.nextInt(99999), 50, 100, 100);
    AbstractNPC thief = new Thief(rand.nextInt(1), 100, 100, 100);
    Player player = new Player(rand.nextInt(100), 300, 100);

    public SafeRoom() {
        allNPC.add(guard);
        allNPC.add(peasant);
        allNPC.add(merchant);
        allNPC.add(thief);
        effects.add(new InvisibilitySpell());
        effects.add(new MindControlSpell());
    }


    public void npcInteraction() {


        String input;
        Optional<Effects> selectedEffectOpt2 = Optional.empty();
        while (true) {
            System.out.println("Do you want to use or remove effects? (y/n)");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                Optional<Effects> selectedEffectOpt = selectEffect();
                selectedEffectOpt2 = selectedEffectOpt;
                if (selectedEffectOpt.isEmpty()) {
                    System.out.println("error");
                } else {
                    Effects selectedEffect = selectedEffectOpt.get();
                    if (selectedEffect.getName().equals("mind")) {
                        if(selectedEffect.getName().equals("mind")) {
                            System.out.println("Who is your target?");
                            input = scan.nextLine();
                            targetSpell(new MindControlSpell(),input);
                        }else if(selectedEffect.getName().equals("inv")) {
                            aoeSpell(selectedEffect);
                        }
                    }
                }
            } else
                System.out.println("no effect selected");
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

                        if (!selectedEffectOpt2.isEmpty() && merchant.hasEffect(selectedEffectOpt2.get()) || merchant.getReputation() < 50 ){
                                break;
                        }
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
    public Optional<Effects> selectEffect() {
        System.out.println("Select the effect: 'inv' for invisibility and 'mind' for mind control ");
        String input = scan.nextLine();
        return  effects.stream()
                .filter(e -> e.getName().equals(input))
                .findFirst();
    }

    public void targetSpell(Effects selectedEffect, String target) {
        Optional<AbstractNPC> targetNPC = allNPC.stream()
                .filter(npc -> npc.getName().equalsIgnoreCase(target))  // FIXED: Compare name, not object
                .findFirst();

        if (targetNPC.isPresent()) {
            System.out.println("Select action: use/remove");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("use")) {
                selectedEffect.applyEffect(targetNPC.get());
            } else if (input.equalsIgnoreCase("remove")) {
                selectedEffect.removeEffect(targetNPC.get());
            } else {
                System.out.println("Invalid input, retry.");
            }
        } else {
            System.out.println("Target not found.");
        }
    }
    public void aoeSpell(Effects selectedEffect) {
        System.out.println("Select action: use/remove");
        String input = scan.nextLine();

        if (input.equalsIgnoreCase("use")) {
            allNPC.forEach(selectedEffect::applyEffect);
        } else if (input.equalsIgnoreCase("remove")) {
            allNPC.forEach(selectedEffect::removeEffect);
        } else {
            System.out.println("Invalid input, retry.");
        }

    }


}
