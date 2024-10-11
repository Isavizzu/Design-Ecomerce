package Entidade;

public class Funcionario {
	private String nome;
	private String cpf;
	private String dataDeNascimento;
	private String cargo;

	public Funcionario(String nome, String cpf, String dataDeNascimento, String cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.cargo = cargo;
	}
	

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getCargo() {
		return cargo;
	}
}
