package main.java.simfarm.animal;

import java.util.Random;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.farm.Farm;

public class Sheep extends Animal {
    private int diseaseResistance;
    private int breedability;
    private int aggression;
    private int age;
    private int productAge;
    private String type = "Sheep";
    private String gender;
    private Random random = new Random();
    private boolean isPregnant = false;
    private int daysPregnant = 0;
    private int daysSinceLastBirth = 0;
    private boolean isDiseased = false;
    private int daysDiseased = 0;

    /**
     * constructor.
     * 
     * @param diseaseResistance skill stat for contstructor
     * @param breedability      skill stat for contstructor
     * @param aggression        skill stat for contstructor
     */
    public Sheep(int diseaseResistance, int breedability, int aggression) {
        this.diseaseResistance = diseaseResistance;
        this.breedability = breedability;
        this.aggression = aggression;
        int g = random.nextInt(2);
        if (g == 0) {
            this.gender = "Female";
        } else {
            this.gender = "Male";
        }
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
        this.daysPregnant = 0;
        this.daysSinceLastBirth = 0;
        this.isPregnant = false;
        return af.create("Sheep");
    }

    @Override
    public void incrementDaysSinceLastBirth() {
        this.daysSinceLastBirth++;
    }

    @Override
    public int getDaysSinceLastBirth() {
        return daysSinceLastBirth;
    }

    @Override
    public boolean isDiseased() {
        return isDiseased;
    }

    @Override
    public int daysDiseased() {
        return daysDiseased;
    }

    @Override
    public void incrementDaysDiseased() {
        daysDiseased++;
    }

    @Override
    public void diseased() {
        this.isDiseased = true;
    }

    @Override
    public void healed() {
        this.isDiseased = false;
    }

}
