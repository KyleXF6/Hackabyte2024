package mainCode;

import java.awt.Color;
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

public class CreateGoalDialog {
	
	private JDialog dialog;
	private String name;
	private int duration;
	private int init;
	private boolean wasSuccessful;
	private JTextField nameField;
	private JTextField durationField;
	private JTextField initField;
	
	public CreateGoalDialog(JFrame parent) {
		JDialog jf = new JDialog(parent, "Create Goal", true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(500,500);

		Container root = jf.getContentPane();
		GridBagConstraints gc = new GridBagConstraints();
		JPanel grid = new JPanel();
		grid.setBorder(new EmptyBorder(30,30,30,30));
		grid.setLayout(new GridBagLayout());
		root.add(grid);
	
		gc.gridx = 0;
		gc.gridy = 0;
		grid.add(new JLabel("Goal: "), gc);
		gc.gridy = 1;
		grid.add(new JLabel("Duration (in days): "), gc);
		gc.gridy = 2;
		grid.add(new JLabel("Initiative: "), gc);
		
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1;
		gc.gridx = 1;
		gc.gridy = 0;
		nameField = new JTextField(); 
		grid.add(nameField, gc);

		gc.gridy = 1;
		durationField = new JTextField();
		durationField.setText("30");
		grid.add(durationField, gc);
		
		gc.gridy = 2;
		initField = new JTextField(); 
		initField.setText("100");
		grid.add(initField, gc);
		
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 2;
		gc.weightx = 1;
		grid.add(flow, gc);
		
		JButton okButton = new JButton("OK");
		okButton.setBackground(Color.GREEN);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleOKButtonClicked();
			}
		});
		flow.add(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.RED);
		flow.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCancelButtonClicked();
			}
		});
		dialog = jf;
	}
	
	public boolean show() {
		dialog.setVisible(true);
		return wasSuccessful;
	}
	
	private void handleOKButtonClicked() {
		dialog.setVisible(false);
		name = nameField.getText();
		duration = Integer.parseInt(durationField.getText());
		init = Integer.parseInt(initField.getText());
		wasSuccessful = true;
	}
	
	private void handleCancelButtonClicked() {
		dialog.setVisible(false);
		wasSuccessful = false;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}


	public int getInit() {
		return init;
	}


}
