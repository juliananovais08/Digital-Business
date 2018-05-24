package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.ImovelDAO;
import br.com.fiap.ws.entity.Imovel;

public class ImovelDAOImpl 
				extends GenericDAOImpl<Imovel, Integer>
										implements ImovelDAO{

	public ImovelDAOImpl(EntityManager em) {
		super(em);
	}

}
