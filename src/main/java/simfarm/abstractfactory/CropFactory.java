package main.java.simfarm.abstractfactory;

import java.util.Random;

import main.java.simfarm.crop.*;

public class CropFactory implements AbstractFactory<Crop> {
	private Random r = new Random();
	private int size = r.nextInt(100);
	private int diseaseResistance = r.nextInt(100);
	
	@Override
	public Crop create(String t) {
	    if ("Barley".equalsIgnoreCase(t)) {
	    	rollNewStats();
	    	return new Barley(size, diseaseResistance);
	    } 
	    
	    else if ("Corn".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Corn(size, diseaseResistance);
	    }
	    
	    else if ("Peanut".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Peanut(size, diseaseResistance);
	    }   
	    
	    else if ("Potato".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Potato(size, diseaseResistance);
	    }     
	    
	    else if ("Rice".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Rice(size, diseaseResistance);
	    }   
	    
	    else if ("Soybean".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Soybean(size, diseaseResistance);
	    }
	    
	    else if ("Tomato".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Tomato(size, diseaseResistance);
	    }   
	    
	    else if ("Wheat".equalsIgnoreCase(t)) {
	    	rollNewStats();
	        return new Wheat(size, diseaseResistance);
	    }

	    return null;
	}

	private void rollNewStats() {
    	this.size = r.nextInt(100);
    	this.diseaseResistance = r.nextInt(100);
	}
}
