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
