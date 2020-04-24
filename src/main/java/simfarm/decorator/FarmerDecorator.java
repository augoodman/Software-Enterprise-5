package main.java.simfarm.decorator;

import main.java.simfarm.abstractfactory.FarmerFactory;
import main.java.simfarm.farmer.Farmer;

public abstract class FarmerDecorator implements DecoratorInterface<Farmer>{
	//protected FarmerFactory farmerFactory;
	
	public FarmerDecorator(FarmerFactory farmerFactory) {
		//this.farmerFactory = farmerFactory;
	}

}