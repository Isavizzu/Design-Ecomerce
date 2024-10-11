package Entrega;

import java.util.Collection;
import java.util.Scanner;

import Entidade.Cliente;

public class Endereco {

	private String estado;

	private String cidade;

	private String bairro;

	private String rua;

	private int numero;

	private Collection<Cliente> cliente;


	public Endereco(String estado, String cidade, String bairro, String rua, int numero) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	public void obterEndereco(){
		System.out.println("Este é o endereço: ");
		System.out.println("Estado: " + getEstado());
		System.out.println("Cidade: " + getCidade());
		System.out.println("Bairro: " + getBairro());
		System.out.println("Rua: " + getRua());
		System.out.println("Número: " + getNumero());
	}

	public void atualizarEndereco(){
		System.out.println("Digite o novo endereço:");
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o estado:");
		String estado = scan.nextLine();
		setEstado(estado);

		System.out.println("Digite a cidade:");
		String cidade = scan.nextLine();
		setCidade(cidade);

		System.out.println("Digite o bairro:");
		String bairro = scan.nextLine();
		setBairro(bairro);

		System.out.println("Digite a rua:");
		String rua = scan.nextLine();
		setRua(rua);

		System.out.println("Digite o número:");
		int num = scan.nextInt();
		setNumero(num);

		System.out.println("Endereço atualizado");
	}

	public void setEstado(String estado){ this.estado = estado;}

	public void setCidade(String cidade){ this.cidade = cidade;}

	public void setBairro(String bairro){ this.bairro = bairro;}

	public void setRua(String rua){ this.rua = rua;}
	
	public void setNumero(int num){ this.numero = num;}

	public String getEstado(){ return estado;}

	public String getCidade(){ return cidade;}

	public String getBairro(){ return bairro;}

	public String getRua(){ return rua;}

	public int getNumero(){ return numero;}

}
