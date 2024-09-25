package Entidade;
import Entidade.Cliente;
import Entrega.Endereco;
import Entidade.FacadeCliente;
import Singleton.Carrinho;
import Singleton.Favorito;
import Venda.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Pão de Forma", 0, 4.99);
        Produto produto2 = new Produto("Croissant", 30, 6.50);
        Produto produto3 = new Produto("Baguete", 20, 3.75);
        Produto produto4 = new Produto("Pão Integral", 40, 5.25);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        FacadeCliente facadeCliente = new FacadeCliente(null);

        facadeCliente.cadastrar();
        facadeCliente.cadastrar();

        // Adicionar produto ao carrinho
        facadeCliente.addProdutoAoCarrinho(produtos.get(0));
        facadeCliente.addProdutoAoCarrinho(produtos.get(0));
        facadeCliente.removeProdutoCarrinho(produtos.get(0));

        // Visualizar carrinho
        facadeCliente.visualizarCarrinho();

        // Adicionar produto aos favoritos
        facadeCliente.addProdutoAoFavorito(produtos.get(0));
        facadeCliente.addProdutoAoFavorito(produtos.get(0));
        facadeCliente.removeProdutoFavorito(produtos.get(0));

        // Visualizar favoritos
        facadeCliente.visualizarFavorito();

        // Comprar
        facadeCliente.cancelarCompra();
        facadeCliente.comprar();
        facadeCliente.visualizarPedidos();

        // Cancelar a compra
        facadeCliente.cancelarCompra();
        facadeCliente.visualizarPedidos();

        // Mudar endereço
        facadeCliente.mudarEndereco();

    }
}
