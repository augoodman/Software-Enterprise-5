package main.java.simfarm.animal;

public abstract class Animal {

	//getters for animal type, size, disease resistance, breedability and aggression
	public abstract int getSize();
	public abstract int getDiseaseResistance();
	public abstract int getBreedability();
	public abstract int getAggression();

    @Override
    public String toString(){
        return "Size = " + this.getSize() + ", Disease Resistance = " + this.getDiseaseResistance() + ", Breedability = " + this.getBreedability() + ", Aggression = " + this.getAggression();
    }
}
