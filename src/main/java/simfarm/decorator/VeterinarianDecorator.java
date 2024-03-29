package main.java.simfarm.decorator;

import java.util.Random;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Veterinarian;

public class VeterinarianDecorator extends FarmerDecorator {
    private Random random = new Random();
    private int businessSkill = random.nextInt(20) + 20;
    private int farmWorkerSkill = random.nextInt(20) + 20;
    private int harvesterSkill = random.nextInt(20) + 20;
    private int breederSkill = random.nextInt(20) + 20;
    private int horticultureSkill = random.nextInt(20) + 20;
    private int veterinarianSkill = 100;

    public VeterinarianDecorator(FarmerFactory farmerFactory) {
        super(farmerFactory);
    }

    @Override
    public Farmer create(String t) {
        return new Veterinarian(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill,
                horticultureSkill, veterinarianSkill);
    }
}
