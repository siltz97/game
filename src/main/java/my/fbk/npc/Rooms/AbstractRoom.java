package my.fbk.npc.Rooms;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AllNPC.*;
import my.fbk.npc.BasicSpells.Effects;
import my.fbk.npc.BasicSpells.InvisibilitySpell;
import my.fbk.npc.BasicSpells.MindControlSpell;
import my.fbk.npc.Enemy.*;
import my.fbk.npc.Game;
import my.fbk.npc.myPlayer.Player;

import java.util.*;

@Getter
@Setter
public abstract class AbstractRoom {

    Player player = null;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    List<Effects> effects = new ArrayList<>();
    List<AbstractNPC> allNPC = new ArrayList<>();
    private AbstractRoom currentRoom;
    Game game;
    String input;
    AbstractEnemy enemy;

    public AbstractRoom(Game game) {
        this.game = game;
        effects.add(new MindControlSpell());
        effects.add(new InvisibilitySpell());
    }

    Optional<Effects> selectedEffectOpt2 = Optional.empty();

    public void castSpell() {

        System.out.println("Do you want to use or remove effects? (y/n)");
        userInput();
        if (input.equals("y")) {
            System.out.println("Select the effect: 'inv' for invisibility and 'mind' for mind control ");
            userInput();
            Optional<Effects> selectedEffectOpt = selectEffect(input);
            selectedEffectOpt2 = selectedEffectOpt;
            if (selectedEffectOpt.isEmpty()) {
                System.out.println("error");
            } else {
                Effects selectedEffect = selectedEffectOpt.get();
                if (selectedEffect.getName().equals("mind")) {
                    System.out.println("Who is your target?");
                    userInput();
                    Optional<AbstractNPC> target = getTarget(input);
                    if (target.isPresent()) {
                        System.out.println("Select action: use/remove");
                        userInput();
                        targetSpell(selectedEffect, target.get(), input);
                    }
                } else if (selectedEffect.getName().equals("inv")) {
                    System.out.println("Select action: use/remove");
                    userInput();
                    aoeSpell(selectedEffect, input);
                } else
                    System.out.println("player has not enough mana");
                System.out.println(player.getMana() + "MP");
            }
        }

    }

    public Optional<Effects> selectEffect(String input) {
        return effects.stream()
                .filter(e -> e.getName().equals(input))
                .findFirst();
    }

    public void targetSpell(Effects selectedEffect, AbstractNPC target, String input) {
        applySpell(selectedEffect, List.of(target), input);
        target.setReputation(target.getReputation() - 20);
    }

    public void aoeSpell(Effects selectedEffect, String input) {
        applySpell(selectedEffect, allNPC, input);
    }


    public void applySpell(
            Effects selectedEffect,
            List<AbstractNPC> targets,
            String input
    ) {

        if (player.getMana() >= selectedEffect.spellCost()) {
            if (input.equals("use")) {
                targets.forEach(selectedEffect::applyEffect);
            }
            player.setMana(player.getMana() - selectedEffect.spellCost());
        }
        if (input.equals("remove")) {
            targets.forEach(selectedEffect::removeEffect);
        }
    }

    public Optional<AbstractNPC> getTarget(String target) {
        return allNPC.stream()
                .filter(npc -> npc.getName().equals(target))
                .findFirst();
    }

    public void userInput() {
        input = scan.nextLine();
    }



}
