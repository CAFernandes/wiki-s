package DAO.user;

import java.sql.Connection;
import java.sql.SQLException;

import model.UserInfo;

public interface iUserDao {
	UserInfo aunteticar(UserInfo uInfo) throws SQLException;
	void setConnection(Connection connection);
}
