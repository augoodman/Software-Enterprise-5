package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.farm.Farm;
import org.junit.Before;
import org.junit.Test;

public class FarmTest {
    ArrayList<Farm> fl = new ArrayList<Farm>();
    AbstractFactory<Farm> aff = FactoryProvider.getFactory("Farm");

    String test1Expected;
    String test2Expected;
    String test3Expected;
    int test4Expected;
    int test5Expected;
    int test6Expected;
    int test7Expected;

    /**
     * sets up test environment.
     * 
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        test1Expected = "AnimalFarm";
        test2Expected = "CropFarm";
        test3Expected = "HybridFarm";
        test4Expected = 0;
        test5Expected = 1000;
        test6Expected = 6;
        test7Expected = 10;

        fl.add(aff.create("AnimalFarm"));
        fl.add(aff.create("CropFarm"));
        fl.add(aff.create("HybridFarm"));

    }

    @Test
    public void animalFarmTypeTest() {
        assertEquals(test1Expected, fl.get(0).getType());
    }

    @Test
    public void cropFarmTypeTest() {
        assertEquals(test2Expected, fl.get(1).getType());
    }

    @Test
    public void hybridFarmTypeTest() {
        assertEquals(test3Expected, fl.get(2).getType());
    }

    @Test
    public void getLevelTest() {
        assertEquals(test4Expected, fl.get(0).getLevel());
    }

    @Test
    public void getMoneyTest() {
        assertEquals(test5Expected, fl.get(1).getMoney());
    }

    @Test
    public void getNumFarmersTest() {
        assertEquals(test6Expected, fl.get(2).getNumFarmers());
    }

    @Test
    public void getAcresTest() {
        assertEquals(test7Expected, fl.get(0).getAcres());
    }

}
