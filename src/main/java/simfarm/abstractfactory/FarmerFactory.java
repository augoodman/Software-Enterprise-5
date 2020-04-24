package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.farmer.*;

public class FarmerFactory implements AbstractFactory<Farmer> {
	private Random r = new Random();
	private int businessSkill = r.nextInt(20);
	private int farmWorkerSkill = r.nextInt(20);
	private int harvesterSkill = r.nextInt(20);
	private int breederSkill = r.nextInt(20);
	private int horticultureSkill = r.nextInt(20);
	private int veterinarySkill = r.nextInt(20);

	@Override
	public Farmer create(String t) {
        if ("Breeder".equalsIgnoreCase(t)) {
            return new Breeder(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill + 80, horticultureSkill, veterinarySkill);
        } 
        
        else if ("FarmWorker".equalsIgnoreCase(t)) {
            return new FarmWorker(businessSkill, farmWorkerSkill + 80, harvesterSkill, breederSkill, horticultureSkill, veterinarySkill);
        }
        
        else if ("Harvester".equalsIgnoreCase(t)) {
            return new Harvester(businessSkill, farmWorkerSkill, harvesterSkill + 80, breederSkill, horticultureSkill, veterinarySkill);
        }   
        
        else if ("Horticulturist".equalsIgnoreCase(t)) {
            return new Horticulturist(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill + 80, veterinarySkill);
        }     
        
        else if ("Owner".equalsIgnoreCase(t)) {
            return new Owner(businessSkill + 80, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarySkill);
        }   
        
        else if ("Veterinary".equalsIgnoreCase(t)) {
            return new Veterinary(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarySkill + 80);
        }
        
        return null;
	}

}
