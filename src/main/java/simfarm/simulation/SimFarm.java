package main.java.simfarm.simulation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import main.java.simfarm.abstractfactory.*;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.decorator.*;
import main.java.simfarm.farm.Farm;
import main.java.simfarm.farmer.*;
import main.java.simfarm.mediator.*;

public class SimFarm {
	static MediatorInterface mediator = new ConcreteMediator();
	static int cycle = 1;
	static boolean day;
	static boolean landAvailable = false;

	public static void simulate() {
		int numFarms;
		AbstractFactory<Farm> f = FactoryProvider.getFactory("Farm");
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
				Farm af = f.create("AnimalFarm");
				farmList.add(af);
				break;
			case 2:
				Farm cf = f.create("CropFarm");
				farmList.add(cf);
				break;
			default:
				Farm hf = f.create("HybridFarm");
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
			boolean hasBoth = false;
			boolean level2Reached = false;
			boolean level3Reached = false;
			boolean level4Reached = false;
			boolean level5Reached = false;
					ManageLand ml = new ManageLand();
			if(farm.getType().equalsIgnoreCase("HybridFarm") || farm.getType().equalsIgnoreCase("CropFarm")) {
				hasCrop = true;
			}
			if(farm.getType().equalsIgnoreCase("HybridFarm") || farm.getType().equalsIgnoreCase("AnimalFarm")){
				hasAnimal = true;
			}
			if(farm.getType().equalsIgnoreCase("HybridFarm")){
				hasBoth = true;
			}

			AbstractFactory<Crop> cf = (CropFactory) FactoryProvider.getFactory("Crop");
			AbstractFactory<Animal> af = (AnimalFactory) FactoryProvider.getFactory("Animal");
			AbstractFactory<Farmer> ff = (FarmerFactory) FactoryProvider.getFactory("Farmer");
			String msg = newFarmMsg(farm);
			simFarm.send(msg);
			simFarm.send(continueMessage());
			enterToContinue();
			ManageCrops mc = new ManageCrops();
			ExchangeAnimals ea = new ExchangeAnimals();
			while (farm.getMoney() < 500000) {
				simFarm.send(("\nDay " + cycle + ":"));
				day = true;
				
				//upgrade farm
				int level = farm.levelUp();
				if(level == 2 && level2Reached == false) {
					level2Reached = true;
					simFarm.send("Farm has reached Level 2!\n");
				}
				if(level == 3 && level3Reached == false) {
					level3Reached = true;
					simFarm.send("Farm has reached Level 3!\n");
				}
				if(level == 4 && level4Reached == false) {
					level4Reached = true;
					simFarm.send("Farm has reached Level 4!\n");
				}
				if(level == 5 && level5Reached == false) {
					level5Reached = true;
					simFarm.send("Farm has reached Level 5!\n");
				}
				
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
					for(int i = 0; i < (farm.getLevel() + 1) * 2; i++) {
						if(ml.isLandAvailable(farm)) {
							ea.buyAnimals(farm, (AnimalFactory) af);
						}
					}
					int numAnimalsAfter = farm.getAnimals().size();
					int moneyAfter = farm.getMoney();
					int animalsBought = numAnimalsAfter - numAnimalsBefore;
					int moneySpent = moneyBefore - moneyAfter;
					//discount based on business skill
					double discount = (double) farm.getBusinessSkill() / 10000;
					if(discount > .5) {
						discount = .5;
					}
					farm.sell((int) ((double) moneySpent * discount));
					simFarm.send("Purchasing animals...");
					simFarm.send("..." + animalsBought + " animals purchased.");
					simFarm.send("...$" + (moneySpent - (int) ((double) moneySpent * discount)) + " spent on new animals today.\n");
				}
				//plant new crops
				if(hasCrop) {
					int numCropsBefore = farm.getCrops().size();
					int moneyBefore = farm.getMoney();
					for(int i = 0; i < farm.getFarmWorkerSkill() / 10; i++) {
						if(ml.isLandAvailable(farm) && farm.getCrops().size() < (farm.getFarmWorkerSkill() / 5)) {
							mc.plantCrops(farm, (CropFactory) cf, ml);
						}
					}

					int numCropsAfter = farm.getCrops().size();
					int moneyAfter = farm.getMoney();
					int cropsPlanted = numCropsAfter - numCropsBefore;
					int moneySpent = moneyBefore - moneyAfter;
					
					//discount based on business skill
					double discount = (double) farm.getBusinessSkill() / 1000;
					if(discount > .5) {
						discount = .5;
					}	
					farm.sell((int) ((double) moneySpent * discount));
					simFarm.send("Planting crops...");
					simFarm.send("..." + cropsPlanted + " crops planted.");
					simFarm.send("...$" + (moneySpent - (int) ((double) moneySpent * discount)) + " spent on new crops today.\n");
				}
				
				//reproduce animals
				if(hasAnimal) {
					simFarm.send("Checking status of animals...");
					int pregnantAnimals = 0;
					BabyAnimals ba = new BabyAnimals();
					ba.pregnant(farm);
					for(Animal animal : farm.getAnimals()) {
						if(animal.isPregnant()) {
							pregnantAnimals++;
						}
					}
					simFarm.send("..." + pregnantAnimals + " animals are pregnant.");
					
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
					simFarm.send("..." + babiesBorn + " animals born today.");
				}
				
				//animals/crops get sick
				Disease d = new Disease();
				d.spreadDisease(farm);

				//treat animals
				if(hasAnimal) {
					int vetCapacity = farm.getVeterinarianSkill() / 50;
					int animalsTreated = 0;
					int diseasedAnimals = 0;
					for(Animal animal : farm.getAnimals()) {
						if(animal.isDiseased()) {
							diseasedAnimals++;
						}
						if(animal.isDiseased() && animalsTreated <= vetCapacity && farm.getMoney() >= 200) {
							animal.healed();
							animalsTreated++;
							farm.buy(200);
						}
					}
					simFarm.send("..." + diseasedAnimals + " animals are sick.");
					simFarm.send("..." + animalsTreated + " sick animals were nursed back to health.\n");
				}
				
				//treat crops
				if(hasCrop) {
					int hortCapacity = farm.getHorticultureSkill() / 25;
					int cropsTreated = 0;
					int diseasedCrops = 0;
					for(Crop crop : farm.getCrops()) {
						if(crop.isDiseased()) {
							diseasedCrops++;
						}
						if(crop.isDiseased() && cropsTreated <= hortCapacity && farm.getMoney() >= 2) {
							crop.healed();
							cropsTreated++;
							farm.buy(1);
						}
					}
					simFarm.send("Checking status of crops...");
					simFarm.send("..." + diseasedCrops + " crops are diseased.");
					simFarm.send("..." + cropsTreated + " diseased crops were successfully treated.\n");
				}
				
				//calc available open land
			    int openSpace = ml.getAvailableLand(farm);
				simFarm.send("Checking amount of open land...");
				simFarm.send("..." + openSpace + " acres are available for animals and crops.");

				//buy land
				int landBought = ml.buyLand(farm);
				simFarm.send("..." + landBought + " acres purchased.");
				simFarm.send("...Farm is now " + farm.getAcres() + " acres in size.");

				//promote employee
				BreederDecorator bd = new BreederDecorator((FarmerFactory) ff);
				FarmWorkerDecorator fwd = new FarmWorkerDecorator((FarmerFactory) ff);
				HarvesterDecorator hd = new HarvesterDecorator((FarmerFactory) ff);
				HorticulturistDecorator hod = new HorticulturistDecorator((FarmerFactory) ff);
				OwnerDecorator od = new OwnerDecorator((FarmerFactory) ff);
				VeterinarianDecorator vd = new VeterinarianDecorator((FarmerFactory) ff);
				Random r = new Random();
				int promote = r.nextInt(farm.getFarmers().size());
				if(cycle % 10 == 0) {
					String farmerType = farm.getFarmers().get(promote).getType();
					Farmer promotee = null;
					switch(farmerType) {
					case "Breeder":
						promotee = (Breeder) bd.create("Breeder");
						farm.getFarmers().set(promote, promotee);
						promotee.decorate();
						break;
					case "FarmWorker":
						promotee = (FarmWorker) fwd.create("FarmWorker");
						farm.getFarmers().set(promote, promotee);
						break;
					case "Harvester":
						promotee = (Harvester) hd.create("Harvester");
						farm.getFarmers().set(promote, promotee);
						break;
					case "Horticulturist":
						promotee = (Horticulturist) hod.create("Horticulturist");
						farm.getFarmers().set(promote, promotee);
						break;
					case "Owner":
						promotee = (Owner) od.create("Owner");
						farm.getFarmers().set(promote, promotee);
						break;
					default:
						promotee = (Veterinarian) vd.create("Veterinarian");
						farm.getFarmers().set(promote, promotee);
					}
					simFarm.send("..." + promotee.getType() + " was promoted to senior " + promotee.getType());
					farm.calcStats();
				}
				
				//hire employee
				if(hasBoth) {
					int noob = r.nextInt(5);
					if(cycle % 5 == 0) {
						String newb = null;
						switch(noob) {
						case 0:
							farm.getFarmers().add(ff.create("Breeder"));
							newb = "Breeder";
							break;
						case 1:
							farm.getFarmers().add(ff.create("FarmWorker"));
							newb = "FarmWorker";
							break;
						case 2:
							farm.getFarmers().add(ff.create("Harvester"));
							newb = "Harvester";
							break;
						case 3:
							farm.getFarmers().add(ff.create("Horticulturist"));
							newb = "Horticulturist";
							break;
						default:
							farm.getFarmers().add(ff.create("Veterinarian"));
							newb = "Veterinarian";
						}
						simFarm.send("..." + newb + " was hired.");
						farm.calcStats();
					}
				}
				else if(hasAnimal) {
					int noob = r.nextInt(3);
					if(cycle % 5 == 0) {
						String newb = null;
						switch(noob) {
						case 0:
							farm.getFarmers().add(ff.create("Breeder"));
							newb = "Breeder";
							break;
						case 1:
							farm.getFarmers().add(ff.create("FarmWorker"));
							newb = "FarmWorker";
							break;
						default:
							farm.getFarmers().add(ff.create("Veterinarian"));
							newb = "Veterinarian";
						}
						simFarm.send("..." + newb + " was hired.");
						farm.calcStats();
					}
				}
				else if(hasCrop) {
					int noob = r.nextInt(3);
					if(cycle % 5 == 0) {
						String newb = null;
						switch(noob) {
						case 0:
							farm.getFarmers().add(ff.create("FarmWorker"));
							newb = "FarmWorker";
							break;
						case 1:
							farm.getFarmers().add(ff.create("Harvester"));
							newb = "Harvester";
							break;
						default:
							farm.getFarmers().add(ff.create("Horticulturist"));
							newb = "Horticulturist";
						}
						simFarm.send("..." + newb + " was hired.");
						farm.calcStats();
					}
				}
				enterToContinue();
				simFarm.send(("\nNight " + cycle + ":"));
				day = false;
				
				//kill diseased animals and crops
				ArrayList<Animal> diseasedAnimals = new ArrayList<Animal>();
				ArrayList<Crop> diseasedCrops = new ArrayList<Crop>();
				ArrayList<Animal> oldAnimals = new ArrayList<Animal>();
				if(hasAnimal) {
					for(Animal animal : farm.getAnimals()) {
						if(animal.getAge() >= 14) {
							oldAnimals.add(animal);
						}
						animal.incrementAge();
						animal.incrementProductClock();
						if(animal.isDiseased()) {
							animal.incrementDaysDiseased();
							if(animal.daysDiseased() >= 4) {
								diseasedAnimals.add(animal);
							}
						}
					}
					simFarm.send("Checking status of animals...");
					simFarm.send("..." + diseasedAnimals.size() + " animals have died from disease.");
					simFarm.send("..." + oldAnimals.size() + " animals have died from old age.");
					for(Animal animal : diseasedAnimals) {
						farm.getAnimals().remove(animal);
					}
					for(Animal animal : oldAnimals) {
						farm.getAnimals().remove(animal);
					}
				}
				if(hasCrop) {
					for(Crop crop : farm.getCrops()) {
						if(crop.isDiseased()) {
							crop.incrementDaysDiseased();
							if(crop.daysDiseased() >= 4) {
								diseasedCrops.add(crop);
							}
						}
					}
					simFarm.send("Checking status of crops...");
					simFarm.send("..." + diseasedCrops.size() + " crops have died from disease.");
					for(Crop crop : farm.getCrops()) {
						crop.incrementAge();
					}
				}
				
				//predator attacks
				if(hasAnimal) {
					if(farm.getAnimals().size() > 0) {
						int victim = r.nextInt(farm.getAnimals().size());
						String deadAnimal = farm.getAnimals().get(victim).getType();
						if(farm.getAnimals().get(victim).getAggression() < r.nextInt(50)) {
							farm.getAnimals().remove(victim);
							simFarm.send("..." + deadAnimal + " was killed by a wolf.");
						}
					}
				}
				//increment day
				cycle++;

				simFarm.send("\nCash on hand: $" + farm.getMoney() + "\n");
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
	
	private static String newFarmMsg(Farm farm) {
		String msg = (farm.getType() + " simulation\nLevel: " + (farm.getLevel() + 1) + "\nCash: $" + farm.getMoney() + "\nSize: " + farm.getAcres()
		+ " acres\n\nStarting Employees:\n");
		for (Farmer farmer : farm.getFarmers()) {
			msg = msg.concat(farmer.getType() + "\n");
		}
		if (farm.getType() != "CropFarm") {
			msg = msg.concat("\nStarting Animals:\nChickens: 2\nCows: 2\nGoats: 2\nHorses: 2\nPigs: 2\nSheep: 2\n");
		}
		if (farm.getType() != "AnimalFarm") {
			msg = msg.concat(
					"\nStarting Crops:\nBarley: 10\nCorn: 10\nPeanut: 10\nPotato: 10\nRice: 10\nSoybean: 10\nTomato: 10\nWheat: 10\n");
		}
		return msg;
	}

	private static String continueMessage() {
		String msg = "Press enter to continue simulation...";
		return msg;
	}
	
	private static void enterToContinue() {
		try{
			System.in.read();}
		catch(Exception e){
				e.printStackTrace();}
	}
}