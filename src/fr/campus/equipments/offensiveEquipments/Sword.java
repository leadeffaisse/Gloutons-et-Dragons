package fr.campus.equipments.offensiveEquipments;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name);
        this.attackBonus = 5;
    }

    @Override
    public String toString() {
        return "Épée : " + name + ", Bonus d'attaque : " + attackBonus;
    }
}
