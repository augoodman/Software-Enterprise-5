package main.java.simfarm.abstractfactory;

import main.java.simfarm.farm.*;

public class FarmFactory implements AbstractFactory<Farm> {

	@Override
	public Farm create(String t) {
        if ("AnimalFarm".equalsIgnoreCase(t)) {
            return new AnimalFarm();
        } 
        
        else if ("CropFarm".equalsIgnoreCase(t)) {
            return new CropFarm();
        }
        
        else if ("HybridFarm".equalsIgnoreCase(t)) {
            return new HybridFarm();
        }   

        return null;
	}

}
