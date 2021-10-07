package calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private enum TipoComando{
		ZERAR, NUMERO, DIVIDIR, MULTIPLICAR, SUBTRAIR, SOMAR, IGUAL, VIRGULA;
	};
	
	private static final Memoria memoria = new Memoria ();
	
	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";
	
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	
	private Memoria () {	
	}
	
	public static Memoria getMemoria() {
		return memoria;
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	public void adicionarObservador(MemoriaObservador observador){
		observadores.add(observador);
	}
	
	public void processarComando(String texto) {
		TipoComando comando = detectarComando(texto);
		
		if(comando == null) {
			return;
		}else if(comando == TipoComando.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			substituir = false;
			ultimaOperacao = null;
		}else if(comando == TipoComando.NUMERO || comando == TipoComando.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto;
			substituir = false;
			textoAtual = obterResultadoOperacao();
			textoBuffer = textoAtual;
			ultimaOperacao = comando;
		}
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private String obterResultadoOperacao() {
		if(ultimaOperacao == null) {
			return textoAtual;
		}
		
		double numeroBuffer = Double.parseDouble(textoBuffer.replace(",","."));
		double numeroAtual = Double.parseDouble(textoAtual.replace(",","."));
		double resultado = 0;
		
		if(ultimaOperacao == TipoComando.SOMAR) {
			resultado = numeroAtual + numeroBuffer;
		}else if(ultimaOperacao == TipoComando.SUBTRAIR) {
			resultado = numeroBuffer - numeroAtual;
		}else if(ultimaOperacao == TipoComando.DIVIDIR) {
			resultado = numeroBuffer / numeroAtual;
		}else if(ultimaOperacao == TipoComando.MULTIPLICAR) {
			resultado = numeroBuffer * numeroAtual;
		}
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		return resultadoString;
	}

	private TipoComando detectarComando(String texto) {
		
		if(textoAtual.isEmpty() && texto == "0") {
			return null;
		}
		
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		}catch (NumberFormatException e) {
			if("AC".equals(texto)) {
				return TipoComando.ZERAR;
			}else if("/".equals(texto)) {
				return TipoComando.DIVIDIR;
			}else if("*".equals(texto)) {
				return TipoComando.MULTIPLICAR;
			}else if("+".equals(texto)) {
				return TipoComando.SOMAR;
			}else if("-".equals(texto)) {
				return TipoComando.SUBTRAIR;
			}else if("=".equals(texto)) {
				return TipoComando.IGUAL;
			}else if(",".equals(texto) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}
		}
		
		return null;
		
	}
}
