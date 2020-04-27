package main.java.simfarm.simulation;

import java.util.ArrayList;
import java.util.Random;

import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.farm.Farm;

public class ExchangeAnimals {
	public void buyAnimals(Farm farm,  AnimalFactory af) {
		Random r = new Random();
		int animalToBuy = r.nextInt(8);
		switch(animalToBuy) {
		case 0:
			if(farm.getMoney() > 50) {
				farm.getAnimals().add(af.create("Chicken"));
				farm.buy(50);
			}
			break;
		case 1:
			if(farm.getMoney() > 500) {
				farm.getAnimals().add(af.create("Cow"));
				farm.buy(500);
			}
			break;
		case 2:
			if(farm.getMoney() > 250) {
				farm.getAnimals().add(af.create("Goat"));
				farm.buy(250);
			}
			break;
		case 3:
			if(farm.getMoney() > 1000) {
				farm.getAnimals().add(af.create("Horse"));
				farm.buy(1000);
			}
			break;
		case 4:
			if(farm.getMoney() > 100) {
				farm.getAnimals().add(af.create("Pig"));
				farm.buy(100);
			}
			break;
		default:
			if(farm.getMoney() > 300) {
				farm.getAnimals().add(af.create("Sheep"));
				farm.buy(300);
			}
		}
	}
	
	public void sellAnimals(Farm farm) {
		int runningTotal = 0;
		for(Animal animal : farm.getAnimals()) {
			if(animal.getProductAge() >= 2) {
				//animal.resetProductClock();
				switch(animal.getType()) {
				case "Chicken":
					//sell eggs
					farm.sell(3);
					runningTotal += 3;
					break;
				case "Goat":
					//sell goat milk
					farm.sell(15);
					runningTotal += 15;
					break;
				default:
					//sell sheep wool
					farm.sell(30);
					runningTotal += 15;
				}
			}
		}
		
		ArrayList<Animal> animalsToRemove = new ArrayList<Animal>();
		for(Animal animal : farm.getAnimals()) {
			if(animal.getProductAge() >= 10) {
				switch(animal.getType()) {
				case "Cow":
					//slaughter cow and sell beef
					farm.sell(750);
					animalsToRemove.add(animal);
					runningTotal += 750;
					break;
				case "Horse":
					//sell horse
					farm.sell(1500);
					animalsToRemove.add(animal);
					runningTotal += 1500;
					break;
				default:
					//slaughter pig and sell pork
					farm.sell(300);
					animalsToRemove.add(animal);
					runningTotal += 300;
					break;
				}
			}
		}
		
		for(Animal animal : animalsToRemove) {
			farm.getAnimals().remove(animal);
		}
		
		//bonus sales price based on breeder skill
		double bonus = (double) farm.getBreederSkill() / 1000;
		farm.sell((int) ((double) runningTotal * bonus));
	}
}