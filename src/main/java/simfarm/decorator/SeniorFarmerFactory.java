package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.*;

public abstract class SeniorFarmerFactory implements DecoratorInterface {
	private Random r = new Random();
	private int businessSkill = r.nextInt(20) + 20;
	private int farmWorkerSkill = r.nextInt(20) + 20;
	private int harvesterSkill = r.nextInt(20) + 20;
	private int breederSkill = r.nextInt(20) + 20;
	private int horticultureSkill = r.nextInt(20) + 20;
	private int veterinarySkill = r.nextInt(20) + 20;
	
	@Override
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
