package main.java.simfarm.animal;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.farm.Farm;

public abstract class Animal {

	//getters for animal type, size, disease resistance, breedability and aggression
	public abstract int getSize();
	public abstract int getDiseaseResistance();
	public abstract int getBreedability();
	public abstract int getAggression();
	public abstract int getAge();
	public abstract int getProductAge();
	public abstract String getType();
	public abstract String getGender();
	public abstract void setGender(String gender);
	public abstract void setAge(int age);
	public abstract void resetProductClock();
	public abstract void incrementProductClock();
	public abstract void animalExchanged(String boughtOrSold);
	public abstract void incrementAge();
	public abstract boolean isPregnant();
	public abstract void makePregnant();
	public abstract void incrementPregnancy();
	public abstract int daysPregnant();
	public abstract Animal giveBirth(Farm farm, AbstractFactory<Animal> af);
	public abstract void incrementDaysSinceLastBirth();
	public abstract int getDaysSinceLastBirth();

    @Override
    public String toString(){
        return "Size = " + this.getSize() + ", Disease Resistance = " + this.getDiseaseResistance() + ", Breedability = " + this.getBreedability() + ", Aggression = " + this.getAggression();
    }
}
