package fr.campus.cells;

import fr.campus.equipments.Potion;

public class PotionCell extends Cell{
    private Potion potion;
    private boolean isUsed;

    public PotionCell(Potion potion) {
        super(CaseType.POTION);
        this.potion = potion;
        this.isUsed = false;
        updateDescription();
    }

    @Override
    public String interact() {
        if (isUsed) {
            return "Cette potion a déjà été utilisée.";
        }
        return "Vous trouvez une " + potion.getName().toLowerCase() + " qui restaure " + potion.getDefenseLevel() + " points de vie !";
    }

    public Potion takePotion() {
        if (!isUsed) {
            this.isUsed = true;
            emptyCell();
            return potion;
        }
        return null;
    }

    private void updateDescription() {
        if (isUsed) {
            this.description = "Flacon de potion vide.";
        } else {
            this.description = potion.toString();
        }
    }

    // Getters
    public Potion getPotion() { return potion; }
    public String getPotionName() { return potion != null ? potion.getName() : "Aucune potion."; }
    public int getHealthPoints() { return potion != null ? potion.getDefenseLevel() : 0; }
    public boolean isUsed() { return isUsed; }

    // Setters
    public void setPotion(Potion potion) {
        this.potion = potion;
        updateDescription();
    }
}