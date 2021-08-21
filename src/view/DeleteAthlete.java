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
import model.AthleteTableModel;
import model.OlympicAthlete;

@SuppressWarnings("serial")
public class DeleteAthlete extends JFrame {
	
	private final Color BACKGROUND_COLOR = new Color(143,188,143);
	private final Color COLOR_GREEN_LIGHT_1 = new Color(144,238,144);
	private final Color COLOR_GRAY = new Color(220,220,220);
	private final Color COLOR_RED = new Color(255,99,71);
	
	private final int SCREEN_WIDTH = 480;
	private final int SCREEN_HIGHT = 230;
	
	private List<OlympicAthlete> listAthletes = new ArrayList<>();
	private AthleteTableModel tableModel = new AthleteTableModel(listAthletes);
	private JTable table = new JTable(tableModel);
	JPanel panel;

	
	private JTextField idText;
	
	public DeleteAthlete() {
		formatUpdateAthlete();
	}

	private void formatUpdateAthlete() {
		
		setLayout(new FlowLayout());
		setTitle("Update Athlete");
		setSize(SCREEN_WIDTH, SCREEN_HIGHT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		readDataBaseAthlete();
		
		panel = new JPanel();
		add(panel);
		panel.add(table);
		table.setPreferredScrollableViewportSize(new Dimension(440, 100));
		table.setBackground(COLOR_GREEN_LIGHT_1);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		panel.add(scroll);
		
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
		idLabel.setForeground(BACKGROUND_COLOR);
		idText = new JTextField(4);
		idPanel.add(idLabel); idPanel.add(idText);
		add(idPanel);
		
	}
	
	public void formatButtons(JPanel container) {
		Button buttonUpdate = new Button("DELETE", COLOR_GREEN_LIGHT_1);
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
		add(container);
	}
	
	private void actionInUpdate(Button buttonDelete) {
		buttonDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAthlete();
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
	
    public void deleteAthlete() {
        Connection connection = ConnectionFactory.getConnection();
        String query = "DELETE FROM athletes WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(idText.getText()));
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Success to delete an athlete", "delete athlete", JOptionPane.INFORMATION_MESSAGE);
           // readDataBaseAthlete();
            tableModel.fireTableDataChanged();
            //table = new JTable(tableModel);
            //panel.add(table);

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error to delete an athlete", "Erro Database", JOptionPane.ERROR_MESSAGE);
        }
    }
	
}







