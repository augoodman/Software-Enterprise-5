package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Owner;

public class OwnerDecorator extends FarmerDecorator {
    private Random random = new Random();
    private int businessSkill = 100;
    private int farmWorkerSkill = random.nextInt(20) + 20;
    private int harvesterSkill = random.nextInt(20) + 20;
    private int breederSkill = random.nextInt(20) + 20;
    private int horticultureSkill = random.nextInt(20) + 20;
    private int veterinarianSkill = random.nextInt(20) + 20;

    public OwnerDecorator(FarmerFactory farmerFactory) {
        super(farmerFactory);
    }

    @Override
    public Farmer create(String t) {
        return new Owner(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill,
                horticultureSkill, veterinarianSkill);
    }
}
