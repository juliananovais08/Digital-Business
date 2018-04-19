package br.com.fiap.ws.bo;

public class CalculadoraBO {

	public int somar(int i, int j) {
		return i+j;
	}
	
	public int fatorial(int x) {
		int resultado = 1;
		for (int i = 1; i <=x; i++) {
			resultado *= i;
		}
		return resultado;
	}
	
	public double raizQuadrada(double x) {
		return Math.sqrt(x);
	}
	
}
