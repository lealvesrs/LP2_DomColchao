package dao;

import ctr.BancoDados;
import dto.Vendedor;
import dto.Vendedor;
import dto.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class VendedorDAO {
    private Connection conexao;

    public VendedorDAO() {
    	this.conexao = BancoDados.getBanco().getConnection();
    }

    public boolean inserir(Vendedor vendedor) {
    	 String sql = "INSERT INTO vendedor (nome, cpf, cep, telefone, rua, numero, data_nasc, ctps, remuneracao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
             stmt.setString(1, vendedor.getNome());
             stmt.setString(2, vendedor.getCpf());
             stmt.setString(3, vendedor.getCep());
             stmt.setString(4, vendedor.getTelefone());
             stmt.setString(5, vendedor.getRua());
             stmt.setInt(6, vendedor.getNumero());
             stmt.setDate(7, Date.valueOf(vendedor.getDataNascimento()));
             stmt.setString(8, vendedor.getNumeroCTPS());
             stmt.setDouble(9, vendedor.getRemuneracao());
             stmt.executeUpdate();
             return true;
         } catch (SQLException e) {
             System.err.println("Erro ao inserir vendedor: " + e.getMessage());
             return false;
         }
    }


    public List<Vendedor> listar() {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vendedor vendedor = new Vendedor(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    rs.getString("rua"),
                    rs.getInt("numero"),
                    rs.getDate("data_nasc").toLocalDate(),
                    rs.getString("ctps"),
                    rs.getDouble("remuneracao")
                );
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar vendedores: " + e.getMessage());
        }
        return vendedores;
    }
    
    public boolean excluir(String cpf) {
        String sql = "DELETE FROM Vendedor WHERE cpf = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; 
        } catch (SQLException e) {
            System.err.println("Erro ao excluir vendedor: " + e.getMessage());
            return false;
        }
    }
    
    
    
    public Boolean verificaExistencia(String cpf) {
        String sql = "SELECT COUNT(*) AS total FROM Vendedor WHERE cpf = ?";
        
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

    
    public List<Vendedor> pesquisarPorNome(String nomeBusca) {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM Vendedor WHERE nome ILIKE ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeBusca + "%"); 
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vendedor vendedor = new Vendedor(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getDate("data_nasc").toLocalDate(),
                        rs.getString("ctps"),
                        rs.getDouble("remuneracao")
                        
                    );
                    vendedores.add(vendedor);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar vendedor: " + e.getMessage());
        }
        return vendedores;
    }
    
    public boolean editar(Vendedor vendedor) {
        String sql = "UPDATE Vendedor SET nome = ?, cep = ?, telefone = ?, rua = ?, numero = ?, data_nasc = ?, ctps = ?, remuneracao = ? WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCep());
            stmt.setString(3, vendedor.getTelefone());
            stmt.setString(4, vendedor.getRua());
            stmt.setInt(5, vendedor.getNumero());
            stmt.setDate(6, Date.valueOf(vendedor.getDataNascimento()));
            stmt.setString(7, vendedor.getNumeroCTPS());
            stmt.setDouble(8, vendedor.getRemuneracao());
            stmt.setString(9, vendedor.getCpf());

            int linhasAfetadas = stmt.executeUpdate();
            
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar vendedor: " + e.getMessage());
            return false;
        }
    }
}
