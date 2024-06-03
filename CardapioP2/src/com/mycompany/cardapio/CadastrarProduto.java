
package com.mycompany.cardapio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


// Método para cadastrar produtos no cardápio.
public class CadastrarProduto {
    public void cadastrarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            if (nome.isEmpty()) {
                System.out.println("Nome não pode ser vazio!");
                return;
            }

            System.out.print("Categoria: ");
            String categoria = scanner.nextLine();
            if (categoria.isEmpty()) {
                System.out.println("Categoria não pode ser vazia!");
                return;
            }

            System.out.print("Preco (0,00): ");
            double preco = scanner.nextDouble();
            if (preco <= 0) {
                System.out.println("Preco deve ser maior que zero!");
                return;
            }

            System.out.print("Quantidade (Un.): ");
            int quantidade = scanner.nextInt();
            if (quantidade < 0) {
                System.out.println("Quantidade não pode ser negativa!");
                return;
            }

            scanner.nextLine(); 

            System.out.print("Descricao: ");
            String descricao = scanner.nextLine();
            if (descricao.isEmpty()) {
                System.out.println("Descricao não pode ser vazia!");
                return;
            }

            produtos.add(new Produto(nome, categoria, preco, quantidade, descricao));
            System.out.println("Produto cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida! O cadastro foi cancelado.");
            scanner.nextLine();
        }
    }
}

