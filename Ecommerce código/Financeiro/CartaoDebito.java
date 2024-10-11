package Financeiro;

public class CartaoDebito extends Cartao {

    public CartaoDebito(int numero, String nomeTitular, String dataValidade, int cvv, String bandeira) {
        super(numero, nomeTitular, dataValidade, cvv, bandeira);
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento com cartão de débito...");
    }
}
