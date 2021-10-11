package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	public static Connection getConnection() {
		try {
			String stringDeConexao = "jdbc:mysql://localhost/curso_java"
					+ "?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "password";
			
			return  DriverManager.getConnection(stringDeConexao, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
