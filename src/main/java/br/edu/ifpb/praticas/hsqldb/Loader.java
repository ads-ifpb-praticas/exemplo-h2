package br.edu.ifpb.praticas.hsqldb;

import java.sql.*;

/**
 * Este projeto demonstra como utilizar uma base de dados embarcada.
 * Aqui foi utilizado o H2, porém, outras bases
 * também podem ser utilizadas seguindo a mesma idéia.
 *
 * @author diogomoreira
 */
public class Loader {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection =
				DriverManager.getConnection("jdbc:h2:mem:;" +
						"INIT=RUNSCRIPT FROM './src/main/resources/create_schema.sql'\\;", "sa", "");
		PreparedStatement ps = connection.prepareStatement("INSERT INTO entidade (nome) VALUES ('Diogo')");
		ps.execute();
		
		PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM entidade");
		ResultSet rs = ps2.executeQuery();
		rs.next();
		String nome = rs.getString("nome");
		System.out.println(nome);
		connection.close();
	}
	
}
