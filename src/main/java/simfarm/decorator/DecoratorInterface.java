package main.java.simfarm.decorator;

import main.java.simfarm.abstractfactory.AbstractFactory;

public interface DecoratorInterface<T> extends AbstractFactory<T>{
	T create(String t);
}
