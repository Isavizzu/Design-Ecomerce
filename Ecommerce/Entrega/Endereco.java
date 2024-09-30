package Entrega;

import java.util.Collection;
import Entidade.Cliente;

public class Endereco {

	private String estado;

	private String cidade;

	private String bairro;

	private String rua;

	private int numero;

	private Collection<Cliente> cliente;


	public Endereco(String estado, String cidade, String bairro, String rua, int numero) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	public void obterEndereco(){
		System.out.println("Este é o endereço");
	}

	public void atualizarEndereco(){
		System.out.println("Endereço atualizado");
	}
}
