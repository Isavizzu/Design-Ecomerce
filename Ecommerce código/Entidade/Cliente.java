package Entidade;

import Financeiro.Pagamento;
import Financeiro.CartaoCredito; // Importar a classe de Cartão de Crédito
import Financeiro.Boleto; // Importar a classe de Boleto
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

public class Cliente implements Observer {

	private String nome;
	private String cpf;
	private String dataDeNascimento;
	private Endereco endereco;
	private ArrayList<Pedido> pedidos;
	private Favorito favorito;
	private Carrinho carrinho;
	private Collection<Pedido> pedido;

	public Cliente(String nome, String cpf, String dataDeNascimento, Endereco endereco, Favorito favorito, Carrinho carrinho) {
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
		for (Produto produto : produtos) {
			produto.atualizarEstoque(produto.getQuantidade() - 1);
		}

		Pagamento pagamento = escolherPagamento();

		Transportadora transportadora = new Transportadora("Transportadora XYZ", "12.345.678/0001-90");
		Entrega entrega = new Entrega("Em trânsito", transportadora);
		double valorTotal = carrinho.calcularValorTotal();

		Pedido novoPedido = new Pedido(cliente, entrega, produtos, pagamento, valorTotal);
		adicionarPedido(novoPedido);
		pagamento.realizarPagamento();
		return novoPedido;
	}

	private Pagamento escolherPagamento() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha o método de pagamento:");
		System.out.println("1 - Cartão de Crédito");
		System.out.println("2 - Boleto");
		int escolha = scanner.nextInt();

		double valorTotal = carrinho.calcularValorTotal();
		switch (escolha) {
			case 1:
				System.out.print("Número do cartão: ");
				int numeroCartao = scanner.nextInt();
				System.out.print("Nome do titular: ");
				String nomeTitular = scanner.next();
				System.out.print("Data de validade (MM/AA): ");
				String dataValidade = scanner.next();
				System.out.print("CVV: ");
				int cvv = scanner.nextInt();
				System.out.print("Bandeira: ");
				String bandeira = scanner.next();
				CartaoCredito cartaoCredito = new CartaoCredito(numeroCartao, nomeTitular, dataValidade, cvv, bandeira);
				return new Pagamento(valorTotal, cartaoCredito);

			case 2:
				System.out.print("Código de barras: ");
				int codigoBarras = scanner.nextInt();
				System.out.print("Data de vencimento (DD/MM/AAAA): ");
				String dataVencimento = scanner.next();
				Boleto boleto = new Boleto(codigoBarras, dataVencimento);
				return new Pagamento(valorTotal, boleto);

			default:
				System.out.println("Método de pagamento inválido! O pagamento será considerado como pendente.");
				return new Pagamento(valorTotal, null); // Pagamento pendente
		}
	}

	public void adicionarPedido(Pedido novoPedido) {
		pedidos.add(novoPedido);
	}

	public Pedido cancelarPedido(double pedido) {
		Pedido ped = null;
		for (Pedido p : pedidos) {
			if (p.getValorTotal() == pedido) {
				pedidos.remove(p);
				ArrayList<Produto> produtos = p.getProdutos();
				for (Produto produto : produtos) {
					produto.atualizarEstoque(produto.getQuantidade() + 1);
				}

				System.out.println("Pedido de R$" + pedido + " cancelado com sucesso!");
				ped = p;
				break;
			}
		}
		return ped;
	}

	public void atualizarEndereco() {
		endereco.atualizarEndereco();
		System.out.println("Endereço atualizado com sucesso!");
	}

	public void limparCarrinho() {
		carrinho.limpar();
	}

	public void visualizarPedidos() {
		System.out.println("Pedidos: ");
		if (pedidos.isEmpty()) {
			System.out.println("Você ainda não fez nenhum pedido!");
		} else {
			int i = 0;
			for (Pedido pedido : getPedidos()) {
				System.out.println(++i + "- R$" + pedido.getValorTotal());
			}
		}
	}

	public double escolherPedido() {
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

	public void atualizar(String mensagem) {
		System.out.println("Notificação para o cliente " + this.nome + ": " + mensagem);
	}
}
