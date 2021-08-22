package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connection.ConnectionFactory;
import model.AthleteTableModel;
import model.OlympicAthlete;

@SuppressWarnings("serial")
public class ReadAthlete extends JFrame {
	
	private final Color BACKGROUND_COLOR = new Color(134, 163, 195);
	private final Color BACKGROUND_TABLE = new Color(157, 194, 236);
	private final Color COLOR_BLUE_LIGHT = new Color(199,231,238);
	private final int SCREEN_WIDTH = 500;
	private final int SCREEN_HIGHT = 180;
	
	private List<OlympicAthlete> listAthletes = new ArrayList<>();; 
	private AthleteTableModel tableModel = new AthleteTableModel(listAthletes);;
	private JTable table = new JTable(tableModel);;
	
	public ReadAthlete() {
		formatReadAthlete();
	}

	private void formatReadAthlete() {
		setLayout(new BorderLayout());
		setTitle("Read Athlete");
		setSize(SCREEN_WIDTH, SCREEN_HIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(BACKGROUND_COLOR);

		readDataBaseAthlete();
		
		JPanel panel = new JPanel();
		add(panel);
		panel.add(table);
		
		table.setBackground(COLOR_BLUE_LIGHT);
		table.setPreferredScrollableViewportSize(new Dimension(480, 100));
	
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.getViewport().setBackground(BACKGROUND_TABLE);
		panel.add(scroll);
		
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
