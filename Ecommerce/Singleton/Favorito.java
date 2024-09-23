package Singleton;
import Entidade.Cliente;
import Venda.Produto;
import java.util.ArrayList;

public class Favorito {

	private ArrayList<Produto> produtos;


	private static Favorito instancia;


	public Favorito () {
		produtos = new ArrayList<>();
	}


	public static Favorito getInstance() {
		if (instancia == null) {
			instancia = new Favorito();
		}
		return instancia;
	}


	public ArrayList<Produto> getProdutos () {
		return produtos;
	}


	public void addProduto (Produto produto) {
		produtos.add(produto);
		System.out.println("Produto adicionado com sucesso nos favoritos!");
	}


	public void removeProduto (Produto produto) {
		if (produtos.contains(produto)) {
			produtos.remove(produto);
			System.out.println("Produto removido dos Favoritos");
			return;
		}
		System.out.println("Produto não se encontra nos Favoritos");
	}


	public void visualizarFavorito() {
		System.out.println("Favoritos: ");
		if (produtos.isEmpty()) {
			System.out.println("Favoritos vazio!");
		}
		else {
			int i = 0;
			for (Produto p : produtos) {
				System.out.println(++i + "- " + p.getNome());
			}
		}
	}
}
