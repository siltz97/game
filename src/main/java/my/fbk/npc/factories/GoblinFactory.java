package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Goblin;

import java.util.Random;

/* Produces goblins. */
public class GoblinFactory {

    private static Random rand = new Random();

    public static Goblin makeWarior() {
        return new Goblin(75, 100, 0, 80, 11);
    }

    public static Goblin makeMage() {
        return new Goblin(75, 80, 100, 5, 11);
    }

    public static Goblin makeBoss() {
        return new Goblin(200, 150, 100, 100, 11);
    }

    public static Goblin random() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeWarior();
        else
            return makeMage();
    }

}
