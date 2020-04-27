package main.java.simfarm.crop;

public class Corn extends Crop {
	private int size;
	private int diseaseResistance;
	private int numCrops;
	private int age;
	private String type = "Corn";

	public Corn(int size, int diseaseResistance) {
		this.size = size;
		this.diseaseResistance = diseaseResistance;
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
	public String getType() {
		return type;
	}	

	@Override
	public int getNumCrops() {
		return numCrops;
	}

	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public void cropExchanged(String boughtOrSold) {
		if(boughtOrSold.equalsIgnoreCase("bought")) {
			this.numCrops++;
		}
		else {
			this.numCrops--;
		}
	}

	@Override
	public void incrementAge() {
		this.age++;
	}

	@Override
	public void resetAge() {
		this.age = 0;
	}
	
}