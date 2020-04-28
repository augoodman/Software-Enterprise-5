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
    public void ageTest0() {
        assertEquals(test7Expected, al.get(0).getAge());
    }

    @Test
    public void incrementAgeTest0() {
        al.get(0).incrementAge();
        assertEquals(test8Expected, al.get(0).getAge());
    }

    @Test
    public void setAgeTest0() {
        al.get(0).setAge(3);
        assertEquals(test9Expected, al.get(0).getAge());
    }

    @Test
    public void ageTest1() {
        assertEquals(test7Expected, al.get(1).getAge());
    }

    @Test
    public void incrementAgeTest1() {
        al.get(1).incrementAge();
        assertEquals(test8Expected, al.get(1).getAge());
    }

    @Test
    public void setAgeTest1() {
        al.get(1).setAge(3);
        assertEquals(test9Expected, al.get(1).getAge());
    }

    @Test
    public void ageTest2() {
        assertEquals(test7Expected, al.get(2).getAge());
    }

    @Test
    public void incrementAgeTest2() {
        al.get(2).incrementAge();
        assertEquals(test8Expected, al.get(2).getAge());
    }

    @Test
    public void setAgeTest2() {
        al.get(2).setAge(3);
        assertEquals(test9Expected, al.get(2).getAge());
    }

    @Test
    public void ageTest3() {
        assertEquals(test7Expected, al.get(3).getAge());
    }

    @Test
    public void incrementAgeTest3() {
        al.get(3).incrementAge();
        assertEquals(test8Expected, al.get(3).getAge());
    }

    @Test
    public void setAgeTest3() {
        al.get(3).setAge(3);
        assertEquals(test9Expected, al.get(3).getAge());
    }

    @Test
    public void ageTest4() {
        assertEquals(test7Expected, al.get(4).getAge());
    }

    @Test
    public void incrementAgeTest4() {
        al.get(4).incrementAge();
        assertEquals(test8Expected, al.get(4).getAge());
    }

    @Test
    public void setAgeTest4() {
        al.get(4).setAge(3);
        assertEquals(test9Expected, al.get(4).getAge());
    }

    @Test
    public void ageTest5() {
        assertEquals(test7Expected, al.get(5).getAge());
    }

    @Test
    public void incrementAgeTest5() {
        al.get(5).incrementAge();
        assertEquals(test8Expected, al.get(5).getAge());
    }

    @Test
    public void setAgeTest5() {
        al.get(5).setAge(3);
        assertEquals(test9Expected, al.get(5).getAge());
    }

    @Test
    public void isPregnantTest0() {
        assertEquals(test10Expected, al.get(0).isPregnant());
    }

    @Test
    public void makePregnantTest0() {
        al.get(0).makePregnant();
        assertEquals(test11Expected, al.get(0).isPregnant());
    }

    @Test
    public void isPregnantTest1() {
        assertEquals(test10Expected, al.get(1).isPregnant());
    }

    @Test
    public void makePregnantTest1() {
        al.get(1).makePregnant();
        assertEquals(test11Expected, al.get(1).isPregnant());
    }

    @Test
    public void isPregnantTest2() {
        assertEquals(test10Expected, al.get(2).isPregnant());
    }

    @Test
    public void makePregnantTest2() {
        al.get(2).makePregnant();
        assertEquals(test11Expected, al.get(2).isPregnant());
    }

    @Test
    public void isPregnantTest3() {
        assertEquals(test10Expected, al.get(3).isPregnant());
    }

    @Test
    public void makePregnantTest3() {
        al.get(3).makePregnant();
        assertEquals(test11Expected, al.get(3).isPregnant());
    }

    @Test
    public void isPregnantTest4() {
        assertEquals(test10Expected, al.get(4).isPregnant());
    }

    @Test
    public void makePregnantTest4() {
        al.get(4).makePregnant();
        assertEquals(test11Expected, al.get(4).isPregnant());
    }

    @Test
    public void isPregnantTest5() {
        assertEquals(test10Expected, al.get(5).isPregnant());
    }

    @Test
    public void makePregnantTest5() {
        al.get(5).makePregnant();
        assertEquals(test11Expected, al.get(5).isPregnant());
    }

    @Test
    public void getProductAgeTest0() {
        assertEquals(test12Expected, al.get(2).getProductAge());
    }

    @Test
    public void incrementProductAgeTest0() {
        al.get(0).incrementProductClock();
        assertEquals(test13Expected, al.get(0).getProductAge());
    }

    @Test
    public void resetProductAgeTest0() {
        al.get(0).resetProductClock();
        assertEquals(test14Expected, al.get(0).getProductAge());
    }

    @Test
    public void getProductAgeTest1() {
        assertEquals(test12Expected, al.get(0).getProductAge());
    }

    @Test
    public void incrementProductAgeTest1() {
        al.get(1).incrementProductClock();
        assertEquals(test13Expected, al.get(1).getProductAge());
    }

    @Test
    public void resetProductAgeTest1() {
        al.get(1).resetProductClock();
        assertEquals(test14Expected, al.get(1).getProductAge());
    }

    @Test
    public void getProductAgeTest2() {
        assertEquals(test12Expected, al.get(1).getProductAge());
    }

    @Test
    public void incrementProductAgeTest2() {
        al.get(2).incrementProductClock();
        assertEquals(test13Expected, al.get(2).getProductAge());
    }

    @Test
    public void resetProductAgeTest2() {
        al.get(2).resetProductClock();
        assertEquals(test14Expected, al.get(2).getProductAge());
    }

    @Test
    public void getProductAgeTest3() {
        assertEquals(test12Expected, al.get(3).getProductAge());
    }

    @Test
    public void incrementProductAgeTest3() {
        al.get(3).incrementProductClock();
        assertEquals(test13Expected, al.get(3).getProductAge());
    }

    @Test
    public void resetProductAgeTest3() {
        al.get(3).resetProductClock();
        assertEquals(test14Expected, al.get(3).getProductAge());
    }

    @Test
    public void getProductAgeTest4() {
        assertEquals(test12Expected, al.get(4).getProductAge());
    }

    @Test
    public void incrementProductAgeTest4() {
        al.get(4).incrementProductClock();
        assertEquals(test13Expected, al.get(4).getProductAge());
    }

    @Test
    public void resetProductAgeTest4() {
        al.get(2).resetProductClock();
        assertEquals(test14Expected, al.get(4).getProductAge());
    }

    @Test
    public void getProductAgeTest5() {
        assertEquals(test12Expected, al.get(5).getProductAge());
    }

    @Test
    public void incrementProductAgeTest5() {
        al.get(5).incrementProductClock();
        assertEquals(test13Expected, al.get(5).getProductAge());
    }

    @Test
    public void resetProductAgeTest5() {
        al.get(5).resetProductClock();
        assertEquals(test14Expected, al.get(5).getProductAge());
    }

    @Test
    public void setGenderFemaleTest0() {
        al.get(0).setGender("Female");
        assertEquals(test15Expected, al.get(0).getGender());
    }

    @Test
    public void setGenderMaleTest0() {
        al.get(0).setGender("Male");
        assertEquals(test16Expected, al.get(0).getGender());
    }

    @Test
    public void setGenderFemaleTest1() {
        al.get(1).setGender("Female");
        assertEquals(test15Expected, al.get(1).getGender());
    }

    @Test
    public void setGenderMaleTest1() {
        al.get(1).setGender("Male");
        assertEquals(test16Expected, al.get(1).getGender());
    }

    @Test
    public void setGenderFemaleTest2() {
        al.get(2).setGender("Female");
        assertEquals(test15Expected, al.get(2).getGender());
    }

    @Test
    public void setGenderMaleTest2() {
        al.get(2).setGender("Male");
        assertEquals(test16Expected, al.get(2).getGender());
    }

    @Test
    public void setGenderFemaleTest3() {
        al.get(3).setGender("Female");
        assertEquals(test15Expected, al.get(3).getGender());
    }

    @Test
    public void setGenderMaleTest3() {
        al.get(3).setGender("Male");
        assertEquals(test16Expected, al.get(3).getGender());
    }

    @Test
    public void setGenderFemaleTest4() {
        al.get(4).setGender("Female");
        assertEquals(test15Expected, al.get(4).getGender());
    }

    @Test
    public void setGenderMaleTest4() {
        al.get(4).setGender("Male");
        assertEquals(test16Expected, al.get(4).getGender());
    }

    @Test
    public void setGenderFemaleTest5() {
        al.get(5).setGender("Female");
        assertEquals(test15Expected, al.get(5).getGender());
    }

    @Test
    public void setGenderMaleTest5() {
        al.get(5).setGender("Male");
        assertEquals(test16Expected, al.get(5).getGender());
    }

    @Test
    public void incrementPregnancyTest0() {
        al.get(0).incrementPregnancy();
        assertEquals(test17Expected, al.get(0).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest0() {
        assertEquals(test18Expected, al.get(0).getDaysSinceLastBirth());
    }

    @Test
    public void incrementPregnancyTest1() {
        al.get(1).incrementPregnancy();
        assertEquals(test17Expected, al.get(1).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest1() {
        assertEquals(test18Expected, al.get(1).getDaysSinceLastBirth());
    }

    @Test
    public void incrementPregnancyTest2() {
        al.get(2).incrementPregnancy();
        assertEquals(test17Expected, al.get(2).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest2() {
        assertEquals(test18Expected, al.get(2).getDaysSinceLastBirth());
    }

    @Test
    public void incrementPregnancyTest3() {
        al.get(3).incrementPregnancy();
        assertEquals(test17Expected, al.get(3).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest3() {
        assertEquals(test18Expected, al.get(3).getDaysSinceLastBirth());
    }

    @Test
    public void incrementPregnancyTest4() {
        al.get(4).incrementPregnancy();
        assertEquals(test17Expected, al.get(4).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest4() {
        assertEquals(test18Expected, al.get(4).getDaysSinceLastBirth());
    }

    @Test
    public void incrementPregnancyTest5() {
        al.get(5).incrementPregnancy();
        assertEquals(test17Expected, al.get(5).daysPregnant());
    }

    @Test
    public void incrementDaysSinceLastBirthTest5() {
        assertEquals(test18Expected, al.get(5).getDaysSinceLastBirth());
    }

    @Test
    public void diseasedTest0() {
        al.get(0).diseased();
        assertEquals(test19Expected, al.get(0).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest0() {
        al.get(0).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(0).daysDiseased());
    }

    @Test
    public void healedTest0() {
        al.get(0).healed();
        assertEquals(test21Expected, al.get(0).isDiseased());
    }

    @Test
    public void diseasedTest1() {
        al.get(1).diseased();
        assertEquals(test19Expected, al.get(1).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest1() {
        al.get(1).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(1).daysDiseased());
    }

    @Test
    public void healedTest1() {
        al.get(1).healed();
        assertEquals(test21Expected, al.get(1).isDiseased());
    }

    @Test
    public void diseasedTest2() {
        al.get(2).diseased();
        assertEquals(test19Expected, al.get(2).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest2() {
        al.get(2).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(2).daysDiseased());
    }

    @Test
    public void healedTest2() {
        al.get(2).healed();
        assertEquals(test21Expected, al.get(2).isDiseased());
    }

    @Test
    public void diseasedTest3() {
        al.get(3).diseased();
        assertEquals(test19Expected, al.get(3).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest3() {
        al.get(3).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(3).daysDiseased());
    }

    @Test
    public void healedTest3() {
        al.get(3).healed();
        assertEquals(test21Expected, al.get(3).isDiseased());
    }

    @Test
    public void diseasedTest4() {
        al.get(4).diseased();
        assertEquals(test19Expected, al.get(4).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest4() {
        al.get(4).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(4).daysDiseased());
    }

    @Test
    public void healedTest4() {
        al.get(4).healed();
        assertEquals(test21Expected, al.get(4).isDiseased());
    }

    @Test
    public void diseasedTest5() {
        al.get(5).diseased();
        assertEquals(test19Expected, al.get(5).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest5() {
        al.get(5).incrementDaysDiseased();
        assertEquals(test20Expected, al.get(5).daysDiseased());
    }

    @Test
    public void healedTest5() {
        al.get(5).healed();
        assertEquals(test21Expected, al.get(5).isDiseased());
    }

}
