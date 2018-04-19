package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;

public class RemoveView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Ler o código
		System.out.println("Codigo para excluir");
		int codigo = sc.nextInt();

		//Chamar o webservice para remover a seleção
		SelecaoService service = new SelecaoService();
		try {
			service.remover(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
