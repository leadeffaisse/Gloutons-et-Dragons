package fr.campus;

import java.util.Scanner;
import java.util.InputMismatchException;
import fr.campus.characters.Character;

public class Menu {
    private final Scanner clavier;
    private Character currentCharacter;
    private Game game;

    // Constructeur
    public Menu() {
        this.clavier = new Scanner(System.in);
        this.game = new Game();
    }

    public void start() {
        displayMenu();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            displayMessage("\n+======================+");
            displayMessage("|  Gloutons et Dragons   |");
            displayMessage("+========================+");
            displayMessage("| 1. Créer personnage    |");
            displayMessage("| 2. Commencer aventure  |");
            displayMessage("| 3. Afficher personnage |");
            displayMessage("| 4. Quitter             |");
            displayMessage("+========================+");

            int choice = secureChoiceEntry(1, 4);

            switch (choice) {
                case 1:
                    currentCharacter = createCharacter();
                    game = new Game(currentCharacter);
                    break;
                case 2:
                    if (currentCharacter != null) {
                        try {
                            game.startGame(clavier);
                            if (askRestartGame()) {
                                game.resetGame();
                            }
                        }catch (Exception e) {
                            displayMessage("Erreur pendant le jeu : " + e.getMessage());
                        }
                    } else {
                        displayMessage("Veuillez d'abord créer un personnage !");
                    }
                    break;
                case 3:
                    if (currentCharacter != null) {
                        displayMessage("\n Informations du personnage");
                        displayMessage(currentCharacter.toString());
                    } else {
                        displayMessage("Aucun personnage créé.");
                    }
                    break;
                case 4:
                    if (confirmExit()) {
                        exit = true;
                    };
                    break;
            }
        }
    }

    private Character createCharacter() {
        String name = "";
        String classType = "";

        displayMessage("\n+===== Création du personnage =====+");
        while (name.trim().isEmpty()) {
            displayMessage("Nom de votre personnage : ");
            name = clavier.nextLine();
            if (name.trim().isEmpty()) {
                displayMessage("Le nom ne peut pas être vide !");
            }
        }

        displayMessage("Veuillez choisir l'un des classes suivantes : ");
        displayMessage("1. Guerrier");
        displayMessage("2. Mage");

        int choice = secureChoiceEntry(1, 2);

        classType = switch (choice) {
            case 1 -> "Warrior";
            case 2 -> "Wizard";
            default -> classType;
        };

        Character character = new Character(name, classType);

        displayMessage("\n Personnage créé avec succès !");
        displayMessage(character.toString());

        return character;
    }

    private boolean askRestartGame() {
        String response = "";
        boolean validInput = false;

        while (!validInput) {
            displayMessage("Voulez-vous recommencer une partie ? (o/n) : ");
            response = clavier.nextLine().trim().toLowerCase();

            if (!response.isEmpty() && (response.equals("o") || response.equals("oui") || response.equals("n") || response.equals("non"))) {
                validInput = true;
            } else {
                displayMessage("Veuillez répondre par 'o'/'oui' ou 'n'/'non' :");
            }
        }
        return response.equals("o") || response.equals("oui");
    }

    private int secureChoiceEntry(int min, int max) {
        int choice = -1;
        boolean valideEntry = false;

        while (!valideEntry) {
            System.out.print("Votre choix (" + min + "-" + max + "): ");
            try {
                choice = clavier.nextInt(); // méthode
                clavier.nextLine();

                if (choice >= min && choice <= max) {
                    valideEntry = true;
                } else {
                    displayMessage("Veuillez choisir entre " + min + " et " + max + " !");
                }
            } catch (InputMismatchException e) {
                displayMessage("Veuillez entrer un nombre valide !");
                clavier.nextLine();
            }
        }
        return choice;
    }

    private boolean confirmExit() {
        System.out.print("Êtes-vous sûr(e) de vouloir quitter ? (o/n) : ");
        String response = clavier.nextLine().toLowerCase();

        if (response.equals("o") || response.equals("oui")) {
            displayMessage("Merci d'avoir joué ! À bientôt !");
            return true;
        }
        return false;
    }
}