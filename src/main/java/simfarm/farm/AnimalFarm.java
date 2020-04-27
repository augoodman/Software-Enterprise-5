package main.java.simfarm.farm;

import java.util.ArrayList;

import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.decorator.BreederDecorator;
import main.java.simfarm.decorator.FarmWorkerDecorator;
import main.java.simfarm.decorator.HarvesterDecorator;
import main.java.simfarm.decorator.HorticulturistDecorator;
import main.java.simfarm.decorator.OwnerDecorator;
import main.java.simfarm.decorator.VeterinarianDecorator;
import main.java.simfarm.farmer.Breeder;
import main.java.simfarm.farmer.FarmWorker;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Harvester;
import main.java.simfarm.farmer.Horticulturist;
import main.java.simfarm.farmer.Owner;
import main.java.simfarm.farmer.Veterinarian;

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
	private ArrayList<Farmer> farmerList = new ArrayList<Farmer>();
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public AnimalFarm() {
		this.level = 0;
		this.money = 1000;
		this.acres = 5;
		farmerList.add((Owner) fp.getFactory("Farmer").create("Owner"));
		farmerList.add((Breeder) fp.getFactory("Farmer").create("Breeder"));
		farmerList.add((FarmWorker) fp.getFactory("Farmer").create("FarmWorker"));
		farmerList.add((Veterinarian) fp.getFactory("Farmer").create("Veterinarian"));
		this.numFarmers = 4;
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
		this.money += price;
	}

	@Override
	public void sell(int price) {
		this.money -= price;
	}
	
	public void buyAnimal(Animal animal, int num) {
		for (int i = 0; i < num; i++) {
			Animal a = (Animal) fp.getFactory("Crop").create(animal.getType());
			animalList.add(a);
			animal.animalExchanged("bought");
		}
	}

	public void sellAnimal(Animal animal, int num) {
		for(int i = 0; i < num; i++) {
			animalList.remove(animal);
			animal.animalExchanged("sold");
		}
	}
	
}
