package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.animal.*;

public class AnimalFactory implements AbstractFactory<Animal> {
	private Random r = new Random();
	private int size;
	private int diseaseResistance;
	private int breedability;
	private int aggression;
	
	@Override
	public Animal create(String t) {
        if ("Chicken".equalsIgnoreCase(t)) {
        	rollNewStats();
            return new Chicken(size, diseaseResistance, breedability, aggression);
        } 
        
        else if ("Cow".equalsIgnoreCase(t)) {
        	rollNewStats();
            return new Cow(size, diseaseResistance, breedability, aggression);
        }
        
        else if ("Goat".equalsIgnoreCase(t)) {
        	rollNewStats();
            return new Goat(size, diseaseResistance, breedability, aggression);
        }   
        
        else if ("Horse".equalsIgnoreCase(t)) {
        	rollNewStats();
            return new Horse(size, diseaseResistance, breedability, aggression);
        }     
        
        else if ("Pig".equalsIgnoreCase(t)) {
        	rollNewStats();
            return new Pig(size, diseaseResistance, breedability, aggression);
        }   
        
        else if ("Sheep".equalsIgnoreCase(t)) {
        	rollNewStats();
            return new Sheep(size, diseaseResistance, breedability, aggression);
        }

        return null;
	}

	private void rollNewStats() {
    	this.size = r.nextInt(100);
    	this.diseaseResistance = r.nextInt(100);
    	this.breedability = r.nextInt(100);
    	this.aggression = r.nextInt(100);		
	}

}
