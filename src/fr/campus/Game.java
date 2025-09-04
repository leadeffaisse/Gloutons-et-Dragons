package fr.campus;

import fr.campus.cells.Cell;
import fr.campus.cells.EnemyCell;
import fr.campus.cells.PotionCell;
import fr.campus.cells.WeaponCell;
import fr.campus.characters.Character;
import fr.campus.equipments.Potion;
import fr.campus.equipments.Weapon;

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
        String[] weaponNames = {"épée", "hâche", "marteau", "arc", "lance"};
        String weaponName = weaponNames[dice.nextInt(weaponNames.length)];
        int damage = 2 + dice.nextInt(6);

        Weapon weapon = new Weapon(weaponName, damage);

        return new WeaponCell(weapon);
    }

    private PotionCell createPotionCell() {
        String[] potionNames = {"Potion de soin", "Elixir de vie", "Philtre de régénération", "Potion magique", "Remède naturel"};
        String potionName = potionNames[dice.nextInt(potionNames.length)];
        int healing = 3 + dice.nextInt(8);

        Potion potion = new Potion(potionName, healing);

        return new PotionCell(potion);
    }

    // ===== Logique du jeu =====
    public void startGame(Scanner scanner) {
        if (player == null) {
            displayMessage("Aucun personnage créé. Veuillez d'abord créer un personnage.");
            return;
        }

        displayMessage("\n===== Début de l'aventure =====");
        displayMessage("Votre personnage " + player.getName() + " commence l'aventure !");
        displayMessage("Position actuelle : case " + playerPosition + "/" + BOARD_SIZE);

        while (playerPosition < BOARD_SIZE && player.isAlive()) {
            displayMessage("\nAppuyez sur Entrée pour lancer le dé...");
            scanner.nextLine();

            playTurn();
        }

        if (playerPosition >= BOARD_SIZE) {
            displayMessage("\nFélicitation ! Vous avez terminé la partie !");
        } else {
            displayMessage("\nVotre personnage est mort. Fin de la partie.");
        }
    }

    // Le joueur joue son tour
    public void playTurn() {
        int diceRoll = rollDice();
        displayMessage("Vous avez fait un " + diceRoll + " !");
        playerPosition += diceRoll;

        if (playerPosition > BOARD_SIZE) {
            playerPosition = BOARD_SIZE;
        }

        displayMessage(player.getName() + " se déplace à la case " + playerPosition);
        interactWithCell(playerPosition);
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
                displayMessage(enemyCell.getEnemyType() + " vous attaque et inflige " + enemyDamage + " dégâts !");
                player.sufferDamage(enemyDamage);
            } else {
                displayMessage("Vous avez vaincu l'ennemi !");
                break;
            }
        }
    }

    private void handleWeaponCell(WeaponCell weaponCell) {
        displayMessage("Vous équipez cette nouvelle arme.");
        Weapon weapon = weaponCell.takeWeapon();
        player.setOffensiveEquipment(weapon);
    }

    private void handlePotionCell(PotionCell potionCell) {
        Potion potion = potionCell.takePotion();
        displayMessage("Vous utilisez la potion.");
        if (potion != null) {
            int healing = player.heal(potionCell.getHealthPoints());
            displayMessage("Vous récupérez " + healing + " PV !");
            displayMessage("PV actuels : " + player.getHealth() + "/" + player.getMaxHealth());
        }
    }

    private int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public void resetGame() {
        this.playerPosition = 1;
    }



    // Getters et setters
    public Character getPlayer() { return player; }
    public void setPlayer(Character player) { this.player = player; }
    public int getPlayerPosition() { return playerPosition; }
}