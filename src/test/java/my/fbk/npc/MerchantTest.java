package my.fbk.npc;

import my.fbk.npc.all_npc.Merchant;
import my.fbk.npc.effects.InvisibilityAbstractEffect;
import my.fbk.npc.inventory.ItemList;
import my.fbk.npc.my_player.Player;
import my.fbk.npc.speak.SilentSpeak;
import my.fbk.npc.factories.NPCFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class MerchantTest {

    @Test
    public void merchantTestPositiveBehavior() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        merchant.speak();
    }

    @Test
    public void merchantTestNeutralBehavior() {
        Merchant merchant = new Merchant(1, 100, 61, 2,1,0);
        merchant.speak();
    }

    @Test
    public void merchantTestAggressiveBehavior() {
        Merchant merchant = new Merchant(1, 100, 40, 2,1,0);
        merchant.speak();
        Assertions.assertFalse(merchant.getReputation() > 50 && merchant.getAbstractEffects().isEmpty());
    }

    @Test
    public void merchantTestSilentBehavior() {
        Merchant merchant = new Merchant(1, 100, 100, 2,1,0);
        merchant.setAbstractEffects(new InvisibilityAbstractEffect(5));
        merchant.speak();
        Assertions.assertTrue(merchant.getBehavior() instanceof SilentSpeak);
    }

    @Test
    @DisplayName("user can trade")
    public void merchantTestInventoryAccessConditions() {
        Merchant merchant = NPCFactory.makeMerchant();
        if (merchant.getReputation() > 30 && merchant.getAbstractEffects().isEmpty()) {
            merchant.showInventory();
        }
        Assertions.assertTrue(merchant.getReputation() > 30 && merchant.getAbstractEffects().isEmpty());
    }
    @Test
    public void merchantTestInventoryHasItems() {
      Merchant merchant =  NPCFactory.makeMerchant();
        merchant.showInventory();
        Assertions.assertTrue(merchant.getInventory().getInventorySize()>0,"good");
    }
    @Test
    @DisplayName("Buy items with increased price")
    public void merchantTestInventoryChangePriseBasedOnReputationBuy() {
        Merchant merchant =  NPCFactory.makeMerchant();
        merchant.setReputation(90);
        merchant.getInventory().tradeBasedOnReputationBuy(merchant);
        merchant.showInventory();
    }
    @Test
    @DisplayName("Sell items with decreased price")
    public void merchantTestInventoryChangePriseBasedOnReputationSell() {
        Merchant merchant =  NPCFactory.makeMerchant();
        Player player = new Player(1000, 100, 100, 2,1,1);
        merchant.setReputation(90);
        player.getInventory().addItemToInventory(ItemList.fireScroll());
        player.getInventory().tradeBasedOnReputationSell(merchant,player);
        player.showInventory();
    }


}
