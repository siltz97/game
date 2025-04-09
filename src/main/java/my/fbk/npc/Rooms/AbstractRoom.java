package my.fbk.npc.Rooms;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AbstractClass.AbstractCharacter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.effects.Effect;
import my.fbk.npc.effects.InvisibilityEffect;
import my.fbk.npc.effects.MindControlEffect;
import my.fbk.npc.Game;
import my.fbk.npc.myPlayer.Player;
import my.fbk.npc.spells.FreezingField;
import my.fbk.npc.spells.Invisibility;
import my.fbk.npc.spells.MindControl;
import my.fbk.npc.spells.Spell;

import java.util.*;

@Getter
@Setter
public abstract class AbstractRoom {

    Player player = null;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    List<Spell> spells = new ArrayList<>();
    List<AbstractCharacter> allCharacters = new ArrayList<>();
    private AbstractRoom currentRoom;
    Game game;
    String input;

    public AbstractRoom(Game game) {
        this.game = game;
        spells.add(new Invisibility(30));
        spells.add(new FreezingField(30));
        spells.add(new MindControl(30));
    }

    Optional<Spell> spellOpt2 = Optional.empty();

    public void castSpell() {
        System.out.println("Select the effect: 'inv' for invisibility(50MP) and 'mind' for mind control(50MP) or 'back' to go back");
        userInput();
        if (input.equals("back")) {
            System.out.print(" ");
        }
        Optional<Spell> spellOpt = selectSpell(input);
        spellOpt2 = spellOpt;
        if (spellOpt.isEmpty()) {
            System.out.println("error");
        } else {
            Spell spell = spellOpt.get();
            if (spell.getName().equals("mind")) {
                System.out.println("Who is your target?");
                userInput();
                Optional<AbstractCharacter> target = getTarget(input);
                if (target.isPresent()) {
                    System.out.println("Select action: use/remove");
                    userInput();
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
                System.out.println("player has not enough MP");
            System.out.println(player.getMana() + "MP");
        }


    }

    public Optional<Spell> selectSpell(String input) {
        return spells.stream()
                .filter(e -> e.getName().equals(input))
                .findFirst();
    }

    public void targetSpell(Spell spell, AbstractCharacter target, String input) {
        applySpell(spell, List.of(target));
    }

    public void aoeSpell(Spell spell, String input) {
        applySpell(spell, allCharacters);
    }


    public void applySpell(
            Spell spell,
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


}
