package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.crop.Barley;
import main.java.simfarm.crop.Corn;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.crop.Peanut;
import main.java.simfarm.crop.Potato;
import main.java.simfarm.crop.Rice;
import main.java.simfarm.crop.Soybean;
import main.java.simfarm.crop.Tomato;
import main.java.simfarm.crop.Wheat;

public class CropFactory implements AbstractFactory<Crop> {
    private Random random = new Random();
    private int diseaseResistance = random.nextInt(100);

    @Override
    public Crop create(String t) {
        if ("Barley".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Barley(diseaseResistance);
        } else if ("Corn".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Corn(diseaseResistance);
        } else if ("Peanut".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Peanut(diseaseResistance);
        } else if ("Potato".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Potato(diseaseResistance);
        } else if ("Rice".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Rice(diseaseResistance);
        } else if ("Soybean".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Soybean(diseaseResistance);
        } else if ("Tomato".equalsIgnoreCase(t)) {
            rollNewStats();
            return new Tomato(diseaseResistance);
        } else {
            rollNewStats();
            return new Wheat(diseaseResistance);
        }

    }

    private void rollNewStats() {
        this.diseaseResistance = random.nextInt(100);
    }
}
