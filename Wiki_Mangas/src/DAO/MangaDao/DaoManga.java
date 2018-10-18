package DAO.MangaDao;

import java.sql.SQLException;
import java.util.List;

import model.Manga;

public interface DaoManga {
	void adicionar(Manga m) throws SQLException;
	List<Manga> pesquisarPorNome(String titulo) throws SQLException;
	List<Manga> listarTodosMangas() throws SQLException;
	void remover(int id) throws SQLException;
	void alterar(int id, Manga m) throws SQLException;

}
