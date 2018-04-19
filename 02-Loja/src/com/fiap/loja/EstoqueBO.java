package com.fiap.loja;


import com.fiap.loja.to.ProdutoTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EstoqueBO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(EstoqueBO.class);

	public ProdutoTO consultarProduto(int codigo) {
		ProdutoTO to = null;
		log.debug("Pesquisando um produto");
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401, "Camiseta Masculina",
					40, "Camiseta branca");
			break;
		case 402:
			to = new ProdutoTO(402, "Camiseta Feminina",
					50, "Camiseta rosa");
			break;
		}
		return to;
	}
	
}
