package main.java.simfarm.farmer;

public class Horticulturist extends Farmer {
	private int businessSkill;
	private int farmWorkerSkill;
	private int harvesterSkill;
	private int breederSkill;
	private int horticultureSkill;
	private int veterinarianSkill;

	public Horticulturist(int businessSkill, int farmWorkerSkill, int harvesterSkill, int breederSkill, int horticultureSkill, int veterinarianSkill) {
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

}
