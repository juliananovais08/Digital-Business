package br.com.fiap.resource;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import br.com.fiap.entity.Selecao;
import br.com.fiap.jpa.dao.SelecaoDAO;
import br.com.fiap.jpa.dao.impl.SelecaoDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/selecao")
public class SelecaoResource {
	
	private SelecaoDAO dao;

	//Construtor que inicializa o SelecaoDAO
	public SelecaoResource() {
		EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
		dao = new SelecaoDAOImpl(em);
	}

	@GET
	@Path("{id}") //Parametro que é enviado pela URL
	@Produces(MediaType.APPLICATION_JSON) //Tipo de retorno
	public Selecao pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Selecao> listar(){
		return dao.listar();
	}
	
	@PUT //Atualizar
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Selecao selecao,
					@PathParam("id") int codigo) {
		try {
			selecao.setCodigo(codigo);
			dao.atualizar(selecao);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void apagar(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new 
				WebApplicationException(
						Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST //Cadastrar
	@Consumes(MediaType.APPLICATION_JSON)//Recebe JSON
	public Response cadastrar(Selecao selecao, @Context UriInfo uri) {
		try {
			dao.inserir(selecao);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			//Retorna o Status Code 500 do HTTP
			return Response.serverError().build();
		}
		//Recupera a URL atual
		UriBuilder b = uri.getAbsolutePathBuilder();
		//Adiciona o código da seleção na URL
		b.path(String.valueOf(selecao.getCodigo()));
		//Retorna Status 201 com a URL para acessar a seleção
		return Response.created(b.build()).build();
	}
	
	
}
