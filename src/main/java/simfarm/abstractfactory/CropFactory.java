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
	        return new Barley(size, diseaseResistance);
	    } 
	    
	    else if ("Corn".equalsIgnoreCase(t)) {
	        return new Corn(size, diseaseResistance);
	    }
	    
	    else if ("Peanut".equalsIgnoreCase(t)) {
	        return new Peanut(size, diseaseResistance);
	    }   
	    
	    else if ("Potato".equalsIgnoreCase(t)) {
	        return new Potato(size, diseaseResistance);
	    }     
	    
	    else if ("Rice".equalsIgnoreCase(t)) {
	        return new Rice(size, diseaseResistance);
	    }   
	    
	    else if ("Soybean".equalsIgnoreCase(t)) {
	        return new Soybean(size, diseaseResistance);
	    }
	    
	    else if ("Tomato".equalsIgnoreCase(t)) {
	        return new Tomato(size, diseaseResistance);
	    }   
	    
	    else if ("Wheat".equalsIgnoreCase(t)) {
	        return new Wheat(size, diseaseResistance);
	    }
	    
	    return null;
	}
}
