package ctr;

import dao.ClienteDAO;
import dao.VendedorDAO;
import dto.Cliente;
import dto.Pessoa;
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

   

    public boolean criarCliente(String nome, String cpf, String cep, String telefone, 
                                          String rua, int numero) {
        Pessoa cliente = PessoaFactory.criarPessoa("cliente",nome, cpf, cep, telefone, rua, numero,null,null,null);
        return clienteDAO.inserir((Cliente) cliente);
    }

    public boolean editarCliente(String nome, String cpf, String cep, String telefone, 
            String rua, int numero) {
    	Pessoa cliente = (Cliente) PessoaFactory.criarPessoa("cliente",nome, cpf, cep, telefone, rua, numero, null,null,null);
		return clienteDAO.editar((Cliente) cliente);
	}
    
    public List<Cliente> pesquisarPorNome(String nome) {
        return clienteDAO.pesquisarPorNome(nome);
    }
    
    public Boolean verificaExistencia(String cpf) {
        return clienteDAO.verificaExistencia(cpf);
    }
    
    public Boolean excluirCliente(String cpf) {
        return clienteDAO.excluir(cpf);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }
    
    public boolean criarVendedor(String nome, String cpf, String cep, String telefone, 
            String rua, int numero, LocalDate dataNascimento, 
            String numeroSerieCarteiraTrabalho, double remuneracao) {
	Pessoa vendedor = new Vendedor(nome, cpf, cep, telefone, rua, numero, dataNascimento, 
	          numeroSerieCarteiraTrabalho, remuneracao);
	return vendedorDAO.inserir((Vendedor)vendedor);
	}
    
    public boolean editarVendedor(String nome, String cpf, String cep, String telefone, 
            String rua, int numero, LocalDate dataNascimento, 
            String numeroSerieCarteiraTrabalho, double remuneracao) {
    	Pessoa vendedor = (Vendedor) PessoaFactory.criarPessoa("vendedor",nome, cpf, cep, telefone, rua, numero, dataNascimento, 
  	          numeroSerieCarteiraTrabalho, remuneracao);
		return vendedorDAO.editar((Vendedor)vendedor);
	}

    public List<Vendedor> listarVendedores() {
        return vendedorDAO.listar();
    }
    
    public List<Vendedor> pesquisarPorNomeVendedor(String nome) {
        return vendedorDAO.pesquisarPorNome(nome);
    }
    
    public Boolean excluirVendedor(String cpf) {
        return vendedorDAO.excluir(cpf);
    }
    
    public Boolean verificaExistenciaVendedor(String cpf) {
        return vendedorDAO.verificaExistencia(cpf);
    }
    
}
