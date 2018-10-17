package DAO.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.connection.GenericDao;
import DAO.connection.iGenericDao;
import model.UserInfo;

public class UserDao implements iUserDao {
	
	private Connection c;

	public UserDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
	}
	@Override
	public UserInfo aunteticar(UserInfo uInfo) throws SQLException {
		UserInfo userInfo = uInfo;
		String sql = "select usuario, senha from usuario where usuario = ? and senha = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, userInfo.getUser());
		ps.setString(2, uInfo.getsenha());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			userInfo.setLogado(true);
		}
		return userInfo;
	}

	@Override
	public void setConnection(Connection connection) {
		this.c = connection;

	}

}
