package fr.campus.characters;

import fr.campus.equipments.OffensiveEquipment;
import fr.campus.equipments.DefensiveEquipment;
import static fr.campus.Menu.displayMessage;

public abstract class Character {
    protected String name;
    protected int initialMaxHealth;
    protected int initialHealth;
    protected int initialLevel;
    protected int initialAttackPoints;
    protected int initialDefense;

    protected int maxHealth;
    protected int health;
    protected int level;
    protected int attackPoints;
    protected int defense;
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    // ===== Constructeur =====
    public Character(String name) {
        this.name = name;
        this.level = 1;
        initializeEquipment();
    }

    // ===== Méthodes abstraites =====

    public abstract void initializeEquipment();

    public abstract void attack();

    public abstract void applyLevelBonus();

    // ===== Méthodes =====
    protected void saveInitialStats() {
        this.initialMaxHealth = this.maxHealth;
        this.initialHealth = this.health;
        this.initialLevel = this.level;
        this.initialAttackPoints = this.attackPoints;
        this.initialDefense = this.defense;
    }

    public void resetStats() {
        this.maxHealth = this.initialMaxHealth;
        this.health = this.initialHealth;
        this.level = this.initialLevel;
        this.attackPoints = this.initialAttackPoints;
        this.defense = this.initialDefense;
        initializeEquipment();
    }

    public void levelUp() {
        this.level++;
        displayMessage(name + " passe au niveau " + level + " !");
        applyLevelBonus();
    }

    public void sufferDamage(int damage) {
        int equipmentDefense = (defensiveEquipment != null) ? defensiveEquipment.getDefenseLevel() : 0;
        int totalDefense = equipmentDefense + getDefense();
        int realDamage = Math.max(0, damage - totalDefense);

        this.health -= realDamage;
        if (this.health < 0) {
            this.health = 0;
        }
         displayMessage(name + " bloque une partie des dégâts ! (Défense : " + totalDefense + ")");
         displayMessage("Dégâts subis : " + realDamage + ", PV restants : " + health);
    }

    public int heal(int potion) {
        int oldHealth = health;
        int newHealth = Math.min(health + potion, maxHealth);
        int actualHealing = newHealth - oldHealth;
        this.health = newHealth;
        displayMessage(name + " utilise une potion et récupère " + potion + " PV. PV actuels : " + health);
        return actualHealing;
    }

    // ===== GETTERS ET SETTERS =====


    public int getTotalAttack() {
       int equipmentAttack = (offensiveEquipment != null) ? offensiveEquipment.getAttackLevel() : 0;
       return this.attackPoints + equipmentAttack;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    // toString
    @Override
    public String toString() {
        return "Personnage : " + name + " (Niveau " + level + ", " + health + " PV, " + getTotalAttack() + " ATQ totale.";
    }

    //Getters
    public String getName() { return name; }
    public int getMaxHealth() { return maxHealth; }
    public int getHealth() { return health; }
    public int getLevel() { return level; }
    public int getAttackPoints() { return attackPoints; }
    private int getDefense() { return this.defense; }
    public OffensiveEquipment getOffensiveEquipment() { return offensiveEquipment; }
    public DefensiveEquipment getDefensiveEquipment() { return defensiveEquipment; }

    //Setters
    public void setName(String name) { this.name = name; }
    protected void setMaxHealth(int maxHealth) {
        if (maxHealth > 0) {
            this.maxHealth = maxHealth;

            if (this.health > maxHealth) {
                this.health = maxHealth;
            }
        }
    }

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = Math.min(health, maxHealth);
        }
    }

    public void setLevel(int level) {
        if (level >= 1) this.level = level;
    }

    public void setAttackPoints(int attackPoints) {
        if (attackPoints >= 0) this.attackPoints = attackPoints;
    }

	 public void setOffensiveEquipment(OffensiveEquipment equipment) {
	 this.offensiveEquipment = equipment;
	 }
	 
	 public void setDefensiveEquipment(DefensiveEquipment equipment) {
	 this.defensiveEquipment = equipment;
	 }
	
}