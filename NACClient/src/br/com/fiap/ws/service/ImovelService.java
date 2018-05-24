package br.com.fiap.ws.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Imovel;

public class ImovelService {
	
	//PUSH OU PUT = TYPE
	//GET = ACCEPT
	
	private static final String URL = "http://localhost:8080/NACServer/rest/imovel";
	
	private Client client = Client.create();
	
	public void cadastrar(Imovel imovel) throws Exception {
		//Chamar o webservice
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, imovel);
		
		//verificar se deu certo!
		if(resp.getStatus() != 201) {
			throw new Exception("Erro ao cadastrar");
		}
	}
	
	public List<Imovel> listar() throws Exception{
		//Chamar o webservice
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		//validar se foi ok
		if(resp.getStatus() != 200) {
			throw new Exception("Erro ao listar");
		}
		//retornar a listar de Imoveis
		
		return Arrays.asList(resp.getEntity(Imovel[].class));
	}
	
	public void atualizar(Imovel imovel) throws Exception {
		//Chamar o webservice
		WebResource resource = client.resource(URL).path(String.valueOf(imovel.getCodigo()));
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, imovel);
		
		//validar se deu certo
		if(resp.getStatus() != 200) {
			throw new Exception("Erro ao atualizar"); 
		}
	}

}
