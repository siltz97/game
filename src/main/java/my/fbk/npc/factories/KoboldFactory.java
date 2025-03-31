package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Kobold;

import java.util.Random;

public class KoboldFactory {

    private static Random rand = new Random();

    public static Kobold makeWarior() {
        return new Kobold(75, 100, 0, 80, rand.nextInt(100)+20);
    }

    public static Kobold makeMage() {
        return new Kobold(75, 80, 100, 5, rand.nextInt(100)+20);
    }

    public static Kobold makeBoss() {
        return new Kobold(200, 150, 100, 100, rand.nextInt(300)+50);
    }

    public static Kobold random() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeWarior();
        else
            return makeMage();
    }
}
