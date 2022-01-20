public class Conta implements IConta {

    public static Integer SEQUENCIA = 1;

    private Integer numero;
    private Integer agencia;
    private Double saldo = 0.0;

    public Conta() {
    }

    public Conta(Integer agencia) {
        this.numero = SEQUENCIA++;
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(Double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }
}
