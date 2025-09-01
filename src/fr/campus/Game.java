package fr.campus;

import fr.campus.characters.Character;
import java.util.Random;
import java.util.Scanner;

import static fr.campus.Menu.displayMessage;

public class Game {
    private Character player;
    private int currentPosition;
    private final Random dice;

    public Game() {
        this.currentPosition = 1;
        this.dice = new Random();
    }

    public void startGame(Scanner scanner) {
        if (player == null) {
            displayMessage("Aucun personnage créé. Veuillez d'abord créer un personnage.");
            return;
        }

        displayMessage("\n===== Début de l'aventure =====");
        displayMessage("Votre personnage " + player.getName() + " commence l'aventure !");
        int boardSize = 64;
        displayMessage("Position actuelle : case " + currentPosition + "/" + boardSize);

        while (currentPosition < boardSize && player.isAlive()) {
            displayMessage("\nAppuyez sur Entrée pour lancer le dé...");
            scanner.nextLine();

            int diceRoll = rollDice();
            displayMessage("Vous avez fait un " + diceRoll + " !");

            currentPosition += diceRoll;
            if (currentPosition > boardSize) {
                currentPosition = boardSize;
            }

            displayMessage("Nouvelle position : case " + currentPosition + "/" + boardSize);
        }
        if (currentPosition >= boardSize) {
            displayMessage("\nFélicitation ! Vous avez terminé la partie !");
        } else {
            displayMessage("\nVotre personnage est mort. Fin de la partie.");
        }
    }

    private int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public void resetGame() {
        this.currentPosition = 1;
    }

    // Getters et setters
    public Character getPlayer() { return player; }
    public void setPlayer(Character player) { this.player = player; }
    public int getCurrentPosition() { return currentPosition; }
}