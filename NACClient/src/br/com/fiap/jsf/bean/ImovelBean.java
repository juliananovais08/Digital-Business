package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.ImovelService;
import br.com.fiap.ws.to.Imovel;

@ManagedBean
public class ImovelBean {
	
	private Imovel imovel;
	
	private ImovelService service;
	
	//Método de inicialização
	@PostConstruct
	private void init() {
		service = new ImovelService();
		imovel = new Imovel();
	}
	
	//Método para popular a tabela na página
	//***ultimo item da ultima questão
	public List<Imovel> getLista(){
		
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Método para o click do botão	
	public String cadastrar() {
		FacesMessage msg;
		
		try {
			service.cadastrar(imovel);
			msg = new FacesMessage("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Coloca a mensagem no contexto
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após um redirect
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		//Retorna a página de resposta realizando um redirect
		return "imovel?faces-redirect=true";
	}
	
	//GETTERS AND SETTERS

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	

}
