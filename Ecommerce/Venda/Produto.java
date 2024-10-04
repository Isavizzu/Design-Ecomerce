package Venda;

import java.util.ArrayList;
import Entidade.Observer;

public class Produto {
	private String nome;
	private int quantidade;
	private double preco;
	private ArrayList<Observer> observadores;


	public Produto(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.observadores = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void adicionarObservador(Observer observador) {
		observadores.add(observador);
	}

	public void removerObservador(Observer observador) {
		observadores.remove(observador);
	}


	public void notificarObservadores(String mensagem) {
		for (Observer observador : observadores) {
			observador.atualizar(mensagem);
		}
	}

	public void atualizarEstoque(int quantidade) {
		this.quantidade += quantidade;
		if (this.quantidade > 0) {
			notificarObservadores("O produto " + nome + " está disponível novamente!");
		}
	}

	@Override
	public String toString() {
		return "Produto: " + nome + ", Quantidade: " + quantidade + ", Preço: R$" + preco;
	}
}
