package main.java.simfarm.animal;

public class Cow extends Animal {
	private int size;
	private int diseaseResistance;
	private int breedability;
	private int aggression;
	private int numAnimals;
	private String type = "Cow";
	private String gender;

	public Cow(int size, int diseaseResistance, int breedability, int aggression) {
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

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void animalExchanged(String boughtOrSold) {
		if(boughtOrSold.equalsIgnoreCase("bought")) {
			this.numAnimals++;
		}
		else {
			this.numAnimals--;
		}
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

}
