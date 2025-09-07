package fr.campus.equipments.defensiveEquipments;

public class Shield extends DefensiveEquipment {
    public Shield(String name, int defenseLevel) {
        super(name);
    }

    @Override
    public String toString() {
        return "Bouclier: " + name + ", Niveau de défense: " + defenseBonus;
    }

}
