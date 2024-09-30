package Venda;
import Entidade.Observer;
import java.util.ArrayList;

public class Produto {

	private String nome;

	private int quantidade;

	private double preco;

	private ArrayList<Observer> observadores = new ArrayList<>();


	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	public void mudarPreco(double preco){
		this.preco = preco;
	}


	public Produto(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
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


	public void atualizarEstoque(int quant) {
		this.quantidade = quant;
	}
}
