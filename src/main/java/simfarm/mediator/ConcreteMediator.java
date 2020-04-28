package main.java.simfarm.mediator;

import java.util.HashMap;
import java.util.Map;

import main.java.simfarm.farm.Farm;

public class ConcreteMediator implements MediatorInterface {

    private Map<Farm, AbstractSimFarm> asfMap = new HashMap<>();

    @Override
    public void sendMessage(String msg, Farm farm) {
        AbstractSimFarm asf = asfMap.get(farm);
    }

    @Override
    public void addAsf(AbstractSimFarm asf) {
        this.asfMap.put(asf.getFarm(), asf);
    }
}
