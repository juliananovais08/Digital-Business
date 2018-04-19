package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta 
						implements ContaInvestimento{

	private float taxa;
	
	//Constante
	public static final float RENDIMENTO = 0.05f;
	
	@Override
	public double calcularRetornoInvestimento() {
		return saldo*RENDIMENTO;
	}

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (saldo >= valor + taxa) {
			saldo -= valor + taxa;
		}else {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
}