package domain;

import domain.models.Cliente;
import domain.models.Conta;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("========= Extrato da Conta Poupança ========");
        imprimirInfosComuns();
    }
}
