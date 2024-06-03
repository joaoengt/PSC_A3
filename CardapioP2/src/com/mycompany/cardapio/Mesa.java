package com.mycompany.cardapio;

import java.util.ArrayList;

public class Mesa {
    private int numero;
    private ArrayList<ItemMesa> itens;

    public Mesa(int numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<ItemMesa> getItens() {
        return itens;
    }

    // Estrutura de repetição ligada ao método, permitindo adicionar produtos
    public void adicionarProduto(Produto produto, int quantidade) {
        for (ItemMesa item : itens) {
            if (item.getProduto().getNome().equalsIgnoreCase(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new ItemMesa(produto, quantidade));
    }

    public void retirarProduto(String nomeProduto, int quantidade) {
        itens.removeIf(item -> {
            if (item.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                if (item.getQuantidade() > quantidade) {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        });
    }

    // Método de listar produtos com tratamento de formatação
    public void listarProdutos() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum produto na mesa.");
        } else {
            System.out.printf("%-20s %-15s %-10s %-10s %-30s%n", "Nome", "Categoria", "Preco", "Quantidade", "Descricao");
            for (ItemMesa item : itens) {
                Produto produto = item.getProduto();
                System.out.printf("%-20s %-15s %-10.2f %-10d %-30s%n",
                        produto.getNome(), produto.getCategoria(), produto.getPreco(), item.getQuantidade(), produto.getDescricao());
            }
        }
    }

    // Uso do método for para exibir o valor total de produtos consumidos pela mesa, atribuíndo posteriormente o valor null 
    public double fecharMesa() {
        double total = 0;
        for (ItemMesa item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        itens.clear();
        return total;
    }
}
