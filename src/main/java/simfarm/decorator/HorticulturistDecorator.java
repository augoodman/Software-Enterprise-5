package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Horticulturist;

public class HorticulturistDecorator extends FarmerDecorator {
	private Random r = new Random();
	private int businessSkill = r.nextInt(20) + 20;
	private int farmWorkerSkill = r.nextInt(20) + 20;
	private int harvesterSkill = r.nextInt(20) + 20;
	private int breederSkill = r.nextInt(20) + 20;
	private int horticultureSkill = 100;
	private int veterinarianSkill = r.nextInt(20) + 20;
	
	public HorticulturistDecorator(FarmerFactory farmerFactory) {
		super(farmerFactory);
	}
	
	@Override
	public Farmer create(String t) {
        return new Horticulturist(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill, horticultureSkill, veterinarianSkill);
	}
}
