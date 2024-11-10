package ctr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
	private String URL = "jdbc:postgresql://localhost:5432/domcolchao";  
	private String usuario = "postgres";  
	private String senha = "postdba";
	private Connection conexao;


	private static BancoDados bd;
	
	private BancoDados() {
		try {
			Class.forName("org.postgresql.Driver");  
													 
			this.conexao = DriverManager.getConnection(URL, usuario, senha); 
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não existe");
		} catch (SQLException e) {
			System.out.println("Erro ao acessar o BD");
		}
	}
	
	public static BancoDados getBanco() {
		if(bd==null)
			bd =new BancoDados();      
		
		return bd;
	}
	
	 public Connection getConnection() {
	        return conexao;
	    }

}
