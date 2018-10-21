package DAO.User;

import java.sql.Connection;

import DAO.GenericDAOException;
import model.User;

public interface iUserDao {

	User autenticar(User user)throws GenericDAOException;
	void setConnection(Connection connection);
	
}
