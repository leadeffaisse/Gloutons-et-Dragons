package fr.campus.equipments.offensiveEquipments;

public class Mace extends Weapon {
    public Mace(String name) {
        super(name);
        this.attackBonus = 3;
    }

    @Override
    public String toString() {
        return "Masse : " + name + ", Bonus d'attaque : " + attackBonus;
    }
}