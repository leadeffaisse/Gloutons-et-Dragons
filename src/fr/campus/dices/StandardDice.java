package fr.campus.dices;

import java.util.Random;

public class StandardDice implements Dice {
    private final int faces;
    private final Random random;

    // Constructeur
    public StandardDice(int faces) {
        if (faces < 1) {
            throw new IllegalArgumentException("Un dé doit avoir au moins 1 face.");
        }
        this.faces = faces;
        this.random = new Random();
    }

    /** Constructeur avec graine pour les tests
     * @param faces Nombre de faces du dé
     * @param seed Graine pour initialiser le générateur de nombres aléatoires
     * */
    public StandardDice(int faces, long seed) {
        if (faces < 1) {
            throw new IllegalArgumentException("Un dé doit avoir au moins 1 face.");
        }
        this.faces = faces;
        this.random = new Random(seed);
    }

    @Override
    public int roll() {
        return random.nextInt(faces) + 1;
    }

    @Override
    public int[] roll(int times) {
        if (times < 1) {
            throw new IllegalArgumentException("Le nombre de lancers doit être au moins 1.");
        }

         int[] results = new int[times];
         for (int i = 0; i < times; i++) {
             results[i] = roll();
         }
         return results;
    }

    @Override
    public int rollSum(int times) {
        if (times < 1) {
            throw new IllegalArgumentException("Le nombre de lancers doit être au moins 1.");
        }

        int sum = 0;
        for (int i = 0; i < times; i++) {
            sum += roll();
        }
        return sum;
    }

    @Override
    public int getFaces() {
        return faces;
    }

    @Override
    public int rollWithModifier(int modifier) {
        return roll() + modifier;
    }

    @Override
    public String toString() {
        return "D" + faces;
    }
}