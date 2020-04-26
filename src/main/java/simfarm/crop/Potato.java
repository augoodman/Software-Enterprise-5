package main.java.simfarm.crop;

public class Potato extends Crop {
	private int size;
	private int diseaseResistance;
	private int numCrops;
	private String type = "Potato";

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

	@Override
	public String getType() {
		return type;
	}	

	@Override
	public int getNumCrops() {
		return numCrops;
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
}