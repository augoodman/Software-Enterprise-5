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
	private int veterinarianSkill = r.nextInt(20);

	@Override
	public Farmer create(String t) {
        if ("Breeder".equalsIgnoreCase(t)) {
	    	rollNewStats();
            return new Breeder(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill + 80, horticultureSkill, veterinarianSkill);
        } 
        
        else if ("FarmWorker".equalsIgnoreCase(t)) {
	    	rollNewStats();
            return new FarmWorker(businessSkill, farmWorkerSkill + 80, harvesterSkill, breederSkill, horticultureSkill, veterinarianSkill);
        }
        
        else if ("Harvester".equalsIgnoreCase(t)) {
	    	rollNewStats();
            return new Harvester(businessSkill, farmWorkerSkill, harvesterSkill + 80, breederSkill, horticultureSkill, veterinarianSkill);
        }   
        
        else if ("Horticulturist".equalsIgnoreCase(t)) {
	    	rollNewStats();
            return new Horticulturist(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill + 80, veterinarianSkill);
        }     
        
        else if ("Owner".equalsIgnoreCase(t)) {
	    	rollNewStats();
            return new Owner(businessSkill + 80, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarianSkill);
        }   
        
        else if ("Veterinarian".equalsIgnoreCase(t)) {
	    	rollNewStats();
            return new Veterinarian(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarianSkill + 80);
        }

        return null;
	}

	private void rollNewStats() {
    	this.businessSkill = r.nextInt(20);
    	this.farmWorkerSkill = r.nextInt(20);
    	this.harvesterSkill = r.nextInt(20);
    	this.breederSkill = r.nextInt(20);
    	this.horticultureSkill = r.nextInt(20);
    	this.veterinarianSkill = r.nextInt(20);
	}
}
