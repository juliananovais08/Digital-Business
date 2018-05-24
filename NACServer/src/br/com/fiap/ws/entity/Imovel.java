package br.com.fiap.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="imovel",sequenceName="SQ_T_IMOVEL",allocationSize=1)
public class Imovel {

	@Id
	@GeneratedValue(generator="imovel",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String endereco;
	
	private double preco;
	
	private boolean residencial;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isResidencial() {
		return residencial;
	}

	public void setResidencial(boolean residencial) {
		this.residencial = residencial;
	}
	
	
}
