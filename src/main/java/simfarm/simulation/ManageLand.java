package main.java.simfarm.simulation;

import main.java.simfarm.animal.Animal;
import main.java.simfarm.crop.Crop;
import main.java.simfarm.farm.Farm;

public class ManageLand {
    private boolean landAvailable;

    /**
     * constructor.
     * 
     * @param farm farm object for which to check available land
     * @return
     */
    public int getAvailableLand(Farm farm) {
        int totalLand = farm.getAcres();
        double landUsed;
        int[] numEachAnimal = new int[4];
        int[] numEachCrop = new int[3];
        if (farm.getType().equalsIgnoreCase("AnimalFarm")
                || farm.getType().equalsIgnoreCase("HybridFarm")) {
            numEachAnimal = calcNumEachAnimal(farm);
        }
        if (farm.getType().equalsIgnoreCase("CropFarm")
                || farm.getType().equalsIgnoreCase("HybridFarm")) {
            numEachCrop = calcNumEachCrop(farm);
        }
        landUsed = calcLandUsed(totalLand, farm, numEachAnimal, numEachCrop);
        int availableLand = 0;
        availableLand = (int) (totalLand - landUsed);
        return availableLand;

    }

    /**
     * computes how many of each animal are on the farm.
     * 
     * @param farm farm object from which to count animals
     * @return
     */
    public int[] calcNumEachAnimal(Farm farm) {
        int numChickens = 0;
        int numCowsAndPigs = 0;
        int numGoatsAndSheep = 0;
        int numHorses = 0;
        int[] numEachAnimal = new int[4];
        for (Animal animal : farm.getAnimals()) {
            if (animal.getType().equalsIgnoreCase("Chicken")) {
                numChickens++;
            } else if (animal.getType().equalsIgnoreCase("Cow")
                    || animal.getType().equalsIgnoreCase("Pig")) {
                numCowsAndPigs++;
            } else if (animal.getType().equalsIgnoreCase("Goat")
                    || animal.getType().equalsIgnoreCase("Sheep")) {
                numGoatsAndSheep++;
            } else if (animal.getType().equalsIgnoreCase("Horse")) {
                numHorses++;
            }
        }
        numEachAnimal[0] = numChickens;
        numEachAnimal[1] = numCowsAndPigs;
        numEachAnimal[2] = numGoatsAndSheep;
        numEachAnimal[3] = numHorses;
        return numEachAnimal;
    }

    /**
     * computes how many of each crop are on the farm.
     * 
     * @param farm farm farm object from which to count crops
     * @return
     */
    public int[] calcNumEachCrop(Farm farm) {
        int numBarleyAndRiceAndWheat = 0;
        int numCornAndPotatoesAndTomatoes = 0;
        int numPeanutsAndSoybeans = 0;
        int[] numEachCrop = new int[3];

        for (Crop crop : farm.getCrops()) {
            if (crop.getType().equalsIgnoreCase("Barley") || crop.getType().equalsIgnoreCase("Rice")
                    || crop.getType().equalsIgnoreCase("Wheat")) {
                numBarleyAndRiceAndWheat++;
            }
            if (crop.getType().equalsIgnoreCase("Corn") || crop.getType().equalsIgnoreCase("Potato")
                    || crop.getType().equalsIgnoreCase("Tomato")) {
                numCornAndPotatoesAndTomatoes++;
            }
            if (crop.getType().equalsIgnoreCase("Peanut")
                    || crop.getType().equalsIgnoreCase("Soybean")) {
                numPeanutsAndSoybeans++;
            }
        }
        numEachCrop[0] = numBarleyAndRiceAndWheat;
        numEachCrop[1] = numCornAndPotatoesAndTomatoes;
        numEachCrop[2] = numPeanutsAndSoybeans;
        return numEachCrop;

    }

    /**
     * computes how much land is consumed by farm animals and crops.
     * 
     * @param totalLand     total space on farm from which to calc available space
     * @param farm          farm object from which to calc land used
     * @param numEachAnimal array with each animal total
     * @param numEachCrop   array with each crop total
     * @return
     */
    public int calcLandUsed(int totalLand, Farm farm, int[] numEachAnimal, int[] numEachCrop) {
        /*
         * Animals and crops consume the following amount of land: Animals: Chicken: 500
         * per acre Cow: 50 per acre Goat: 100 per acre Horse: 25 per acre Pig: 50 per
         * acre Sheep: 100 per acre
         * 
         * Crops: Barley: 5000 per acre Corn: 1000 per acre Peanut: 3000 per acre
         * Potato: 1000 per acre Rice: 5000 per acre Soybean: 3000 per acre Tomato: 1000
         * per acre Wheat: 5000 per acre
         */
        // System.out.println(farm.getAnimals().size());
        int totalRoundedUp = 0;
        if (farm.getType().equalsIgnoreCase("AnimalFarm")) {
            double chickenSpace = numEachAnimal[0] / 100.0;
            double cowAndPigSpace = numEachAnimal[1] / 10.0;
            double goatAndSheepSpace = numEachAnimal[2] / 20.0;
            double horseSpace = numEachAnimal[3] / 5.0;
            totalRoundedUp = (int) Math
                    .ceil(chickenSpace + cowAndPigSpace + goatAndSheepSpace + horseSpace);
        } else if (farm.getType().equalsIgnoreCase("CropFarm")) {
            double barleyAndRiceAndWheatSpace = numEachCrop[0] / 500.0;
            double cornAndPotatoAndTomatoSpace = numEachCrop[1] / 100.0;
            double peanutAndSoybeanSpace = numEachCrop[2] / 400.0;
            totalRoundedUp = (int) Math.ceil(barleyAndRiceAndWheatSpace
                    + cornAndPotatoAndTomatoSpace + peanutAndSoybeanSpace);
        } else {
            double chickenSpace = numEachAnimal[0] / 100.0;
            double cowAndPigSpace = numEachAnimal[1] / 10.0;
            double goatAndSheepSpace = numEachAnimal[2] / 20.0;
            double horseSpace = numEachAnimal[3] / 5.0;
            double barleyAndRiceAndWheatSpace = numEachCrop[0] / 500.0;
            double cornAndPotatoAndTomatoSpace = numEachCrop[1] / 100.0;
            double peanutAndSoybeanSpace = numEachCrop[2] / 400.0;
            totalRoundedUp = (int) Math.ceil(chickenSpace + cowAndPigSpace + goatAndSheepSpace
                    + horseSpace + barleyAndRiceAndWheatSpace + cornAndPotatoAndTomatoSpace
                    + peanutAndSoybeanSpace);
        }
        int landUsed = totalRoundedUp;
        return landUsed;

    }

    /**
     * checks to see if there is open land for new animals and crops.
     * 
     * @param farm farm object for which to determine if full
     * @return
     */
    public boolean isLandAvailable(Farm farm) {
        if (getAvailableLand(farm) > 0) {
            landAvailable = true;
        } else {
            landAvailable = false;
        }
        return landAvailable;
    }

    /**
     * buys land if the farm run out of space.
     * 
     * @param farm farm object for which to buy new land if full
     * @return
     */
    public int buyLand(Farm farm) {
        int acresBought = 0;
        // System.out.println(getAvailableLand(farm));
        while (getAvailableLand(farm) <= 1) {
            acresBought++;
            farm.expandFarm(1);
            farm.buy(500);
        }
        return acresBought;
    }

}
