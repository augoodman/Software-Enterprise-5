package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import main.java.simfarm.abstractfactory.AbstractFactory;
import main.java.simfarm.abstractfactory.AnimalFactory;
import main.java.simfarm.abstractfactory.CropFactory;
import main.java.simfarm.abstractfactory.FactoryProvider;
import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;
import main.java.simfarm.simulation.BabyAnimals;
import main.java.simfarm.simulation.Disease;
import main.java.simfarm.simulation.ExchangeAnimals;
import main.java.simfarm.simulation.ManageCrops;
import main.java.simfarm.simulation.ManageLand;

import org.junit.Before;
import org.junit.Test;

public class SimulationTest {
    ExchangeAnimals ea = new ExchangeAnimals();
    ManageLand ml = new ManageLand();
    ManageCrops mc = new ManageCrops();
    BabyAnimals ba = new BabyAnimals();
    Disease disease = new Disease();
    Farm hf;
    Farm af;
    Farm cf;
    AbstractFactory<Farm> aff = FactoryProvider.getFactory("Farm");
    AbstractFactory<Animal> afa = FactoryProvider.getFactory("Animal");
    AbstractFactory<Crop> afc = FactoryProvider.getFactory("Crop");

    int test1Expected;
    int test2Expected;
    int test3Expected;
    int test4Expected;
    int test5Expected;
    boolean test6Expected;
    int test7Expected;
    int test8Expected;
    int test9Expected;
    int test10Expected;

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
        test1Expected = hf.getAnimals().size() + 100;
        test2Expected = 106;
        test3Expected = 8;
        test4Expected = 8;
        test5Expected = 9;
        test6Expected = true;
        test7Expected = 0;
        test8Expected = 180;
        test9Expected = 80;
        test10Expected = 0;

    }

    @Test
    public void buyAnimalsTest() {
        hf.sell(1000000000);
        for (int i = 0; i < 100; i++) {
            ea.buyAnimals(hf, (AnimalFactory) afa);
        }
        assertEquals(test1Expected, hf.getAnimals().size());
    }

    @Test
    public void sellAnimalsTest() {
        hf.sell(1000000000);
        for (Animal animal : hf.getAnimals()) {
            animal.incrementProductClock();
            animal.incrementProductClock();
            animal.incrementProductClock();
        }
        hf.setBusinessSkill(100);
        for (int i = 0; i < 100; i++) {
            ea.buyAnimals(hf, (AnimalFactory) afa);
            ea.sellAnimals(hf);
        }
        assertEquals(test2Expected, hf.getAnimals().size());
    }

    @Test
    public void manageLandHybridTest() {
        assertEquals(test3Expected, ml.getAvailableLand(hf));
    }

    @Test
    public void manageLandAnimalTest() {
        assertEquals(test4Expected, ml.getAvailableLand(hf));
    }

    @Test
    public void manageLandCropTest() {
        assertEquals(test5Expected, ml.getAvailableLand(cf));
    }

    @Test
    public void isLandAvailableTest() {
        assertEquals(test6Expected, ml.isLandAvailable(cf));
    }

    @Test
    public void buyLandTest() {
        assertEquals(test7Expected, ml.buyLand(hf));
    }

    @Test
    public void plantCropsTest() {
        cf.sell(1000000000);
        for (int i = 0; i < 100; i++) {
            mc.plantCrops(cf, (CropFactory) afc, ml);
        }
        assertEquals(test8Expected, cf.getCrops().size());
    }

    @Test
    public void sellCropsTest() {
        hf.sell(1000000000);
        for (Crop crop : cf.getCrops()) {
            crop.incrementAge();
            crop.incrementAge();
            crop.incrementAge();
        }
        hf.setBusinessSkill(100);
        for (int i = 0; i < 80; i++) {
            mc.sellCrops(cf);
        }
        assertEquals(test9Expected, cf.getCrops().size());
    }

    @Test
    public void pregnantTest() {
        for (Animal animal : af.getAnimals()) {
            animal.incrementAge();
            animal.incrementAge();
            animal.incrementAge();
            animal.incrementDaysSinceLastBirth();
        }
        ba.pregnant(af);
        boolean atLeastOnePregnancy = false;
        for (Animal animal : af.getAnimals()) {
            if (animal.isPregnant()) {
                atLeastOnePregnancy = true;
            }
        }
        assertTrue(atLeastOnePregnancy);
    }

    @Test
    public void birthTest() {
        for (Animal animal : af.getAnimals()) {
            ba.pregnant(af);
            animal.incrementPregnancy();
            animal.incrementPregnancy();
            animal.incrementPregnancy();
            animal.incrementPregnancy();
            animal.incrementAge();
            animal.incrementAge();
            animal.incrementAge();
            animal.incrementDaysSinceLastBirth();
        }
        ba.birth(af, afa);
        assertEquals(test10Expected, af.getAnimals().get(0).getDaysSinceLastBirth());
    }

    @Test
    public void spreadDiseaseTest() {
        disease.spreadDisease(hf);
        boolean atLeastOneDisease = false;
        for (Animal animal : hf.getAnimals()) {
            if (animal.isDiseased()) {
                atLeastOneDisease = true;
            }
        }
        assertTrue(atLeastOneDisease);
    }
}
