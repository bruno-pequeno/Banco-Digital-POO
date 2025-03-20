package domain.models;

import java.util.List;

public class Banco {
    private String name;
    private List<Conta> contas;

    public Banco(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    private void imprimirClientes(){
        for(Conta conta: contas){
            System.out.println("======= Lista de Clientes Banco " + name + "=======");
            System.out.println(conta.cliente.getNome());
        }
    }
}
