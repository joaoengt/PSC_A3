package com.mycompany.cardapio;

import java.util.ArrayList;
import java.util.Scanner;

// Método para buscar produtos cadastrados.
public class BuscarProduto {
    public void buscarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine().toLowerCase();

        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome)) {
                System.out.println(produto);
                return;
            }
        }

        System.out.println("Produto nao encontrado.");
    }
}

