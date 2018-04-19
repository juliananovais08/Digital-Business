package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private SelecaoService service; //Não tem get e set
	
	//Método de inicialização do ManagedBean
	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}
	
	//Método para excluir uma seleção
	
	public void deletar(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void cadastrar() {
		FacesMessage msg; //Objeto para exibir msg na tela
		try {
			if(selecao.getCodigo() == 0) {
			service.cadastrar(selecao);
			msg = new FacesMessage("Cadastrado!");
			} else {
			service.atualizar(selecao);
			msg = new FacesMessage ("Atualizado!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		//Adiciona a mensagem para a tela exibir
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public List<Selecao> getSelecoes() {
		
		try {
			return service.listar();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}