package desafiosVariados;

import java.util.Scanner;

public class AlgoritmosSort {
	public static void main(String[] args) {
		int quantidade;
		
		Scanner contador = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de números");
		quantidade = contador.nextInt();
		
		int [] numeros = new int [quantidade];
		
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Digite um numero");
			numeros[i] = contador.nextInt();

		}
		contador.close();
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		for (int j = 1; j < numeros.length; j++ ) {
			int chave = numeros[j];
			int i = j - 1;
			
			while (i >= 0 && numeros[i] > chave) {
				numeros[i+1] = numeros[i];
					i = i -1;
			}
			numeros[i+1] = chave;
		}
		System.out.println("Ordenado");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	}

}
