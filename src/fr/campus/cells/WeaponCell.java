package fr.campus.cells;

public class WeaponCell extends Cell {
    private int damage;
    private String weaponType;

    public WeaponCell(String weaponType, int damage) {
        super(CaseType.WEAPON);
        this.damage = damage;
        this.weaponType = weaponType;
        this.description = weaponType + ": " + damage + " dégâts).";
    }

    // Getters
    public int getDamage() {
        return damage;
    }

    public String getWeaponType() {
        return weaponType;
    }

    // Setters
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
        updateDescription();
    }

    private void updateDescription() {
        this.description = weaponType + ": " + damage + " dégâts).";
    }

    @Override
    public String interact() {
        return "Vous ramassez un(e)" + weaponType + " qui inflige " + damage + " points de dégâts !";
    }
}
