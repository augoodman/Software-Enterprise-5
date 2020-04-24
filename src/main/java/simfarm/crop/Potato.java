package main.java.simfarm.crop;

public class Potato extends Crop {
	private int size;
	private int diseaseResistance;

	public Potato(int size, int diseaseResistance) {
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