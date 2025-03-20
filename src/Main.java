import domain.services.Operacoes;

import java.util.*;

import static domain.services.Operacoes.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Banco Interativo ===");
            System.out.println("1 - Criar Cliente e Contas");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Mostrar Extrato");
            System.out.println("6 - Listar Clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarClienteContas();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 5:
                    mostrarExtrato();
                    break;
                case 6:
                    banco.imprimirClientes();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Obrigado por usar o banco!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
