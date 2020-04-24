package main.java.simfarm.crop;

public class Wheat extends Crop {
	private int size;
	private int diseaseResistance;

	public Wheat(int size, int diseaseResistance) {
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

}