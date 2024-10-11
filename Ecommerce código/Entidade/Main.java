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

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Bem-vindo, escolha um tipo de usuário:");
            System.out.println("1- Cliente");
            System.out.println("2- Funcionário");
            
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    FacadeCliente fc = new FacadeCliente(null);
                    fc.cadastrar();
                    System.out.println("Escolha uma pessoa: ");
                    System.out.println("1- Adicionar produto ao carrinha");
                    System.out.println("2- Remover produto do carrinha");
                    System.out.println("3- Adicionar produto ao favorito");
                    System.out.println("4- Remover produto do favorito");
                    System.out.println("5- Comprar");
                    System.out.println("6- Cancelar compra");
                    System.out.println("7- Mudar endereço");
                    System.out.println("8- Visualizar pedidos");
                    System.out.println("9- Visualizar carrinho");
                    System.out.println("10- Visualizar favorito");

                    int escolhaCliente = scanner.nextInt();

                    try{
                        switch (escolhaCliente) {
                            case 1:
                                fc.addProdutoAoCarrinho(produtos.get(1));
                                break;

                            case 2:
                                fc.removeProdutoCarrinho(produtos.get(1));
                                break;

                            case 3:
                                fc.addProdutoAoFavorito(produtos.get(0));
                                break;

                            case 4: 
                                fc.removeProdutoFavorito(produtos.get(0));

                            case 5:
                                fc.comprar();
                                break;
                        
                            default:
                                break;
                        }

                    }catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    }
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Método de pagamento inválido!");
                    return;
            }


        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número válido.");
        } finally {
            scanner.close();
        }
    }
}
