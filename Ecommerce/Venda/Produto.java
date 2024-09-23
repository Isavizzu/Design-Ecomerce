package Venda;

import java.util.Collection;

public class Produto {

	private String nome;

	private int quantidade;

	private double preco;

	private Collection<Pedido> pedido;

	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	public Produto(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
}
