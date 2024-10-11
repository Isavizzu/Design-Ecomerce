package Entidade;
import Venda.Produto;
import java.util.ArrayList;
import java.util.Scanner;


public class MainFuncionario {
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

        menu: while (true) {
            System.out.println("Funcionalidades:");
            System.out.println("1-Me logar Funcionário");
            System.out.println("2-Cadastrar Transportadora");
            System.out.println("3-Cadastrar Produto");
            System.out.println("4-Atualizar Estoque");
            System.out.println("5-Sair");
            Scanner scanner = new Scanner(System.in);
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

    }
}
