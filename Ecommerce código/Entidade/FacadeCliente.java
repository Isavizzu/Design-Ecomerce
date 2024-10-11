package Entidade;

import Entrega.Entrega;
import Financeiro.Pagamento;
import Venda.Pedido;
import Venda.Produto;
import Entrega.Endereco;
import Singleton.Carrinho;
import Singleton.Favorito;

import java.util.ArrayList;

public class FacadeCliente {

	private Cliente cliente;


	public FacadeCliente (Cliente cliente) {
		this.cliente = cliente;
	}


	public void cadastrar() {
		if (cliente == null) {
			Endereco endereco = new Endereco("Paraná", "Curitiba", "Padrão Alto", "Rua Silva", 123);
			Carrinho carrinho = Carrinho.getInstance();
			Favorito favorito = Favorito.getInstance();
			Cliente cliente = new Cliente("Romano de La Costa", "123.456.789-00", "01/01/1990", endereco, favorito, carrinho);
			this.cliente= cliente;
			System.out.println(cliente.getNome() + " cadastrado com sucesso!");
			return;
		}
		System.out.println("Você já está cadastrado");
	}


	public void removeProdutoCarrinho(Produto produto) {
		cliente.getCarrinho().removeProduto(produto);
	}


	public void addProdutoAoCarrinho(Produto produto) {
		if (produto.getQuantidade() == 0) {
			produto.adicionarObservador(cliente);
			System.out.println("Produto não disponível no estoque!");
			return;
		}
		cliente.getCarrinho().addProduto(produto);
	}


	public void removeProdutoFavorito(Produto produto) {
		cliente.getFavorito().removeProduto(produto);
	}


	public void addProdutoAoFavorito(Produto produto) {
		cliente.getFavorito().addProduto(produto);
	}


	public void comprar() {
		Pedido pedido = cliente.fazerPedido(cliente);
		cliente.adicionarPedido(pedido);
		cliente.limparCarrinho();
		System.out.println("Pedido adicionado com sucesso!");
	}


	public void cancelarCompra() {
		if (cliente.getPedidos().isEmpty()){
			System.out.println("Você ainda não tem pedido!");
			return;
		}
		cliente.visualizarPedidos();
		double pedido = cliente.escolherPedido();
		Pedido ped = cliente.cancelarPedido(pedido);
		if (ped == null) {
			System.out.println("Pedido não encontrado!");
			return;
		}
		ped.getEntrega().setStatus("CANCELADO");
	}


	public void mudarEndereco() {
		cliente.atualizarEndereco();
	}


	public void visualizarPedidos() {
		cliente.visualizarPedidos();
	}


	public void visualizarCarrinho() {
		cliente.getCarrinho().visualizarCarrinho();
	}


	public void visualizarFavorito() {
		cliente.getFavorito().visualizarFavorito();
	}

}
