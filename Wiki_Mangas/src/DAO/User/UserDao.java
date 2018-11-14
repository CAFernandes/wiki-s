package DAO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.GenericDAOException;
import DAO.connection.GenericDao;
import DAO.connection.iGenericDao;
import model.User;

public class UserDao implements iUserDao {
	
	private Connection connection;
	
	public UserDao () {
		iGenericDao gDao = new GenericDao();
		try {
			setConnection(gDao.getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User autenticar(User user) throws GenericDAOException {
		String sql = "SELECT PWDCOMPARE(?, senha) AS valido FROM usuario WHERE usuario = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getsenha());
			ps.setString(2, user.getUser());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("valido")==1) {
					user.setLogado(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void setConnection(Connection connection){
		this.connection = connection;
		
	}

}
