package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost";
			String user = "root";
			String password = "pauloalunoufc";
			
			return DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void createDataBase() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.execute("CREATE DATABASE IF NOT EXISTS olympiad");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error creating database - " + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);;
		}	
	}
	
	public static void createTableAthlete() {
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS athletes ("
				+ "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(50) NOT NULL,"
				+ "age INT NOT NULL,"
				+ "sex VARCHAR(10) NOT NULL,"
				+ "comittee VARCHAR(50) NOT NULL,"
				+ "sport VARCHAR(50) NOT NULL"
				+ ");";
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error creating table athletes - " + e.getMessage(), "Dadabase error", JOptionPane.ERROR_MESSAGE);
		}
	}
}