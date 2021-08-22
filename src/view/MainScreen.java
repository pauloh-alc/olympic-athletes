package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import connection.ConnectionFactory;

@SuppressWarnings("serial")
public class MainScreen extends JFrame{
	
	private final int SCREEN_WIDTH = 700;
	private final int SCREEN_HEIGHT = 500;
	
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
		Icon iconCreate = new ImageIcon("img/create.png");
		Button buttonCreateAthlete = new Button(iconCreate);
		containsButtons.add(buttonCreateAthlete);
		actionInCreatingAthlete(buttonCreateAthlete);
		
		
		Icon iconRead = new ImageIcon("img/read.png");
		Button buttonReadAthlete = new Button(iconRead);
		containsButtons.add(buttonReadAthlete);
		actionInReadAthlete(buttonReadAthlete);
		
		Icon iconUpdate = new ImageIcon("img/update.png");
		Button buttonUpdateAthlete = new Button(iconUpdate);
		containsButtons.add(buttonUpdateAthlete);
		actionInUpdateAthlete(buttonUpdateAthlete);
		
		Icon iconDelete = new ImageIcon("img/delete.png");
		Button buttonDeleteAthlete = new Button(iconDelete);
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
	private void actionInDeleteAthlete(Button buttonDeleteAthlete) {
		buttonDeleteAthlete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteAthlete();
			}
		});
	}
	
	public static void main(String[] args) {
		new MainScreen();
		ConnectionFactory.createDataBase();     
		ConnectionFactory.createTableAthlete();
	}
}
