package my.fbk.npc.Rooms;

import ch.qos.logback.core.joran.sanity.Pair;
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
    @Getter @Setter
    Player player = null;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    List<Effects> effects = new ArrayList<>();
    List<AbstractNPC> allNPC = new ArrayList<>();
    List<AbstractEnemy> allEnemy = new ArrayList<>();
    private AbstractRoom currentRoom;
    Game game;



    AbstractNPC merchant = new Merchant(99999, 50, 100, 100,1);
    AbstractNPC guard = new Guard(99999, 50, 100, 100,1);
    AbstractNPC thief = new Thief(99999, 50, 100, 100,1);
    AbstractNPC peasant = new Peasant(99999, 50, 100, 100,1);
    AbstractEnemy goblin = new Goblin(100, 50, 0, 10);
    AbstractEnemy kobold = new Kobold(100, 50, 0, 10);
    AbstractEnemy skeleton = new Skeleton(100, 50, 0, 10);
    AbstractEnemy zombie = new Zombie(100, 50, 0, 10);


    public AbstractRoom(Game game) {
        effects.add(new MindControlSpell());
        effects.add(new InvisibilitySpell());
        allNPC.add(merchant);
        allNPC.add(guard);
        allNPC.add(thief);
        allNPC.add(peasant);
        allEnemy.add(goblin);
        allEnemy.add(kobold);
        allEnemy.add(skeleton);
        allEnemy.add(zombie);
        this.game = game;
    }

    public void castSpell() {
        String input;
       // Optional<Effects> selectedEffectOpt2 = Optional.empty();

        System.out.println("Do you want to use or remove effects? (y/n)");
        input = scan.nextLine();
        if (input.equals("y")) {
            System.out.println("Select the effect: 'inv' for invisibility and 'mind' for mind control ");
            input = scan.nextLine();
            Optional<Effects> selectedEffectOpt = selectEffect(input);
            //selectedEffectOpt2 = selectedEffectOpt;
            if (selectedEffectOpt.isEmpty()) {
                System.out.println("error");
            } else {
                Effects selectedEffect = selectedEffectOpt.get();
                if (selectedEffect.getName().equals("mind")) {
                    System.out.println("Who is your target?");
                    input = scan.nextLine();
                    Optional<AbstractNPC> target = getTarget(input);
                    if (target.isPresent()) {
                        System.out.println("Select action: use/remove");
                        input = scan.nextLine();
                        targetSpell(selectedEffect, target.get(), input);
                    }
                } else if (selectedEffect.getName().equals("inv")) {
                    System.out.println("Select action: use/remove");
                    input = scan.nextLine();
                    aoeSpell(selectedEffect, input);
                } else
                    System.out.println("player has not enough mana");
                System.out.println(player.getMana() + "MP");
            }
        } else
            System.out.println("no effect selected");

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


}
