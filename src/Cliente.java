import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;

    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void addContaCorrente(Integer agencia) {
        this.contas.add(new ContaCorrente(agencia));
    }

    public void addContaPoupanca(Integer agencia) {
        this.contas.add(new ContaPoupanca(agencia));
    }

    public Conta getConta(Integer numConta) {
        Conta aux = null;
        boolean encontrou = false;

        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                aux = conta;
                encontrou = true;
            }
        }
        return aux;
    }

    public void depositar(Integer numConta, Double valor) {
        if (!(getConta(numConta) == null)) {
            getConta(numConta).depositar(valor);
        }
        else System.out.println("Conta não existe");
    }

    public void sacar(Integer numConta, Double valor) {
        if (!(getConta(numConta) == null)) {
            getConta(numConta).sacar(valor);
        }
        else System.out.println("Conta não existe");
    }

    public void transferir(Integer numConta, Double valor, Cliente clienteDestino, Integer contaDestino) {
        if (!(getConta(numConta) == null)) {
            getConta(numConta).transferir(clienteDestino.getConta(contaDestino), valor);
        }
        else System.out.println("Conta não existe");
    }

    public void saldo(Integer numConta) {
        if (!(getConta(numConta) == null)) {
            System.out.println("Saldo da conta " + numConta + ": " + getConta(numConta).getSaldo());
        }
        else System.out.println("Conta não existe");
    }
}
