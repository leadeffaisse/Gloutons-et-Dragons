package fr.campus.equipments;

public class Spell extends OffensiveEquipment {
    public Spell(String name, int attackLevel) {
        super(name, attackLevel);
    }

    @Override
    public String toString() {
        return "Sort: " + name + ", Niveau d'attaque: " + attackLevel;
    }
}
