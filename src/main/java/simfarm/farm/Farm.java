package main.java.simfarm.farm;

import java.util.ArrayList;

import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farmer.Farmer;

public abstract class Farm {
	//getters for farm type, level, money, employees, and size
	public abstract int getLevel();
	public abstract int getMoney();
	public abstract int getNumFarmers();
	public abstract int getAcres();
	public abstract int getBusinessSkill();
	public abstract int getFarmWorkerSkill();
	public abstract int getHarvesterSkill();
	public abstract int getBreederSkill();
	public abstract int getHorticultureSkill();
	public abstract int getVeterinarianSkill();
	public abstract String getType();
	public abstract ArrayList<Farmer> getFarmers();
	public abstract ArrayList<Animal> getAnimals();
	public abstract ArrayList<Crop> getCrops();
	public abstract void buy(int price);
	public abstract void sell(int price);

	//change farm name
	public abstract void setType(String name);
	
	//increase(+)/decrease(-) farm money
	public abstract void transaction(int dollars);
	
	//manage farmers
	public abstract void hireFarmer(String farmerType);
	public abstract void promoteFarmer(Farmer farmer);
	public abstract Farmer transferFarmer(Farmer farmer);
	
	//increase farm size
	public abstract void expandFarm(int acres);
	
	//calculate farm stats
	public abstract void calcStats();
	
	@Override
    public String toString(){
        return "Level = " + this.getLevel() + ", Money = " + this.getMoney() + ", Employees = " + this.getNumFarmers() + ", Size = " + this.getAcres();
    }
}
