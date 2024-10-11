package Financeiro;

public abstract class Cartao implements PagamentoStrategy {
	protected int numero;
	protected String nomeTitular;
	protected String dataValidade;
	protected int cvv;
	protected String bandeira;

	public Cartao(int numero, String nomeTitular, String dataValidade, int cvv, String bandeira) {
		this.numero = numero;
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
		this.cvv = cvv;
		this.bandeira = bandeira;
	}

}
