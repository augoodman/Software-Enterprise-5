package main.java.simfarm.simulation;

import java.util.Random;

import main.java.simfarm.abstractfactory.CropFactory;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;

public class ManageCrops {
	public void plantCrops(Farm farm,  CropFactory cf, ManageLand ml) {
		Random r = new Random();
		int cropToPlant = r.nextInt(8);
		switch(cropToPlant) {
		case 0:
			if(farm.getMoney() > 1 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Barley"));
				farm.buy(1);
			}
			break;
		case 1:
			if(farm.getMoney() > 2 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Corn"));
				farm.buy(2);
			}
			break;
		case 2:
			if(farm.getMoney() > 1 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Peanut"));
				farm.buy(1);
			}
			break;
		case 3:
			if(farm.getMoney() > 2 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Potato"));
				farm.buy(2);
			}
			break;
		case 4:
			if(farm.getMoney() > 1 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Rice"));
				farm.buy(1);
			}
			break;
		case 5:
			if(farm.getMoney() > 1 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Soybean"));
				farm.buy(1);
			}
			break;
		case 6:
			if(farm.getMoney() > 2 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Tomato"));
				farm.buy(2);
			}
			break;
		default:
			if(farm.getMoney() > 1 && ml.isLandAvailable(farm) == true) {
				farm.getCrops().add(cf.create("Wheat"));
				farm.buy(1);
			}
			break;
		}
	}
	
	public int sellCrops(Farm farm) {
		int runningTotal = 0;
		int cropsSold = 0;
		for(Crop crop : farm.getCrops()) {
			if(crop.getAge() >= 3) {
				crop.resetAge();
				switch(crop.getType()) {
				case "Barley":
					farm.sell(40);
					cropsSold++;
					break;
				case "Corn":
					farm.sell(50);
					cropsSold++;
					break;
				case "Peanut":
					farm.sell(40);
					cropsSold++;
					break;
				case "Potato":
					farm.sell(50);
					cropsSold++;
					break;
				case "Rice":
					farm.sell(40);
					cropsSold++;
					break;
				case "Soybean":
					farm.sell(40);
					cropsSold++;
					break;
				case "Tomato":
					farm.sell(50);
					cropsSold++;
					break;
				default:
					farm.sell(40);
					cropsSold++;
				}
			}
		}
		//bonus sales price based on harvester skill
		double bonus = (double) farm.getHarvesterSkill() / 1000;
		farm.sell((int) ((double) runningTotal * bonus));
		return cropsSold;
	}
}
