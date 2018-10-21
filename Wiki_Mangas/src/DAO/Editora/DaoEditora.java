package DAO.Editora;

import java.util.List;

import DAO.GenericDAOException;
import model.Editora;

public interface DaoEditora {
	void adicionar(Editora e) throws GenericDAOException;
	List<Editora> pesquisarPorNome(String editora) throws GenericDAOException;
	List<Editora> listarTodasEditoras() throws GenericDAOException;
	void alterar(int id, Editora e) throws GenericDAOException;

}
