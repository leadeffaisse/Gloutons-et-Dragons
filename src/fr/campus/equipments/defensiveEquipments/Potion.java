package fr.campus.equipments.defensiveEquipments;

public class Potion extends DefensiveEquipment {
    public Potion(String name) {
        super(name);
        this.defenseBonus = 2;
    }

    @Override
    public String toString() {
        return "Potion: " + name + ", Niveau de défense: " + defenseBonus;
    }
}