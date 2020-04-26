package main.java.simfarm.farmer;

public abstract class Farmer {
	//getters for farmer skills
	public abstract int getBusinessSkill();
	public abstract int getFarmWorkerSkill();
	public abstract int getHarvesterSkill();
	public abstract int getBreederSkill();
	public abstract int getHorticultureSkill();
	public abstract int getVeterinarianSkill();
	public abstract String getType();
	
    @Override
    public String toString(){
        return "Business Skill = " + this.getBusinessSkill() + ", Farm Worker Skill = " + this.getFarmWorkerSkill() + ", Harvester Skill = " + this.getHarvesterSkill() + ", Breeder Skill = " + this.getBreederSkill() + ", Horticulture Skill = " + this.getHorticultureSkill() + ", Veterinarian Skill = " + this.getVeterinarianSkill();
    }
}
