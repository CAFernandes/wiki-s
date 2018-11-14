package DAO.Autor;

import java.util.List;

import DAO.GenericDAOException;
import model.Autor;

public interface DaoAutor {
	void adicionar(Autor a) throws GenericDAOException;
	List<Autor> pesquisarPorNome(String nome) throws GenericDAOException;
	List<Autor> listarTodosAutores() throws GenericDAOException;
	void alterar(Autor a) throws GenericDAOException;

}
