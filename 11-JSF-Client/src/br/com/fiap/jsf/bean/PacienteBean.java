package br.com.fiap.jsf.bean;

import java.util.Calendar;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import br.com.fiap.ws.service.PacienteService;
import br.com.fiap.ws.to.Paciente;

@ManagedBean
public class PacienteBean {
	
	private Paciente paciente;
	private PacienteService service; //Não tem get e set
	
	
	//Método de inicialização do ManagedBean
	@PostConstruct
	private void init() {
		
		paciente = new Paciente();
		paciente.setDataNascimento(Calendar.getInstance());
		service = new PacienteService();
	}
	
	

	
		
	
	

}
