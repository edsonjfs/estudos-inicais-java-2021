package calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import calc.modelo.Memoria;
import calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{
	private JLabel label;
	
	public Display() {
		Memoria.getMemoria().adicionarObservador(this);
		
		label = new JLabel(Memoria.getMemoria().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		setBackground(new Color(46,49,50));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT,10, 25));
		
		add(label);
		
	}
	
	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
}
