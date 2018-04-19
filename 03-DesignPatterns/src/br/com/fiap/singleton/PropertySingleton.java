package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {
	
	private static final Logger log = 
		LoggerFactory.getLogger(PropertySingleton.class);

	//1 - Atributo estático que mantem a única instancia
	private static Properties prop;
	
	//3 - Construtor private
	private PropertySingleton() { }
	
	//2 - Método estático getInstance que retorna a única instancia
	public static Properties getInstance() {
		if (prop == null) {
			log.trace("Criando o objeto properties");
			prop = new Properties();
			//carregar o arquivo com as propriedades
			try {
				log.info("Carregando o arquivo de propriedade do sistema");
				prop.load(PropertySingleton.class
						.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				log.error("Arquivo de configuração não carregado");
				e.printStackTrace();
			}
		}
		log.debug("Retornando as configurações do sistema");
		return prop;
	}
	
}