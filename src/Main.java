import domain.ContaPoupanca;
import domain.models.Banco;
import domain.models.Cliente;
import domain.models.Conta;
import domain.models.ContaCorrente;

public class Main {
    public static void main(String[] args) {
        Banco bradesco = new Banco("Bradesco");

        Cliente cliente = new Cliente();
        cliente.setNome("Bruno");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        cc.depositar(100);
        cc.sacar(10);

        cc.transferir(50, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}