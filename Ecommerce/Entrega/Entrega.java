package Entrega;

import Venda.Pedido;

public class Entrega {

	private String status;

	private Transportadora transportadora;



	public Entrega(String status, Transportadora transportadora) {
		this.status = status;
		this.transportadora = transportadora;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void verificarStatus(){
		System.out.println("O status da entrega é esse");
	}
}
