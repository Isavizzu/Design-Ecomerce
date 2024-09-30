package Entrega;

import java.util.Collection;

public class Transportadora {

	private String nome;

	private String cnpj;


	public Transportadora(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public void verificarTransportadora(){
		System.out.println("Essa é a transportadora");
	}
}
