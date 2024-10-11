package Financeiro;

public class Pagamento {
	private double valor;
	private String status;
	private PagamentoStrategy metodoPagamento;

	public Pagamento(double valor, PagamentoStrategy metodoPagamento) {
		this.valor = valor;
		this.metodoPagamento = metodoPagamento;
		this.status = "pendente";
	}

	public void realizarPagamento() {
		metodoPagamento.processarPagamento(valor);
		this.status = "concluído";
	}

	public void setMetodoPagamento(PagamentoStrategy novoMetodo){ this.metodoPagamento = novoMetodo;}

	public double getValor() { return valor;}

	public String getStatus() { return status;}

	public void setStatus(String status) { this.status = status;}
}
