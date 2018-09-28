package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Autor;

public interface DaoAutor {
	void adicionar(Autor a) throws SQLException;
	List<Autor> pesquisarPorNome(String nome) throws SQLException;
	List<Autor> listarTodosAutores() throws SQLException;
	void alterar(int id, Autor a) throws SQLException;

}
