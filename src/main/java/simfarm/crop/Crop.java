package main.java.simfarm.crop;

public abstract class Crop {
	//getters for crop type, size and disease resistance
	public abstract int getSize();
	public abstract int getDiseaseResistance();
	public abstract int getNumCrops();
	public abstract String getType();
	public abstract void cropExchanged(String boughtOrSold);

    @Override
    public String toString(){
        return "Size = " + this.getSize() + ", Disease Resistance = " + this.getDiseaseResistance();
    }
}
