package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import connection.ConnectionFactory;
import model.OlympicAthlete;

@SuppressWarnings("serial")
public class CreateAthlete extends JFrame{
	
	private final int SCREEN_WIDTH = 400;
	private final int SCREEN_HEIGHT = 265;
	
	private final Color BACKGROUND_COLOR = new Color(134, 163, 195);
	private final Color COLOR_BLUE_DARK = new Color(28,210,66);
	private final Color COLOR_BLUE_LIGHT = new Color(192, 202, 214);
	private final Color COLOR_RED = new Color(255,99,71);

	private JTextField nameText;
	private JTextField ageText;
	private JTextField sexText;
	private JTextField committeeText;
	private JTextField sportText;
	private JTextField medalGoldText;
	private JTextField medalSilverText;
	private JTextField medalBronzeText;
	
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
		Button buttonSave = new Button("SAVE", COLOR_BLUE_DARK);
		Button buttonClear = new Button("CLEAR", COLOR_BLUE_LIGHT);
		Button buttonExit = new Button("EXIT", COLOR_RED);

		add(buttonSave);
		actionInSave(buttonSave);
		
		add(buttonClear);
		actionInClear(buttonClear);
		
		add(buttonExit);
		actionInExit(buttonExit);
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
		sexText = new JTextField(30);
		sexPanel.add(sexLabel); 
		sexPanel.add(sexText);
		add(sexPanel);
		
		// Sport
		JPanel sportPanel = new JPanel();
		sportPanel.setLayout(new BoxLayout(sportPanel, BoxLayout.X_AXIS));
		sportPanel.setPreferredSize(new Dimension(370, 20));
		sportPanel.setBackground(BACKGROUND_COLOR);
		
		JLabel sportLabel = new JLabel("Sport: ");
		sportText = new JTextField(30);
		sportPanel.add(sportLabel); 
		sportPanel.add(sportText);
		add(sportPanel);
		
		
		// Comittee
		JPanel comitteePanel = new JPanel();
		comitteePanel.setLayout(new BoxLayout(comitteePanel, BoxLayout.X_AXIS));
		comitteePanel.setPreferredSize(new Dimension(370, 20));
		comitteePanel.setBackground(BACKGROUND_COLOR);
		
		JLabel comitteeLabel = new JLabel("Comittee: ");
		committeeText = new JTextField(28);
		comitteePanel.add(comitteeLabel); 
		comitteePanel.add(committeeText);
		add(comitteePanel);
		
		// Medal Gold
		JPanel medalGoldPanel = new JPanel();
		medalGoldPanel.setLayout(new BoxLayout(medalGoldPanel, BoxLayout.X_AXIS));
		medalGoldPanel.setPreferredSize(new Dimension(370, 20));
		medalGoldPanel.setBackground(BACKGROUND_COLOR);
		
		JLabel medalGoldLabel = new JLabel("Amount of Gold: ");
		medalGoldText = new JTextField(28);
		medalGoldPanel.add(medalGoldLabel); 
		medalGoldPanel.add(medalGoldText);
		add(medalGoldPanel);
		
		// Medal Silver
		JPanel medalSilverPanel = new JPanel();
		medalSilverPanel.setLayout(new BoxLayout(medalSilverPanel, BoxLayout.X_AXIS));
		medalSilverPanel.setPreferredSize(new Dimension(370, 20));
		medalSilverPanel.setBackground(BACKGROUND_COLOR);
		
		JLabel medalSilverLabel = new JLabel("Amount of Silver: ");
		medalSilverText = new JTextField(28);
		medalSilverPanel.add(medalSilverLabel); 
		medalSilverPanel.add(medalSilverText);
		add(medalSilverPanel);
		
		// Medal Bronze
		JPanel medalBronzePanel = new JPanel();
		medalBronzePanel.setLayout(new BoxLayout(medalBronzePanel, BoxLayout.X_AXIS));
		medalBronzePanel.setPreferredSize(new Dimension(370, 20));
		medalBronzePanel.setBackground(BACKGROUND_COLOR);
		
		JLabel medalBronzeLabel = new JLabel("Amount of Bronze: ");
		medalBronzeText = new JTextField(28);
		medalBronzePanel.add(medalBronzeLabel); 
		medalBronzePanel.add(medalBronzeText);
		add(medalBronzePanel);
		
	}
	
	private void actionInSave(Button buttonSave) {
		buttonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addAthleteToDataBase();
			}
		});
	}
	
	private void addAthleteToDataBase() {
		OlympicAthlete athlete = new OlympicAthlete();
		
		
		athlete.setName(nameText.getText());
		athlete.setAge(Integer.parseInt(ageText.getText()));
		athlete.setSex(sexText.getText());
		athlete.setCommittee(committeeText.getText());
		athlete.setSport(sportText.getText());
		athlete.setMedals(Integer.parseInt(medalGoldText.getText()));
		athlete.setMedals(Integer.parseInt(medalSilverText.getText()));
		athlete.setMedals(Integer.parseInt(medalBronzeText.getText()));
	
		Connection connection = ConnectionFactory.getConnection();

		String sql = "INSERT INTO athletes (name, age, sex, committee, sport, gold, silver, bronze) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, athlete.getName());
			stmt.setInt(2, athlete.getAge());
			stmt.setString(3, athlete.getSex());
			stmt.setString(4, athlete.getCommittee());
			stmt.setString(5, athlete.getSport());
			stmt.setInt(6, athlete.getMedals().get(0));
			stmt.setInt(7, athlete.getMedals().get(1));
			stmt.setInt(8, athlete.getMedals().get(2));
			stmt.execute();
			clearFields();
			JOptionPane.showMessageDialog(null, "Athlete added with success!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error insert athlete - " + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void actionInClear(Button buttonClear) {
		buttonClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
	}
	
	public void clearFields() {
		nameText.setText("");
		ageText.setText("");
		sexText.setText("");
		committeeText.setText("");
		sportText.setText("");
		medalGoldText.setText("");
		medalSilverText.setText("");
		medalBronzeText.setText("");
	}
	
	private void actionInExit(Button buttonExit) {
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}
}
