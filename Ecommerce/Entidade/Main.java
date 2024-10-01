package Entidade;

import Entidade.Funcionario;
import Entidade.FacadeCliente;
import Singleton.Carrinho;
import Singleton.Favorito;
import Venda.Produto;
import Financeiro.Pagamento;
import Financeiro.CartaoCredito;
import Financeiro.Boleto;
import Financeiro.CartaoDebito;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Pão de Forma", 0, 4.99);
        Produto produto2 = new Produto("Croissant", 30, 6.50);
        Produto produto3 = new Produto("Baguete", 20, 3.75);
        Produto produto4 = new Produto("Pão Integral", 40, 5.25);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        Funcionario funcionario = new Funcionario("João", "123.456.789-00", "01/01/1990", "Estoquista");
        produto1.adicionarObservador(funcionario);

        FacadeCliente facadeCliente = new FacadeCliente(null);
        facadeCliente.cadastrar();

        facadeCliente.addProdutoAoCarrinho(produtos.get(0));
        facadeCliente.removeProdutoCarrinho(produtos.get(0));

        facadeCliente.visualizarCarrinho();

        facadeCliente.addProdutoAoFavorito(produtos.get(0));
        facadeCliente.removeProdutoFavorito(produtos.get(0));

        facadeCliente.visualizarFavorito();

        facadeCliente.comprar();
        facadeCliente.visualizarPedidos();

        facadeCliente.cancelarCompra();
        facadeCliente.visualizarPedidos();

        facadeCliente.mudarEndereco();

        Scanner scanner = new Scanner(System.in);
        double valorTotal = 50.00;

        try {
            System.out.println("Escolha o método de pagamento:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Cartão de Débito");
            System.out.println("3 - Boleto");

            int escolhaPagamento = scanner.nextInt();
            Pagamento pagamento = null;

            switch (escolhaPagamento) {
                case 1:
                    int numeroCartao = 123456789;
                    String nomeTitular = "João Silva";
                    String dataValidade = "12/25";
                    int cvv = 123;
                    String bandeira = "Visa";
                    CartaoCredito cartaoCredito = new CartaoCredito(numeroCartao, nomeTitular, dataValidade, cvv, bandeira);
                    pagamento = new Pagamento(valorTotal, cartaoCredito);
                    break;

                case 2:
                    int numeroCartaoDebito = 987654321;
                    String nomeTitularDebito = "Maria Oliveira";
                    String dataValidadeDebito = "11/24";
                    int cvvDebito = 456;
                    String bandeiraDebito = "MasterCard";
                    CartaoDebito cartaoDebito = new CartaoDebito(numeroCartaoDebito, nomeTitularDebito, dataValidadeDebito, cvvDebito, bandeiraDebito);
                    pagamento = new Pagamento(valorTotal, cartaoDebito);
                    break;

                case 3:
                    long codigoBarras = 123456789012L;
                    String dataVencimento = "30/12/2024";
                    Boleto boleto = new Boleto((int) codigoBarras, dataVencimento);
                    pagamento = new Pagamento(valorTotal, boleto);
                    break;

                default:
                    System.out.println("Método de pagamento inválido!");
                    return;
            }

            if (pagamento != null) {
                System.out.println("Pagamento realizado com sucesso! Valor: R$" + valorTotal);
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número válido.");
        } finally {
            scanner.close();
        }
    }
}
