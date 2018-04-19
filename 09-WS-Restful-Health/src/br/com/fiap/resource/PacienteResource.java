package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;
import br.com.fiap.jpa.dao.impl.PacienteDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class PacienteResource {

	public PacienteDAO dao;
	
	public PacienteResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacienteDAOImpl(em);
	}
	
	@POST//Cadastrar
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Paciente paciente, @Context UriInfo uri) {
		try {
			dao.inserir(paciente);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//Recupera a URL atual
		UriBuilder b = uri.getAbsolutePathBuilder();
		//Add o codigo do paciente na URL
		b.path(String.valueOf(paciente.getCodigo()));
		//Retorna o status 201 com a URL para acessar o paciente
		return Response.created(b.build()).build();
	}
	
	@GET //Listar
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> listar(){
		return dao.listar();
	}
	
	
	
	
	
}
