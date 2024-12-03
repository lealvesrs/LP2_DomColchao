package dao;
import ctr.BancoDados;
import dto.Produto;
import dto.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProdutoDAO {

	 private Connection conexao;

	    public ProdutoDAO() {
	    	this.conexao = BancoDados.getBanco().getConnection();
	    }
	    
	    
	    //inserir produto
	    
	    public boolean inserir(Produto produto) {
	    	 String sql = "INSERT INTO produto (nomeProd, idProd, tamanhoProd, densidadeProd, materialProd, precoProd) VALUES (?, ?, ?, ?, ?, ?)";
	         try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	             stmt.setString(1, produto.getNomeProd());
	             stmt.setInt(2, produto.getIdProd());
	             stmt.setString(3, produto.getTamanhoProd());
	             stmt.setString(4, produto.getDensidadeProd());
	             stmt.setString(5, produto.getMaterialProd());
	             stmt.setDouble(6, produto.getPrecoProd());
	             stmt.executeUpdate();
	             return true;
	         } catch (SQLException e) {
	             System.err.println("Erro ao inserir produto: " + e.getMessage());
	             return false;
	         }
	    }
	    
	
	    
	    //listar Produto
	    
	    public List<Produto> listar() {
	        List<Produto> produtos = new ArrayList<>();
	        String sql = "SELECT * FROM produto";
	        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Produto produto = new Produto(
	                    rs.getString("nomeProd"),
	                    rs.getInt("idProd"),
	                    rs.getString("tamanhoProd"),
	                    rs.getString("densidadeProd"),
	                    rs.getString("materialProd"),
	                    rs.getDouble("precoProd")
	                );
	                produtos.add(produto);
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao listar produtos: " + e.getMessage());
	        }
	        return produtos;
	    }
	    
	    
	    
	    //Excluir Produto
	    
	    public boolean excluir(int idProd) {
	        String sql = "DELETE FROM Vendedor WHERE idProd = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, idProd);

	            int linhasAfetadas = stmt.executeUpdate();
	            return linhasAfetadas > 0; 
	        } catch (SQLException e) {
	            System.err.println("Erro ao excluir produto: " + e.getMessage());
	            return false;
	        }
	    }
	    
	   
	    
	    //Verfifica existencia 
	    
	    public Boolean verificaExistencia(int idProd) {
	        String sql = "SELECT COUNT(*) AS total FROM Produto WHERE idProd = ?";
	        
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, idProd); 

	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int total = rs.getInt("total");
	                    return total > 0; 
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao verificar ID do produto: " + e.getMessage());
	        }
	        return false; 
	    }
	    
	    
	    
	    //Pesquisar Nome produto
	    
	    public List<Produto> pesquisarPorNomeProduto(String nomeBusca) {
	        List<Produto> produtos = new ArrayList<>();
	        String sql = "SELECT * FROM Produto WHERE nome ILIKE ?";
	        
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setString(1, "%" + nomeBusca + "%"); 
	            
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    Produto produto = new Produto(
	                    		rs.getString("nomeProd"),
	      	                    rs.getInt("idProd"),
	      	                    rs.getString("tamanhoProd"),
	      	                    rs.getString("densidadeProd"),
	      	                    rs.getString("materialProd"),
	      	                    rs.getDouble("precoProd")
	      	                );
	      	                produtos.add(produto);
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao pesquisar produto: " + e.getMessage());
	        }
	        return produtos;
	    }
	    
	    
	    
	    //Editar 
	    
	    public boolean editar(Produto produto) {
	        String sql = "UPDATE Produto SET nomeProd = ?, idProd = ?, tamanhoProd = ?, densidadeProd = ?, materialProd = ?, precoProd = ?, WHERE idProd = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setString(1, produto.getNomeProd());
	            stmt.setInt(2, produto.getIdProd());
	            stmt.setString(3, produto.getTamanhoProd());
	            stmt.setString(4, produto.getDensidadeProd());
	            stmt.setString(5, produto.getMaterialProd());
	            stmt.setDouble(6, produto.getPrecoProd());          

	            int linhasAfetadas = stmt.executeUpdate();
	            
	            return linhasAfetadas > 0;
	        } catch (SQLException e) {
	            System.err.println("Erro ao atualizar produto: " + e.getMessage());
	            return false;
	        }
	    }
	    
}
