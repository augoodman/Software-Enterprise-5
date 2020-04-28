package main.java.simfarm.simulation;

import java.util.Random;

import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;

public class Disease {
	Random r = new Random();
	public void spreadDisease(Farm farm) {
		if(farm.getType().equalsIgnoreCase("AnimalFarm") || farm.getType().equalsIgnoreCase("HybridFarm")) {
			for(Animal animal : farm.getAnimals()) {
				int viral = r.nextInt(25);
				if(animal.getDiseaseResistance() <= viral) {
					diseasedAnimal(animal);
				}
			}
		}
		if(farm.getType().equalsIgnoreCase("CropFarm") || farm.getType().equalsIgnoreCase("HybridFarm")) {
			for(Crop crop : farm.getCrops()) {
				int viral = r.nextInt(25);
				if(crop.getDiseaseResistance() <= viral) {
					diseasedCrop(crop);
				}
			}
		}
	}
	
	public void diseasedAnimal(Animal animal) {
		animal.diseased();
	}
	
	public void diseasedCrop(Crop crop) {
		crop.diseased();
	}
}
