package mainCode;

public class GoalTracker {
	private int goalsCompleted;
	private int goalsToBeCompleted;
	private int goalsIncompleted;
	private int initiative;
	private int highestInitiative;
	private int dayOfHighestInitiative;
	private int day;
	
	
	public GoalTracker() {
		goalsCompleted = 0;
		goalsToBeCompleted = 0;
		goalsIncompleted = 0;
		initiative = 1000;
		highestInitiative = 1000;
		dayOfHighestInitiative = 1;
		day = 1;
	}
	
	public int getGoalsCompleted() {
		return goalsCompleted;
	}
	
	public int getGoalsToBeCompleted() {
		return goalsToBeCompleted;
	}
	
	public int getGoalsIncompleted() {
		return goalsIncompleted;
	}
	
	public int getInitiative() {
		return initiative;
	}
	
	public int getHighestInitiative() {
		return highestInitiative;
	}
	
	public int getDayOfHighestInitiative() {
		return dayOfHighestInitiative;
	}
	
	public void addGoal() {
		goalsToBeCompleted++;
	}
	
	public void removeGoal() {
		goalsToBeCompleted--;
	}
	
	public void completeGoal() {
		goalsCompleted++;
	}
	
	public void changeInitiative(int amount) {
		initiative += amount;
		if(initiative >= highestInitiative) {
			highestInitiative = initiative;
			dayOfHighestInitiative = day;
		}
	}

	
	public void failGoal() {
		goalsIncompleted++;
	}
	
	public int getDay() {
		return day;
	}
	
	public void increaseDay() {
		day++;
	} 
}
