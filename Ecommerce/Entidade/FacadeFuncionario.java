package Entidade;

import Venda.Produto;
import Singleton.Carrinho;
import Singleton.Favorito;
import Entrega.Transportadora;

import java.util.ArrayList;

public class FacadeFuncionario {

	private Funcionario funcionario;

	public FacadeFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void cadastrarFuncionario(String nome, String cpf, String dataNascimento, String cargo) {
		if (this.funcionario == null) {
			Funcionario novoFuncionario = new Funcionario(nome, cpf, dataNascimento, cargo);
			this.funcionario = novoFuncionario;
			System.out.println("Funcionário " + nome + " cadastrado com sucesso!");
		} else {
			System.out.println("Funcionário já está cadastrado.");
		}
	}

	public void cadastrarTransportadora(String nome, String endereco) {
		Transportadora transportadora = new Transportadora(nome, endereco);
		System.out.println("Transportadora " + nome + " cadastrada com sucesso.");
	}

	public void cadastrarProduto(ArrayList<Produto> produtos, Produto novoProduto) {
		produtos.add(novoProduto);
		System.out.println("Produto " + novoProduto.getNome() + " cadastrado com sucesso.");
	}


	public void atualizarEstoque(int quant, Produto produto) {
		if (produto.getQuantidade() == 0 && quant > 0) {
			produto.notificarObservadores("O produto: " + produto.getNome() + " voltou ao Estoque!");
		}
		produto.atualizarEstoque(quant);
		System.out.println("Estoque do produto " + produto.getNome() + " atualizado para " + quant);
	}

	public void removerFuncionario() {
		if (this.funcionario != null) {
			System.out.println("Funcionário " + funcionario.getNome() + " removido.");
			this.funcionario = null;
		} else {
			System.out.println("Nenhum funcionário cadastrado para remover.");
		}
	}
}
