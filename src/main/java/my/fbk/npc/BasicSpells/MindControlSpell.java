package my.fbk.npc.BasicSpells;

import lombok.Getter;
import lombok.Setter;
import my.fbk.npc.AllNPC.AbstractNPC;

@Getter
@Setter
public class MindControlSpell implements Effects {

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
        return "mind";
    }
}
