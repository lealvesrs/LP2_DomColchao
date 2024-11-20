package dao;

import ctr.BancoDados;
import dto.Cliente;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	 private Connection conexao;

    public ClienteDAO() {
    	this.conexao = BancoDados.getBanco().getConnection();
    }


    public boolean inserir(Cliente cliente) {
    	String sql = "INSERT INTO Cliente (nome, cpf, cep, telefone, rua, numero) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getRua());
            stmt.setInt(6, cliente.getNumero());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean editar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, cep = ?, telefone = ?, rua = ?, numero = ? WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCep());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getRua());
            stmt.setInt(5, cliente.getNumero());
            stmt.setString(6, cliente.getCpf());

            int linhasAfetadas = stmt.executeUpdate();
            
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean excluir(String cpf) {
        String sql = "DELETE FROM Cliente WHERE cpf = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; 
        } catch (SQLException e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
            return false;
        }
    }
    
    
    
    public Boolean verificaExistencia(String cpf) {
        String sql = "SELECT COUNT(*) AS total FROM Cliente WHERE cpf = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf); 

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");
                    return total > 0; 
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar CPF: " + e.getMessage());
        }
        return false; 
    }

    
    public List<Cliente> pesquisarPorNome(String nomeBusca) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE nome ILIKE ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeBusca + "%"); 
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getString("rua"),
                        rs.getInt("numero")
                    );
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar cliente: " + e.getMessage());
        }
        return clientes;
    }


    public List<Cliente> listar() {
    	 List<Cliente> clientes = new ArrayList<>();
         String sql = "SELECT * FROM Cliente";
         try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
             while (rs.next()) {
                 Cliente cliente = new Cliente(
                     rs.getString("nome"),
                     rs.getString("cpf"),
                     rs.getString("cep"),
                     rs.getString("telefone"),
                     rs.getString("rua"),
                     rs.getInt("numero")
                 );
                 clientes.add(cliente);
             }
         } catch (SQLException e) {
             System.err.println("Erro ao listar clientes: " + e.getMessage());
         }
         return clientes;
    }
}
