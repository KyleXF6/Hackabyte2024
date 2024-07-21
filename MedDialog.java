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
import javax.swing.border.EmptyBorder;

public class MedDialog {
private JDialog dialog;
	
	public MedDialog(JFrame parent, String title, String text1, String text2, String text3, String text4, String text5) {
		JDialog jf = new JDialog(parent, title, true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(800,200);

		Container root = jf.getContentPane();
		GridBagConstraints gc = new GridBagConstraints();
		JPanel grid = new JPanel();
		grid.setBorder(new EmptyBorder(30,30,30,30));
		grid.setLayout(new GridBagLayout());
		root.add(grid);
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		grid.add(new JLabel(text1), gc);
		gc.gridy = 1;
		grid.add(new JLabel(text1), gc);
		gc.gridy = 2;
		grid.add(new JLabel(text3), gc);
		gc.gridy = 3;
		grid.add(new JLabel(text4), gc);
		gc.gridy = 4;
		grid.add(new JLabel(text5), gc);
		
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		gc.gridx = 0;
		gc.gridy = 6;
		gc.gridwidth = 2;
		gc.weightx = 1;
		grid.add(flow, gc);
		
		JButton closeButton = new JButton("Close");
		closeButton.setBackground(Color.RED);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleOKButtonClicked();
			}
		});
		flow.add(closeButton);
		dialog = jf;
	}
	
	private void handleOKButtonClicked() {
		dialog.setVisible(false);
	}
	
	public void show() {
		dialog.setVisible(true);
	}
}


