package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Harvester;

public class HarvesterDecorator extends FarmerDecorator {
	private Random r = new Random();
	private int businessSkill = r.nextInt(20) + 20;
	private int farmWorkerSkill = r.nextInt(20) + 20;
	private int harvesterSkill = 100;
	private int breederSkill = r.nextInt(20) + 20;
	private int horticultureSkill = r.nextInt(20) + 20;
	private int veterinarianSkill = r.nextInt(20) + 20;
	
	public HarvesterDecorator(FarmerFactory farmerFactory) {
		super(farmerFactory);
	}
	
	@Override
	public Farmer create(String t) {
        return new Harvester(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarianSkill);
	}
}