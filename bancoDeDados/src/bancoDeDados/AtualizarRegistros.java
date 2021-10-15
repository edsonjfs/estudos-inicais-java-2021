package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarRegistros {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConnection();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome para ser atualizado :");
		String nomeNovo = entrada.nextLine();
		
		System.out.println("Digite o codigo :");
		int codigoTabela = entrada.nextInt();
	
		
		String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nomeNovo);
		stmt.setInt(2, codigoTabela);
		stmt.execute();
		
		stmt.close();
		conexao.close();
		entrada.close();
		
	}


}
