package fr.campus.characters;

public class Character {
    private String name;
    private int health;
    private int level;
    private String classType;
    private int attackPoints;

    // Constructeur
    public Character(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.level = 1;

        if (classType.equals("Warrior")) {
            this.health = 10;
            this.attackPoints = 5;

        } else if (classType.equals("Wizard")) {
            this.health = 6;
            this.attackPoints = 8;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Personnage{nom='" + name + "', PV=" + health + ", niveau=" + level + ", classe=" + classType + ", points d'attaque=" + attackPoints + "}";
    }

    //Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getLevel() { return level; }
    public String getClassType() { return classType; }
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

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setAttackPoints(int attackPoints) {
        if (attackPoints >= 0) {
            this.attackPoints = attackPoints;
        }
    }
}