package DAO.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.GenericDAOException;
import DAO.connection.GenericDao;
import model.Autor;

public class AutorDao implements DaoAutor {
	private Connection c;

	public AutorDao() {
		GenericDao gDao = new GenericDao();
		try {
			c = gDao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adicionar(Autor a) throws GenericDAOException {
		String sql = "INSERT INTO autor(nome) VALUES(?);";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Autor> pesquisarPorNome(String nome) throws GenericDAOException {
		String sql = "SELECT * FROM `autor`  WHERE nome like ?";

		List<Autor> autores = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Autor a = new Autor();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				autores.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return autores;
	}

	@Override
	public List<Autor> listarTodosAutores() throws GenericDAOException {
		String sql = "SELECT * FROM `autor`";

		List<Autor> autores = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Autor a = new Autor();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				autores.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autores;
	}

	@Override
	public void alterar(Autor a) throws GenericDAOException {
		String sql = "UPDATE `autor` SET `nome`= ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
