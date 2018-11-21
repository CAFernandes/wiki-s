package DAO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.GenericDAOException;
import DAO.connection.GenericDao;
import model.User;

public class UserDao implements iUserDao {
	
	private Connection connection;
	
	public UserDao () {
		GenericDao gDao = new GenericDao();
		try {
			connection = gDao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User autenticar(User user) throws GenericDAOException {
		String sql = "select aes_decrypt(senha, ?) as valido from usuario WHERE usuario = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getsenha());
			ps.setString(2, user.getUser());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("valido").equals("admin")) {
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
