package fr.campus.equipments;

public class DefensiveEquipment { // Shield ou Potion
    protected String name;
    protected int defenseLevel;

    // Constructeurs, getters, setters, toString
    public DefensiveEquipment(String name, int defenseLevel) {
        this.name = name;
        this.defenseLevel = defenseLevel;
    }

    public String getName() {
        return name;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setDefenseLevel(int defenseLevel) {
        if (defenseLevel >= 0) {
            this.defenseLevel = defenseLevel;
        }
    }
}
