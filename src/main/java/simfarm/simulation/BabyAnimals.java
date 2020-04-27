package main.java.simfarm.simulation;

import java.util.ArrayList;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.farm.Farm;

public class BabyAnimals {
	private Animal female = null;
	private String femaleType = "some animal";
	private Animal male = null;
	private String maleType = "another animal";
	
	public void pregnant(Farm farm) {
		for(Animal animal : farm.getAnimals()) {
			if(animal.getGender().equalsIgnoreCase("Female") && animal.isPregnant() == false && animal.getDaysSinceLastBirth() >= 1 && animal.getAge() >= 3) {
				female = animal;
				femaleType = animal.getType();

			}
			if(animal.getGender().equalsIgnoreCase("Male")) {
				male = animal;
				maleType = animal.getType();

			}
			if(femaleType.equalsIgnoreCase(maleType)) {
				female.makePregnant();
			}
		}
	}
	
	public int birth(Farm farm, AbstractFactory<Animal> af) {
		ArrayList<Animal> babies = new ArrayList<Animal>();
		for(Animal animal : farm.getAnimals()) {
			if(animal.isPregnant() && animal.daysPregnant() >= 4) {
				babies.add(animal.giveBirth(farm, af));
			}
		}
		for(Animal baby : babies) {
			farm.getAnimals().add(baby);
		}
		return babies.size();
	}
}
