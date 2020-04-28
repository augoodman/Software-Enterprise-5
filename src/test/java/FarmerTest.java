package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.farmer.Farmer;
import org.junit.Before;
import org.junit.Test;

public class FarmerTest {
    ArrayList<Farmer> fl = new ArrayList<Farmer>();
    AbstractFactory<Farmer> aff = FactoryProvider.getFactory("Farmer");

    String test1Expected;
    String test2Expected;
    String test3Expected;
    String test4Expected;
    String test5Expected;
    String test6Expected;
    boolean test7Expected;

    /**
     * sets up test environment.
     * 
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        test1Expected = "Breeder";
        test2Expected = "FarmWorker";
        test3Expected = "Harvester";
        test4Expected = "Horticulturist";
        test5Expected = "Owner";
        test6Expected = "Veterinarian";
        test7Expected = true;

        fl.add(aff.create("Breeder"));
        fl.add(aff.create("FarmWorker"));
        fl.add(aff.create("Harvester"));
        fl.add(aff.create("Horticulturist"));
        fl.add(aff.create("Owner"));
        fl.add(aff.create("Veterinarian"));

    }

    @Test
    public void breederTypeTest() {
        assertEquals(test1Expected, fl.get(0).getType());
    }

    @Test
    public void farmWorkerTypeTest() {
        assertEquals(test2Expected, fl.get(1).getType());
    }

    @Test
    public void harvesterTypeTest() {
        assertEquals(test3Expected, fl.get(2).getType());
    }

    @Test
    public void horticulturistTypeTest() {
        assertEquals(test4Expected, fl.get(3).getType());
    }

    @Test
    public void ownerTypeTest() {
        assertEquals(test5Expected, fl.get(4).getType());
    }

    @Test
    public void veterinarianTypeTest() {
        assertEquals(test6Expected, fl.get(5).getType());
    }

    @Test
    public void decoratorTest() {
        fl.get(0).decorate();
        ;
        assertEquals(test7Expected, fl.get(0).isDecorated());
    }

}
