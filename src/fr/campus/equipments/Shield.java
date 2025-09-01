package fr.campus.equipments;

public class Shield extends DefensiveEquipment {
    public Shield(String name, int defenseLevel) {
        super(name, defenseLevel);
    }

    @Override
    public String toString() {
        return "Bouclier: " + name + ", Niveau de défense: " + defenseLevel;
    }

}
