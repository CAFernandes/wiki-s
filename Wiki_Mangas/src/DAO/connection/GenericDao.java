package DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	private Connection c;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String hostName = "127.0.0.1";
		String dbName = "wiki";
		String user = "azure";
		String senha = "6#vWHD_$";
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://" + hostName + ":54151/" + dbName, user, senha);

		return c;
	}

}
/*
 * Connector to SQL Server -- fiquei triste para deletar import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.SQLException;
 * 
 * public class GenericDao implements iGenericDao { private Connection c;
 * 
 * public Connection getConnection() { try { String hostName = "localhost";
 * String user ="caio_note"; String senha ="041519";
 * Class.forName("net.sourceforge.jtds.jdbc.Driver"); String conexao =
 * String.format("jdbc:jtds:sqlserver://%s:1433/wiki;user=%s;password=%s;",
 * hostName, user, senha); c = DriverManager.getConnection(conexao); return c;
 * }catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
 * return c; } }
 */
