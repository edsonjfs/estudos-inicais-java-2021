package campominado02.tabuleiro;

public class Tabuleiro implements CampoObservador {
	int linhas;
	int colunas;
	
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
	}
	
	public StringBuilder ImprimirTabuleiro (int linhas, int colunas, Campo campo ) {
		StringBuilder tabuleiroImpresso = new StringBuilder();
		
		for (int l = 0; l < linhas; l++ ) {
			for (int c = 0; c < colunas; c ++) {
				tabuleiroImpresso.append(" ");
				tabuleiroImpresso.append(campo.tostring);
				tabuleiroImpresso.append(" ");
			}
			tabuleiroImpresso.append("\n");
		}
		
		return tabuleiroImpresso;
	}
	
	@Override
	public void EventoOcorreu(Campo campo, CampoEvento evento) {
		
		
	}
	
}
