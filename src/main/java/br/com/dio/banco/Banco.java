package br.com.dio.banco;

public class Banco {
    private String nome;
    private int numeroAgencia;

    public Banco(String nome) {
        this.nome = nome = "DIO";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}
