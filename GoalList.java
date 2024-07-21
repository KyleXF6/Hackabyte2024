package mainCode;

import java.util.ArrayList;

public class GoalList {
	private ArrayList<Goal> listOfGoals;
	
	public GoalList() {
		listOfGoals = new ArrayList<Goal>();
	}
	
	public void addToList(Goal goal) {
		listOfGoals.add(goal);
	}
	
	public void removeFromList(Goal goal) {
		listOfGoals.remove(goal);
	}
	
	public ArrayList<Goal> getListOfGoals() {
		return listOfGoals;
	}
}
