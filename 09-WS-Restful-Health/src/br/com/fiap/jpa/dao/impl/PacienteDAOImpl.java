package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;

public class PacienteDAOImpl 
			extends GenericDAOImpl<Paciente, Integer>
					implements PacienteDAO{

	public PacienteDAOImpl(EntityManager em) {
		super(em);
	}

}