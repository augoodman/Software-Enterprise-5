package main.java.simfarm.farm;

public class CropFarm extends Farm{
	private int level;
	private int money;
	private int employees;
	private int size;
	
	public CropFarm() {
		this.level = 0;
		this.money = 1000;
		this.employees = 1;
		this.size = 5;
	}
	
	@Override
	public int getLevel() {
		return level;
	}
	
	@Override
	public int getMoney() {
		return money;
	}
	
	@Override
	public int getEmployees() {
		return employees;
	}
	
	@Override
	public int getSize() {
		return size;
	}

}
