package br.com.fiap.resource;

import java.rmi.ServerError;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.ImovelDAO;
import br.com.fiap.ws.dao.impl.ImovelDAOImpl;
import br.com.fiap.ws.entity.Imovel;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/imovel")
public class ImovelResource {
	
	private ImovelDAO dao;
	
	//INICIALIZAR OS OBJETOS! DAO	
	public ImovelResource() {
		//Cria um EnitityManager através do singleton e fábrica
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		dao = new ImovelDAOImpl(em);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Imovel imovel, @Context UriInfo uri) {
		
		try {
			dao.cadastrar(imovel);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//Retorna a URL e o status 201
		UriBuilder url = uri.getAbsolutePathBuilder();
		url.path(String.valueOf(imovel.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> listar(){
		return dao.listar();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id")int codigo, Imovel imovel) {
				
		try {
			imovel.setCodigo(codigo);
			dao.atualizar(imovel);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
}
