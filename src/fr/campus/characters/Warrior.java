package fr.campus.characters;

public class Warrior extends Character {
	 private int defense;

    public Warrior(String name) {
        super(name);
		  this.health = 10;
		  this.attackPoints = 5;
    }

	 @Override
	 public void initializeEquipment() {
	 this.offensiveEquipment = new Weapon("Épée", 5);
	 this.defensiveEquipment = new Shield("Bouclier", 3);
	 }
	
	 @Override
	 public void attack() {
	 displayMessage(name + " attaque avec son épée !");
	 displayMessage("Dégâts infligés : " + getTotalAttack());
	 }
	
	 @Override
	 public void applyLevelBonus() {
	 this.health += 5;
	 this.attackPoints +=2;
	 this.defense += 1;
	 displayMessage("Bonus de montée de niveau : +5 PV, +2 attaque, +1 défense");
	 }
	
	 @Override
	 public void sufferDamage(int damage) {
	 int defenseEquipment = (defensiveEquipment != null) ? defensiveEquipment.getDefenseLevel() : 0;
	 int totalDefense = defenseEquipment + defense;
	 int realDamage = Math.max(0, damage - totalDefense);
	
	 this.health -= realDamage;
	 displayMessage(name + " bloque une partie des dégâts ! (Défense : " + totalDefense + ")");
	 displayMessage("Dégâts subis : " + realDamage + ", PV restants : " + health);
	 }
	 // Getter
	 public int getDefense() { return defense; }
	 // 
	 @Override
	 public String toString() {
	 return "Personnage : " + name + ", niveau de vie : " + health + ", attaque : " + attackPoints + ", défense : " + defense + "niveau : " + level + ", équipement : " + (offensiveEquipment != null ? offensiveEquipment.getName() : "Aucun") + (defensiveEquipment != null ? defendiveEquipment.getName() : "Aucun");
	}
}