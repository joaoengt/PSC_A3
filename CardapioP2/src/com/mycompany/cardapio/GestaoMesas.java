package com.mycompany.cardapio;

import java.util.ArrayList;
import java.util.Scanner;

// Opção do menu responsável pela gestão das mesas
public class GestaoMesas {
    private ArrayList<Mesa> mesas = new ArrayList<>();

    public void gestaoDeMesas(Scanner scanner, ArrayList<Produto> produtos) {
        while (true) {
            System.out.println("\nGESTÃO DE MESAS:");
            System.out.println("4.1 Adicionar produtos a mesa");
            System.out.println("4.2 Retirar produtos da mesa");
            System.out.println("4.3 Listar produtos da mesa");
            System.out.println("4.4 Fechar mesa");
            System.out.println("4.5 Retornar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            String opcao = scanner.nextLine();


            // Estrutura de repetição do menu de gestão de mesas
            switch (opcao) {
                case "4.1":
                    adicionarProdutoMesa(scanner, produtos);
                    break;
                case "4.2":
                    retirarProdutoMesa(scanner);
                    break;
                case "4.3":
                    listarProdutosMesa(scanner);
                    break;
                case "4.4":
                    fecharMesa(scanner);
                    break;
                case "4.5":
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }


    private Mesa encontrarMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numero) {
                return mesa;
            }
        }
        Mesa novaMesa = new Mesa(numero);
        mesas.add(novaMesa);
        return novaMesa;
    }

    // Método para adicionar produtos consumidos pela mesa
    private void adicionarProdutoMesa(Scanner scanner, ArrayList<Produto> produtos) {
        System.out.print("NUmero da mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();

        Mesa mesa = encontrarMesa(numeroMesa);

        System.out.print("Nome do produto: ");
        String nomeProduto = scanner.nextLine();

        Produto produtoEncontrado = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoEncontrado = produto;
                break;
            }
        }

        // Estrutura de repetição do método adicionaProdutosMesa. Caso o produto não exista no cardápio,
        // será informado ao usuário sua inexistencia.
        if (produtoEncontrado != null) {
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if (quantidade > 0) {
                mesa.adicionarProduto(produtoEncontrado, quantidade);
                System.out.println("Produto adicionado à mesa.");
            } else {
                System.out.println("Quantidade inválida.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Método para retirar produtos da mesa
    private void retirarProdutoMesa(Scanner scanner) {
        System.out.print("NUmero da mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); 

        Mesa mesa = encontrarMesa(numeroMesa);

        System.out.print("Nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        mesa.retirarProduto(nomeProduto, quantidade);
        System.out.println("Produto retirado da mesa, se estava presente.");
    }

    // Método que lista os produtos pedidos pela mesa, assim como a sua quantidade e valor unitário
    private void listarProdutosMesa(Scanner scanner) {
        System.out.print("Número da mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();

        Mesa mesa = encontrarMesa(numeroMesa);
        mesa.listarProdutos();
    }


    // Método para fechar mesa
    private void fecharMesa(Scanner scanner) {
        System.out.print("Número da mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); 

        Mesa mesa = encontrarMesa(numeroMesa);
        double total = mesa.fecharMesa();
        System.out.printf("Mesa %d fechada. Total: R$ %.2f%n", numeroMesa, total);
    }
}
