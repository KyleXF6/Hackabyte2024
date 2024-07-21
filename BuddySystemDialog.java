package mainCode;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BuddySystemDialog {
	private JDialog dialog;
	private String text;
	private JTextField textField;
	
	private String[] motivationalQuotes = {"You got this!", "You're doing great!", "Just believe in yourself!", "You can pull through!", "One more step!", 
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
	
	private String[] facts = {"Regular physical activity among seniors reduces the risk of chronic diseases such as heart disease, stroke, type 2 diabetes, and certain cancers.",
			"Exercise helps maintain and increase muscle mass, which is crucial for maintaining strength and mobility as we age.",
			"Weight-bearing exercises such as walking, dancing, and strength training help maintain bone density and reduce the risk of osteoporosis and fractures.",
			"Participating in fitness activities can lead to social interaction and community involvement, reducing feelings of isolation and loneliness among seniors.",
			"Seniors who engage in regular physical activity tend to live longer and have a higher quality of life compared to sedentary individuals.",
			"Fitness programs for seniors often include low-impact activities that are gentle on joints, such as swimming, tai chi, and yoga.",
			"Balance exercises, such as standing on one foot or heel-to-toe walking, help improve stability and reduce the risk of falls.",
			"Regular physical activity helps seniors maintain a healthy weight and metabolism, reducing the risk of obesity and related health issues.",
			"Combined with a balanced diet, exercise supports overall health and well-being by providing essential nutrients and energy for daily activities."
	};
	
	private String[] suggestions = {"Go interact with your family!", "Go hang out with your pet(s)!", 
			"Go to your nearest library and read a book!", "Go take a long nap!", "Go indulge in some good food!", "Go to your nearest garden!", 
			"Go breathe in the fresh air and look at some good scenery!", "Go and take some time to meditate!", "Make yourself a nice cup of tea.", 
			"Explore some mindfulness exercises!”, “Go journal your day!", "Turn on some music and relax!"
	};
	
	public BuddySystemDialog(JFrame parent) {
		JDialog jf = new JDialog(parent, "BuddySystem", true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(800,300);

		Container root = jf.getContentPane();
		GridBagConstraints gc = new GridBagConstraints();
		JPanel grid = new JPanel();
		grid.setBorder(new EmptyBorder(30,30,30,30));
		grid.setLayout(new GridBagLayout());
		root.add(grid);
		
		gc.gridx = 0;
		gc.gridy = 0;
		grid.add(new JLabel("Text: "), gc);
		
		
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1;
		gc.gridx = 1;
		gc.gridy = 0;
		textField = new JTextField(); 
		grid.add(textField, gc);

		
		
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.weightx = 1;
		grid.add(flow, gc);
		
		JButton enterButton = new JButton("ENTER");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleEnterButtonClicked();
			}
		});
		flow.add(enterButton);
		dialog = jf;
		show();

	}
	
	public void show() {
		dialog.setVisible(true);

	}
	
	private void handleEnterButtonClicked() {
		text = textField.getText();
		if(text.indexOf("fact") != -1) {
			textField.setText("");
			int random = (int)(Math.random()*facts.length);
			SimpleDialog response = new SimpleDialog(new JFrame(), "Response", facts[random], "Type 'exit' to leave, "
					+ "'fact' for a fitness fact, or 'suggestion' for a suggestion.");
			response.show();
		} else if(text.equals("exit")){
			textField.setText("");
			SimpleDialog response = new SimpleDialog(new JFrame(), "Response", "Bye Bye!", "Remember to stay safe and fit!");
			dialog.setVisible(false);
			response.show();
		} else if(text.indexOf("suggestion") != -1) {
			textField.setText("");
			int random = (int)(Math.random()*suggestions.length);
			SimpleDialog response = new SimpleDialog(new JFrame(), "Response", suggestions[random], "Type 'exit' to leave, "
					+ "'fact' for a fitness fact, or 'suggestion' for a suggestion.");
			response.show();
		} else if(text.toLowerCase().indexOf("hello") != -1) {
			textField.setText("");
			SimpleDialog response = new SimpleDialog(new JFrame(), "Response", "Hello!", "Is there anything I can help you with today?");
			response.show();

		} else {
			textField.setText("");
			int random = (int)(Math.random()*motivationalQuotes.length);
			SimpleDialog response = new SimpleDialog(new JFrame(), "Response", motivationalQuotes[random], "Type 'exit' to leave, "
					+ "'fact' for a fitness fact, or 'suggestion' for a suggestion.");
			response.show();
		}
		
	}
	
	

	public String getText() {
		return text;
	}
}
