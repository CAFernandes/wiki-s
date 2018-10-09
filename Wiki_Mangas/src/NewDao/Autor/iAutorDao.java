package NewDao.Autor;

import java.sql.Connection;
import java.util.List;

import NewDao.GenericDAOException;
import model.Autor;

public interface iAutorDao {
	void adicionar(Autor a) throws GenericDAOException;
	List<Autor> pesquisarPorNome(String nome) throws GenericDAOException;
	List<Autor> listarTodosAutores() throws GenericDAOException;
	void alterar(int id, Autor a) throws GenericDAOException;
	void setConnection(Connection connection);
}
