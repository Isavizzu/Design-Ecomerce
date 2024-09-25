package Entidade;
import Entrega.Endereco;
import Singleton.Carrinho;
import Singleton.Favorito;
import Venda.Produto;

import java.util.ArrayList;


public class FacadeFuncionario {

	private Funcionario funcionario;


	public FacadeFuncionario (Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public void cadastrarTransportadora() {

	}

	public void cadastrarProduto(ArrayList<Produto> produtos) {

	}


	public void atualizarEstoque(int quant, Produto produto) {
		if (produto.getQuantidade() == 0) {
			produto.notificarObservadores("O produto: " + produto.getNome() + " voltou ao Estoque!");
		}
		produto.atualizarEstoque(quant);
	}

}
