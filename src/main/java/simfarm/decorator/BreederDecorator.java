package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Breeder;
import main.java.simfarm.farmer.Farmer;

public class BreederDecorator extends FarmerDecorator {
    private Random random = new Random();
    private int businessSkill = random.nextInt(20) + 20;
    private int farmWorkerSkill = random.nextInt(20) + 20;
    private int harvesterSkill = random.nextInt(20) + 20;
    private int breederSkill = 100;
    private int horticultureSkill = random.nextInt(20) + 20;
    private int veterinarianSkill = random.nextInt(20) + 20;

    public BreederDecorator(FarmerFactory farmerFactory) {
        super(farmerFactory);
    }

    @Override
    public Farmer create(String t) {
        return new Breeder(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill,
                horticultureSkill, veterinarianSkill);
    }
}
