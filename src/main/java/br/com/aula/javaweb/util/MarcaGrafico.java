package br.com.aula.javaweb.util;


public class MarcaGrafico {
    
    private String nome;
    private int quantidadeModelos;

    public MarcaGrafico(String nome, int quantidadeModelos) {
        this.nome = nome;
        this.quantidadeModelos = quantidadeModelos;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeModelos() {
        return quantidadeModelos;
    }

    public void setQuantidadeModelos(int quantidadeModelos) {
        this.quantidadeModelos = quantidadeModelos;
    }
    
    
}
