package main.java.simfarm.simulation;

import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;

public class LandAvailable {
	private int numChickens = 0;
	private int numCowsAndPigs = 0;
	private int numGoatsAndSheep = 0;
	private int numHorses = 0;
	private int numBarleyAndRiceAndWheat = 0;
	private int numCornAndPotatoesAndTomatoes = 0;
	private int numPeanutsAndSoybeans = 0;
	
	public int getAvailableLand(Farm farm) {
		int totalLand = farm.getAcres();
		double landUsed;
		int availableLand = 0;
		if(farm.getType().equalsIgnoreCase("Animal") || farm.getType().equalsIgnoreCase("Hybrid")) {
			calcNumEachAnimal(farm);
		}
		if(farm.getType().equalsIgnoreCase("Crop") || farm.getType().equalsIgnoreCase("Hybrid")) {
			calcNumEachCrop(farm);
		}
		landUsed = calcLandUsed(totalLand);
		availableLand = (int) (totalLand - landUsed);
		return availableLand;
		
	}

	public void calcNumEachAnimal(Farm farm) {
		for(Animal animal : farm.getAnimals()) {
			if(animal.getType().equalsIgnoreCase("Chicken")) {
				numChickens++;
			}
			if(animal.getType().equalsIgnoreCase("Cow") || animal.getType().equalsIgnoreCase("Pig")) {
				numCowsAndPigs++;
			}
			if(animal.getType().equalsIgnoreCase("Goat") || animal.getType().equalsIgnoreCase("Sheep")) {
				numGoatsAndSheep++;
			}
			if(animal.getType().equalsIgnoreCase("Horse")) {
				numHorses++;
			}
		}
	}
	
	public void calcNumEachCrop(Farm farm) {
		for(Crop crop : farm.getCrops()) {
			if(crop.getType().equalsIgnoreCase("Barley") || crop.getType().equalsIgnoreCase("Rice") || crop.getType().equalsIgnoreCase("Wheat")) {
				numBarleyAndRiceAndWheat++;
			}
			if(crop.getType().equalsIgnoreCase("Corn") || crop.getType().equalsIgnoreCase("Potato") || crop.getType().equalsIgnoreCase("Tomato")) {
				numCornAndPotatoesAndTomatoes++;
			}
			if(crop.getType().equalsIgnoreCase("Peanut") || crop.getType().equalsIgnoreCase("Soybean")) {
				numPeanutsAndSoybeans++;
			}
		}
	}

	public int calcLandUsed(int totalLand) {
		/*
		 * Animals and crops consume the following amount of land:
		 * Animals:
		 * Chicken: 500 per acre
		 * Cow: 50 per acre
		 * Goat: 100 per acre
		 * Horse: 25 per acre
		 * Pig: 50 per acre
		 * Sheep: 100 per acre
		 * 
		 * Crops:
		 * Barley: 5000 per acre
		 * Corn: 1000 per acre
		 * Peanut: 3000 per acre
		 * Potato: 1000 per acre
		 * Rice: 5000 per acre
		 * Soybean: 3000 per acre
		 * Tomato: 1000 per acre
		 * Wheat: 5000 per acre
		 */
		double chickenSpace = numChickens / 500.0;
		double cowAndPigSpace = numCowsAndPigs / 50.0;
		double goatAndSheepSpace = numGoatsAndSheep / 100.0;
		double horseSpace = numHorses / 25.0;
		double barleyAndRiceAndWheatSpace = numBarleyAndRiceAndWheat / 5000.0;
		double cornAndPotatoAndTomatoSpace = numCornAndPotatoesAndTomatoes / 1000.0;
		double peanutAndSoybeanSpace = numPeanutsAndSoybeans / 3000.0;
		int totalRoundedUp = (int) Math.ceil(chickenSpace + cowAndPigSpace + goatAndSheepSpace + horseSpace + barleyAndRiceAndWheatSpace + cornAndPotatoAndTomatoSpace + peanutAndSoybeanSpace);
		int landUsed = totalRoundedUp;
		return landUsed;

	}
}
