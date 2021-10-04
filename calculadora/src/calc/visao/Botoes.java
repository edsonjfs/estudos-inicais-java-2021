package calc.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botoes extends JButton {
	public Botoes (String texto, Color cor) {
		setText(texto);
		setBackground(cor);
		setOpaque(true);
		setFont(new Font("courier", Font.PLAIN, 25));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setForeground(Color.white);
	}
}
