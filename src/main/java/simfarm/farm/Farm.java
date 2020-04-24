package main.java.simfarm.farm;

public abstract class Farm {
	//getters for farm type, level, money, employees, and size
	public abstract int getLevel();
	public abstract int getMoney();
	public abstract int getEmployees();
	public abstract int getSize();
	public abstract void spendMoney(int dollars);
	public abstract String getName();
	
	//change farm name
	public abstract void setName(String name);

	@Override
    public String toString(){
        return "Level = " + this.getLevel() + ", Money = " + this.getMoney() + ", Employees = " + this.getEmployees() + ", Size = " + this.getSize();
    }
}
