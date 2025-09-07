package fr.campus.equipments.defensiveEquipments;

public class GreatPotion extends Potion {
    public GreatPotion(String name) {
        super(name);
        this.defenseBonus = 5;
    }

    @Override
    public String toString() {
        return "Grande potion: " + name + ", Niveau de défense: " + defenseBonus;
    }
}