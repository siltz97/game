package my.fbk.npc.BasicSpells;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.fbk.npc.AllNPC.AbstractNPC;
import my.fbk.npc.Rooms.InteractRoom;
import my.fbk.npc.myPlayer.Player;


@Getter
@Setter
public class InvisibilitySpell implements Effects {
    int spellCost = 50;


    @Override
    public int spellCost() {
        return this.spellCost;
    }

    @Override
    public void applyEffect(AbstractNPC npc) {
            npc.setEffects(this);
    }

    @Override
    public void removeEffect(AbstractNPC npc) {
        npc.setRemoveEffect(this);
    }
    @Override
    public boolean hasEffect(AbstractNPC npc) {
        return npc.getEffects() != null;
    }

    @Override
    public String getName() {
        return "inv";
    }

}
