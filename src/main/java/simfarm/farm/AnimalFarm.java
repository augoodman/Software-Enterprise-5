package main.java.simfarm.farm;

import java.util.ArrayList;

import main.java.simfarm.abstractfactory.*;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.decorator.*;
import main.java.simfarm.farmer.*;

public class AnimalFarm extends Farm{
	private int level;
	private int money;
	private int numFarmers;
	private int acres;
	private int businessSkill;
	private int farmWorkerSkill;
	private int harvesterSkill;
	private int breederSkill;
	private int horticultureSkill;
	private int veterinarianSkill;
	private String type = "AnimalFarm";
	private FactoryProvider fp = new FactoryProvider();
	private FarmerFactory ff = (FarmerFactory) fp.getFactory("Farmer");
	private AnimalFactory af = (AnimalFactory) fp.getFactory("Animal");
	private ArrayList<Farmer> farmerList = new ArrayList<Farmer>();
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public AnimalFarm() {
		this.level = 0;
		this.money = 1000;
		this.acres = 10;
		farmerList.add(ff.create("Owner"));
		farmerList.add(ff.create("Breeder"));
		farmerList.add(ff.create("FarmWorker"));
		farmerList.add(ff.create("Veterinarian"));
		this.numFarmers = 4;
		animalList.add(af.create("Chicken"));
		animalList.add(af.create("Chicken"));
		animalList.add(af.create("Cow"));
		animalList.add(af.create("Cow"));
		animalList.add(af.create("Goat"));
		animalList.add(af.create("Goat"));
		animalList.add(af.create("Horse"));
		animalList.add(af.create("Horse"));
		animalList.add(af.create("Pig"));
		animalList.add(af.create("Pig"));
		animalList.add(af.create("Sheep"));
		animalList.add(af.create("Sheep"));
		for(Animal animal : animalList) {
			if(animalList.indexOf(animal) % 2 == 0) {
				animal.setGender("Female");
			}
			else {
				animal.setGender("Male");
			}
		}
	}
	
	@Override
	public int getLevel() {
		return level;
	}
	
	@Override
	public int getMoney() {
		return money;
	}
	
	@Override
	public int getNumFarmers() {
		return numFarmers;
	}
	
	@Override
	public int getAcres() {
		return acres;
	}
	
	@Override
	public int getBusinessSkill() {
		return businessSkill;
	}
	
	@Override
	public int getFarmWorkerSkill() {
		return farmWorkerSkill;
	}
	
	@Override
	public int getHarvesterSkill(){
		return harvesterSkill;
	}
	
	@Override
	public int getBreederSkill() {
		return breederSkill;
	}
	
	@Override
	public int getHorticultureSkill() {
		return horticultureSkill;
	}
	
	@Override
	public int getVeterinarianSkill() {
		return veterinarianSkill;
	}
	
	@Override
	public void transaction(int dollars) {
		this.money += -dollars;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void hireFarmer(String farmerType) {
			Farmer f = (Breeder) fp.getFactory("Farmer").create(farmerType);
			farmerList.add(f);
			numFarmers++;
	}

	@Override
	public void promoteFarmer(Farmer farmer) {
		String farmerType = farmer.getType();
		FarmerFactory ff = (FarmerFactory) fp.getFactory("Farmer");
		switch (farmerType) {
		case "Breeder":
			transferFarmer(farmer);
			BreederDecorator bd = new BreederDecorator((FarmerFactory) ff);
			farmer = bd.create(farmerType);
			farmerList.add(farmer);
			break;
		case "FarmWorker":
			transferFarmer(farmer);
			FarmWorkerDecorator fwd = new FarmWorkerDecorator((FarmerFactory) ff);
			farmer = fwd.create(farmerType);
			farmerList.add(farmer);
			break;
		case "Harvester":
			transferFarmer(farmer);
			HarvesterDecorator hd = new HarvesterDecorator((FarmerFactory) ff);
			farmer = hd.create(farmerType);
			farmerList.add(farmer);
			break;
		case "Horticulturist":
			transferFarmer(farmer);
			HorticulturistDecorator hod = new HorticulturistDecorator((FarmerFactory) ff);
			farmer = hod.create(farmerType);
			farmerList.add(farmer);
			break;
		case "Owner":
			transferFarmer(farmer);
			OwnerDecorator od = new OwnerDecorator((FarmerFactory) ff);
			farmer = od.create(farmerType);
			farmerList.add(farmer);
			break;
		case "Veterinarian":
			transferFarmer(farmer);
			VeterinarianDecorator vd = new VeterinarianDecorator((FarmerFactory) ff);
			farmer = vd.create(farmerType);
			farmerList.add(farmer);
			break;
		default:
			System.out.println("No employees of that type to promote!");
		}
	}

	@Override
	public Farmer transferFarmer(Farmer farmer) {
		farmerList.remove(farmer);
		return farmer;
	}

	@Override
	public void expandFarm(int acres) {
		this.acres += acres;
		//transaction(-pricePerAcre);
	}

	@Override
	public void calcStats() {
		for(Farmer farmer : farmerList) {
			this.businessSkill += farmer.getBusinessSkill();
			this.farmWorkerSkill += farmer.getFarmWorkerSkill();
			this.harvesterSkill += farmer.getHarvesterSkill();
			this.breederSkill += farmer.getBreederSkill();
			this.horticultureSkill += farmer.getHorticultureSkill();
			this.veterinarianSkill += farmer.getVeterinarianSkill();
		}				
	}

	@Override
	public ArrayList<Farmer> getFarmers() {
		return farmerList;
	}

	@Override
	public ArrayList<Animal> getAnimals() {
		return animalList;
	}
	
	@Override
	public ArrayList<Crop> getCrops() {
		return null;
	}

	@Override
	public void buy(int price) {
		money -= price;
	}

	@Override
	public void sell(int price) {
		money += price;
	}

	@Override
	public int levelUp() {
		if(this.money >= 25000 && this.money < 50000) {
			this.level = 2;
		}
		else if(this.money >= 50000 && this.money < 100000) {
			this.level = 3;
		}
		else if(this.money >= 100000 && this.money < 200000) {
			this.level = 4;
		}
		else if(this.money >= 200000) {
			this.level = 5;
		}
		return level;
	}

}
