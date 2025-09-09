package fr.campus.characters;

import fr.campus.equipments.defensiveEquipments.Shield;
import fr.campus.equipments.offensiveEquipments.Mace;
import fr.campus.equipments.offensiveEquipments.Weapon;

import static fr.campus.Menu.displayMessage;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
		  this.health = 10;
          this.maxHealth = 10;
		  this.attackPoints = 5;

          saveInitialStats();
    }

	 @Override
	 public void initializeEquipment() {
	 this.offensiveEquipment = new Mace("Massue");
	 this.defensiveEquipment = new Shield("Bouclier");
	 }
	
	 @Override
	 public void attack() {
	 displayMessage(super.getName() + " attaque avec son épée !");
	 displayMessage("Dégâts infligés : " + getTotalAttack());
	 }
	
	 @Override
	 public void applyLevelBonus() {
	 this.maxHealth += 5;
	 this.attackPoints +=2;
	 this.defense += 1;
	 displayMessage("Bonus de montée de niveau : +5 PV, +2 attaque, +1 défense");
	 }

	 // Getter
	 public int getDefense() { return defense; }
	 // 
	 @Override
	 public String toString() {
	 return "Personnage : " + super.getName() + ", niveau de vie : " + health + ", attaque : " + attackPoints + ", défense : " + defense + ", niveau : " + level + ", équipement : " + (offensiveEquipment != null ? offensiveEquipment.getName() : "Aucun") + " / " + (defensiveEquipment != null ? defensiveEquipment.getName() : "Aucun");
	}
}