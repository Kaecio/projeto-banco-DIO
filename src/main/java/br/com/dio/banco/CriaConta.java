package br.com.dio.banco;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.Scanner;

public class CriaConta {

    private static String tipoDeConta = "";
    private static String tipoDeOperacao = "";

    private static boolean conectado = true;

    private static double valor = 0;

    public static double getValor() {
        return valor;
    }

    public static void setValor(double valor) {
        CriaConta.valor = valor;
    }

    public String getTipoDeOperacao() {
        return tipoDeOperacao;
    }

    public void setTipoDeOperacao(String tipoDeOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }


    public CriaConta() {
    }

    public static void main(String[] args) {


        Cliente cliente = new Cliente();
        Cliente cliente2 = new Cliente();
        Conta contaPoupanca = new ContaPoupanca();
        Conta contaCorrente = new ContaCorrente();

        Conta contaPoupanca2 = new ContaPoupanca();
        Conta contaCorrente2 = new ContaCorrente();

        Scanner scan = new Scanner(System.in);
        System.out.println("*** Banco DIO ***");
        System.out.println("Abra a sua conta e tenha muitos benefícios como cliente DIO");
        System.out.println("Vamos começar então? Me diga como vodê gostaria de ser chamado? Pode digitar por favor! ");
        cliente.setNome( scan.next());
        System.out.println("Bem vindo ao banco DIO " + cliente.getNome());
        System.out.println("Agora me diga a sua data de nascimento");
        cliente.setDataNasc(scan.next());
        System.out.println("Gostaria de abrir uma conta corrente ou uma conta poupança? (p) Poupança? Conta (c) Corrente? Ou ambas (pc) ? " );
        tipoDeConta = scan.next().toLowerCase();
        System.out.println(tipoDeConta);

        if (tipoDeConta.equals("p")) {
            //conta.imprimirExtrato();
            contaPoupanca.titular = new Cliente();
            contaPoupanca.imprimirDadosConta();

        }
        if (tipoDeConta.equals("c")){
            //conta.imprimirExtrato();
            contaCorrente.titular = new Cliente();
            contaCorrente.imprimirDadosConta();
        }
        if (tipoDeConta.equals("pc")){
            contaCorrente.titular = new Cliente();
            contaPoupanca.imprimirDadosConta();
            System.out.println("-------------------------");
            contaCorrente.imprimirDadosConta();
        }


        System.out.println("*******************************************************************************");
        System.out.println(cliente.getNome() + "Escolha qual tipo de operação que voce gostaria de realizar!!");


        while(conectado == true){
            System.out.println("Depósito, tecle - 1 \nSaque, tecle - 2 \nTransferencia, tecle - 3 \nSair, tecle - 0 ");
            tipoDeOperacao = scan.next();

            switch (tipoDeOperacao){
                case "1":
                    System.out.println("Digite o valor do depósito:");
                    valor = scan.nextDouble();
                    if (tipoDeConta.equals("p")){
                        System.out.println("depósito conta Poupança");
                        contaPoupanca.deposita(valor);
                    }
                    if (tipoDeConta.equals("c")){
                        System.out.println("depósito conta Corrente");
                        contaCorrente.deposita(valor);
                    }
                    break;
                case "2":
                    System.out.println("Digite o valor do saque:");
                    valor = scan.nextDouble();
                    if (tipoDeConta.equals("p")){
                        System.out.println("Saque conta Poupança");
                        contaPoupanca.saca(valor);
                    }
                    if (tipoDeConta.equals("c")){
                        System.out.println("Saque conta Corrente");
                        contaCorrente.saca(valor);
                    }
                    break;
                case "3":
                    System.out.println("Digite o valor da transferencia bancaria:");
                    valor = scan.nextDouble();
                    if (tipoDeConta.equals("p")){
                        System.out.println("Transferencia conta Poupança");
                        contaPoupanca.tranfere(valor, contaCorrente2);
                    }
                    if (tipoDeConta.equals("c")){
                        System.out.println("Transferencia conta Corrente");
                        contaCorrente.tranfere(valor,contaPoupanca2);
                    }
                    break;
                case "0":
                    System.out.println("Obrigado por ser nosso cliente do banco DIO, volte sempre!!");
                    conectado = false;
                    break;
                default:
                    System.out.println("Operação não satisfatoria");
            }
        }

//-------------------------------------------------
        /*double valor;
        String nome = "kaecio";
        String senha = "123";


        Conta contaCliente1 = new Conta();
        Scanner scan = new Scanner(System.in);

        contaCliente1.titular = new Cliente();

        Scanner scan1 = new Scanner(System.in);
        System.out.print("nome: ");
        nome = scan1.next();

        Scanner scan2 = new Scanner(System.in);
        System.out.print("senha: ");
        senha = scan2.next();

        //contaCliente1.verificaCliente(nome, senha);

        System.out.print("deposita : ");

        valor = scan.nextDouble();
        contaCliente1.saldoEmConta(valor);

        System.out.println("Depositar valor de R$: ");
        valor = scan.nextDouble();
        contaCliente1.deposita(valor);

        System.out.println("Saque no valor de R$: ");
        valor = scan.nextDouble();
        contaCliente1.saca(valor);

        System.out.println("Transferir valor de R$: ");
        valor = scan.nextDouble();

        Conta contaCliente2 = new Conta();

        if (contaCliente1.transfere(valor, contaCliente2)){
            System.out.println("Tranferencia realizada com sucesso!!!");
        }else {
            System.out.println("Saldo insuficiente!!");
        }


        double valorFinal =  contaCliente2.saldoEmConta(valor);
        System.out.println(valorFinal);
*/
    }

}