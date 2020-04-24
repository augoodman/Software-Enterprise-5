package main.java.simfarm.farm;

public class HybridFarm extends Farm{
	private int level;
	private int money;
	private int employees;
	private int size;
	private String name = "Hybrid Farm";

	
	public HybridFarm() {
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

	@Override
	public void spendMoney(int dollars) {
		this.money -= dollars;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
