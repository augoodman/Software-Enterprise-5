package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Breeder;
import main.java.simfarm.farmer.FarmWorker;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Harvester;
import main.java.simfarm.farmer.Horticulturist;
import main.java.simfarm.farmer.Owner;
import main.java.simfarm.farmer.Veterinary;

public abstract class FarmerDecorator implements DecoratorInterface{
	protected FarmerFactory farmerFactory;
	private Random r = new Random();
	private int businessSkill = r.nextInt(20) + 20;
	private int farmWorkerSkill = r.nextInt(20) + 20;
	private int harvesterSkill = r.nextInt(20) + 20;
	private int breederSkill = r.nextInt(20) + 20;
	private int horticultureSkill = r.nextInt(20) + 20;
	private int veterinarySkill = r.nextInt(20) + 20;
	
	public FarmerDecorator(FarmerFactory farmerFactory) {
		this.farmerFactory = farmerFactory;
	}

	public Farmer create(String t) {
        if ("Breeder".equalsIgnoreCase(t)) {
            return new Breeder(businessSkill, farmWorkerSkill, harvesterSkill, 100, horticultureSkill, veterinarySkill);
        } 
        
        else if ("FarmWorker".equalsIgnoreCase(t)) {
            return new FarmWorker(businessSkill, 100, harvesterSkill, breederSkill, horticultureSkill, veterinarySkill);
        }
        
        else if ("Harvester".equalsIgnoreCase(t)) {
            return new Harvester(businessSkill, farmWorkerSkill, 100, breederSkill, horticultureSkill, veterinarySkill);
        }   
        
        else if ("Horticulturist".equalsIgnoreCase(t)) {
            return new Horticulturist(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, 100, veterinarySkill);
        }     
        
        else if ("Owner".equalsIgnoreCase(t)) {
            return new Owner(100, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarySkill);
        }   
        
        else if ("Veterinary".equalsIgnoreCase(t)) {
            return new Veterinary(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, 100);
        }
        
        return null;
	}
	
}