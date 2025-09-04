package fr.campus.equipments.offensiveEquipments;

public class Spell extends OffensiveEquipment {
    public Spell(String name) {
        super(name);
        this.attackBonus = 1;
    }

    @Override
    public String toString() {
        return "Sort: " + name + ", Niveau d'attaque: " + attackBonus;
    }
}