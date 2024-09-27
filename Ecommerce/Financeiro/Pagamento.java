package Financeiro;

public class Pagamento {
	private double valor;
	private String status;
	private InterfacePagamento metodoPagamento;

	public Pagamento(double valor, InterfacePagamento metodoPagamento) {
		this.valor = valor;
		this.metodoPagamento = metodoPagamento;
		this.status = "pendente";
	}

	public void realizarPagamento() {
		metodoPagamento.processarPagamento();
		this.status = "concluído";
	}

	public double getValor() {
		return valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
