package br.com.dio.banco;

public interface IConta {
    void saca(double valor);
    void deposita(double valor);
    void tranfere(double valor, IConta destino);

    void imprimirExtrato();
}
