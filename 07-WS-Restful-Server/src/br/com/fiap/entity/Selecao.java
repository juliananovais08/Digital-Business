package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_SELECAO")
@SequenceGenerator(name="selecao",sequenceName="SQ_T_SELECAO",allocationSize=1)
public class Selecao {

	@Id
	@Column(name="cd_selecao")
	@GeneratedValue(generator="selecao",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pais")
	private String pais;
	
	@Column(name="st_classificado")
	private boolean classificado;
	
	@Column(name="nr_mudiais")
	private int numeroMundiais;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isClassificado() {
		return classificado;
	}

	public void setClassificado(boolean classificado) {
		this.classificado = classificado;
	}

	public int getNumeroMundiais() {
		return numeroMundiais;
	}

	public void setNumeroMundiais(int numeroMundiais) {
		this.numeroMundiais = numeroMundiais;
	}
	
}
