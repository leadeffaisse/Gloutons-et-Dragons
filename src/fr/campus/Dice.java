package fr.campus;

public class Dice {
    private int maxNumber;

    public Dice (int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getMaxNumber() { return maxNumber; }
    public void setMaxNumber(int maxNumber) { this.maxNumber = maxNumber; }
}