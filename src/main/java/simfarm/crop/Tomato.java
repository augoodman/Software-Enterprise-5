package main.java.simfarm.crop;

public class Tomato extends Crop {
	private int size;
	private int diseaseResistance;

	public Tomato(int size, int diseaseResistance) {
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