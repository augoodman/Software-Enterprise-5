package main.java.simfarm.simulation;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.simfarm.abstractfactory.*;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.mediator.*;

public class SimFarm {
	static MediatorInterface mediator = new ConcreteMediator();
	static int cycle = 1;
	static boolean day;
	static boolean landAvailable = false;

	public static void simulate() {
		int numFarms;
		AbstractFactory<Farm> ff = FactoryProvider.getFactory("Farm");
		ArrayList<Farm> farmList = new ArrayList<Farm>();
		Scanner scanner = new Scanner(System.in, "UTF-8");
		System.out.println("Welcome to SimFarm. Please see the README for simulation details.");
		System.out.println("How many farms would you like to simulate?");
		numFarms = scanner.nextInt();
		int[] farmArray = new int[numFarms];
		for (int i = 0; i < numFarms; i++) {
			System.out.println("Choose farm-type for farm #" + (i + 1) + ":");
			System.out.println("1: Animal Farm");
			System.out.println("2: Crop Farm");
			System.out.println("3: Hybrid Farm");
			farmArray[i] = scanner.nextInt();
		}
		for (int farmType : farmArray) {
			switch (farmType) {
			case 1:
				Farm af = ff.create("AnimalFarm");
				farmList.add(af);
				break;
			case 2:
				Farm cf = ff.create("CropFarm");
				farmList.add(cf);
				break;
			default:
				Farm hf = ff.create("HybridFarm");
				farmList.add(hf);
			}
		}
		for (Farm farm : farmList) {
			AbstractSimFarm simFarm = new ConcreteSimFarm(mediator, farm);
			mediator.addAsf(simFarm);
			farm.calcStats();
			boolean bankrupt = false;
			boolean hasCrop = false;
			boolean hasAnimal = false;
			LandAvailable la = new LandAvailable();
			if(farm.getType().equalsIgnoreCase("HybridFarm") || farm.getType().equalsIgnoreCase("CropFarm")) {
				hasCrop = true;
			}
			if(farm.getType().equalsIgnoreCase("HybridFarm") || farm.getType().equalsIgnoreCase("AnimalFarm")){
				hasAnimal = true;
			}

			AbstractFactory<Crop> cf = (CropFactory) FactoryProvider.getFactory("Crop");
			AbstractFactory<Animal> af = (AnimalFactory) FactoryProvider.getFactory("Animal");
			String msg = newFarmMsg(farm);
			simFarm.send(msg);
			simFarm.send(continueMessage());
			enterToContinue();
			ManageCrops mc = new ManageCrops();
			ExchangeAnimals ea = new ExchangeAnimals();
			while (!bankrupt) {
				simFarm.send(("Day " + cycle + ":"));
				day = true;
				isLandAvailable(la, farm);
				//calc farm value
				//upgrade farm?
				
				
				
				//sell animal products
				if(hasAnimal) {
					int numAnimalsBeforeSale = farm.getAnimals().size();
					int moneyBeforeAnimalSale = farm.getMoney();
					ea.sellAnimals(farm);
					int numAnimalsAfterSale = farm.getAnimals().size();
					int moneyAfterAnimalSale = farm.getMoney();
					int moneyFromAnimalSale = moneyAfterAnimalSale - moneyBeforeAnimalSale;
					int numAnimalsSlaughtered = numAnimalsBeforeSale - numAnimalsAfterSale;
					simFarm.send("Bringing animals to market...");
					simFarm.send("..." + numAnimalsSlaughtered + " animals slaughtered and sold.");
					simFarm.send("...$" + moneyFromAnimalSale + " made from sale of meat, eggs, milk and wool.\n");
				}
				//sell crops
				if(hasCrop) {
					int moneyBeforeCropSale = farm.getMoney();
					int numCropHarvested = mc.sellCrops(farm);
					int moneyAfterCropSale = farm.getMoney();
					int moneyFromCropSale = moneyAfterCropSale - moneyBeforeCropSale;
					simFarm.send("Bringing crops to market...");
					simFarm.send("..." + numCropHarvested + " crops harvested and sold.");
					simFarm.send("...$" + moneyFromCropSale + " made from sale of crops.\n");
				}
				//buy animals
				if(hasAnimal) {
					int numAnimalsBefore = farm.getAnimals().size();
					int moneyBefore = farm.getMoney();
					for(int i = 0; i < farm.getLevel() + 1; i++) {
						if(landAvailable) {
							ea.buyAnimals(farm, (AnimalFactory) af);
							isLandAvailable(la, farm);
						}
					}
					int numAnimalsAfter = farm.getAnimals().size();
					int moneyAfter = farm.getMoney();
					int animalsBought = numAnimalsAfter - numAnimalsBefore;
					int moneySpent = moneyBefore - moneyAfter;
					//discount based on business skill
					double discount = (double) farm.getBusinessSkill() / 1000;
					farm.sell((int) ((double) moneySpent * discount));
					simFarm.send("Purchasing animals...");
					simFarm.send("..." + animalsBought + " animals purchased.");
					simFarm.send("...$" + moneySpent + " spent on new animals today.\n");
				}
				//plant new crops
				if(hasCrop) {
					int numCropsBefore = farm.getCrops().size();
					int moneyBefore = farm.getMoney();
					for(int i = 0; i < farm.getFarmWorkerSkill(); i++) {
						if(landAvailable) {
							mc.plantCrops(farm, (CropFactory) cf);
							isLandAvailable(la, farm);
						}
					}
					int numCropsAfter = farm.getCrops().size();
					int moneyAfter = farm.getMoney();
					int cropsPlanted = numCropsAfter - numCropsBefore;
					int moneySpent = moneyBefore - moneyAfter;
					//discount based on business skill
					double discount = (double) farm.getBusinessSkill() / 1000;
					farm.sell((int) ((double) moneySpent * discount));
					simFarm.send("Planting crops...");
					simFarm.send("..." + cropsPlanted + " crops planted.");
					simFarm.send("...$" + moneySpent + " spent on new crops today.\n");
				}
				simFarm.send("Money remaining: $" + farm.getMoney() + "\n");
				//reproduce animals
				BabyAnimals ba = new BabyAnimals();
				ba.pregnant(farm);
				for(Animal animal : farm.getAnimals()) {
					
				}
				//rear animal births
				int babiesBorn = ba.birth(farm, af);
				//manage animal reproduction
				for(Animal animal : farm.getAnimals()) {
					if(animal.isPregnant()) {
						animal.incrementPregnancy();
					}
					else {
						animal.incrementDaysSinceLastBirth();
					}
				}
				simFarm.send(babiesBorn + " baby animals born today.");
				//treat animals
				
				//treat crops
				//calc available open land
				//buy land
				//promote employees
				simFarm.send(continueMessage());
				enterToContinue();
				
				simFarm.send(("Night " + cycle + ":"));
				day = false;
				//predator attacks
				//disease deaths
				if (farm.getMoney() <= 0) {
					bankrupt = true;
				}
				cycle++;
				for(Animal animal : farm.getAnimals()) {
					animal.incrementAge();
					animal.incrementProductClock();
				}
				for(Crop crop : farm.getCrops()) {
					crop.incrementAge();
				}
				simFarm.send(continueMessage());
				enterToContinue();
			}
			scanner.close();
			simFarm.send("SIMULATION OVER!");
		}
	}
	
	private static boolean getTime() {
		return day;
	}
	
	private static int getCycle() {
		return cycle;
	}

	private static boolean isLandAvailable(LandAvailable la, Farm farm) {
		if(la.getAvailableLand(farm) > 0) {
			landAvailable = true;
		}
		else {
			landAvailable = false;
		}
		return landAvailable;
	}
	
	private static String newFarmMsg(Farm farm) {
		String msg = (farm.getType() + " simulation\nLevel: " + (farm.getLevel() + 1) + "\nCash: $" + farm.getMoney() + "\nSize: " + farm.getAcres()
		+ " acres\n\nStarting Employees and Stats:\n");
		for (Farmer farmer : farm.getFarmers()) {
			msg = msg.concat(farmer.getType() + ": " + farmer.toString() + "\n");
		}
		if (farm.getType() != "CropFarm") {
			msg = msg.concat("\nStarting Animals:\nChickens: 2\nCows: 2\nGoats: 2\nHorses: 2\nPigs: 2\nSheep: 2\n");
		}
		if (farm.getType() != "AnimalFarm") {
			msg = msg.concat(
					"\nStarting Crops:\nBarley: 2\nCorn: 2\nPeanut: 2\nPotato: 2\nRice: 2\nSoybean: 2\nTomato: 2\nWheat: 2\n");
		}
		return msg;
	}

	private static String continueMessage() {
		String msg = "Press enter to continue simulation...";
		return msg;
	}
	
	private static void enterToContinue() {
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}