import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do banco : ");
        String nomeBanco = sc.nextLine();

        Banco banco = new Banco(nomeBanco);
        Cliente cliente = null;

        int opcao;

        do {
            System.out.println("--- Bem vindo ao banco " + nomeBanco + " ---");

            System.out.println("--- Escolha uma opção: ---");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Escolher cliente");

            opcao = sc.nextInt();
            sc.nextLine();
            String nome;

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    nome = sc.nextLine();
                    banco.addCliente(nome);
                    break;

                case 2:
                    System.out.println("Digite o nome do cliente: ");
                    nome = sc.nextLine();
                    banco.remCliente(nome);
                    break;

                case 3:
                    System.out.println("Digite o nome do cliente: ");
                    nome = sc.nextLine();
                    cliente = banco.getCliente(nome);
                    if (cliente == null) {
                        opcao = 0;
                        System.out.println("Cliente não encontrado");
                    }
                    break;

                default:
                    break;

            }
        } while (opcao != 3);

        do {
            System.out.println("--- Bem vindo ao banco " + nomeBanco + " ---");

            System.out.println("--- Escolha uma opção: ---");
            System.out.println("1 - Adicionar conta poupança");
            System.out.println("2 - Adicionar conta corrente");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Saldo");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();
            int agencia;
            double valor;
            int numConta;
            String nome;
            int contaDestino;

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da agência: ");
                    agencia = sc.nextInt();
                    cliente.addContaPoupanca(agencia);
                    break;

                case 2:
                    System.out.println("Digite o número da agência: ");
                    agencia = sc.nextInt();
                    cliente.addContaCorrente(agencia);
                    break;

                case 3:
                    System.out.println("Digite o número da conta: ");
                    numConta = sc.nextInt();
                    System.out.println("Digite o valor a ser depositado: ");
                    valor = sc.nextDouble();
                    cliente.depositar(numConta, valor);
                    break;

                case 4:
                    System.out.println("Digite o número da conta: ");
                    numConta = sc.nextInt();
                    System.out.println("Digite o valor a ser sacado: ");
                    valor = sc.nextDouble();
                    cliente.sacar(numConta, valor);
                    break;

                case 5:
                    System.out.println("Digite o número da sua conta: ");
                    numConta = sc.nextInt();
                    System.out.println("Digite o valor a ser transferido: ");
                    valor = sc.nextDouble();
                    System.out.println("Digite o nome do cliente: ");
                    nome = sc.nextLine();
                    System.out.println("Digite o número da conta de destino: ");
                    contaDestino = sc.nextInt();
                    Cliente cliente2 = banco.getCliente(nome);
                    cliente.transferir(numConta, valor, cliente2, contaDestino);
                    break;

                case 6:
                    System.out.println("Digite o número da conta: ");
                    numConta = sc.nextInt();
                    cliente.saldo(numConta);
                    break;

                default:
                    System.out.println("Opção errada");
                    break;

            }
        } while (opcao != 0);
    }
}
