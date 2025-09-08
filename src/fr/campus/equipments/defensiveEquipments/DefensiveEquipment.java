package fr.campus.equipments.defensiveEquipments;

public class DefensiveEquipment { // Shield ou Potion
    protected String name;
    protected int defenseBonus;

    // Constructeurs
    public DefensiveEquipment(String name) {
        this.name = name;
        this.defenseBonus = 3; // Valeur par défaut
    }

    public String getName() {
        return name;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setDefenseBonus(int defenseBonus) {
        if (defenseBonus >= 0) {
            this.defenseBonus = defenseBonus;
        }
    }
}
