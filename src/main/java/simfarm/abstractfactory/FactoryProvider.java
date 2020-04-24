package main.java.simfarm.abstractfactory;

public class FactoryProvider {
	public static AbstractFactory getFactory(String t) {
		
        if("Farm".equalsIgnoreCase(t)) {
            return new FarmFactory();
        }
        
        else if("Farmer".equalsIgnoreCase(t)) {
            return new FarmerFactory();
        }   
                 
        else if("Animal".equalsIgnoreCase(t)) {
            return new AnimalFactory();
        }
        
        else if("Crop".equalsIgnoreCase(t)) {
        	return new CropFactory();
        }

        return null;	}
}
