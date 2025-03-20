package domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Banco {
    private String name;
    private List<Cliente> clientes;

    public Banco(String name){
        this.name = name;
        this.clientes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void imprimirClientes(){
            System.out.println("======= Lista de Clientes Banco " + name + "=======");
        for(Cliente cliente: clientes){
            System.out.println(cliente.getNome());
        }
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
