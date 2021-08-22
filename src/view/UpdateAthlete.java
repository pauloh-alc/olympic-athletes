package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import connection.ConnectionFactory;
import javax.swing.table.DefaultTableModel;
import model.OlympicAthlete;

@SuppressWarnings("serial")
public class UpdateAthlete extends JFrame {
	
	private final Color BACKGROUND_COLOR = new Color(134, 163, 195);
	private final Color BACKGROUND_TABLE = new Color(157, 194, 236);
	private final Color COLOR_BLUE_LIGHT = new Color(199,231,238);
	private final Color COLOR_GRAY = new Color(220,220,220);
	private final Color COLOR_RED = new Color(255,99,71);
	
	private final int SCREEN_WIDTH = 480;
	private final int SCREEN_HIGHT = 430;
	
	private List<OlympicAthlete> listAthletes = new ArrayList<>();
	private JTable table = new JTable();
	
	private JTextField idText;
	private JTextField nameText;
	private JTextField ageText;
	private JTextField sexText;
	private JTextField committeeText;
	private JTextField sportText;
	private JTextField medalGoldText;
	private JTextField medalSilverText;
	private JTextField medalBronzeText;
	
	public UpdateAthlete() {
		formatUpdateAthlete();
	}

	private void formatUpdateAthlete() {
		
		setLayout(new FlowLayout());
		setTitle("Update Athlete");
		setSize(SCREEN_WIDTH, SCREEN_HIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(BACKGROUND_COLOR);

		readDataBaseAthlete();
		
		JPanel panel = new JPanel();
		add(panel);
		panel.add(table);
		table.setPreferredScrollableViewportSize(new Dimension(440, 100));
		table.setBackground(COLOR_BLUE_LIGHT);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.getViewport().setBackground(BACKGROUND_TABLE);
		
		setModelTable();
		
		panel.add(scroll);
		
		loadTable();

		formatInput();
		
		JPanel container = new JPanel();
		
		
		formatButtons(container);
		
		setVisible(true);
	}
	
	public void formatInput() {
		
		// Id
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
			
		JLabel idLabel = new JLabel("ENTER THE ID: ");
		idLabel.setForeground(Color.BLACK);
		idText = new JTextField(4);
		idPanel.add(idLabel); idPanel.add(idText);
		idPanel.setBackground(BACKGROUND_COLOR);
		add(idPanel);
		
		// Name
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		namePanel.setPreferredSize(new Dimension(370, 20));
				
		JLabel nameLabel = new JLabel("Name: ");
		nameText = new JTextField(30);
		namePanel.add(nameLabel); namePanel.add(nameText);
		namePanel.setBackground(BACKGROUND_COLOR);
		add(namePanel);
		
		
		// Age
		JPanel agePanel = new JPanel();
		agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
		agePanel.setPreferredSize(new Dimension(370, 20));
		
		JLabel ageLabel = new JLabel("Age: ");
		ageText = new JTextField(30);
		agePanel.add(ageLabel); agePanel.add(ageText);
		agePanel.setBackground(BACKGROUND_COLOR);
		add(agePanel);
		
		// Sex
		JPanel sexPanel = new JPanel();
		sexPanel.setLayout(new BoxLayout(sexPanel, BoxLayout.X_AXIS));
		sexPanel.setPreferredSize(new Dimension(370, 20));
	
		JLabel sexLabel = new JLabel("Sex: ");
		sexText = new JTextField(30);
		sexPanel.add(sexLabel); 
		sexPanel.add(sexText);
		sexPanel.setBackground(BACKGROUND_COLOR);
		add(sexPanel);
		
		// Sport
		JPanel sportPanel = new JPanel();
		sportPanel.setLayout(new BoxLayout(sportPanel, BoxLayout.X_AXIS));
		sportPanel.setPreferredSize(new Dimension(370, 20));
		
		JLabel sportLabel = new JLabel("Sport: ");
		sportText = new JTextField(30);
		sportPanel.add(sportLabel); 
		sportPanel.add(sportText);
		sportPanel.setBackground(BACKGROUND_COLOR);
		add(sportPanel);
		
		// Comittee
		JPanel comitteePanel = new JPanel();
		comitteePanel.setLayout(new BoxLayout(comitteePanel, BoxLayout.X_AXIS));
		comitteePanel.setPreferredSize(new Dimension(370, 20));
		
		JLabel comitteeLabel = new JLabel("Comittee: ");
		committeeText = new JTextField(28);
		comitteePanel.add(comitteeLabel); 
		comitteePanel.add(committeeText);
		comitteePanel.setBackground(BACKGROUND_COLOR);
		add(comitteePanel);
		
		// Medal Gold
		JPanel medalGoldPanel = new JPanel();
		medalGoldPanel.setLayout(new BoxLayout(medalGoldPanel, BoxLayout.X_AXIS));
		medalGoldPanel.setPreferredSize(new Dimension(370, 20));
		
		JLabel medalGoldLabel = new JLabel("Amount of Gold: ");
		medalGoldText = new JTextField(28);
		medalGoldPanel.add(medalGoldLabel); 
		medalGoldPanel.add(medalGoldText);
		medalGoldPanel.setBackground(BACKGROUND_COLOR);
		add(medalGoldPanel);
		
		// Medal Silver
		JPanel medalSilverPanel = new JPanel();
		medalSilverPanel.setLayout(new BoxLayout(medalSilverPanel, BoxLayout.X_AXIS));
		medalSilverPanel.setPreferredSize(new Dimension(370, 20));
		
		JLabel medalSilverLabel = new JLabel("Amount of Silver: ");
		medalSilverText = new JTextField(28);
		medalSilverPanel.add(medalSilverLabel); 
		medalSilverPanel.add(medalSilverText);
		medalSilverPanel.setBackground(BACKGROUND_COLOR);
		add(medalSilverPanel);
		
		// Medal Bronze
		JPanel medalBronzePanel = new JPanel();
		medalBronzePanel.setLayout(new BoxLayout(medalBronzePanel, BoxLayout.X_AXIS));
		medalBronzePanel.setPreferredSize(new Dimension(370, 20));
		
		JLabel medalBronzeLabel = new JLabel("Amount of Bronze: ");
		medalBronzeText = new JTextField(28);
		medalBronzePanel.add(medalBronzeLabel); 
		medalBronzePanel.add(medalBronzeText);
		medalBronzePanel.setBackground(BACKGROUND_COLOR);
		add(medalBronzePanel);
	}
	
	public void formatButtons(JPanel container) {
		Button buttonUpdate = new Button("UPDATE", COLOR_BLUE_LIGHT);
		Button buttonClear = new Button("CLEAR", COLOR_GRAY);
		Button buttonExit = new Button("EXIT", COLOR_RED);

		add(buttonUpdate);
		actionInUpdate(buttonUpdate);
		
		add(buttonClear);
		actionInClear(buttonClear);
		
		add(buttonExit);
		actionInExit(buttonExit);
		
		container.add(buttonUpdate);
		container.add(buttonClear);
		container.add(buttonExit);
		container.setBackground(BACKGROUND_COLOR);
		add(container);
	}
	
	private void actionInUpdate(Button buttonUpdate) {
		buttonUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAthlete();
			}
		});
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

	private void actionInClear(Button buttonClear) {
		buttonClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				idText.setText("");
				nameText.setText("");
				ageText.setText("");
				sexText.setText("");
				committeeText.setText("");
				sportText.setText("");
				medalGoldText.setText("");
				medalSilverText.setText("");
				medalBronzeText.setText("");
			}
		});
	}


	public void readDataBaseAthlete() {
		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM athletes";

		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				String name = result.getString("name");
				int age = result.getInt("age");
				String sex = result.getString("sex");
				String committee = result.getString("committee");
				String sport = result.getString("sport");
				int medalGold = result.getInt("gold");
				int medalSilver = result.getInt("silver");
				int medalBronze = result.getInt("bronze");
				int id = result.getInt("id");
				listAthletes.add(new OlympicAthlete(id ,name, age, sex, committee, sport, medalGold, medalSilver, medalBronze));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error read database", "Erro Database", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void updateAthlete() {
		
		Connection connection = ConnectionFactory.getConnection();
		
		String select = "SELECT name, age, sex, committee, sport, gold, silver, bronze FROM athletes WHERE id = ?";
		String update = "UPDATE athletes SET name = ?, age = ?, sex = ?, "
				+ "committee = ?, sport = ?, gold = ?, silver = ?, bronze = ? WHERE id = " + idText.getText();
		try {
			PreparedStatement stmt = connection.prepareStatement(select);
			stmt.setInt(1, Integer.parseInt(idText.getText()));
				
			ResultSet result = stmt.executeQuery();
			
			if (result.next()) {
				OlympicAthlete athlete = new OlympicAthlete();
		
				athlete.setId(Integer.parseInt(idText.getText()));
				athlete.setName(nameText.getText());
				athlete.setAge(Integer.parseInt(ageText.getText()));
				athlete.setSex(sexText.getText());
				athlete.setCommittee(committeeText.getText());
				athlete.setSport(sportText.getText());
				athlete.setMedals(Integer.parseInt(medalGoldText.getText()));
				athlete.setMedals(Integer.parseInt(medalSilverText.getText()));
				athlete.setMedals(Integer.parseInt(medalBronzeText.getText()));
				
				stmt.close();
				stmt = connection.prepareStatement(update);
			
				stmt.setString(1, athlete.getName());
				stmt.setInt(2, athlete.getAge());
				stmt.setString(3, athlete.getSex());
				stmt.setString(4, athlete.getCommittee());
				stmt.setString(5, athlete.getSport());
				stmt.setInt(6, athlete.getMedals().get(0));
				stmt.setInt(7, athlete.getMedals().get(1));
				stmt.setInt(8, athlete.getMedals().get(2));

				stmt.execute();
			}
			
			refreshListAthlete();
			loadTable();
			
			JOptionPane.showMessageDialog(null, "Athlete updated with sucess!", "Update", JOptionPane.INFORMATION_MESSAGE);
			clear();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "..."+ e.getMessage());
		}
	}
	
	public void clear() {
		idText.setText("");
		nameText.setText("");
		ageText.setText("");
		sexText.setText("");
		committeeText.setText("");
		sportText.setText("");
		medalGoldText.setText("");
		medalSilverText.setText("");
		medalBronzeText.setText("");
	}

	public void loadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setNumRows(0);

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(5);
		table.getColumnModel().getColumn(7).setPreferredWidth(5);
		table.getColumnModel().getColumn(8).setPreferredWidth(5);

		try {
			for(OlympicAthlete tempAthlete: listAthletes) {
				model.addRow(new Object[] {
					tempAthlete.getId(),
					tempAthlete.getName(),
					tempAthlete.getAge(),
					tempAthlete.getSex(),
					tempAthlete.getCommittee(),
					tempAthlete.getSport(),
					tempAthlete.getMedals().get(0),
					tempAthlete.getMedals().get(1),
					tempAthlete.getMedals().get(2)
				} );
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error to load the table on the database");
		}
	}

	public void refreshListAthlete() {
		for (OlympicAthlete a: listAthletes) {
			if (a.getId() == Integer.parseInt(idText.getText())) {
				a.setId(Integer.parseInt(idText.getText()));
				a.setName(nameText.getText());
				a.setAge(Integer.parseInt(ageText.getText()));
				a.setSex(sexText.getText());
				a.setCommittee(committeeText.getText());
				a.setSport(sportText.getText());
				a.getMedals().clear();
				a.setMedals(Integer.parseInt(medalGoldText.getText()));
				a.setMedals(Integer.parseInt(medalSilverText.getText()));
				a.setMedals(Integer.parseInt(medalBronzeText.getText()));
				break;
			}
		}

	}

	public void setModelTable() {
		table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"Id","Name", "Age", "Sex", "Committee", "Sport", "Gold", "Silver", "Bronze" 
		}
		));
	}
}	


