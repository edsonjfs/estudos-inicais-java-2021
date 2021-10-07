package campoMinado;


public class Testes_main {
	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(5, 5, 2);
		
		tabuleiro.gerarTabuleiro();
		tabuleiro.associarCamposVizinhos();
		
		System.out.println(tabuleiro.camposDoTabuleiro.get(1).camposVizinhos.stream().count());
		
		
		
		
		
		
	}
}
