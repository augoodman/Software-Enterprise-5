package main.java.simfarm.farmer;

public class FarmWorker extends Farmer {
	private int businessSkill;
	private int farmWorkerSkill;
	private int harvesterSkill;
	private int breederSkill;
	private int horticultureSkill;
	private int veterinarianSkill;
	private String type = "FarmWorker";

	public FarmWorker(int businessSkill, int farmWorkerSkill, int harvesterSkill, int breederSkill, int horticultureSkill, int veterinarianSkill) {
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
	
}
