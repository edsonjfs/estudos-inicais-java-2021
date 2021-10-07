package campoMinado;

import java.util.ArrayList;
import java.util.List;


public class Campo {
	boolean aberto;
	boolean minado;
	boolean marcado;
	int linha;
	int coluna;
	
	public Campo( int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	
	public List<Campo> camposVizinhos = new ArrayList<Campo>();
	
	public boolean isVizinho(Campo isVizinho) {
		int diferencaLinha = Math.abs(linha - isVizinho.linha);
		int diferencaColuna = Math.abs(coluna - isVizinho.coluna);	
		int somaDasDiferencas = diferencaColuna + diferencaLinha;
		
		if ((linha == isVizinho.linha || coluna == isVizinho.coluna) &&
				(somaDasDiferencas == 1 )) {
			return true;
		} else if ((diferencaColuna == 1 || diferencaLinha == 1) && 
				(somaDasDiferencas == 2 )) {
			return true;
		}
		
		return false;	
	}
	

	
	public void alternarMarcacaoDoCampo(){
		if (!aberto) {
			marcado = !marcado;
			}
	}
	
	
}
