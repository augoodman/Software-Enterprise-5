package main.java.simfarm;

import java.util.ArrayList;
import java.util.Random;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.farm.Farm;
import main.java.simfarm.farmer.Farmer;
import main.java.simfarm.mediator.AbstractSimFarm;
import main.java.simfarm.mediator.ConcreteMediator;
import main.java.simfarm.mediator.ConcreteSimFarm;
import main.java.simfarm.mediator.MediatorInterface;
import main.java.simfarm.simulation.ManageLand;

public class Main {
    public static void main(String[] args) {
        AbstractFactory<Farm> f = FactoryProvider.getFactory("Farm");
        ArrayList<Farm> farmList = new ArrayList<Farm>();
        System.out.println("Welcome to SimFarm. Please see the README for simulation details.");
        System.out.println("How many farms would you like to simulate?");
        Random random = new Random();
        int farmType = random.nextInt(3);
        switch (farmType) {
            case 0:
                Farm af = f.create("AnimalFarm");
                farmList.add(af);
                break;
            case 1:
                Farm cf = f.create("CropFarm");
                farmList.add(cf);
                break;
            default:
                Farm hf = f.create("HybridFarm");
                farmList.add(hf);
        }
        for (Farm farm : farmList) {
            MediatorInterface mediator = new ConcreteMediator();
            AbstractSimFarm simFarm = new ConcreteSimFarm(mediator, farm);
            mediator.addAsf(simFarm);
            farm.calcStats();
            ManageLand ml = new ManageLand();
            ConcreteSimFarm csf = new ConcreteSimFarm(mediator, farm);
            String msg = newFarmMsg(farm);
            simFarm.send(msg);
            csf.simulate(farm, simFarm, ml);
        }
    }

    private static String newFarmMsg(Farm farm) {
        String msg = (farm.getType() + " simulation\nLevel: " + (farm.getLevel() + 1) + "\nCash: $"
                + farm.getMoney() + "\nSize: " + farm.getAcres()
                + " acres\n\nStarting Employees:\n");
        for (Farmer farmer : farm.getFarmers()) {
            msg = msg.concat(farmer.getType() + "\n");
        }
        if (farm.getType() != "CropFarm") {
            msg = msg.concat("\nStarting Animals:\nChickens: 2\nCows: "
                    + "2\nGoats: 2\nHorses: 2\nPigs: 2\nSheep: 2\n");
        }
        if (farm.getType() != "AnimalFarm") {
            msg = msg.concat("\nStarting Crops:\nBarley: 10\nCorn: 10\nPeanut: 10\nPotato:"
                    + " 10\nRice: 10\nSoybean: 10\nTomato: 10\nWheat: 10\n");
        }
        return msg;
    }

}
