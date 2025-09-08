package fr.campus.dices;

public class DiceFactory {

    // Constructeur privé pour empêcher l'instanciation
    private DiceFactory() {
        throw new UnsupportedOperationException("Classe utilitaire non instanciable");
    }

    // Méthodes statiques de création de dés standard
    public static Dice d4() { return new StandardDice(Dice.D4); }
    public static Dice d6() { return new StandardDice(Dice.D6); }
    public static Dice d8() { return new StandardDice(Dice.D8); }
    public static Dice d10() { return new StandardDice(Dice.D10); }
    public static Dice d12() { return new StandardDice(Dice.D12); }
    public static Dice d20() { return new StandardDice(Dice.D20); }
    public static Dice d100() { return new StandardDice(Dice.D100); }

    // Méthodes statiques de création de dés personnalisés
    public static Dice custom(int faces) { return new StandardDice(faces); }
    public static Dice seeded(int faces, long seed) { return new StandardDice(faces, seed); }
}