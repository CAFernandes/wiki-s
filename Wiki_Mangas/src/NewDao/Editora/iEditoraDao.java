package NewDao.Editora;

import java.sql.Connection;
import java.util.List;

import NewDao.GenericDAOException;
import model.Editora;

public interface iEditoraDao {
	void adicionar(Editora e) throws GenericDAOException;
	List<Editora> pesquisarPorNome(String editora) throws GenericDAOException;
	List<Editora> listarTodasEditoras() throws GenericDAOException;
	void alterar(int id, Editora e) throws GenericDAOException;
	void setConnection (Connection connection);
}
