package main.java.simfarm;

import java.util.ArrayList;

import main.java.simfarm.farm.Farm;
import main.java.simfarm.mediator.*;

public class SimFarm {
	static MediatorInterface mediator = new ConcreteMediator();
	
	public static void simulate(ArrayList<Farm> farmList) {
		for(Farm farm : farmList) {
			AbstractSimFarm simFarm = new ConcreteSimFarm(mediator, farm);
			mediator.addAsf(simFarm);
			boolean bankrupt = false;
			int cycle = 1;
			while (!bankrupt) {
				simFarm.send(("Day " + cycle + ":   $" + farm.getMoney() + " remaining."), farm);
				simFarm.send(("Night " + cycle + ": $" + farm.getMoney() + " remaining."), farm);
				farm.spendMoney(100);
				cycle++;
				if(farm.getMoney() <= 0) {
					bankrupt = true;
				}
			}
			System.out.println("GAME OVER YEEEEEAH!");
		}
	}

}