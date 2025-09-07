package fr.campus.equipments.defensiveEquipments;

public class StandardPotion extends Potion {
    public StandardPotion(String name) {
        super(name);
        this.defenseBonus = 2;
    }

    @Override
    public String toString() {
        return "Potion standard: " + name + ", Niveau de défense: " + defenseBonus;
    }
}