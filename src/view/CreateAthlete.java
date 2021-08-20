package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.OlympicAthlete;

@SuppressWarnings("serial")
public class CreateAthlete extends JFrame{
	
	private final int SCREEN_WIDTH = 400;
	private final int SCREEN_HEIGHT = 230;
	
	private final Color BACKGROUND_COLOR = new Color(152,251,152);
	private final Color COLOR_GREEN_LIGHT_4 = new Color(0,250,154);
	private final Color COLOR_GRAY = new Color(220,220,220);
	private final Color COLOR_RED = new Color(255,99,71);
	
	private JTextField nameText;
	private JTextField ageText;
	
	public CreateAthlete() {
		formatCreateAthlete();
	}
	
	private void formatCreateAthlete() {
		setLayout(new FlowLayout());
		setTitle("Create Athlete");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(BACKGROUND_COLOR);
		
		createContainerInput();
		
		createButtons();
		
		setVisible(true);
	}
	
	private void createButtons() {
		Button buttonSave = new Button("SAVE", COLOR_GREEN_LIGHT_4);
		Button buttonClear = new Button("CLEAR", COLOR_GRAY);
		Button buttonExit = new Button("EXIT", COLOR_RED);

		add(buttonSave);
		actionInSave(buttonSave);
		
		add(buttonClear);
		actionInClear(buttonClear);
		
		add(buttonExit);
		actionInExit(buttonExit);
	}
	
	private void actionInSave(Button buttonSave) {
		buttonSave.addActionListener(new ActionListener() {
			
			OlympicAthlete athlete = new OlympicAthlete();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//athlete.setNome();
				System.out.println(athlete.getNome());
			}
		});
		
	}
	
	private void actionInClear(Button buttonClear) {
	
		
	}
	
	private void actionInExit(Button buttonExit) {
		
	}

	public void createContainerInput() {

		// Name
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		namePanel.setPreferredSize(new Dimension(370, 20));
		namePanel.setBackground(BACKGROUND_COLOR);
		
		JLabel nameLabel = new JLabel("Name: ");
		nameText = new JTextField(30);
		namePanel.add(nameLabel); namePanel.add(nameText);
		add(namePanel);
		
		// Age
		JPanel agePanel = new JPanel();
		agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
		agePanel.setPreferredSize(new Dimension(370, 20));
		agePanel.setBackground(BACKGROUND_COLOR);
		
		JLabel ageLabel = new JLabel("Age: ");
		ageText = new JTextField(30);
		agePanel.add(ageLabel); agePanel.add(ageText);
		add(agePanel);
		
		// Sex
		JPanel sexPanel = new JPanel();
		sexPanel.setLayout(new BoxLayout(sexPanel, BoxLayout.X_AXIS));
		sexPanel.setPreferredSize(new Dimension(370, 20));
		sexPanel.setBackground(BACKGROUND_COLOR);
	
		JLabel sexLabel = new JLabel("Sex: ");
		JTextField sexText = new JTextField(30);
		sexPanel.add(sexLabel); 
		sexPanel.add(sexText);
		add(sexPanel);
		
		// Sport
		JPanel sportPanel = new JPanel();
		sportPanel.setLayout(new BoxLayout(sportPanel, BoxLayout.X_AXIS));
		sportPanel.setPreferredSize(new Dimension(370, 20));
		sportPanel.setBackground(BACKGROUND_COLOR);
		
		JLabel sportLabel = new JLabel("Sport: ");
		JTextField sportText = new JTextField(30);
		sportPanel.add(sportLabel); 
		sportPanel.add(sportText);
		add(sportPanel);
		
		
		// Comittee
		JPanel comitteePanel = new JPanel();
		comitteePanel.setLayout(new BoxLayout(comitteePanel, BoxLayout.X_AXIS));
		comitteePanel.setPreferredSize(new Dimension(370, 20));
		comitteePanel.setBackground(BACKGROUND_COLOR);
		
		JLabel comitteeLabel = new JLabel("Comittee: ");
		JTextField comitteeText = new JTextField(28);
		comitteePanel.add(comitteeLabel); 
		comitteePanel.add(comitteeText);
		add(comitteePanel);
	}
}
