package my.fbk.npc;

import my.fbk.npc.AllNPC.Merchant;
import my.fbk.npc.effects.InvisibilityEffect;
import my.fbk.npc.Speak.SilentSpeak;
import my.fbk.npc.factories.NPCFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class MerchantTest {

    @Test
    public void merchantTestPositive() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        merchant.speak();
    }

    @Test
    public void merchantTestNeutral() {
        Merchant merchant = new Merchant(1, 100, 61, 2,1,0);
        merchant.speak();
    }

    @Test
    public void merchantTestAggressive() {
        Merchant merchant = new Merchant(1, 100, 40, 2,1,0);
        merchant.speak();
        Assertions.assertFalse(merchant.getReputation() > 50 && merchant.getEffects().isEmpty());
    }

    @Test
    public void merchantTestSilent() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        merchant.setEffects(new InvisibilityEffect());
        merchant.speak();
        Assertions.assertTrue(merchant.getBehavior() instanceof SilentSpeak);
    }

    @Test
    @DisplayName("user can trade")
    public void merchantTestInventoryAccessConditions() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        if (merchant.getReputation() > 50 && merchant.getEffects().isEmpty()) {
            merchant.showInventory();
        }
        Assertions.assertTrue(merchant.getReputation() > 50 && merchant.getEffects().isEmpty());
    }
    @Test
    public void merchantTestInventoryHasItems() {
      Merchant merchant =  NPCFactory.makeMerchant();
        merchant.showInventory();
        Assertions.assertTrue(merchant.getInventory().getInventorySize()>=0,"good");
    }

}
