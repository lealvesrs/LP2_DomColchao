package view;

import ctr.Cliente;
import ctr.PessoaController;
import ctr.Vendedor;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PessoaController pessoaController = new PessoaController();

        if (pessoaController.criarVendedor("João", "123456789", "12345-678", "987654321", 
                                                     "Rua A", 100, LocalDate.of(1985, 5, 15), 
                                                     "9876543210", 5000.0)) {
            System.out.println("Vendedor inserido com sucesso.");
        }

    
        if (pessoaController.criarCliente("Maria", "987654321", "54321-123", "123456789", 
                                                    "Rua B", 200)) {
            System.out.println("Cliente inserido com sucesso.");
        }

      
        
        List<Vendedor> vendedores = pessoaController.listarVendedores();
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
            
        }else {
        	System.out.println("Lista de vendedores:");
            for (Vendedor vendedor : vendedores) {
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("CPF: " + vendedor.getCpf());
                System.out.println("CEP: " + vendedor.getCep());
                System.out.println("Telefone: " + vendedor.getTelefone());
                System.out.println("Rua: " + vendedor.getRua());
                System.out.println("Número: " + vendedor.getNumero());
                System.out.println("Número: " + vendedor.getNumeroCTPS());
                System.out.println("Número: " + vendedor.getRemuneracao());
                System.out.println("---------------------------");
            }
        }

        
        
        List<Cliente> clientes = pessoaController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            
        }else {
        	System.out.println("\n\nLista de clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("CEP: " + cliente.getCep());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Rua: " + cliente.getRua());
                System.out.println("Número: " + cliente.getNumero());
                System.out.println("---------------------------");
            }
        }
    }
}

