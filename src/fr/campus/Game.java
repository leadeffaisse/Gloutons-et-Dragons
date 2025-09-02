package fr.campus;

import fr.campus.cells.Cell;
import fr.campus.cells.EnemyCell;
import fr.campus.cells.PotionCell;
import fr.campus.cells.WeaponCell;
import fr.campus.characters.Character;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import static fr.campus.Menu.displayMessage;

public class Game {
    private Character player;
    private int playerPosition;
    private final Random dice;
    private ArrayList<Cell> board;
    private final int BOARD_SIZE = 64;

    public Game() {
        this.playerPosition = 1;
        this.dice = new Random();
        this.board = new ArrayList<>();
        generateBoard();
    }

    private void generateBoard() {
        for (int i = 1; i <= BOARD_SIZE; i++) {
            Cell cell;
            if (i == 1 || i == BOARD_SIZE) {
                cell = new Cell(); // case vide par défaut
            } else {
                cell = generateCell();
            }
            board.add(cell);
        }
        displayMessage("Plateau généré avec succès!");
    }

    private Cell generateCell() {
        int randomValue = dice.nextInt(100);
        if (randomValue < 50) {
            return new Cell(); // créer une case vide
        } else if (randomValue < 75) {
            return createEnemyCell();
        } else if (randomValue < 90) {
            return createWeaponCell();
        } else {
            return createPotionCell();
        }
    }

    // ===== Méthodes de création de cases=====
    private EnemyCell createEnemyCell() {
        String[] enemyTypes = {"Gobelin", "Orc", "Squelette", "Loup", "Bandit"};
        String enemyType = enemyTypes[dice.nextInt(enemyTypes.length)];

        int healthPoints = 10 + dice.nextInt(11);
        int attack = 3 + dice.nextInt(5);
        int defense = dice.nextInt(3);

        return new EnemyCell(enemyType, healthPoints, attack, defense);
    }

    private WeaponCell createWeaponCell() {
        String[] weaponTypes = {"épée", "hâche", "marteau", "arc", "lance"};
        String weaponType = weaponTypes[dice.nextInt(weaponTypes.length)];
        int damage = 2 + dice.nextInt(6);

        return new WeaponCell(weaponType, damage);
    }

    private PotionCell createPotionCell() {
        int health = 3 + dice.nextInt(8);

        return new PotionCell(health);
    }

    // ===== Logique du jeu =====
    public void startGame(Scanner scanner) {
        if (player == null) {
            displayMessage("Aucun personnage créé. Veuillez d'abord créer un personnage.");
            return;
        }

        displayMessage("\n===== Début de l'aventure =====");
        displayMessage("Votre personnage " + player.getName() + " commence l'aventure !");
        int boardSize = 64;
        displayMessage("Position actuelle : case " + playerPosition + "/" + boardSize);

        while (playerPosition < boardSize && player.isAlive()) {
            displayMessage("\nAppuyez sur Entrée pour lancer le dé...");
            scanner.nextLine();

            playTurn();
        }
        if (playerPosition >= boardSize) {
            displayMessage("\nFélicitation ! Vous avez terminé la partie !");
        } else {
            displayMessage("\nVotre personnage est mort. Fin de la partie.");
        }
    }

    private void interactWithCell(int playerPosition) {
        Cell currentCell = board.get(playerPosition - 1);

        displayMessage("Votre personnage est sur la case " + playerPosition + " : " + currentCell.getDescription());

        displayMessage(currentCell.interact());

        switch (currentCell.getType()) {
            case EMPTY -> {}
            case ENEMY -> handleEnemyCell((EnemyCell) currentCell);
            case WEAPON -> handleWeaponCell((WeaponCell) currentCell);
            case POTION -> handlePotionCell((PotionCell) currentCell);
        }
    }

    private void handleEnemyCell(EnemyCell enemyCell) {
        while (player.isAlive() && enemyCell.isAlive()) {
            int playerDamage = player.getAttackPoints();
            displayMessage("Vous infligez " + playerDamage + " dégâts !");
            enemyCell.sufferDamage(playerDamage);

            if (enemyCell.isAlive()) {
                displayMessage(enemyCell.getEnemyType() + " : " + enemyCell.getCurrentHealthPoints() + "/" +
                        enemyCell.getMaxHealthPoints() + " PV.");

                int enemyDamage = enemyCell.attack();
                displayMessage(enemyCell.getEnemyType() + " vous attaque et inflige " + enemyDamage + " dégâtes !");
                player.sufferDamage(enemyDamage);
                displayMessage("Il vous reste " + player.getHealth() + " PV.");
            } else {
                displayMessage("Vous avez vaincu l'ennemi !");
                break;
            }
        }
    }

    private void handleWeaponCell(WeaponCell weaponCell) {
        displayMessage("Trésor trouvé!");
        displayMessage("Vous prenez " + weaponCell.getWeaponType() + " !");
        displayMessage("Cette arme inflige : " + weaponCell.getDamage() + " dégâts !");

        weaponCell.emptyCell();
    }

    private void handlePotionCell(PotionCell potionCell) {
        displayMessage("Potion découverte !");
        int oldHealth = player.getHealth();
        player.heal(potionCell.getHealthPoints());
        int newHealth = player.getHealth();

        displayMessage("Vous récupérez " + (newHealth - oldHealth) + " PV !");
        displayMessage("PV actuels : " + newHealth);

        potionCell.emptyCell();
    }

    private int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public void resetGame() {
        this.playerPosition = 1;
    }

    public void playTurn() {
        int diceRoll = rollDice();
        displayMessage("Vous avez fait un " + diceRoll + " !");
        playerPosition += diceRoll;
        if (playerPosition > BOARD_SIZE) {
            playerPosition = BOARD_SIZE;
        }
        displayMessage("Nouvelle position : case " + playerPosition);
        interactWithCell(playerPosition);
    }

    // Getters et setters
    public Character getPlayer() { return player; }
    public void setPlayer(Character player) { this.player = player; }
    public int getPlayerPosition() { return playerPosition; }
}