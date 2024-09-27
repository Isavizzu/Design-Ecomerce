package Financeiro;

public class Boleto implements InterfacePagamento {
	private int codigoBarras;
	private String dataVencimento;

	public Boleto(int codigoBarras, String dataVencimento) {
		this.codigoBarras = codigoBarras;
		this.dataVencimento = dataVencimento;
	}

	@Override
	public void processarPagamento() {
		System.out.println("Processando pagamento via boleto...");
	}
}
