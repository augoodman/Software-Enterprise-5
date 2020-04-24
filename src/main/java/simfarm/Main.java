package main.java.simfarm;

import main.java.simfarm.abstractfactory.*;
import main.java.simfarm.animal.*;
import main.java.simfarm.crop.*;
import main.java.simfarm.decorator.*;
import main.java.simfarm.farm.*;
import main.java.simfarm.farmer.*;

public class Main {
	public static void main(String[] args) {
		AbstractFactory<Farmer> af1 = FactoryProvider.getFactory("Farmer");
		AbstractFactory<Animal> af2 = FactoryProvider.getFactory("Animal");
		AbstractFactory<Crop> af3 = FactoryProvider.getFactory("Crop");
		AbstractFactory<Farm> af4 = FactoryProvider.getFactory("Farm");
		Farmer b = af1.create("Breeder");
		System.out.println(b);
		Animal c = af2.create("Cow");
		System.out.println(c);
		Crop w = af3.create("Wheat");
		System.out.println(w);
		Farm fr = af4.create("HybridFarm");
		System.out.println(fr);
		BreederDecorator bd = new BreederDecorator((FarmerFactory) af1);
		Farmer b2 = bd.create("Breeder");
		System.out.println(b2);
	}
}
