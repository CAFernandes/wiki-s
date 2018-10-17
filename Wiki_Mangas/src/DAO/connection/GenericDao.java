package DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements iGenericDao{
private Connection c;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String user ="Teddy";
		String senha ="1234";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String conexao = String.format("jdbc:jtds:sqlserver://%s:1433/wiki;%s;password=%s;", hostName, user, senha);
		c = DriverManager.getConnection(conexao);
		return c;
		
	}


}
