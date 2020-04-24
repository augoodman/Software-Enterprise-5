package main.java.simfarm.decorator;

import main.java.simfarm.abstractfactory.FarmerFactory;

public abstract class FarmerDecorator implements DecoratorInterface{
	protected FarmerFactory farmerFactory;
	
	public FarmerDecorator(FarmerFactory farmerFactory) {
		this.farmerFactory = farmerFactory;
	}

}