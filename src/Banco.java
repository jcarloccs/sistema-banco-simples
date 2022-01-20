import java.util.HashMap;
import java.util.Map;

public class Banco {

    private String nomeBanco;
    private Map<String, Cliente> clientes;

    public Banco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
        this.clientes = new HashMap<>();
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void addCliente(String nome) {
        clientes.put(nome, new Cliente(nome));
    }

    public Cliente getCliente(String nome) {
        return clientes.get(nome);
    }

    public void remCliente(String nome) {
        clientes.remove(nome);
    }
}
