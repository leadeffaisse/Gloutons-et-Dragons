package fr.campus.characters;

import fr.campus.equipments.OffensiveEquipment;
import fr.campus.equipments.DefensiveEquipment;
import fr.campus.equipments.Weapon;
import fr.campus.equipments.Spell;
import fr.campus.equipments.Shield;
import fr.campus.equipments.Potion;
import fr.campus.Menu;

import static fr.campus.Menu.displayMessage;

public abstract class Character {
    protected String name;
    protected int health;
    protected int level;
    protected int attackPoints;
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment

    // Constructeur
    public Character(String name) {
        this.name = name;
        this.level = 1;
        initializeEquipment();
    }

    public abstract void initializeEquipment();

    public abstract void attack();

    public abstract void applyLevelBonus();

    public void levelUp() {
        this.level++;
        displayMessage(name + " passe au niveau " + level + " !");
        applyLevelBonus();
    }

    /**public void sufferDamage(int damage) {
        int defense = (DefensiveEquipment != null) ? DefensiveEquipment.getDefenseLevel() : 0;
        int realDamage = Math.max(0, damage - defense);

        this.health -= realDamage;
        if (health < 0) {
            this.health = 0;
        }
        displayMessage(name + " subit " + realDamage + " dégats ! PV restants: " + health);
    }*/

    public int getTotalAttack() {
       //int equipmentAttack = (offensiveEquipment != null) ? offensiveEquipment.getAttackLevel() : 0;
        // return this.attackPoints + equipmentAttack;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    // ===== GETTERS ET SETTERS =====

    // toString
    @Override
    public String toString() {
        return "Personnage : " + name + " (Niveau " + level + ", " + health + " PV, " + getTotalAttack() + " ATQ totale";
    }

    //Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getLevel() { return level; }
    public int getAttackPoints() { return attackPoints; }

    //Setters
    public void setName(String name) { this.name = name; }

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        }
    }

    public void setLevel(int level) {
        if (level >= 0) {
            this.level = level;
        }
    }

    public void setAttackPoints(int attackPoints) {
        if (attackPoints >= 0) {
            this.attackPoints = attackPoints;
        }
    }
}