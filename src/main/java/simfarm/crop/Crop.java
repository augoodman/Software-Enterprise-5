package main.java.simfarm.crop;

public abstract class Crop {
    // getters for crop type, size and disease resistance
    public abstract int getDiseaseResistance();

    public abstract int getNumCrops();

    public abstract int getAge();

    public abstract String getType();

    public abstract void cropExchanged(String boughtOrSold);

    public abstract void incrementAge();

    public abstract void resetAge();

    public abstract boolean isDiseased();

    public abstract int daysDiseased();

    public abstract void incrementDaysDiseased();

    public abstract void diseased();

    public abstract void healed();

    @Override
    public String toString() {
        return "Disease Resistance = " + this.getDiseaseResistance();
    }
}
