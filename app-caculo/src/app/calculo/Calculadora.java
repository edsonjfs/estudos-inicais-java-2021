package app.calculo;

import app.calculo.interno.OperacoesAritmeticas;
import app.logging.Logger;

public class Calculadora {
	private OperacoesAritmeticas operacao = new OperacoesAritmeticas();

	public double soma(double... nums) {
		Logger.info("Somando");
		return operacao.soma(nums);
	}
	
	
}
