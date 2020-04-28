package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.FarmWorker;
import main.java.simfarm.farmer.Farmer;

public class FarmWorkerDecorator extends FarmerDecorator {
    private Random random = new Random();
    private int businessSkill = random.nextInt(20) + 20;
    private int farmWorkerSkill = 100;
    private int harvesterSkill = random.nextInt(20) + 20;
    private int breederSkill = random.nextInt(20) + 20;
    private int horticultureSkill = random.nextInt(20) + 20;
    private int veterinarianSkill = random.nextInt(20) + 20;

    public FarmWorkerDecorator(FarmerFactory farmerFactory) {
        super(farmerFactory);
    }

    @Override
    public Farmer create(String t) {
        return new FarmWorker(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill,
                horticultureSkill, veterinarianSkill);
    }
}
