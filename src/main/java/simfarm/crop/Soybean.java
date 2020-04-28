package main.java.simfarm.crop;

public class Soybean extends Crop {
	private int size;
	private int diseaseResistance;
	private int numCrops;
	private int age;
	private String type = "Soybean";
	private boolean isDiseased = false;
	private int daysDiseased = 0;

	public Soybean(int size, int diseaseResistance) {
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

	@Override
	public boolean isDiseased() {
		return isDiseased;
	}

	@Override
	public int daysDiseased() {
		return daysDiseased;
	}

	@Override
	public void incrementDaysDiseased() {
		daysDiseased++;
	}

	@Override
	public void diseased() {
		this.isDiseased = true;
	}

	@Override
	public void healed() {
		this.isDiseased = false;
	}
	
}