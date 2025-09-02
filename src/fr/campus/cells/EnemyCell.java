package fr.campus.cells;

public class EnemyCell extends Cell{
    private String enemyType;
    private int maxHealthPoints;
    private int currentHealthPoints;
    private int attack;
    private int defense;
    private boolean isAlive;

    public EnemyCell (String enemyType, int maxHealthPoints, int attack) {
        this("Ennemi", maxHealthPoints, attack, 0);
    }

    public EnemyCell(String enemyType, int maxHealthPoints, int attack, int defense) {
        super(CaseType.ENEMY);
        this.enemyType = enemyType;
        this.maxHealthPoints = maxHealthPoints;
        this.currentHealthPoints = maxHealthPoints;
        this.attack = attack;
        this.defense = defense;
        this.isAlive = true;
        updateDescription();
    }

    // Getters
    public String getEnemyType() {
        return enemyType;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isAlive() {
        return isAlive;
    }

    // Setters
    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
        updateDescription();
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
        updateDescription();
    }

    public void setAttack(int attack) {
        this.attack = attack;
        updateDescription();
    }

    public void setDefense(int defense) {
        this.defense = defense;
        updateDescription();
    }

    // Méthodes
    public void sufferDamage(int damage) {
        int reelDamage = Math.max(0, damage - defense);
        currentHealthPoints -= reelDamage;

        if (currentHealthPoints <= 0) {
            isAlive = false;
            isOccupied = false;
        }
        updateDescription();
    }

    public int attack() {
        if (!isAlive) return 0;
        return attack;
    }

    private void updateDescription() {
        if (isAlive) {
            this.description = enemyType + ": " + currentHealthPoints + "/" + maxHealthPoints + " PV, " + attack + " ATK, " + defense + " DEF.";
        } else {
            this.description = enemyType + " est mort.";
        }
    }

    @Override
    public String interact() {
        if (!isAlive) {
            return enemyType + " est mort.";
        }
        return "Vous rencontrez " + enemyType + " ! Préparez-vous au combat !";
    }
}
