package main.java.simfarm.animal;

import java.util.Random;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.farm.Farm;

public class Chicken extends Animal {
	private int size;
	private int diseaseResistance;
	private int breedability;
	private int aggression;
	private int numAnimals;
	private int age = 0;
	private int productAge = 0;
	private String type = "Chicken";
	private String gender;
	private Random r = new Random();
	private boolean isPregnant = false;
	private int daysPregnant = 0;
	private int daysSinceLastBirth = 0;
	
	public Chicken(int size, int diseaseResistance, int breedability, int aggression) {
		this.size = size;
		this.diseaseResistance = diseaseResistance;
		this.breedability = breedability;
		this.aggression = aggression;
		int g = r.nextInt(1);
		if(g == 0) {
			this.gender = "Female";
		}
		else {
			this.gender = "Male";
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getDiseaseResistance() {
		return diseaseResistance;
	}

	@Override
	public int getBreedability() {
		return breedability;
	}

	@Override
	public int getAggression() {
		return aggression;
	}

	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public void animalExchanged(String boughtOrSold) {
		if(boughtOrSold.equalsIgnoreCase("bought")) {
			this.numAnimals++;
		}
		else {
			this.numAnimals--;
		}
	}

	@Override
	public void incrementAge() {
		this.age++;
	}

	@Override
	public void setAge(int age) {
		this.age = age;		
	}

	@Override
	public void resetProductClock() {
		this.productAge = 0;
	}

	@Override
	public void incrementProductClock() {
		this.productAge++;
	}

	@Override
	public String getGender() {
		return gender;
	}
	
	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int getProductAge() {
		return productAge;
	}

	@Override
	public boolean isPregnant() {
		return isPregnant;
	}

	@Override
	public void makePregnant() {
		this.isPregnant = true;
	}

	@Override
	public void incrementPregnancy() {
		this.daysPregnant++;		
	}

	@Override
	public int daysPregnant() {
		return daysPregnant;
	}
	
	@Override
	public Animal giveBirth(Farm farm, AbstractFactory<Animal> af) {
		this.isPregnant = false;
		return af.create("Cow");
	}

	@Override
	public void incrementDaysSinceLastBirth() {
		this.daysSinceLastBirth++;
	}	
	
	@Override
	public int getDaysSinceLastBirth() {
		return daysSinceLastBirth;
	}

}
