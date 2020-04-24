package main.java.simfarm.animal;

public class Goat extends Animal {
	private int size;
	private int diseaseResistance;
	private int breedability;
	private int aggression;
	
	public Goat(int size, int diseaseResistance, int breedability, int aggression) {
		this.size = size;
		this.diseaseResistance = diseaseResistance;
		this.breedability = breedability;
		this.aggression = aggression;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getDiseaseResistance() {
		return diseaseResistance;
	}

	@Override
	public int getBreedability() {
		return breedability;
	}

	@Override
	public int getAggression() {
		return aggression;
	}

}
