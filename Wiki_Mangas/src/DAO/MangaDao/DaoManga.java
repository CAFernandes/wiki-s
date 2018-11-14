package DAO.MangaDao;

import java.util.List;

import DAO.GenericDAOException;
import model.Manga;

public interface DaoManga {
	void adicionar(Manga m) throws GenericDAOException;
	List<Manga> pesquisarPorNome(String titulo) throws GenericDAOException;
	List<Manga> listarTodosMangas() throws GenericDAOException;
	void remover(int id) throws GenericDAOException;
	void alterar(Manga m) throws GenericDAOException;

}
