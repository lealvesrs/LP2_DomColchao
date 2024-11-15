package ctr;

import dao.ClienteDAO;
import dao.VendedorDAO;
import dto.Cliente;
import dto.Vendedor;

import java.time.LocalDate;
import java.util.List;

public class PessoaController {
    private ClienteDAO clienteDAO;
    private VendedorDAO vendedorDAO;

    public PessoaController() {
        this.clienteDAO = new ClienteDAO();
        this.vendedorDAO = new VendedorDAO();
    }

   
    public boolean criarVendedor(String nome, String cpf, String cep, String telefone, 
                                            String rua, int numero, LocalDate dataNascimento, 
                                            String numeroSerieCarteiraTrabalho, double remuneracao) {
        Vendedor vendedor = new Vendedor(nome, cpf, cep, telefone, rua, numero, dataNascimento, 
                                          numeroSerieCarteiraTrabalho, remuneracao);
        return vendedorDAO.inserir(vendedor);
    }

    public boolean criarCliente(String nome, String cpf, String cep, String telefone, 
                                          String rua, int numero) {
        Cliente cliente = new Cliente(nome, cpf, cep, telefone, rua, numero);
        return clienteDAO.inserir(cliente);
    }


    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

    public List<Vendedor> listarVendedores() {
        return vendedorDAO.listar();
    }
}
