package main.java.simfarm;

import java.util.ArrayList;

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
		Animal c = af2.create("Cow");
		System.out.println(c);
		Crop w = af3.create("Wheat");
		System.out.println(w);
		Farm hf = af4.create("HybridFarm");
		System.out.println(hf);
		FarmWorkerDecorator fd = new FarmWorkerDecorator((FarmerFactory) af1);
		Farmer f2 = fd.create("FarmWorker");
		System.out.println(f2);
		HarvesterDecorator hd = new HarvesterDecorator((FarmerFactory) af1);
		Farmer h2 = hd.create("Harvester");
		System.out.println(h2);
		HorticulturistDecorator hod = new HorticulturistDecorator((FarmerFactory) af1);
		Farmer ho2 = hod.create("Horticulturist");
		System.out.println(ho2);
		OwnerDecorator od = new OwnerDecorator((FarmerFactory) af1);
		Farmer o2 = od.create("Owner");
		System.out.println(o2);
		VeterinarianDecorator vd = new VeterinarianDecorator((FarmerFactory) af1);
		Farmer v2 = vd.create("Veterinarian");
		System.out.println(v2);
		VeterinarianDecorator vd2 = new VeterinarianDecorator((FarmerFactory) af1);
		v2 = vd2.create("Veterinarian");
		System.out.println(v2);
		BreederDecorator bd = new BreederDecorator((FarmerFactory) af1);
		Farmer b2 = bd.create("Breeder");
		System.out.println(b2);
		Farmer b = af1.create("Breeder");
		System.out.println(b);
		BreederDecorator bd2 = new BreederDecorator((FarmerFactory) af1);
		b = bd2.create("Breeder");
		System.out.println(b);
		ArrayList<Farm> farmList = new ArrayList<Farm>();
		farmList.add(hf);
		SimFarm.simulate(farmList);
	}
}
