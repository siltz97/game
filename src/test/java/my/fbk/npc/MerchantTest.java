package my.fbk.npc;

import my.fbk.npc.all_npc.Merchant;
import my.fbk.npc.effects.InvisibilityAbstractEffect;
import my.fbk.npc.speak.SilentSpeak;
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
        Assertions.assertFalse(merchant.getReputation() > 50 && merchant.getAbstractEffects().isEmpty());
    }

    @Test
    public void merchantTestSilent() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        merchant.setAbstractEffects(new InvisibilityAbstractEffect(5));
        merchant.speak();
        Assertions.assertTrue(merchant.getBehavior() instanceof SilentSpeak);
    }

    @Test
    @DisplayName("user can trade")
    public void merchantTestInventoryAccessConditions() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        if (merchant.getReputation() > 50 && merchant.getAbstractEffects().isEmpty()) {
            merchant.showInventory();
        }
        Assertions.assertTrue(merchant.getReputation() > 50 && merchant.getAbstractEffects().isEmpty());
    }
    @Test
    public void merchantTestInventoryHasItems() {
      Merchant merchant =  NPCFactory.makeMerchant();
        merchant.showInventory();
        Assertions.assertTrue(merchant.getInventory().getInventorySize()>0,"good");
    }

}
