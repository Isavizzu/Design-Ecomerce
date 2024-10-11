package Singleton;
import Entidade.Cliente;
import Venda.Pedido;
import Venda.Produto;
import java.util.ArrayList;

public class Carrinho {

	private ArrayList<Produto> produtos;

	private static Carrinho instancia;


	public Carrinho () {
		produtos = new ArrayList<>();
	}


	public static Carrinho getInstance() {
		if (instancia == null) {
			instancia = new Carrinho();
		}
		return instancia;
	}


	public ArrayList<Produto> getProdutos () {
		return produtos;
	}


	public void addProduto (Produto produto) {
		produtos.add(produto);
		System.out.println("Produto adicionado com sucesso no carrinho!");
	}


	public void removeProduto (Produto produto) {
		if (produtos.contains(produto)) {
			produtos.remove(produto);
			System.out.println("Produto removido do Carrinho");
			return;
		}
		System.out.println("Produto não se encontra no Carrinho");
	}


	public void visualizarCarrinho() {
		System.out.println("Carrinho: ");
		if (produtos.isEmpty()) {
			System.out.println("Carrinho vazio!");
		}
		else {
			int i = 0;
			for (Produto p : produtos) {
				System.out.println(++i + "- " + p.getNome());
			}
		}
	}


	public double calcularValorTotal() {
		double valorTotal = 0;

		for (Produto produto : produtos) {
			valorTotal += produto.getPreco();
		}

		return valorTotal;
	}


	public void limpar() {
		produtos = new ArrayList<>();
	}
}
