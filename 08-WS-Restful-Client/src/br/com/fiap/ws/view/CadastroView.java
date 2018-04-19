package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

public class CadastroView {

	public static void main(String[] args) {
		//Ler os dados
		Scanner sc = new Scanner(System.in);
		Selecao selecao = new Selecao();
		
		System.out.println("País");
		selecao.setPais(sc.next() + sc.nextLine());
		
		System.out.println("Número de mundiais");
		selecao.setNumeroMundiais(sc.nextInt());
		
		System.out.println("Classificado?");
		selecao.setClassificado(sc.nextBoolean());
		
		//Enviar para o webservice
		SelecaoService service = new SelecaoService();
		try {
			service.cadastrar(selecao);
			System.out.println("Cadastrado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
	
}