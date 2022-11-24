package br.com.dio.banco;

public abstract class Conta implements IConta{

    protected static final int NUM_AGENCIA = 1;
    private static int SEQUENCIAL = 1;
    protected double saldo;
    protected int agencia;
    protected int numero;
    String senha;
    Cliente titular;
    boolean logar = false;

    public Conta() {
        this.agencia = Conta.NUM_AGENCIA;
        this.numero = SEQUENCIAL++;
    }

    public void verificaCliente(String titular, String senha){
       /*if (this.titular.getNome() == titular){
           if (this.senha == senha){
               System.out.println("Logado com sucesso!");
               this.logar = true;
           }else {
               System.out.println("Senha invalida!");
           }
       }else {
           System.out.println("Titular invalido!");
       }
*/
    }

    @Override
    public void saca(double valor) {
        if (this.saldo >= valor){
            System.out.println("Valor sacado: R$ " + valor);
            this.saldo -= valor;
            saldoEmConta(saldo);
        }else {
            System.out.println("Saldo insuficiente!");
            System.out.println("Seu saldo atual é de R$ " + this.saldo);
        }
    }

    @Override
    public void deposita(double valor) {
        System.out.println("Valor depositado: R$" + valor);
        this.saldo += valor;
        saldoEmConta(saldo);
    }

    @Override
    public void tranfere(double valor, IConta destino) {
        if (saldo >= valor){
            System.out.println("Tranferido o valor de R$ " + valor);
            this.saldo -= valor;
            destino.deposita(valor);
            saldoEmConta(saldo);
        }else{
            System.out.println("valor insuficiente!!");
        }
    }

    public double saldoEmConta(double valor){
        this.saldo = valor;
        System.out.println("Saldo atual R$ " + this.saldo);
        return this.saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public boolean isLogar() {
        return logar;
    }

    public void setLogar(boolean logar) {
        this.logar = logar;
    }

    public abstract void imprimirExtrato();

    protected void imprimirDadosConta(){
        System.out.println("Agencia: " + this.agencia + "\nconta: " + this.numero + "\nSaldo inicial no valor de  R$ " + this.saldo);
    }
}
