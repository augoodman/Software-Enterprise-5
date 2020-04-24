package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.animal.*;

public class AnimalFactory implements AbstractFactory<Animal> {
	private Random r = new Random();
	private int size = r.nextInt(100);
	private int diseaseResistance = r.nextInt(100);
	private int breedability = r.nextInt(100);
	private int aggression = r.nextInt(100);

	@Override
	public Animal create(String t) {
        if ("Chicken".equalsIgnoreCase(t)) {
            return new Chicken(size, diseaseResistance, breedability, aggression);
        } 
        
        else if ("Cow".equalsIgnoreCase(t)) {
            return new Cow(size, diseaseResistance, breedability, aggression);
        }
        
        else if ("Goat".equalsIgnoreCase(t)) {
            return new Cow(size, diseaseResistance, breedability, aggression);
        }   
        
        else if ("Horse".equalsIgnoreCase(t)) {
            return new Cow(size, diseaseResistance, breedability, aggression);
        }     
        
        else if ("Pig".equalsIgnoreCase(t)) {
            return new Cow(size, diseaseResistance, breedability, aggression);
        }   
        
        else if ("Sheep".equalsIgnoreCase(t)) {
            return new Cow(size, diseaseResistance, breedability, aggression);
        }
        
        return null;
	}

}
