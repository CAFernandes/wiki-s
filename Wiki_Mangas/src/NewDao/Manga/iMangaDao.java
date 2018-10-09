package NewDao.Manga;

import java.sql.Connection;
import java.util.List;

import NewDao.GenericDAOException;
import model.Manga;

public interface iMangaDao {
	void adicionar(Manga m) throws GenericDAOException;
	List<Manga> pesquisarPorNome(String titulo) throws GenericDAOException;
	List<Manga> listarTodosMangas() throws GenericDAOException;
	void remover(int id) throws GenericDAOException;
	void alterar(int id, Manga m) throws GenericDAOException;
	void setConnection(Connection connection);
}
