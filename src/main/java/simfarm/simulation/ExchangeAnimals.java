package main.java.simfarm.simulation;

import java.util.ArrayList;
import java.util.Random;

import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.farm.Farm;

public class ExchangeAnimals {
    /**
     * buys new animals for the farm.
     * 
     * @param farm farm object for which animals will be bought
     * @param af   animal factory to build animals
     */
    public void buyAnimals(Farm farm, AnimalFactory af) {
        Random r = new Random();
        int animalToBuy = r.nextInt(6);
        switch (animalToBuy) {
            case 0:
                if (farm.getMoney() > 100) {
                    farm.getAnimals().add(af.create("Chicken"));
                    farm.buy(100);
                    for (Animal animal : farm.getAnimals()) {
                        if (animal.getType() == "Chicken" && animal.getAge() == 0) {
                            animal.setAge(3);
                            break;
                        }
                    }
                }
                break;
            case 1:
                if (farm.getMoney() > 750) {
                    farm.getAnimals().add(af.create("Cow"));
                    farm.buy(750);
                    for (Animal animal : farm.getAnimals()) {
                        if (animal.getType() == "Chicken" && animal.getAge() == 0) {
                            animal.setAge(3);
                            break;
                        }
                    }
                }
                break;
            case 2:
                if (farm.getMoney() > 500) {
                    farm.getAnimals().add(af.create("Goat"));
                    farm.buy(500);
                    for (Animal animal : farm.getAnimals()) {
                        if (animal.getType() == "Chicken" && animal.getAge() == 0) {
                            animal.setAge(3);
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (farm.getMoney() > 2000) {
                    farm.getAnimals().add(af.create("Horse"));
                    farm.buy(2000);
                    for (Animal animal : farm.getAnimals()) {
                        if (animal.getType() == "Chicken" && animal.getAge() == 0) {
                            animal.setAge(3);
                            break;
                        }
                    }
                }
                break;
            case 4:
                if (farm.getMoney() > 250) {
                    farm.getAnimals().add(af.create("Pig"));
                    farm.buy(250);
                    for (Animal animal : farm.getAnimals()) {
                        if (animal.getType() == "Chicken" && animal.getAge() == 0) {
                            animal.setAge(3);
                            break;
                        }
                    }
                }
                break;
            default:
                if (farm.getMoney() > 500) {
                    farm.getAnimals().add(af.create("Sheep"));
                    farm.buy(500);
                    for (Animal animal : farm.getAnimals()) {
                        if (animal.getType() == "Chicken" && animal.getAge() == 0) {
                            animal.setAge(3);
                            break;
                        }
                    }
                }
        }
    }

    /**
     * sells animals from a farm.
     * 
     * @param farm farm object from which to sell animals
     */
    public void sellAnimals(Farm farm) {
        int runningTotal = 0;
        int productDailyLimit = farm.getBusinessSkill() / 5;
        int productSold = 0;
        ArrayList<Animal> animalsToRemove = new ArrayList<Animal>();
        int slaughterDailyLimit = farm.getBusinessSkill() / 10;
        int numSlaughtered = 0;

        for (Animal animal : farm.getAnimals()) {
            if (animal.getProductAge() >= 2) {
                switch (animal.getType()) {
                    case "Chicken":
                        // sell eggs
                        if (productSold >= productDailyLimit) {
                            break;
                        }
                        runningTotal += 20;
                        productSold++;
                        animal.resetProductClock();
                        break;
                    case "Goat":
                        // sell goat milk
                        if (productSold >= productDailyLimit) {
                            break;
                        }
                        runningTotal += 100;
                        productSold++;
                        animal.resetProductClock();
                        break;
                    default:
                        // sell sheep wool
                        if (animal.getType().equalsIgnoreCase("Sheep")) {
                            if (productSold >= productDailyLimit) {
                                break;
                            }
                            runningTotal += 200;
                            productSold++;
                            animal.resetProductClock();
                        }
                }
            }
        }

        for (Animal animal : farm.getAnimals()) {
            if (animal.getProductAge() >= 3) {
                switch (animal.getType()) {
                    case "Cow":
                        // slaughter cow and sell beef
                        if (numSlaughtered >= slaughterDailyLimit) {
                            break;
                        }
                        animalsToRemove.add(animal);
                        runningTotal += 3000;
                        numSlaughtered++;
                        break;
                    case "Horse":
                        // sell horse for labor/racing (not slaughterd ;D)
                        if (numSlaughtered >= slaughterDailyLimit) {
                            break;
                        }
                        animalsToRemove.add(animal);
                        runningTotal += 6000;
                        numSlaughtered++;

                        break;
                    default:
                        // slaughter pig and sell pork
                        if (numSlaughtered >= slaughterDailyLimit) {
                            break;
                        }
                        animalsToRemove.add(animal);
                        runningTotal += 2000;
                        numSlaughtered++;
                }
            }
        }

        for (Animal animal : animalsToRemove) {
            farm.getAnimals().remove(animal);
        }

        // bonus sales price based on breeder skill
        double bonus = (double) farm.getBreederSkill() / 10000;
        if (bonus > .5) {
            bonus = .5;
        }
        int discount = (int) ((double) runningTotal * bonus);
        farm.sell(runningTotal - discount);
    }
}