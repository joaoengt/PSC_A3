package com.mycompany.cardapio;

import java.util.ArrayList;
import java.util.InputMismatchException; // biblioteca do tratamento de erro
import java.util.Scanner;

public class Principal {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        cadastrarProdutosIniciais();
        menu();
    }

    // Pre cadastro de produtos no sistema
    private static void cadastrarProdutosIniciais() {
        produtos.add(new Produto("Hamburguer", "Comida", 15.99, 50, "Hamburguer artesanal com queijo"));
        produtos.add(new Produto("Pizza", "Comida", 39.99, 20, "Pizza de mussarela"));
        produtos.add(new Produto("Refrigerante", "Bebida", 4.50, 100, "Refrigerante de cola"));
        produtos.add(new Produto("Suco Natural", "Bebida", 6.00, 80, "Suco de laranja natural"));
        produtos.add(new Produto("Salada", "Comida", 12.50, 30, "Salada fresca com molho especial"));
        produtos.add(new Produto("Sorvete", "Sobremesa", 7.99, 60, "Sorvete de chocolate"));
        produtos.add(new Produto("Bolo", "Sobremesa", 8.99, 40, "Bolo de cenoura com cobertura de chocolate"));
    }

    // Estrutura do menu principal
    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        CadastrarProduto cadastrarProduto = new CadastrarProduto();
        ListarProdutos listarProdutos = new ListarProdutos();
        BuscarProduto buscarProduto = new BuscarProduto();
        GestaoMesas gestaoMesas = new GestaoMesas();

        // Estrutura de repetição do menu
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Gestão de Mesas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            // Tratamento de erro com estrutura de repetição no menu
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarProduto.cadastrarProduto(produtos, scanner);
                        break;
                    case 2:
                        listarProdutos.listarProdutos(produtos);
                        break;
                    case 3:
                        buscarProduto.buscarProduto(produtos, scanner);
                        break;
                    case 4:
                        gestaoMesas.gestaoDeMesas(scanner, produtos);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção invalida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida! Por favor, insira um numero.");
                scanner.nextLine();
            }
        }
    }
}
