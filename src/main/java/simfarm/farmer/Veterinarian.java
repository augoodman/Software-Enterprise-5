package main.java.simfarm.farmer;

public class Veterinarian extends Farmer {
    private int businessSkill;
    private int farmWorkerSkill;
    private int harvesterSkill;
    private int breederSkill;
    private int horticultureSkill;
    private int veterinarianSkill;
    private String type = "Veterinarian";
    private boolean isDecorated = false;

    /**
     * constructor.
     * 
     * @param businessSkill     skill parameter for construction
     * @param farmWorkerSkill   skill parameter for construction
     * @param harvesterSkill    skill parameter for construction
     * @param breederSkill      skill parameter for construction
     * @param horticultureSkill skill parameter for construction
     * @param veterinarianSkill skill parameter for construction
     */
    public Veterinarian(int businessSkill, int farmWorkerSkill, int harvesterSkill,
            int breederSkill, int horticultureSkill, int veterinarianSkill) {
        this.businessSkill = businessSkill;
        this.farmWorkerSkill = farmWorkerSkill;
        this.harvesterSkill = harvesterSkill;
        this.breederSkill = breederSkill;
        this.horticultureSkill = horticultureSkill;
        this.veterinarianSkill = veterinarianSkill;
    }

    @Override
    public int getBusinessSkill() {
        return businessSkill;
    }

    @Override
    public int getFarmWorkerSkill() {
        return farmWorkerSkill;
    }

    @Override
    public int getHarvesterSkill() {
        return harvesterSkill;
    }

    @Override
    public int getBreederSkill() {
        return breederSkill;
    }

    @Override
    public int getHorticultureSkill() {
        return horticultureSkill;
    }

    @Override
    public int getVeterinarianSkill() {
        return veterinarianSkill;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isDecorated() {
        return isDecorated;
    }

    @Override
    public void decorate() {
        this.isDecorated = true;
    }

}
