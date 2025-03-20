package services;

import domain.models.ContaPoupanca;
import domain.models.Banco;
import domain.models.Cliente;
import domain.models.Conta;
import domain.models.ContaCorrente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Operacoes {
    public static final Scanner sc = new Scanner(System.in);
    public static final Banco banco = new Banco("Bradesco");
    public static final Map<String, Conta[]> contas = new HashMap<>();

    public static void criarClienteContas() {
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = new Cliente(nome);

        ContaCorrente contaCorrente = new ContaCorrente(cliente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);

        contas.put(cliente.getNome(), new Conta[]{contaCorrente, contaPoupanca});
        banco.adicionarCliente(cliente);

        System.out.println("Contas criadas com sucesso para " + nome);
    }

    public static void realizarDeposito() {
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        Conta[] contasCliente = contas.get(nome);

        if (contasCliente != null) {
            Conta conta = escolherConta(contasCliente);
            if (conta != null) {
                System.out.print("Digite o valor do depósito: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                conta.depositar(valor);
                System.out.println("Depósito realizado com sucesso!");
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static void realizarSaque() {
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        Conta[] contasCliente = contas.get(nome);

        if (contasCliente != null) {
            Conta conta = escolherConta(contasCliente);
            if (conta != null) {
                System.out.print("Digite o valor do saque: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                conta.sacar(valor);
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static void realizarTransferencia() {
        System.out.print("Digite o nome do remetente: ");
        String remetente = sc.nextLine();
        Conta[] contasRemetente = contas.get(remetente);

        if (contasRemetente == null) {
            System.out.println("Cliente remetente não encontrado!");
            return;
        }

        Conta contaOrigem = escolherConta(contasRemetente);
        if (contaOrigem == null) return;

        System.out.print("Digite o nome do destinatário: ");
        String destinatario = sc.nextLine();
        Conta[] contasDestinatario = contas.get(destinatario);

        if (contasDestinatario == null) {
            System.out.println("Cliente destinatário não encontrado!");
            return;
        }

        Conta contaDestino = escolherConta(contasDestinatario);
        if (contaDestino == null) return;

        System.out.print("Digite o valor da transferência: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        contaOrigem.transferir(valor, contaDestino);
    }

    public static void mostrarExtrato() {
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        Conta[] contasCliente = contas.get(nome);

        if (contasCliente != null) {
            Conta conta = escolherConta(contasCliente);
            if (conta != null) {
                conta.imprimirExtrato();
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static Conta escolherConta(Conta[] contasCliente) {
        System.out.println("Escolha a conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {
            return contasCliente[0];
        } else if (opcao == 2) {
            return contasCliente[1];
        } else {
            System.out.println("Opção inválida!");
            return null;
        }
    }
}
