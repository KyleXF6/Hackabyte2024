package mainCode;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SearchForFactsDialog {
	
	private JFrame frame;
	
	private String[] dance = {"Improves condition of your heart and lungs.", "Increases muscular strength, endurance and motor fitness.", 
			"Develops stronger bones and reduces risk of osteoporosis.", "Improves coordination, agility and flexibility.", "Helps with weight management."};
	
	private String[] walkingHiking = {"Increases cardiovascular fitness.", "Strengthens bones.", "Reduces excess body fat.", 
			"Boosts muscle power and endurance.", "Reduces your risk of developing conditions such as heart disease, type 2 diabetes, osteoporosis and cancers."};

	private String[] swimming = {"Increases your heart rate without stressing your body.", "Tones muscles.", "Builds endurance.", 
			"Helps lower blood pressure and controls blood sugar.", "Reduces physical limitation in patients with osteoarthritis."};

	private String[] meditation = {"Helps lower blood pressure.", "Regulates stress levels.", "Improves self-awareness.", 
			"Improves sleep quality.", "Reduces anxiety."};

	private String[] cycling = {"Increased cardiovascular fitness.", "Increased muscle strength and flexibility.", 
			"Improved joint mobility.", "Decreased stress levels.", "Improved posture and coordination."};

	private String[] aquaAerobics = {"Reduces stress and anxiety.", "Decreases heart rate and blood pressure.", "Helps with joint pressure.", 
			"Reduces risk of cardiovascular disease.", "Enhances balance and coordination."};

	private String[] pilatesYogaStretching = {"Improves sleep.", "Reduces stress.", "Improves balance and coordination.", "Supports bones and joints.", "Improves respiration."};

	private String[] taiChi = {"Improves balance.", "Improves cognitive function.", "Improves sleep quality.", "Enhances immune system.", "Reduces risk of heart failure."};



	public SearchForFactsDialog(JFrame parent) {
		JFrame jf = new JFrame("Facts Search");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500,500);

		Container root = jf.getContentPane();
		GridBagConstraints gc = new GridBagConstraints();
		JPanel grid = new JPanel();
		grid.setBorder(new EmptyBorder(30,30,30,30));
		grid.setLayout(new GridBagLayout());
		root.add(grid);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		JButton walkingHikingButton = new JButton("Walking/Hiking");
		grid.add(walkingHikingButton, gc);
		walkingHikingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleWalkingHikingButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 1;
		JButton danceButton = new JButton("Dance");
		grid.add(danceButton,gc);
		danceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleDanceButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 2;
		JButton swimmingButton = new JButton("Swimming");
		grid.add(swimmingButton, gc);
		swimmingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleSwimmingButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 3;
		JButton meditationButton = new JButton("Meditation");
		grid.add(meditationButton, gc);
		meditationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleMeditationButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 4;
		JButton pilatesYogaStretchingButton = new JButton("Yoga");
		grid.add(pilatesYogaStretchingButton, gc);
		pilatesYogaStretchingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handlePilatesYogaStretchingButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 5;
		JButton taiChiButton = new JButton("Tai Chi");
		grid.add(taiChiButton, gc);
		taiChiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleTaiChiButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 6;
		JButton aquaAerobicsButton = new JButton("Aqua Aerobics");
		grid.add(aquaAerobicsButton, gc);
		aquaAerobicsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleAquaAerobicsButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 7;
		JButton cyclingButton = new JButton("Cycling");
		grid.add(cyclingButton, gc);
		cyclingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCyclingButtonClicked();
			}
		});
		gc.gridx = 0;
		gc.gridy = 8;
		
		JButton closeButton = new JButton("Close");
		grid.add(closeButton, gc);
		closeButton.setBackground(Color.RED);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCloseButtonClicked();
			}
		});
		
		frame = jf;
		show();
	}
	
	private void handleCloseButtonClicked() {
		frame.setVisible(false);
	}
	
	private void handleDanceButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", dance[0], dance[1], dance[2], dance[3], dance[4]);
		cdg.show();
	}
	
	private void handleWalkingHikingButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", walkingHiking[0], walkingHiking[1], walkingHiking[2], walkingHiking[3], walkingHiking[4]);
		cdg.show();
	}
	
	private void handleSwimmingButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", swimming[0], swimming[1], swimming[2], swimming[3], swimming[4]);
		cdg.show();
	}
	
	private void handleMeditationButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", meditation[0], meditation[1], meditation[2], meditation[3], meditation[4]);
		cdg.show();
	}
	
	private void handlePilatesYogaStretchingButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", pilatesYogaStretching[0], pilatesYogaStretching[1], pilatesYogaStretching[2], 
				pilatesYogaStretching[3], pilatesYogaStretching[4]);
		cdg.show();
	}

	private void handleTaiChiButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", taiChi[0], taiChi[1], taiChi[2], 
				taiChi[3], taiChi[4]);
		cdg.show();
	}
	
	private void handleAquaAerobicsButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", aquaAerobics[0], aquaAerobics[1], aquaAerobics[2], 
				aquaAerobics[3], aquaAerobics[4]);
		cdg.show();
	}
	
	private void handleCyclingButtonClicked() {
		MedDialog cdg = new MedDialog(frame, "Suggestions", cycling[0], cycling[1], cycling[2], 
				cycling[3], cycling[4]);
		cdg.show();
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
