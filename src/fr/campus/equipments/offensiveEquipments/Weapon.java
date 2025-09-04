package fr.campus.equipments.offensiveEquipments;

public class Weapon extends OffensiveEquipment {
    public Weapon(String name, int attackBonus) {
        super(name, attackBonus);
    }

    public Weapon(String name) {
        super(name);
        this.attackBonus = 1; // Default attack bonus for generic weapons) {
    }

    @Override
    public String toString() {
        return "Arme: " + name + ", Bonus d'attaque: " + attackBonus;
    }
}