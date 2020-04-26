package main.java.simfarm;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.farm.Farm;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.mediator.*;

public class SimFarm {
	static MediatorInterface mediator = new ConcreteMediator();

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
			boolean bankrupt = false;
			int cycle = 1;
			String msg = newFarmMsg(farm);
			simFarm.send(msg);
			simFarm.send(continueMessage());
			enterToContinue();
			while (!bankrupt) {
				simFarm.send(("Day " + cycle + ":"));
				//plant new crops
				//rear animal births
				//sell animals
				//sell crops
				//reproduce animals
				//calc available open land
				//plant crops
				//treat animals
				//treat crops
				//buy land
				//promote employees
				//calc farm value
				//upgrade farm?
				simFarm.send(("Night " + cycle + ":"));
				//plant new crops
				//rear animal births
				//sell animals
				//sell crops
				//reproduce animals
				//calc available open land
				//plant crops
				//treat animals
				//treat crops
				//buy land
				//promote employees
				//calc farm value
				//upgrade farm?
				farm.transaction(100);
				cycle++;
				if (farm.getMoney() <= 0) {
					bankrupt = true;
				}
			}
			scanner.close();
			System.out.println("SIMULATION OVER!");
		}
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