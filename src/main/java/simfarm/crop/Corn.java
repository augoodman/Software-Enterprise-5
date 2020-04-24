package main.java.simfarm.crop;

public class Corn extends Crop {
	private int size;
	private int diseaseResistance;

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

}