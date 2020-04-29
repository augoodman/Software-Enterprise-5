package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    int test6bExpected;
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
        test6bExpected = 4;
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
    public void getLevelTest0() {
        assertEquals(test4Expected, fl.get(0).getLevel());
    }

    @Test
    public void getLevelTest1() {
        assertEquals(test4Expected, fl.get(1).getLevel());
    }

    @Test
    public void getLevelTest2() {
        assertEquals(test4Expected, fl.get(2).getLevel());
    }

    @Test
    public void getMoneyTest0() {
        assertEquals(test5Expected, fl.get(0).getMoney());
    }

    @Test
    public void getMoneyTest1() {
        assertEquals(test5Expected, fl.get(1).getMoney());
    }

    @Test
    public void getMoneyTest2() {
        assertEquals(test5Expected, fl.get(2).getMoney());
    }

    @Test
    public void getNumFarmersTest0() {
        assertEquals(test6bExpected, fl.get(0).getNumFarmers());
    }

    @Test
    public void getNumFarmersTest1() {
        assertEquals(test6bExpected, fl.get(1).getNumFarmers());
    }

    @Test
    public void getNumFarmersTest2() {
        assertEquals(test6Expected, fl.get(2).getNumFarmers());
    }

    @Test
    public void getAcresTest0() {
        assertEquals(test7Expected, fl.get(0).getAcres());
    }

    @Test
    public void getAcresTest1() {
        assertEquals(test7Expected, fl.get(1).getAcres());
    }

    @Test
    public void getAcresTest2() {
        assertEquals(test7Expected, fl.get(2).getAcres());
    }

    @Test
    public void hireFarmerTest0() {
        fl.get(0).hireFarmer("Breeder");
        assertTrue(fl.get(0).getFarmers().get(fl.get(0).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Breeder"));
    }

    @Test
    public void hireFarmerTest1() {
        fl.get(0).hireFarmer("FarmWorker");
        assertTrue(fl.get(0).getFarmers().get(fl.get(0).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("FarmWorker"));
    }

    @Test
    public void hireFarmerTest2() {
        fl.get(0).hireFarmer("Harvester");
        assertTrue(fl.get(0).getFarmers().get(fl.get(0).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Harvester"));
    }

    @Test
    public void hireFarmerTest3() {
        fl.get(0).hireFarmer("Horticulturist");
        assertTrue(fl.get(0).getFarmers().get(fl.get(0).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Horticulturist"));
    }

    @Test
    public void hireFarmerTest4() {
        fl.get(0).hireFarmer("Veterinarian");
        assertTrue(fl.get(0).getFarmers().get(fl.get(0).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Veterinarian"));
    }

    @Test
    public void hireFarmerTest0b() {
        fl.get(1).hireFarmer("Breeder");
        assertTrue(fl.get(1).getFarmers().get(fl.get(1).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Breeder"));
    }

    @Test
    public void hireFarmerTest1b() {
        fl.get(1).hireFarmer("FarmWorker");
        assertTrue(fl.get(1).getFarmers().get(fl.get(1).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("FarmWorker"));
    }

    @Test
    public void hireFarmerTest2b() {
        fl.get(1).hireFarmer("Harvester");
        assertTrue(fl.get(1).getFarmers().get(fl.get(1).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Harvester"));
    }

    @Test
    public void hireFarmerTest3b() {
        fl.get(1).hireFarmer("Horticulturist");
        assertTrue(fl.get(1).getFarmers().get(fl.get(1).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Horticulturist"));
    }

    @Test
    public void hireFarmerTest4b() {
        fl.get(1).hireFarmer("Veterinarian");
        assertTrue(fl.get(1).getFarmers().get(fl.get(1).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Veterinarian"));
    }

    @Test
    public void hireFarmerTest0c() {
        fl.get(2).hireFarmer("Breeder");
        assertTrue(fl.get(2).getFarmers().get(fl.get(2).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Breeder"));
    }

    @Test
    public void hireFarmerTest1c() {
        fl.get(2).hireFarmer("FarmWorker");
        assertTrue(fl.get(2).getFarmers().get(fl.get(2).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("FarmWorker"));
    }

    @Test
    public void hireFarmerTest2c() {
        fl.get(2).hireFarmer("Harvester");
        assertTrue(fl.get(2).getFarmers().get(fl.get(2).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Harvester"));
    }

    @Test
    public void hireFarmerTest3c() {
        fl.get(2).hireFarmer("Horticulturist");
        assertTrue(fl.get(2).getFarmers().get(fl.get(2).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Horticulturist"));
    }

    @Test
    public void hireFarmerTest4c() {
        fl.get(2).hireFarmer("Veterinarian");
        assertTrue(fl.get(2).getFarmers().get(fl.get(2).getFarmers().size() - 1).getType()
                .equalsIgnoreCase("Veterinarian"));
    }

}
