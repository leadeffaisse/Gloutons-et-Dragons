package fr.campus.cells;

public class PotionCell extends Cell{
    private int healthPoints;
    private String potionType;
    private String effect;

    public PotionCell(int healthPoints) {
        this(healthPoints, "Potion de soin", "Restaure les points de vie");
    }

    public PotionCell(int healthPoints, String potionType, String effect) {
        super(CaseType.POTION);
        this.healthPoints = healthPoints;
        this.potionType = potionType;
        this.effect = effect;
        this.description = potionType + ": " + " (+" + healthPoints + " PV) - " + effect;
    }

    // Getters
    public int getHealthPoints() {
        return healthPoints;
    }

    public String getWeaponType() {
        return potionType;
    }

    public String getEffect() {
        return effect;
    }

    // Setters
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
        updateDescription();
    }

    public void setPotionType(String potionType) {
        this.potionType = potionType;
        updateDescription();
    }

    public void setEffect(String effect) {
        this.effect = effect;
        updateDescription();
    }

    private void updateDescription() {
        this.description = potionType + ": " +  " (+" + healthPoints + " dégâts).";
    }

    @Override
    public String interact() {
        return "Vous buvez la " + potionType.toLowerCase() + " et récupérez " + healthPoints + " points de vie !";
    }
}
