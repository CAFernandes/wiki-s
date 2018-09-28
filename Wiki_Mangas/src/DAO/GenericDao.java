package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
private Connection c;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=wiki_mangas;namedPipes=true",
			"admin", "123456");
		System.out.println("Banco de dados conectado com sucesso!");
		return c;
		
	}


}
