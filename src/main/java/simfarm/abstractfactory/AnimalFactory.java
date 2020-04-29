package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.animal.Animal;
import main.java.simfarm.animal.Chicken;
import main.java.simfarm.animal.Cow;
import main.java.simfarm.animal.Goat;
import main.java.simfarm.animal.Horse;
import main.java.simfarm.animal.Pig;
import main.java.simfarm.animal.Sheep;

public class AnimalFactory implements AbstractFactory<Animal> {
    private Random random = new Random();
    private int diseaseResistance;
    private int breedability;
    private int aggression;

    @Override
    public Animal create(String t) {
        if ("Chicken".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Chicken(diseaseResistance, breedability, aggression);
        } else if ("Cow".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Cow(diseaseResistance, breedability, aggression);
        } else if ("Goat".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Goat(diseaseResistance, breedability, aggression);
        } else if ("Horse".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Horse(diseaseResistance, breedability, aggression);
        } else if ("Pig".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Pig(diseaseResistance, breedability, aggression);
        } else {
            rollNewStats();
            return new Sheep(diseaseResistance, breedability, aggression);
        }

    }

    private void rollNewStats() {
        this.diseaseResistance = random.nextInt(100);
        this.breedability = random.nextInt(100);
        this.aggression = random.nextInt(100);
    }

}
