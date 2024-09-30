package Venda;

import Entidade.Cliente;
import Financeiro.Pagamento;
import Entrega.Entrega;
import java.util.ArrayList;
import java.util.Collection;

public class Pedido {

	private Cliente cliente;

	private ArrayList<Produto> produtos;

	private Pagamento pagamento;

	private double valorTotal;

	private ArrayList<Produto> produto;

	private Entrega entrega;


	public Pedido(Cliente cliente,Entrega entrega, ArrayList<Produto> produtos, Pagamento pagamento, double valorTotal) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.pagamento = pagamento;
		this.entrega = entrega;
		this.valorTotal = valorTotal;
	}

	public void verificarPagamento(){
		System.out.println(pagamento.getStatus());
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public Entrega getEntrega() {
		return entrega;
	}


	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
}
