package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton{
	
	public Button(Icon icon) {
		setIcon(icon);
		setOpaque(true);
		setForeground(Color.BLACK);
		setFont(new Font("Arial", Font.BOLD, 15));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public Button(String text, Color color) {
		setText(text);
		setOpaque(true);
		setBackground(color);
		setForeground(Color.BLACK);
		setFont(new Font("Arial", Font.BOLD, 15));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}
