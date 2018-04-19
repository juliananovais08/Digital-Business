package com.fiap.loja;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	
	public List<ProdutoTO> listar(){
		List<ProdutoTO> lista = new ArrayList<>();
		lista.add(new ProdutoTO(401, 
				"Camiseta Masculina", 50, "Branca"));
		lista.add(new ProdutoTO(402, 
				"Camiseta Feminina", 100, "Rosa"));
		return lista;
	}

	public ProdutoTO consultarProduto(int codigo) throws AxisFault {
		ProdutoTO to = null;
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401, "Camiseta Masculina",
					40, "Camiseta branca");
			break;
		case 402:
			to = new ProdutoTO(402, "Camiseta Feminina",
					51, "Camiseta rosa");
			break;
		default:
			throw new AxisFault("Produto não cadastrado!");
		}
		return to;
	}

}
