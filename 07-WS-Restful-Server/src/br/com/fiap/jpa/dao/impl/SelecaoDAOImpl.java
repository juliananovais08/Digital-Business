package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.entity.Selecao;
import br.com.fiap.jpa.dao.SelecaoDAO;

public class SelecaoDAOImpl 
		extends GenericDAOImpl<Selecao, Integer>
			implements SelecaoDAO{

	public SelecaoDAOImpl(EntityManager em) {
		super(em);
	}

}
