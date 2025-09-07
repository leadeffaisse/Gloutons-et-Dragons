package fr.campus.characters;


import fr.campus.equipments.defensiveEquipments.Potion;
import fr.campus.equipments.offensiveEquipments.Spell;

import static fr.campus.Menu.displayMessage;

public class Wizard extends Character {

	 // ===== Constructeur =====
    public Wizard(String name) {
        super(name);
		  this.health = 6;
          this.maxHealth = 6;
		  this.attackPoints = 5;

          saveInitialStats();
    }

	 @Override
	 public void initializeEquipment() {
	 this.offensiveEquipment = new Spell("Baguette");
	 this.defensiveEquipment = new Potion("Potion");
	 }
	
	 @Override
	 public void attack() {
	 displayMessage(name + " lance un sort d'attaque !");
	 displayMessage("Dégâts infligés : " + getTotalAttack());
	 }
	
	 @Override
	 public void applyLevelBonus() {
	 this.maxHealth += 3;
	 this.attackPoints +=4;
	 this.defense += 1;
	 displayMessage("Bonus de montée de niveau : +3 PV, +4 attaque, +1 défense");
	 }

	 // Getter
	 public int getDefense() { return defense; }
	 // 
	 @Override
	 public String toString() {
	 return "Personnage : " + name + ", niveau de vie : " + health + ", attaque : " + attackPoints + ", défense : " + defense + "niveau : " + level + ", équipement : " + (offensiveEquipment != null ? offensiveEquipment.getName() : "Aucun") + (defensiveEquipment != null ? defensiveEquipment.getName() : "Aucun");
	}
}