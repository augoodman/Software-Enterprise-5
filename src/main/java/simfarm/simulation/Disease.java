package main.java.simfarm.simulation;

import java.util.Random;

import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;

public class Disease {
    Random random = new Random();

    /**
     * unleashes a disease the sickens crops and animals alike.
     * 
     * @param farm farm object on which let loose disease
     */
    public void spreadDisease(Farm farm) {
        if (farm.getType().equalsIgnoreCase("AnimalFarm")
                || farm.getType().equalsIgnoreCase("HybridFarm")) {
            for (Animal animal : farm.getAnimals()) {
                int viral = random.nextInt(33);
                if (animal.getDiseaseResistance() <= viral) {
                    diseasedAnimal(animal);
                }
            }
        }
        if (farm.getType().equalsIgnoreCase("CropFarm")
                || farm.getType().equalsIgnoreCase("HybridFarm")) {
            for (Crop crop : farm.getCrops()) {
                int viral = random.nextInt(67);
                if (crop.getDiseaseResistance() <= viral) {
                    diseasedCrop(crop);
                }
            }
        }
    }

    /**
     * marks a heathy animal as diseased.
     * 
     * @param animal animal object to make sick
     */
    public void diseasedAnimal(Animal animal) {
        animal.diseased();
    }

    /**
     * marks a healthy crop as diseased.
     * 
     * @param crop crop object to make sick
     */
    public void diseasedCrop(Crop crop) {
        crop.diseased();
    }
}
