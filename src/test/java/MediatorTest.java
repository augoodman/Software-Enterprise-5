package test.java;

import static org.junit.Assert.assertEquals;

import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;
import main.java.simfarm.mediator.AbstractSimFarm;
import main.java.simfarm.mediator.ConcreteMediator;
import main.java.simfarm.mediator.ConcreteSimFarm;
import main.java.simfarm.mediator.MediatorInterface;
import main.java.simfarm.simulation.ManageLand;

import org.junit.Before;
import org.junit.Test;

public class MediatorTest {
    MediatorInterface mi = new ConcreteMediator();
    ManageLand ml = new ManageLand();
    Farm hf;
    Farm af;
    Farm cf;
    AbstractSimFarm asf;
    AbstractFactory<Farm> aff = FactoryProvider.getFactory("Farm");

    int test1Expected;


    /**
     * sets up test environment.
     * 
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        hf = aff.create("HybridFarm");
        af = aff.create("AnimalFarm");
        cf = aff.create("CropFarm");
        asf = new ConcreteSimFarm(mi, hf);
        test1Expected = 5;

    }

    @Test
    public void simulateHybridFarmTest() {
        asf.simulate(hf, asf, ml);
        assertEquals(test1Expected, hf.getLevel());
    }

    @Test
    public void simulateAnimalFarmTest() {
        asf.simulate(af, asf, ml);
        assertEquals(test1Expected, af.getLevel());
    }

    @Test
    public void simulateCropFarmTest() {
        asf.simulate(cf, asf, ml);
        assertEquals(test1Expected, cf.getLevel());
    }
}
