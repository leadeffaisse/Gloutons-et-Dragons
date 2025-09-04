package fr.campus.equipments.offensiveEquipments;

public class OffensiveEquipment {
    protected String name;
    protected int attackBonus;

    // Constructeur, getters, setters, toString
    public OffensiveEquipment(String name, int attackBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
    }

    public OffensiveEquipment(String name) {
        this.name = name;
        this.attackBonus = 1; // Default attack bonus for generic offensive equipment
    }

    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setAttackBonus(int attackBonus) {
        if (attackBonus >= 0) {
            this.attackBonus = attackBonus;
        }
    }
}
