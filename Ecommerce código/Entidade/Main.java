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
        FacadeFuncionario facedeFuncionario = new FacadeFuncionario(funcionario);

        Scanner scanner = new Scanner(System.in);

        try {
            menu: while(true){
                System.out.println("Bem-vindo, escolha um tipo de usuário:");
            System.out.println("1- Cliente");
            System.out.println("2- Funcionário");
            
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menu1: while(true){
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
                        System.out.println("11- Sair");

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
                                    break;

                                case 5:
                                    fc.comprar();
                                    break;

                                case 6:
                                    fc.cancelarCompra();
                                    break;

                                case 7:
                                    fc.mudarEndereco();
                                    break;
                                
                                case 8:
                                    fc.visualizarPedidos();
                                    break;

                                case 9:
                                    fc.visualizarCarrinho();
                                    break;

                                case 10:
                                    fc.visualizarFavorito();
                                    break;

                                case 11:
                                    break menu1;
                            
                                default:
                                    break;
                            }

                        }catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número válido.");
                        }
                        break;
                        }
                case 2:
                    menu2: while (true) {
                        System.out.println("Funcionalidades:");
                        System.out.println("1-Me logar Funcionário");
                        System.out.println("2-Cadastrar Transportadora");
                        System.out.println("3-Cadastrar Produto");
                        System.out.println("4-Atualizar Estoque");
                        System.out.println("5-Sair");
                        int opcao = scanner.nextInt();
                        switch (opcao){
                            case 1:
                                facedeFuncionario.logarFuncionario("Wilson da Silva", "120.456.789-00", "01/10/1990", "Gerente");
                                break;
                            case 2:
                                facedeFuncionario.cadastrarTransportadora("ViagemSegura", "Rua São Berto 56, Bairro São Francisco-Campina Grande do Sul/PR");
                                break;
                            case 3:
                                facedeFuncionario.cadastrarProduto(produtos, new Produto("Blusinha", 12, 60));
                                break;
                            case 4:
                                facedeFuncionario.atualizarEstoque(2, produtos.getFirst());
                                break;
                            case 5:
                                break menu;
                            default:
                                System.out.println("Opção Inválida");
                                break;
                        }
                    }
                default:
                    System.out.println("Dado inválido!");
                    break;
            }
        }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número válido.");
        } finally {
            scanner.close();
        }
    }
}
