package fr.campus.cells;

import fr.campus.equipments.offensiveEquipments.Weapon;

public class WeaponCell extends Cell {
    private Weapon weapon;
    private boolean isTaken;

    public WeaponCell(Weapon weapon) {
        super(CaseType.WEAPON);
        this.weapon = weapon;
        this.isTaken = false;
        updateDescription();
    }

    @Override
    public String interact() {
        if (isTaken) {
            return "Ce trésor a déjà été pris.";
        }
        return "Trésor trouvé! Vous ramassez un(e)" + weapon.getName().toLowerCase() + " qui inflige " + weapon.getAttackBonus() + " points de dégâts !";
    }

    public Weapon takeWeapon() {
        if (!isTaken) {
            this.isTaken = true;
            emptyCell();
            return weapon;
        }
        return null;
    }

    private void updateDescription() {
        if (isTaken) {
            this.description = "Emplacement d'arme vide.";
        } else {
            this.description = weapon.toString();
        }
    }

    // Getters
    public Weapon getWeapon() { return weapon; }
    public String getWeaponName() { return weapon != null ? weapon.getName() : "Aucune arme"; }
    public int getDamage() { return weapon != null ? weapon.getAttackBonus() : 0; }
    public boolean isTaken() { return isTaken; }

    // Setters
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        updateDescription();
    }
}
