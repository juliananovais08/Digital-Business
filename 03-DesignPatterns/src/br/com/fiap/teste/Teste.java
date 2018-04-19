package br.com.fiap.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.fiap.singleton.PropertySingleton;

public class Teste {

	private static final Logger log = 
			LoggerFactory.getLogger(Teste.class);
	
	public static void main(String[] args) {
		//Recupera uma configuração do arquivo .properties
		String b = PropertySingleton
				.getInstance().getProperty("banco");
		System.out.println(b);
		log.info("Finalizando o sistema");
	}
	
}


