package fr.campus.equipments;

public class OffensiveEquipment {
    protected String name;
    protected int attackLevel;

    // Constructeur, getters, setters, toString
    public OffensiveEquipment(String name, int attackLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
    }

    public String getName() {
        return name;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setAttackLevel() {
        if (attackLevel >= 0) {
            this.attackLevel = attackLevel;
        }
    }
}
