//package my.fbk.npc.factories;
//
//import my.fbk.npc.Enemy.Kobold;
//import my.fbk.npc.inventory.Inventory;
//import my.fbk.npc.inventory.ItemList;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class KoboldFactory {
//
//    static List<ItemList> list = new ArrayList<>();
//
//    private static final Random rand = new Random();
//
//    public static Kobold makeKoboldWarrior() {
//        Kobold koboldWarrior = new Kobold(75, 100, 0, 80, rand.nextInt(100)+20);
//        koboldWarrior.setInventory(createInventory());
//        return koboldWarrior;
//    }
//
//    public static Kobold makeKoboldMage() {
//        Kobold koboldMage = new Kobold(75, 80, 100, 5, rand.nextInt(100)+20);
//        koboldMage.setInventory(createInventory());
//        return koboldMage;
//    }
//
//    public static Kobold makeKoboldBoss() {
//        Kobold koboldBoss = new Kobold(200, 150, 100, 100, rand.nextInt(300)+50);
//        koboldBoss.setInventory(createInventory());
//        return koboldBoss;
//    }
//
//    public static Kobold makeRandomEnemy() {
//        int r = rand.nextInt(2);
//        if (r == 0)
//            return makeKoboldWarrior();
//        else
//            return makeKoboldMage();
//    }
//
//    public static Inventory createInventory() {
//        ItemList[] itemArray = ItemList.values();
//        for (int i = 0; i < 2; i++) {
//            list.add(itemArray[rand.nextInt(itemArray.length)]);
//
//        }
//        return (Inventory) list;
//    }
//}
