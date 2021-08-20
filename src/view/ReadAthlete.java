package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ReadAthlete extends JFrame{
	
	public ReadAthlete() {
		formatReadAthlete();
	}

	private void formatReadAthlete() {
		setLayout(new BorderLayout());
		setTitle("Read Athlete");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
}
