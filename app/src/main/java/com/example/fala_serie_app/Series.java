package com.example.fala_serie_app;

public class Series {

    private String nome;
    private String descricao;
    private int imagem;

    public Series(String nome, String descricao, int imagem){
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getNome(){
        return nome;
    }

    public int getImage(){
        return imagem;
    }

    public String getDescricao(){
        return descricao;
    }

    @Override
    public String toString() {
        return "Selecao{" +
                "nome='" + nome + '\'' +
                ", descrição='" + descricao + '\'' +
                '}';
    }

}
