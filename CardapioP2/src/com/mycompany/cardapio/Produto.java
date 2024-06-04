package com.mycompany.cardapio;

public class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;
    private String descricao;

    // Atributo do método "Produto"
    public Produto(String nome, String categoria, double preco, int quantidade, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    // Uso do método get
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    // Formatação de frase
    @Override
    public String toString() {
        return String.format("Produto{nome='%s', categoria='%s', preco=%.2f, quantidade=%d, descricao='%s'}",
                             nome, categoria, preco, quantidade, descricao);
    }
}
