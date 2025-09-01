package fr.campus.characters;


import fr.campus.equipments.Potion;
import fr.campus.equipments.Spell;

import static fr.campus.Menu.displayMessage;

public class Wizard extends Character {

	 // ===== Constructeur =====
    public Wizard(String name) {
        super(name);
		  this.health = 6;
		  this.attackPoints = 5;
    }

	 @Override
	 public void initializeEquipment() {
	 this.offensiveEquipment = new Spell("Baguette", 8);
	 this.defensiveEquipment = new Potion("Potion", 2);
	 }
	
	 @Override
	 public void attack() {
	 displayMessage(name + " lance un sort d'attaque !");
	 displayMessage("Dégâts infligés : " + getTotalAttack());
	 }
	
	 @Override
	 public void applyLevelBonus() {
	 this.health += 3;
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