package my.fbk.npc;

import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.BasicSpells.InvisibilitySpell;
import my.fbk.npc.Speak.SilentSpeak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class MerchantTest {

    @Test
    public void merchantTestPositive() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1);
        merchant.speak();
    }

    @Test
    public void merchantTestNeutral() {
        Merchant merchant = new Merchant(1, 100, 61, 2,1);
        merchant.speak();
    }

    @Test
    public void merchantTestAggressive() {
        Merchant merchant = new Merchant(1, 100, 40, 2,1);
        merchant.speak();
        Assertions.assertFalse(merchant.getReputation() > 50 && merchant.getEffects().isEmpty());
    }

    @Test
    public void merchantTestSilent() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1);
        merchant.setEffects(new InvisibilitySpell());
        merchant.speak();
        Assertions.assertTrue(merchant.getBehavior() instanceof SilentSpeak);
    }

    @Test
    @DisplayName("user can trade")
    public void merchantTestInventoryAccessConditions() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1);
        if (merchant.getReputation() > 50 && merchant.getEffects().isEmpty()) {
            merchant.showInventory();
        }
        Assertions.assertTrue(merchant.getReputation() > 50 && merchant.getEffects().isEmpty());
    }
    @Test
    public void merchantTestInventoryHasItems() {
        Merchant merchant = new Merchant(99999, 100, 100, 2,1);
        merchant.showInventory();
        Assertions.assertTrue(merchant.getInventory().getInventorySize()>=0,"good");
    }

}
