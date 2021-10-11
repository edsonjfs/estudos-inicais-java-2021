package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
	public static void main(String[] args) throws SQLException{
		String stringDeConexao = "jdbc:mysql://localhost"
				+ "?verifyServerCertificate=false&useSSL=true";
		String usuario = "root";
		String senha = "password";
		
		Connection conexao = DriverManager
							.getConnection(stringDeConexao, usuario, senha);
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
		
		conexao.close();
	}
}
