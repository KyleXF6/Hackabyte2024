package mainCode;

public class Goal {
	private int initiative;
	private String statement;
	private int amountOfDays;
	
	public Goal(int initiative, String statement, int amountOfDays) {
		this.initiative = initiative;
		this.statement = statement;
		this.amountOfDays = amountOfDays;
	}
	
	public int getInitiative() {
		return initiative;
	}
	
	public String getStatement() {
		return statement;
	}
	
	public int getAmountOfDays() {
		return amountOfDays;
	}
	
	public void decreaseAmountOfDays() {
		amountOfDays--;
	}
	
	@Override public String toString() {
		return statement + " (" + amountOfDays + " days left), worth " + initiative + " initiative";
	}
	
	
}
