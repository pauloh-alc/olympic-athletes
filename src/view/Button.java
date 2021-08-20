package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton{
	
	@SuppressWarnings("unused")
	private JButton button;
	
	public Button(String text, Color color) {
		button = new JButton();
		setText(text);
		setOpaque(true);
		setBackground(color);
		setForeground(Color.BLACK);
		setFont(new Font("Arial", Font.BOLD, 15));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
