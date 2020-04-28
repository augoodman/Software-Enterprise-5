package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.animal.Animal;
import org.junit.Before;
import org.junit.Test;

public class AnimalTest {
    ArrayList<Animal> al = new ArrayList<Animal>();
    AbstractFactory<Animal> afa = FactoryProvider.getFactory("Animal");

    String test1Expected;
    String test2Expected;
    String test3Expected;
    String test4Expected;
    String test5Expected;
    String test6Expected;
    int test7Expected;
    int test8Expected;
    int test9Expected;
    boolean test10Expected;
    boolean test11Expected;
    int test12Expected;
    int test13Expected;
    int test14Expected;
    String test15Expected;
    String test16Expected;
    int test17Expected;
    int test18Expected;
    boolean test19Expected;
    int test20Expected;
    boolean test21Expected;

    /**
     * sets up test environment.
     * 
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        test1Expected = "Chicken";
        test2Expected = "Cow";
        test3Expected = "Goat";
        test4Expected = "Horse";
        test5Expected = "Pig";
        test6Expected = "Sheep";
        test7Expected = 0;
        test8Expected = 1;
        test9Expected = 3;
        test10Expected = false;
        test11Expected = true;
        test12Expected = 0;
        test13Expected = 1;
        test14Expected = 0;
        test15Expected = "Female";
        test16Expected = "Male";
        test17Expected = 1;
        test18Expected = 0;
        test19Expected = true;
        test20Expected = 1;
        test21Expected = false;

        al.add(afa.create("Chicken"));
        al.add(afa.create("Cow"));
        al.add(afa.create("Goat"));
        al.add(afa.create("Horse"));
        al.add(afa.create("Pig"));
        al.add(afa.create("Sheep"));

    }

    @Test
    public void chickenTypeTest() {
        assertEquals(test1Expected, al.get(0).getType());
    }

    @Test
    public void cowTypeTest() {
        assertEquals(test2Expected, al.get(1).getType());
    }

    @Test
    public void goatTypeTest() {
        assertEquals(test3Expected, al.get(2).getType());
    }

    @Test
    public void horseTypeTest() {
        assertEquals(test4Expected, al.get(3).getType());
    }

    @Test
    public void pigTypeTest() {
        assertEquals(test5Expected, al.get(4).getType());
    }

    @Test
    public void sheepTypeTest() {
        assertEquals(test6Expected, al.get(5).getType());
    }

    @Test
    public void ageTest() {
        assertEquals(test7Expected, al.get(0).getAge());
    }

    @Test
    public void incrementAgeTest() {
        al.get(0).incrementAge();
        assertEquals(test8Expected, al.get(0).getAge());
    }

    @Test
    public void setAgeTest() {
        al.get(0).setAge(3);
        assertEquals(test9Expected, al.get(0).getAge());
    }

    @Test
    public void isPregnantTest() {
        assertEquals(test10Expected, al.get(1).isPregnant());
    }

    @Test
    public void makePregnantTest() {
        al.get(1).makePregnant();
        assertEquals(test11Expected, al.get(1).isPregnant());
    }

    @Test
    public void getProductAgeTest() {
        assertEquals(test12Expected, al.get(2).getProductAge());
    }

    @Test
    public void incrementProductAgeTest() {
        al.get(2).incrementProductClock();
        assertEquals(test13Expected, al.get(2).getProductAge());
    }

    @Test
    public void resetProductAgeTest() {
        al.get(2).resetProductClock();
        assertEquals(test14Expected, al.get(2).getProductAge());
    }

    @Test
    public void setGenderFemaleTest() {
        al.get(3).setGender("Female");
        assertEquals(test15Expected, al.get(3).getGender());
    }

    @Test
    public void setGenderMaleTest() {
        al.get(3).setGender("Male");
        assertEquals(test16Expected, al.get(3).getGender());
    }

    @Test
    public void incrementPregnancyTest() {
        al.get(1).incrementPregnancy();
        assertEquals(test17Expected, al.get(1).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest() {
        assertEquals(test18Expected, al.get(4).getDaysSinceLastBirth());
    }

    @Test
    public void diseasedTest() {
        al.get(5).diseased();
        assertEquals(test19Expected, al.get(5).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest() {
        al.get(5).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(5).daysDiseased());
    }

    @Test
    public void healedTest() {
        al.get(5).healed();
        assertEquals(test21Expected, al.get(5).isDiseased());
    }

}
