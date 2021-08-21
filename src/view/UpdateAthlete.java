package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import connection.ConnectionFactory;
import model.AthleteTableModel;
import model.OlympicAthlete;

@SuppressWarnings("serial")
public class UpdateAthlete extends JFrame {
	
	
	private final Color COLOR_GREEN_LIGHT = new Color(144,238,144);
	private final int SCREEN_WIDTH = 480;
	private final int SCREEN_HIGHT = 410;
	
	private List<OlympicAthlete> listAthletes = new ArrayList<>();; 
	private AthleteTableModel tableModel = new AthleteTableModel(listAthletes);;
	private JTable table = new JTable(tableModel);;
	
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
		
		//setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		setTitle("Update Athlete");
		setSize(SCREEN_WIDTH, SCREEN_HIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		readDataBaseAthlete();
		
		JPanel panel = new JPanel();
		add(panel);
		//panel.add(table);
		table.setPreferredScrollableViewportSize(new Dimension(440, 100));
		table.setBackground(COLOR_GREEN_LIGHT);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		panel.add(scroll);
		
		nameText = new JTextField(15);
		JLabel name = new JLabel("name");
		JPanel panel2 = new JPanel();
		panel2.add(name);
		panel2.add(nameText);
		add(panel2);
	
		
		setVisible(true);
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
}

