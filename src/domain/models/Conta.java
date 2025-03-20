package domain.models;

import domain.interfaces.IConta;

public abstract class Conta implements IConta {
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo){
            System.out.println("Você não possui saldo o suficiente, tente novamente.");
        } else if(valor <= 0){
            System.out.println("Digite um valor!");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor <= 0) System.out.println("Digite um valor!");
        else saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor > saldo){
            System.out.println("Você não possui saldo o suficiente, tente novamente.");
        } else if(valor <= 0){
            System.out.println("Digite um valor!");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
