package calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel{
	private JLabel label;
	
	public Display() {
		label = new JLabel("LAbek");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		setBackground(new Color(46,49,50));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT,10, 25));
		
		add(label);
	}
}
