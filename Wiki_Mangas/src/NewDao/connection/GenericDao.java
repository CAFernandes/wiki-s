package NewDao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements iGenericDao {

	private Connection c;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String user ="caio_note";
		String senha ="041519";
		String db = "wiki_manga";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String conexao = String.format("jdbc:jtds:sqlserver://%s:1433/%s;user=%s;password=%s;", db, hostName, user, senha);
		c = DriverManager.getConnection(conexao);
		return c;
		
	}

}