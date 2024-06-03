package com.mycompany.cardapio;

import java.util.ArrayList;

// Uso do método for para listar produtos
public class ListarProdutos {
    public void listarProdutos(ArrayList<Produto> produtos) {
        System.out.printf("%-20s %-15s %-10s %-10s %-30s%n", "Nome", "Categoria", "Preco", "Quantidade", "Descricao");
        for (Produto produto : produtos) {
            System.out.printf("%-20s %-15s %-10.2f %-10d %-30s%n",
                    produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getQuantidade(), produto.getDescricao());
        }
    }
}
