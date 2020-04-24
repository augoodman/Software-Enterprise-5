package main.java.simfarm.mediator;

import main.java.simfarm.farm.Farm;

public class ConcreteSimFarm extends AbstractSimFarm {

	public ConcreteSimFarm(MediatorInterface mediator, Farm farm) {
		super(mediator, farm);
	}

	@Override
	public void send(String msg, Farm farm) {
        System.out.println(this.getFarm().getName() + msg);
        //getMediator().sendMessage(msg, farm);		
	}

}
