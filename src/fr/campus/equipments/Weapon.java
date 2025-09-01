package fr.campus.equipments;

public class Weapon extends OffensiveEquipment {
    public Weapon(String name, int attackLevel) {
        super(name, attackLevel);
    }

    @Override
    public String toString() {
        return "Arme: " + name + ", Niveau d'attaque: " + attackLevel;
    }
}