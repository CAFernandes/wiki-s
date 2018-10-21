package DAO.Editora;

import java.sql.SQLException;
import java.util.List;

import model.Editora;

public interface DaoEditora {
	void adicionar(Editora e) throws SQLException;
	List<Editora> pesquisarPorNome(String editora) throws SQLException;
	List<Editora> listarTodasEditoras() throws SQLException;
	void alterar(int id, Editora e) throws SQLException;

}
