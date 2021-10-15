package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas01 {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConnection();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite a parte do nome que se deseja pesquisar :");
		String pesquisa = entrada.nextLine();
		pesquisa = "%"+pesquisa+"%";
		
		String sql = "SELECT * FROM pessoas WHERE nome like ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, pesquisa);
		ResultSet resultado = stmt.executeQuery(sql);
		
		List<Pessoas> pessoas = new ArrayList<Pessoas>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			
			pessoas.add(new Pessoas(codigo, nome));
		}
		
		for(Pessoas a:pessoas) {
			System.out.println(a.codigo +"  "+a.nome);
		}
		
		stmt.close();
		conexao.close();
		entrada.close();
		
	}
}
