package Entidade;
import Financeiro.Pagamento;
import Singleton.Carrinho;
import Singleton.Favorito;
import Entrega.Endereco;
import Entrega.Transportadora;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import Venda.Pedido;
import Venda.Produto;
import Entrega.Entrega;


public class Cliente implements Observer{

	private String nome;

	private String cpf;

	private String dataDeNascimento;

	private Endereco endereco;

	private ArrayList<Pedido> pedidos;

	private Favorito favorito;

	private Carrinho carrinho;

	private Collection<Pedido> pedido;


	public Cliente (String nome, String cpf, String dataDeNascimento, Endereco endereco, Favorito favorito, Carrinho carrinho) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.endereco = endereco;
		this.pedidos = new ArrayList<>();
		this.favorito = favorito;
		this.carrinho = carrinho;
	}


	public String getNome() {
		return nome;
	}


	public Carrinho getCarrinho() {
		return carrinho;
	}


	public Favorito getFavorito() {
		return favorito;
	}


	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public Pedido fazerPedido(Cliente cliente) {
		ArrayList<Produto> produtos = carrinho.getProdutos();
		for (int i = 0; i < produtos.size(); i++) {
			produtos.get(i).atualizarEstoque(produtos.get(i).getQuantidade() - 1);
		}

		Pagamento pagamento = new Pagamento();
		Transportadora transportadora = new Transportadora("Transportadora XYZ", "12.345.678/0001-90");
		Entrega entrega = new Entrega("Em trânsito", transportadora);
		double valorTotal = carrinho.calcularValorTotal();
		return new Pedido(cliente, entrega, produtos, pagamento, valorTotal);
	}


	public void adicionarPedido(Pedido novoPedido) {
		pedidos.add(novoPedido);
	}


	public Pedido cancelarPedido (double pedido) {
		Pedido ped = null;
		for (Pedido p:pedidos) {
			if (p.getValorTotal() == pedido) {
				pedidos.remove(p);
				ArrayList<Produto> produtos = p.getProdutos();
				for (int i = 0; i < produtos.size(); i++) {
					produtos.get(i).atualizarEstoque(produtos.get(i).getQuantidade() + 1);
				}

				System.out.println("Pedido de R$" + pedido + " cancelado com sucesso!");
				ped = p;
				break;
			}
		}
		return ped;
	}


	public void atualizarEndereco(Endereco novoEndereco) {
		this.endereco = novoEndereco;
		System.out.println("Endereço atualizado com sucesso!");
	}


	public void limparCarrinho() {
		carrinho.limpar();
	}


	public void visualizarPedidos() {
		System.out.println("Pedidos: ");
		if (pedidos.isEmpty()) {
			System.out.println("Você ainda não fez nenhum pedido!");
		}
		else {
			int i = 0;
			for (Pedido pedido : getPedidos()) {
				System.out.println(++i + "- R$" + pedido.getValorTotal());
			}
		}
	}


	public double escolherPedido () {
		while (true) {
			try {
				System.out.println("Digite o valor do pedido que deseja cancelar: ");
				Scanner scanner = new Scanner(System.in);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Dado inválido!");
			}
		}
	}


	public void atualizar (String mensagem) {
		System.out.println("Notificação para o cliente " + this.nome + ": " + mensagem);
	}

}
