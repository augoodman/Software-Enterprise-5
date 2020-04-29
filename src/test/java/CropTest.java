package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.crop.Crop;
import org.junit.Before;
import org.junit.Test;

public class CropTest {
    ArrayList<Crop> cl = new ArrayList<Crop>();
    AbstractFactory<Crop> afc = FactoryProvider.getFactory("Crop");

    String test1Expected;
    String test2Expected;
    String test3Expected;
    String test4Expected;
    String test5Expected;
    String test6Expected;
    String test7Expected;
    String test8Expected;
    int test9Expected;
    boolean test10Expected;
    int test11Expected;
    boolean test12Expected;

    /**
     * sets up test environment.
     * 
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        test1Expected = "Barley";
        test2Expected = "Corn";
        test3Expected = "Peanut";
        test4Expected = "Potato";
        test5Expected = "Rice";
        test6Expected = "Soybean";
        test7Expected = "Tomato";
        test8Expected = "Wheat";
        test9Expected = 0;
        test10Expected = true;
        test11Expected = 1;
        test12Expected = false;

        cl.add(afc.create("Barley"));
        cl.add(afc.create("Corn"));
        cl.add(afc.create("Peanut"));
        cl.add(afc.create("Potato"));
        cl.add(afc.create("Rice"));
        cl.add(afc.create("Soybean"));
        cl.add(afc.create("Tomato"));
        cl.add(afc.create("Wheat"));

    }

    @Test
    public void barleyTypeTest() {
        assertEquals(test1Expected, cl.get(0).getType());
    }

    @Test
    public void cornTypeTest() {
        assertEquals(test2Expected, cl.get(1).getType());
    }

    @Test
    public void peanutTypeTest() {
        assertEquals(test3Expected, cl.get(2).getType());
    }

    @Test
    public void potatoTypeTest() {
        assertEquals(test4Expected, cl.get(3).getType());
    }

    @Test
    public void riceTypeTest() {
        assertEquals(test5Expected, cl.get(4).getType());
    }

    @Test
    public void soybeanTypeTest() {
        assertEquals(test6Expected, cl.get(5).getType());
    }

    @Test
    public void tomatoTypeTest() {
        assertEquals(test7Expected, cl.get(6).getType());
    }

    @Test
    public void wheatTypeTest() {
        assertEquals(test8Expected, cl.get(7).getType());
    }

    @Test
    public void ageTest0() {
        assertEquals(test9Expected, cl.get(0).getAge());
    }

    @Test
    public void ageTest1() {
        assertEquals(test9Expected, cl.get(1).getAge());
    }

    @Test
    public void ageTest2() {
        assertEquals(test9Expected, cl.get(2).getAge());
    }

    @Test
    public void ageTest3() {
        assertEquals(test9Expected, cl.get(3).getAge());
    }

    @Test
    public void ageTest4() {
        assertEquals(test9Expected, cl.get(4).getAge());
    }

    @Test
    public void ageTest5() {
        assertEquals(test9Expected, cl.get(5).getAge());
    }

    @Test
    public void ageTest6() {
        assertEquals(test9Expected, cl.get(6).getAge());
    }

    @Test
    public void ageTest7() {
        assertEquals(test9Expected, cl.get(7).getAge());
    }

    @Test
    public void diseasedTest0() {
        cl.get(0).diseased();
        assertEquals(test10Expected, cl.get(0).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest0() {
        cl.get(0).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(0).daysDiseased());
    }

    @Test
    public void healedTest0() {
        cl.get(0).healed();
        assertEquals(test12Expected, cl.get(0).isDiseased());
    }

    @Test
    public void diseasedTest1() {
        cl.get(1).diseased();
        assertEquals(test10Expected, cl.get(1).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest1() {
        cl.get(1).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(1).daysDiseased());
    }

    @Test
    public void healedTest1() {
        cl.get(1).healed();
        assertEquals(test12Expected, cl.get(1).isDiseased());
    }

    @Test
    public void diseasedTest2() {
        cl.get(2).diseased();
        assertEquals(test10Expected, cl.get(2).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest2() {
        cl.get(2).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(2).daysDiseased());
    }

    @Test
    public void healedTest2() {
        cl.get(2).healed();
        assertEquals(test12Expected, cl.get(2).isDiseased());
    }

    @Test
    public void diseasedTest3() {
        cl.get(3).diseased();
        assertEquals(test10Expected, cl.get(3).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest3() {
        cl.get(3).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(3).daysDiseased());
    }

    @Test
    public void healedTest3() {
        cl.get(3).healed();
        assertEquals(test12Expected, cl.get(3).isDiseased());
    }

    @Test
    public void diseasedTest4() {
        cl.get(4).diseased();
        assertEquals(test10Expected, cl.get(4).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest4() {
        cl.get(4).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(4).daysDiseased());
    }

    @Test
    public void healedTest4() {
        cl.get(4).healed();
        assertEquals(test12Expected, cl.get(4).isDiseased());
    }

    @Test
    public void diseasedTest5() {
        cl.get(5).diseased();
        assertEquals(test10Expected, cl.get(5).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest5() {
        cl.get(5).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(5).daysDiseased());
    }

    @Test
    public void healedTest5() {
        cl.get(5).healed();
        assertEquals(test12Expected, cl.get(5).isDiseased());
    }

    @Test
    public void diseasedTest6() {
        cl.get(6).diseased();
        assertEquals(test10Expected, cl.get(6).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest6() {
        cl.get(6).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(6).daysDiseased());
    }

    @Test
    public void healedTest6() {
        cl.get(6).healed();
        assertEquals(test12Expected, cl.get(6).isDiseased());
    }

    @Test
    public void diseasedTest7() {
        cl.get(7).diseased();
        assertEquals(test10Expected, cl.get(7).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest7() {
        cl.get(7).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(7).daysDiseased());
    }

    @Test
    public void healedTest7() {
        cl.get(7).healed();
        assertEquals(test12Expected, cl.get(7).isDiseased());
    }

}
