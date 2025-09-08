package fr.campus.dices;

public interface Dice {

    //Constantes pour les différents types de dés
    int D4 = 4;
    int D6 = 6;
    int D8 = 8;
    int D10 = 10;
    int D12 = 12;
    int D20 = 20;
    int D100 = 100;

    // Méthodes pour lancer les dés
    /**
     * Lance le dé une fois et retourne le résultat.
     * @return le résultat du lancer de dé
     */
    int roll();

    /**
     * Lance le dé un nombre spécifié de fois et retourne les résultats dans un tableau.
     * @param times le nombre de fois à lancer le dé
     * @return un tableau contenant les résultats des lancers de dé
     */
    int[] roll(int times);

    /**
     * Lance le dé un nombre spécifié de fois et retourne la somme des résultats.
     * @param times le nombre de fois à lancer le dé
     * @return la somme des résultats des lancers de dé
     */
    int rollSum(int times);

    /**
     * Retourne le nombre de faces du dé.
     * @return le nombre de faces du dé
     */
    int getFaces();

    /**
     * Lance le dé et ajoute un modificateur au résultat.
     * @param modifier le modificateur à ajouter au résultat du lancer de dé
     * @return le résultat du lancer de dé avec le modificateur appliqué
     */
    int rollWithModifier(int modifier);

    /**
     * Lance le dé avec avantage (lance deux fois et prend le meilleur résultat).
     * @return le meilleur résultat des deux lancers de dé
     */
    default int rollWithAdvantage() {
        int firstRoll = roll();
        int secondRoll = roll();
        return Math.max(firstRoll, secondRoll);
    }

    /**
     * Lance le dé avec désavantage (lance deux fois et prend le pire résultat).
     * @return le pire résultat des deux lancers de dé
     */
    default int rollWithDisadvantage() {
        int firstRoll = roll();
        int secondRoll = roll();
        return Math.min(firstRoll, secondRoll);
    }
}
