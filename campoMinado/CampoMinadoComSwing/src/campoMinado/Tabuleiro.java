package campoMinado;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	int linhas;
	int colunas;
	int minas;
	
	List<Campo> camposDoTabuleiro = new ArrayList<Campo>(); 
	
	Tabuleiro(int linhas, int colunas, int minas){
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
	}
	
	public void gerarTabuleiro() {
		for(int i = 0; i < this.linhas; i++) {
			for(int j = 0; j < this.colunas; j++) {
				camposDoTabuleiro.add(new Campo(i,j));
			}
		}
	}
	
	public void associarCamposVizinhos() {
		for(Campo c1 : camposDoTabuleiro) {
			for(Campo c2 : camposDoTabuleiro) {
				if(c1.isVizinho(c2)) {
					c1.camposVizinhos.add(c2);
				}
			}
		}
	}
	
}
