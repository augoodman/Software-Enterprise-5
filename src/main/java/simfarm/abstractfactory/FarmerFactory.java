package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.farmer.Breeder;
import main.java.simfarm.farmer.FarmWorker;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.farmer.Harvester;
import main.java.simfarm.farmer.Horticulturist;
import main.java.simfarm.farmer.Owner;
import main.java.simfarm.farmer.Veterinarian;

public class FarmerFactory implements AbstractFactory<Farmer> {
    private Random random = new Random();
    private int businessSkill = random.nextInt(20);
    private int farmWorkerSkill = random.nextInt(20);
    private int harvesterSkill = random.nextInt(20);
    private int breederSkill = random.nextInt(20);
    private int horticultureSkill = random.nextInt(20);
    private int veterinarianSkill = random.nextInt(20);

    @Override
    public Farmer create(String t) {
        if ("Breeder".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Breeder(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill + 80,
                    horticultureSkill, veterinarianSkill);
        } else if ("FarmWorker".equalsIgnoreCase(t)) {
            rollNewStats();
            return new FarmWorker(businessSkill, farmWorkerSkill + 80, harvesterSkill, breederSkill,
                    horticultureSkill, veterinarianSkill);
        } else if ("Harvester".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Harvester(businessSkill, farmWorkerSkill, harvesterSkill + 80, breederSkill,
                    horticultureSkill, veterinarianSkill);
        } else if ("Horticulturist".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Horticulturist(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill,
                    horticultureSkill + 80, veterinarianSkill);
        } else if ("Owner".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Owner(businessSkill + 80, farmWorkerSkill, harvesterSkill, breederSkill,
                    horticultureSkill, veterinarianSkill);
        } else {
            rollNewStats();
            return new Veterinarian(businessSkill, farmWorkerSkill, harvesterSkill, breederSkill,
                    horticultureSkill, veterinarianSkill + 80);
        }

    }

    private void rollNewStats() {
        this.businessSkill = random.nextInt(20);
        this.farmWorkerSkill = random.nextInt(20);
        this.harvesterSkill = random.nextInt(20);
        this.breederSkill = random.nextInt(20);
        this.horticultureSkill = random.nextInt(20);
        this.veterinarianSkill = random.nextInt(20);
    }
}
