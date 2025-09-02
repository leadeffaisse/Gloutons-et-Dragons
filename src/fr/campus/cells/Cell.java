package fr.campus.cells;

public class Cell {
    protected CaseType type;
    protected boolean isOccupied;
    protected String description;

    public Cell() {
        this.type = CaseType.EMPTY;
        this.isOccupied = false;
        this.description = "Case vide";
    }
    public Cell(CaseType type) {
        this.type = type;
        this.isOccupied = (type != CaseType.EMPTY);
        this.description = generateDescription(type);
    }

    // Getters et Setters
    public CaseType getType() {
        return type;
    }
    public void setType(CaseType type) {
        this.type = type;
        this.isOccupied = (type != CaseType.EMPTY);
        if (description.equals("Case vide") || description.isEmpty()) {
            this.description = generateDescription(type);
        }
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Méthodes utiles
    private String generateDescription(CaseType type) {
        return switch (type) {
            case EMPTY ->  "Case vide";
            case ENEMY ->  "Ennemi présent";
            case WEAPON -> "Arme disponible";
            case POTION -> "Potion de soin";
        };
    }

    public void emptyCell() {
        this.type = CaseType.EMPTY;
        this.isOccupied = false;
        this.description = "Case vide";
    }

    public String interact() {
        return "Aucune interaction possible avec cette case.";
    }

    @Override
    public String toString() {
        return switch(type) {
            case EMPTY -> "[]";
            case ENEMY -> "[E]";
            case WEAPON ->  "[W]";
            case POTION -> "[P]";
        };
    }
}
