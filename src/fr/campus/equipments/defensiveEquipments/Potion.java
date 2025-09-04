package fr.campus.equipments.defensiveEquipments;

public class Potion extends DefensiveEquipment {
    public Potion(String name, int defenseLevel) {
        super(name, defenseLevel);
    }

    @Override
    public String toString() {
        return "Potion: " + name + ", Niveau de défense: " + defenseLevel;
    }
}
