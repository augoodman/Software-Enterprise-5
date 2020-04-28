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
    public void ageTest() {
        assertEquals(test9Expected, cl.get(0).getAge());
    }

    @Test
    public void diseasedTest() {
        cl.get(1).diseased();
        assertEquals(test10Expected, cl.get(1).isDiseased());
    }

    @Test
    public void incrementDaysDiseasedTest() {
        cl.get(1).incrementDaysDiseased();
        assertEquals(test11Expected, cl.get(1).daysDiseased());
    }

    @Test
    public void healedTest() {
        cl.get(1).healed();
        assertEquals(test12Expected, cl.get(1).isDiseased());
    }

}
