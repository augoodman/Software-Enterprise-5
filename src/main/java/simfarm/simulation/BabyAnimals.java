package main.java.simfarm.simulation;

import java.util.ArrayList;
import java.util.Random;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.farm.Farm;

public class BabyAnimals {
	private Animal female = null;
	private String femaleType = "some animal";
	private Animal male = null;
	private String maleType = "another animal";
	private Random r = new Random();
	private ManageLand la = new ManageLand();
	
	public void pregnant(Farm farm) {
		for(Animal animal : farm.getAnimals()) {
			if(animal.getGender().equalsIgnoreCase("Female") && animal.isPregnant() == false && animal.getDaysSinceLastBirth() >= 1 && animal.getAge() >= 3) {
				female = animal;
				femaleType = animal.getType();
			}
			if(animal.getGender().equalsIgnoreCase("Male") && animal.getAge() >= 3) {
				male = animal;
				maleType = animal.getType();
			}
			if(femaleType.equalsIgnoreCase(maleType)) {
				int femaleBreedability = female.getBreedability();
				int maleBreedability = male.getBreedability();
				int fertility = femaleBreedability + maleBreedability;
				int chances = r.nextInt(100);
				if(fertility > chances) {
					female.makePregnant();
				}
			}
		}
	}
	
	public int birth(Farm farm, AbstractFactory<Animal> af) {
		ArrayList<Animal> babies = new ArrayList<Animal>();
		for(Animal animal : farm.getAnimals()) {
			if(animal.isPregnant() && animal.daysPregnant() >= 4 && la.isLandAvailable(farm)) {
				babies.add(animal.giveBirth(farm, af));
			}
		}
		for(Animal baby : babies) {
			farm.getAnimals().add(baby);
		}
		return babies.size();
	}
}
