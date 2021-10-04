package campominado02.tabuleiro;

public class ClasseParaFazerTestes {
	public static void main(String[] args) {
		Tabuleiro tabuTeste = new Tabuleiro(10, 10);
		StringBuilder sb = new StringBuilder();
		Campo campo = new Campo();
		
		campo.ConteudoDoCampo(campo);
		
		sb = tabuTeste.ImprimirTabuleiro(tabuTeste.linhas, tabuTeste.colunas, campo);
		System.out.print(sb.toString());
		
	}

}
