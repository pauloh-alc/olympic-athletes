package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import connection.ConnectionFactory;

@SuppressWarnings("serial")
public class MainScreen extends JFrame{
	
	private final int SCREEN_WIDTH = 500;
	private final int SCREEN_HEIGHT = 500;
	
	private final Color COLOR_GREEN_LIGHT_1 = new Color(144,238,144);
	private final Color COLOR_GREEN_LIGHT_2 = new Color(152,251,152);
	private final Color COLOR_GREEN_LIGHT_3 = new Color(143,188,143);
	private final Color COLOR_GREEN_LIGHT_4 = new Color(0,250,154);
	
	public MainScreen() {
		formatLayout();
	}
	
	public void formatLayout() {
		setLayout(new BorderLayout());
		setTitle("Main Screen");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel containsButtons = new JPanel();
		containsButtons.setLayout(new GridLayout(2, 2));
		
		createButtons(containsButtons);
		add(containsButtons);
		
		setVisible(true);
	}
	
	public void createButtons(JPanel containsButtons) {
		Button buttonCreateAthlete = new Button("CREATE ATHLETE", COLOR_GREEN_LIGHT_1);
		containsButtons.add(buttonCreateAthlete);
		actionInCreatingAthlete(buttonCreateAthlete);
		
		
		Button buttonReadAthlete = new Button("READ ATHLETE", COLOR_GREEN_LIGHT_2);
		containsButtons.add(buttonReadAthlete);
		actionInReadAthlete(buttonReadAthlete);
		
		Button buttonUpdateAthlete = new Button("UPDATE ATHLETE", COLOR_GREEN_LIGHT_3);
		containsButtons.add(buttonUpdateAthlete);
		actionInUpdateAthlete(buttonUpdateAthlete);
		
		Button buttonDeleteAthlete = new Button("DELETE ATHLETE", COLOR_GREEN_LIGHT_4);
		containsButtons.add(buttonDeleteAthlete);
		actionInDeleteAthlete(buttonDeleteAthlete);
	}
	
	private void actionInCreatingAthlete(Button buttonCreateAthlete) {
		buttonCreateAthlete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateAthlete();
			}
		});
	}
	
	private void actionInReadAthlete(Button buttonReadAthlete) {
		buttonReadAthlete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReadAthlete();
			}
		});
	}
	
	private void actionInUpdateAthlete(Button buttonUpdateAthlete) {
		buttonUpdateAthlete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateAthlete();
			}
		});
	}
	private void actionInDeleteAthlete(Button buttonDeleteAthlete) {}
	
	public static void main(String[] args) {
		new MainScreen();
		ConnectionFactory.createDataBase();     
		ConnectionFactory.createTableAthlete();
	}
}
