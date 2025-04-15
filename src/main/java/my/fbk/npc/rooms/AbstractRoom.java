package my.fbk.npc.rooms;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.abstract_class.AbstractCharacter;
import my.fbk.npc.all_npc.AbstractNPC;
import my.fbk.npc.Game;
import my.fbk.npc.effects.AbstractEffect;
import my.fbk.npc.my_player.Player;
import my.fbk.npc.spells.AbstractSpell;
import my.fbk.npc.spells.FreezingField;
import my.fbk.npc.spells.Invisibility;
import my.fbk.npc.spells.MindControl;


import java.util.*;

@Getter
@Setter
public abstract class AbstractRoom {

    Player player = null;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    List<AbstractSpell> spells = new ArrayList<>();
    List<AbstractCharacter> allCharacters = new ArrayList<>();
    private AbstractRoom currentRoom;
    Game game;
    String input;

    public AbstractRoom(Game game) {
        this.game = game;
        spells.add(new Invisibility(50));
        spells.add(new FreezingField(70));
        spells.add(new MindControl(50));
    }

    Optional<AbstractSpell> spellOpt2 = Optional.empty();

    public void castSpell() {
        System.out.println("Select the effect: 'inv' for invisibility(50MP) and 'mind' for mind control(50MP) or 'back' to go back");
        userInput();
        if (input.equals("back")) {
            System.out.print(" ");
        }
        Optional<AbstractSpell> spellOpt = selectSpell(input);
        spellOpt2 = spellOpt;
        if (spellOpt.isEmpty()) {
            System.out.println("error");
        } else {
            AbstractSpell spell = spellOpt.get();
            if (spell.getName().equals("mind")) {
                System.out.println("Who is your target?");
                userInput();
                Optional<AbstractCharacter> target = getTarget(input);
                if (target.isPresent()) {
                    targetSpell(spell, target.get(), input);
                    if (target.get() instanceof AbstractNPC) {
                        ((AbstractNPC) target.get()).setReputation(((AbstractNPC) target.get()).getReputation() - 20);
                        System.out.println("The reputation of: " + target.get().getName() + " is now: " + ((AbstractNPC) target.get()).getReputation());
                    }

                }
            } else if (spell.getName().equals("inv")) {
                System.out.println("Select action: use/remove");
                userInput();
                aoeSpell(spell, input);
            } else
                System.out.println("❌ You don't have enough MP ❌");
            System.out.println(player.getMana() + "MP");
        }


    }

    public Optional<AbstractSpell> selectSpell(String input) {
        return spells.stream()
                .filter(e -> e.getName().equals(input))
                .findFirst();
    }

    public void targetSpell(AbstractSpell spell, AbstractCharacter target, String input) {
        applySpell(spell, List.of(target));
    }

    public void aoeSpell(AbstractSpell spell, String input) {
        applySpell(spell, allCharacters);
    }


    public void applySpell(
            AbstractSpell spell,
            List<AbstractCharacter> targets
    ) {
        player.cast(spell, targets);

    }

    public Optional<AbstractCharacter> getTarget(String target) {
        return allCharacters.stream()
                .filter(character -> character.getName().equals(target))
                .findFirst();
    }

    public void userInput() {
        input = scan.nextLine();
    }

    public void decrementEffectDuration(List<AbstractCharacter> characters) {
        for (AbstractCharacter c : characters) {
            if (!c.getEffects().isEmpty()) {
                List<AbstractEffect> expiredAbstractEffects = c.getEffects().stream()
                        .filter(e -> e.getEffectDuration() <= 0)
                        .toList();
                expiredAbstractEffects.forEach(e -> e.removeEffect(c));
            }
        }
        for (AbstractCharacter c : characters) {
            if (!c.getEffects().isEmpty()) {
                c.getEffects().stream().forEach(e -> e.setEffectDuration(e.getEffectDuration() - 1));
            }
        }
    }


}
