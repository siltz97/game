package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Skeleton;

import java.util.Random;

public class SkeletonFactory {

    private static Random rand = new Random();

    public static Skeleton makeWarior() {
        return new Skeleton(75, 100, 0, 80, rand.nextInt(100)+20);
    }

    public static Skeleton makeMage() {
        return new Skeleton(75, 80, 100, 5, rand.nextInt(100)+20);
    }

    public static Skeleton makeBoss() {
        return new Skeleton(200, 150, 100, 100, rand.nextInt(300)+50);
    }

    public static Skeleton random() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeWarior();
        else
            return makeMage();
    }
}
