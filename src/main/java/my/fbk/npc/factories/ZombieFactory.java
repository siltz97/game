package my.fbk.npc.factories;

import my.fbk.npc.Enemy.Zombie;

import java.util.Random;

public class ZombieFactory {

    private static Random rand = new Random();

    public static Zombie makeWarrior() {
        return new Zombie(75, 100, 0, 80, rand.nextInt(100)+20);
    }

    public static Zombie makeMage() {
        return new Zombie(75, 80, 100, 5, rand.nextInt(100)+20);
    }

    public static Zombie makeBoss() {
        return new Zombie(200, 150, 100, 100, rand.nextInt(300)+50);
    }

    public static Zombie random() {
        int r = rand.nextInt(2);
        if (r == 0)
            return makeWarrior();
        else
            return makeMage();
    }
}
