package mainCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainApp {
	private JFrame rootFrame;
	private DefaultListModel<Goal> goalModel;
	private JList vgList;
	private GoalTracker goalTracker;
	private JLabel initTracker;
	private JLabel randomText;
	private String[] everything = {"Go interact with your family!", "Go hang out with your pet(s)!", 
			"Go to your nearest library and read a book!", "Go take a long nap!", "Go indulge in some good food!", "Go to your nearest garden!", 
			"Go breathe in the fresh air and look at some good scenery!", "Go and take some time to meditate!", "Make yourself a nice cup of tea.", 
			"Explore some mindfulness exercises!", "Go journal your day!", "Turn on some music and relax!", 
			"Regular physical activity among seniors reduces the risk of chronic diseases such as heart disease, stroke, type 2 diabetes, and certain cancers.",
			"Exercise helps maintain and increase muscle mass, which is crucial for maintaining strength and mobility as we age.",
			"Weight-bearing exercises such as walking, dancing, and strength training help maintain bone density and reduce the risk of osteoporosis and fractures.",
			"Participating in fitness activities can lead to social interaction and community involvement, reducing feelings of isolation and loneliness among seniors.",
			"Seniors who engage in regular physical activity tend to live longer and have a higher quality of life compared to sedentary individuals.",
			"Fitness programs for seniors often include low-impact activities that are gentle on joints, such as swimming, tai chi, and yoga.",
			"Balance exercises, such as standing on one foot or heel-to-toe walking, help improve stability and reduce the risk of falls.",
			"Regular physical activity helps seniors maintain a healthy weight and metabolism, reducing the risk of obesity and related health issues.",
			"Combined with a balanced diet, exercise supports overall health and well-being by providing essential nutrients and energy for daily activities.", 
			"You got this!", "You're doing great!", "Just believe in yourself!", "You can pull through!", "One more step!", 
			"Success is not final, failure is not fatal: It is the courage to continue that counts.",
			"Believe you can and you're halfway there.",
			"The only limit to our realization of tomorrow will be our doubts of today.",
			"It does not matter how slowly you go as long as you do not stop.",
			"The future belongs to those who believe in the beauty of their dreams.",
			"You are never too old to set another goal or to dream a new dream.",
			"Success is walking from failure to failure with no loss of enthusiasm.",
			"The only way to do great work is to love what you do.",
			"In the middle of difficulty lies opportunity.",
			"You don’t have to be great to start, but you have to start to be great.",
			"The journey of a thousand miles begins with one step.",
			"Opportunity does not knock, it presents itself when you beat down the door.",
			"The best way to predict the future is to create it.",
			"Don’t watch the clock; do what it does. Keep going.",
			"What you get by achieving your goals is not as important as what you become by achieving your goals."
	};
	
	public static void changeFontSize(JLabel j, float f) {
		j.setFont(j.getFont().deriveFont(f));
	}
	
	public MainApp() {
		goalTracker = new GoalTracker();
		JFrame jf = new JFrame("SeniorActive");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1250,480);
		Container root = jf.getContentPane();
		GridBagConstraints gc = new GridBagConstraints();
		JPanel grid = new JPanel();
		grid.setBorder(new EmptyBorder(30,30,30,30));
		grid.setLayout(new GridBagLayout());
		root.add(grid);
		JLabel appName = new JLabel("SeniorActive");
		gc.gridx = 0;
		gc.gridy = 0;
		changeFontSize(appName, 35.0f);
		grid.add(appName, gc);
		JLabel label = new JLabel("Active Goals:");
		changeFontSize(label, 20.0f);
		gc.gridx = 0;
		gc.gridy = 1;
		grid.add(label, gc);
		JLabel explanationBecauseSheNeedsIt = new JLabel("*Upon completion of a goal, click on the goal and then click 'Complete Goal'*");
		changeFontSize(explanationBecauseSheNeedsIt, 10.0f);
		gc.gridx = 0;
		gc.gridy = 2;
		grid.add(explanationBecauseSheNeedsIt, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		goalModel = new DefaultListModel<Goal>();
		vgList = new JList(goalModel);
		grid.add(vgList, gc);
		
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 1;
		gc.weighty = 0;
		grid.add(flow, gc);
		
		JButton createGoalButton = new JButton("Create Goal");
		createGoalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCreateGoalButtonClicked();
			}
		});
		flow.add(createGoalButton);

		JButton viewGoalTrackerButton = new JButton("View Goal Tracker");
		flow.add(viewGoalTrackerButton);
		viewGoalTrackerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleViewGoalTrackerButtonClicked();
			}
		});

		JButton completeGoalButton = new JButton("Complete Goal");
		flow.add(completeGoalButton);
		completeGoalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCompleteGoalButtonClicked();
			}
		});
		
		JButton openBuddySystemButton = new JButton("Open BuddySystem");
		flow.add(openBuddySystemButton);
		openBuddySystemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleBuddySystemButtonClicked();
			}
		});

		JButton sleepButton = new JButton("Sleep");
		flow.add(sleepButton, gc);
		sleepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleSleepButtonClicked();
			}
		});
		
		JButton searchForFactsButton = new JButton("Search For Facts");
		flow.add(searchForFactsButton, gc);
		searchForFactsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleSearchForFactsButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 5;
		
		initTracker = new JLabel("Current Initiative: " + goalTracker.getInitiative());
		changeFontSize(initTracker, 20.0f);
		grid.add(initTracker, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		
		int random = (int)(Math.random()*everything.length);
		randomText = new JLabel(everything[random]);
		changeFontSize(randomText, 15.0f);
		grid.add(randomText, gc);
		
		jf.setVisible(true);
		rootFrame = jf;
	}
	
	private void handleCreateGoalButtonClicked() {
		CreateGoalDialog cdg = new CreateGoalDialog(rootFrame);
		if(cdg.show()) {
			Goal g = new Goal(cdg.getInit(), cdg.getName(), cdg.getDuration());
			goalModel.addElement(g);
			goalTracker.addGoal();
		}
		refreshRandomText();
	}
	
	private void handleBuddySystemButtonClicked() {
		BuddySystemDialog cdg = new BuddySystemDialog(rootFrame);
		refreshRandomText();
	}
	
	private void handleViewGoalTrackerButtonClicked() {
		ComplexDialog dialog = new ComplexDialog(rootFrame, "GoalTracker", "Goals History:" , "Goals Completed: " + goalTracker.getGoalsCompleted(),
				"Goals Incompleted: " + goalTracker.getGoalsIncompleted(), "Highest Ever Initiative: " + goalTracker.getHighestInitiative(), 
				"Day of Highest Ever Initiative: " + goalTracker.getDayOfHighestInitiative(), " ", "Current:", "Current Day: " + goalTracker.getDay(), 
				"Current Goals: " + goalTracker.getGoalsToBeCompleted(), "Current Initiative: " + goalTracker.getInitiative(), " ");
		dialog.updateUI();
		dialog = new ComplexDialog(rootFrame, "GoalTracker", "Goals History:", "Goals Completed: " + goalTracker.getGoalsCompleted(),
				"Goals Incompleted: " + goalTracker.getGoalsIncompleted(), "Highest Ever Initiative: " + goalTracker.getHighestInitiative(), 
				"Day of Highest Ever Initiative: " + goalTracker.getDayOfHighestInitiative(), " ", "Current:", "Current Day: " + goalTracker.getDay(), 
				"Current Goals: " + goalTracker.getGoalsToBeCompleted(), "Current Initiative: " + goalTracker.getInitiative(), " ");
		dialog.show();
		refreshRandomText();
	}
	
	private void handleCompleteGoalButtonClicked() {
		int index = vgList.getSelectedIndex();
		if(index != -1) {
			//Goal g2 = goalModel.getElementAt(index);
			Goal g = (Goal)vgList.getSelectedValue();
			SimpleDialog response = new SimpleDialog(new JFrame(), "Success!", "Congratulations! You have completed the goal: '" + 
	    			g.getStatement() + "'!", "Keep crushing it! (+" + g.getInitiative() + " initiative.)");
	    	response.show();
        	goalTracker.changeInitiative(g.getInitiative());
			goalModel.removeElementAt(index);
			goalTracker.removeGoal();
			goalTracker.completeGoal();
			refreshInitTracker();
			refreshRandomText();
		}
	}
	
	private void handleSleepButtonClicked() {
		goalTracker.increaseDay();
	    for (int i = 0; i < goalModel.getSize(); i++) {
	    	goalModel.getElementAt(i).decreaseAmountOfDays();
	    	if(goalModel.getElementAt(i).getAmountOfDays() == 0) {
    			Goal g = (Goal)goalModel.elementAt(i);
    			SimpleDialog response = new SimpleDialog(new JFrame(), "Fail...", "Your goal for '" + 
    			g.getStatement() + "' has timed out...", "Oh well, get 'em next time! (-" + g.getInitiative() + " initiative.)");
    			response.show();
            	goalTracker.changeInitiative(-(g.getInitiative()));
    			goalModel.removeElementAt(i);
    			goalTracker.removeGoal();
    			goalTracker.failGoal();
    			refreshInitTracker();
	    	}
	    }
		refreshGoalList();
		refreshRandomText();
		SimpleDialog dialog = new SimpleDialog(rootFrame, "ZZZ...", "Good night!" , "You are on day #" + goalTracker.getDay());
		dialog.show();
	}
	
	private void handleSearchForFactsButtonClicked() {
		SearchForFactsDialog dialog = new SearchForFactsDialog(rootFrame);
		dialog.show();
		refreshRandomText();
	}
	
	private void refreshGoalList() {
	    for (int i = 0; i < goalModel.getSize(); i++) {
	    	Goal g = goalModel.getElementAt(i);
	    	goalModel.setElementAt(g, i);
	    }
	}
	
	private void refreshInitTracker() {
		initTracker.setText("Current Initiative: " + goalTracker.getInitiative());
	}

	
	private void refreshRandomText() {
		int random = (int)(Math.random()*everything.length);
		randomText.setText(everything[random]);
	}
	
	public static void main(String[] args) {
		MainApp m = new MainApp();
		GoalTracker goalTracker = new GoalTracker();
		GoalList goalList = new GoalList();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Welcome to ActiveSeniors!\n");
        while(goalTracker.getDay() >= 0){
	        System.out.println("What would you like to do?"
	        		+ "\n1. View Goals"
	        		+ "\n2. Create Goals"
	        		+ "\n3. View Goal Tracker"
	        		+ "\n4. Complete Goal"
	        		+ "\n5. Open BuddySystem"
	        		+ "\n6. Sleep");
	        int user = scanner4.nextInt();
	        if(user==1) {
	        	if(goalList.getListOfGoals() == null || goalList.getListOfGoals().size() == 0) {
	        		System.out.println("You have no goals to view right now! Get started by creating some goals!");
	        		System.out.println();
	        	} else {
	        		System.out.println("Days Remaining:   Statement:                                                          Initiative:   ");
	        		for(Goal g: goalList.getListOfGoals()) {
	        			int daysLeft = g.getAmountOfDays();
	        			int lengthOfStatement = g.getStatement().length();
	        			int initiative = g.getInitiative();
	        			System.out.print(daysLeft);
	        			int count = 1;
	        			while((daysLeft /= 10) != 0) {
	        				count++;
	        			}
	        			for(int i = 0; i < 18-count; i++) {
	        				System.out.print(" ");
	        			}
	        			System.out.print(g.getStatement());
	        			for(int i = 0; i < 68-lengthOfStatement; i++) {
	        				System.out.print(" ");
	        			}
	        			System.out.print(initiative);
	        			count = 0;
	        			while((initiative /= 10) != 0) {
	        				initiative /= 10;
	        				count ++;
	        			}
	        			for(int i = 0; i < 14-count; i++) {
	        				System.out.print(" ");
	        			}
	        			System.out.println();
	        		}
	        		System.out.println();
	        		
	        	}
	        } else if(user==2) {
	        	System.out.println("Time to start creating some goals!");
	        	System.out.println("Type the activity you are planning on completing: ");
	        	String input1 = scanner.nextLine();
	        	System.out.println("How many days do you plan to take to complete it?: ");
	        	int input2 = scanner1.nextInt();
	        	System.out.println("How much initiative do you plan on assigning this acitivity?(1-1000):  ");
	        	int input3 = scanner2.nextInt();
	        	while(input3 > 1000 || input3 <= 0) {
	        		System.out.println("This is an invalid value. Try again.");
	        		System.out.println("How much initiative do you plan on assigning this acitivity?(1-1000):  ");
	            	input3 = scanner2.nextInt();
	        	}
	        	Goal g = new Goal(input3, input1, input2);
	        	goalList.addToList(g);
	        	goalTracker.addGoal();
	        } else if(user==3) {
	        	System.out.println("Goals History:");
	        	System.out.println();
	        	System.out.println("Goals Completed: " + goalTracker.getGoalsCompleted());
	        	System.out.println("Goals Incompleted: " + goalTracker.getGoalsIncompleted());
	        	System.out.println("Highest Ever Initiative: " + goalTracker.getHighestInitiative());
	        	System.out.println("Day of Highest Ever Initiative: " + goalTracker.getDayOfHighestInitiative());
	        	System.out.println();
	        	System.out.println("Current:");
	        	System.out.println("Current Day: " + goalTracker.getDay());
	        	System.out.println("Current Goals: " + goalTracker.getGoalsToBeCompleted());
	        	System.out.println("Current Initiative: " + goalTracker.getInitiative());
	        	System.out.println();
	        	
	        } else if(user==4) {
	        	for(int i = 1; i < goalList.getListOfGoals().size()+1; i++) {
	        		System.out.println("" + i + ". " + goalList.getListOfGoals().get(i-1).getStatement());
	        	}
	        	System.out.println("Which goal did you complete?");
	        	int input = scanner3.nextInt();
	        	if(input <= goalList.getListOfGoals().size()+1){
		        	System.out.println("Congratulations! You completed '" + goalList.getListOfGoals().get(input-1).getStatement() + "'! You gained "
		    	        	+ goalList.getListOfGoals().get(input-1).getInitiative() + " initiative!");
		        	goalTracker.changeInitiative(goalList.getListOfGoals().get(input-1).getInitiative());
		        	goalTracker.completeGoal();
		        	goalList.removeFromList(goalList.getListOfGoals().get(input-1));
		        	goalTracker.removeGoal();
	        	} else {
	        		System.out.println("You do not have any goals to complete here.");
	        	}
		        	System.out.println();
	        } else if(user==5) {
				BuddySystem buddySystem = new BuddySystem();
		        System.out.println("Welcome to BuddySystem!");
		        String userInput = scanner.nextLine();
		        String response = buddySystem.getMotivationalOrFact(userInput);
		        System.out.println("Response: " + response + "\nType 'Exit Now' to leave, 'fact' for a fitness fact.");
		        while(userInput.indexOf("Exit Now") == -1) {
			        userInput = scanner.nextLine();
			        response = buddySystem.getMotivationalOrFact(userInput);
			        if(userInput.indexOf("Exit Now") != -1){
			        	System.out.println("Response: Goodbye!");
			        	System.out.println();
			        } else {
			            System.out.println("Response: " + response + "\nType 'Exit Now' to leave, 'fact' for a fitness fact.");
			        }
		        }
	        } else if(user==6) {
	        	System.out.println("Good night!");
	        	goalTracker.increaseDay();
	        	System.out.println("You are on day #" + goalTracker.getDay());
	        	for(int i = 0; i < goalList.getListOfGoals().size(); i++) {
	        		goalList.getListOfGoals().get(i).decreaseAmountOfDays();
	        		if(goalList.getListOfGoals().get(i).getAmountOfDays() <= 0) {
	        			System.out.println("Ouch! You failed to complete '" + goalList.getListOfGoals().get(i).getStatement() + "'! You lost "
			    	        	+ goalList.getListOfGoals().get(i).getInitiative() + " initiative!");
	        			goalTracker.failGoal();
	        			goalTracker.removeGoal();
	        			goalTracker.changeInitiative(-(goalList.getListOfGoals().get(i).getInitiative()));
	        			goalList.removeFromList(goalList.getListOfGoals().get(i));
	        		}
	        	}
	        	System.out.println();
	        }
        }
        scanner.close();
	}
	
	
}
