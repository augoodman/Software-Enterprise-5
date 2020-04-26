package main.java.simfarm.mediator;

import main.java.simfarm.farm.Farm;

public abstract class AbstractSimFarm {
	private MediatorInterface mediator;
	private Farm farm;
	
    public AbstractSimFarm(MediatorInterface mediator, Farm farm){
        this.mediator = mediator;
        this.farm = farm;
    }
    
    public abstract void send(String msg);
    
    public abstract void receive(String msg);
    
    public MediatorInterface getMediator() {
    	return mediator;
    }
    
    public Farm getFarm() {
        return farm;
    }
}
