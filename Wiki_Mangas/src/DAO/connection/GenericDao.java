package DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements iGenericDao {
private Connection c;
	
	public Connection getConnection() {
		try {
			String hostName = "localhost";
			String user ="caio_note";
			String senha ="041519";
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String conexao = String.format("jdbc:jtds:sqlserver://%s:1433/wiki;user=%s;password=%s;", hostName, user, senha);
			c = DriverManager.getConnection(conexao);
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return c;
		
	}


}
