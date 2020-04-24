package main.java.simfarm.crop;

public abstract class Crop {
	//getters for crop type, size and disease resistance
	public abstract int getSize();
	public abstract int getDiseaseResistance();
	
    @Override
    public String toString(){
        return "Size = " + this.getSize() + ", Disease Resistance = " + this.getDiseaseResistance();
    }
}
