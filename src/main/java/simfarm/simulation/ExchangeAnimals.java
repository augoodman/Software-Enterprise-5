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
			if(farm.getMoney() > 100) {
				farm.getAnimals().add(af.create("Chicken"));
				farm.buy(100);
			}
			break;
		case 1:
			if(farm.getMoney() > 750) {
				farm.getAnimals().add(af.create("Cow"));
				farm.buy(750);
			}
			break;
		case 2:
			if(farm.getMoney() > 500) {
				farm.getAnimals().add(af.create("Goat"));
				farm.buy(500);
			}
			break;
		case 3:
			if(farm.getMoney() > 2000) {
				farm.getAnimals().add(af.create("Horse"));
				farm.buy(2000);
			}
			break;
		case 4:
			if(farm.getMoney() > 250) {
				farm.getAnimals().add(af.create("Pig"));
				farm.buy(250);
			}
			break;
		default:
			if(farm.getMoney() > 500) {
				farm.getAnimals().add(af.create("Sheep"));
				farm.buy(500);
			}
		}
	}
	
	public void sellAnimals(Farm farm) {
		int runningTotal = 0;
		int productDailyLimit = farm.getBusinessSkill() / 5;
		int productSold = 0;
		ArrayList<Animal> animalsToRemove = new ArrayList<Animal>();
		int slaughterDailyLimit = farm.getBusinessSkill() / 20;
		int numSlaughtered = 0;
		
		for(Animal animal : farm.getAnimals()) {
			if(animal.getProductAge() >= 2) {
				//animal.resetProductClock();
				switch(animal.getType()) {
				case "Chicken":
					//sell eggs
					if(productSold >= productDailyLimit) {
						break;
					}
					runningTotal += 5;
					productSold++;
					break;
				case "Goat":
					//sell goat milk
					if(productSold >= productDailyLimit) {
						break;
					}
					runningTotal += 25;
					productSold++;
					break;
				default:
					//sell sheep wool
					if(productSold >= productDailyLimit) {
						break;
					}
					runningTotal += 50;
					productSold++;
				}
			}
		}
		
		for(Animal animal : farm.getAnimals()) {
			if(animal.getProductAge() >= 3) {
				switch(animal.getType()) {
				case "Cow":
					//slaughter cow and sell beef
					if(numSlaughtered >= slaughterDailyLimit) {
						break;
					}
					animalsToRemove.add(animal);
					runningTotal += 1500;
					numSlaughtered++;
					break;
				case "Horse":
					//sell horse for labor (not slaughterd ;D)
					if(numSlaughtered >= slaughterDailyLimit) {
						break;
					}
					animalsToRemove.add(animal);
					runningTotal += 3000;
					numSlaughtered++;

					break;
				default:
					//slaughter pig and sell pork
					if(numSlaughtered >= slaughterDailyLimit) {
						break;
					}
					animalsToRemove.add(animal);
					runningTotal += 600;
					numSlaughtered++;

				}
			}
		}
		
		for(Animal animal : animalsToRemove) {
			farm.getAnimals().remove(animal);
		}
		
		//bonus sales price based on breeder skill
		double bonus = (double) farm.getBreederSkill() / 1000;
		int discount = (int) ((double) runningTotal * bonus);
		farm.sell(runningTotal - discount);
	}
}