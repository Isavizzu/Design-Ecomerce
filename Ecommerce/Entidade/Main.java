package Entidade;
import Entidade.Cliente;
import Entrega.Endereco;
import Entidade.FacadeCliente;
import Singleton.Carrinho;
import Singleton.Favorito;

public class Main {
    public static void main(String[] args) {

        FacadeCliente facadeCliente = new FacadeCliente(null);

        facadeCliente.cadastrar();
        facadeCliente.cadastrar();

        // Adicionar produto ao carrinho
        facadeCliente.addProdutoAoCarrinho();
        facadeCliente.addProdutoAoCarrinho();
        facadeCliente.removeProdutoCarrinho();

        // Visualizar carrinho
        facadeCliente.visualizarCarrinho();

        // Adicionar produto aos favoritos
        facadeCliente.addProdutoAoFavorito();
        facadeCliente.addProdutoAoFavorito();
        facadeCliente.removeProdutoFavorito();

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
