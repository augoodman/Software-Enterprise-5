package main.java.simfarm.mediator;

import main.java.simfarm.farm.Farm;

public interface MediatorInterface {
    public void sendMessage(String msg, Farm farm);
    
    void addAsf(AbstractSimFarm asf);
}
