package main.java.simfarm.mediator;

import main.java.simfarm.farm.Farm;

public class ConcreteSimFarm extends AbstractSimFarm {

	public ConcreteSimFarm(MediatorInterface mediator, Farm farm) {
		super(mediator, farm);
	}

	@Override
	public void send(String msg) {
        System.out.println(msg);
        //getMediator().sendMessage(msg, farm);		
	}

	@Override
	public void receive(String msg) {
        System.out.println(this.getFarm().getType() + " " + msg);
	}

}
