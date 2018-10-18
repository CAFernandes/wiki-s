package DAO.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.connection.GenericDao;
import model.Autor;

public class AutorDao implements DaoAutor{
	private Connection c;
	
	public AutorDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void adicionar(Autor a) throws SQLException {
		String sql = "INSERT INTO autor VALUES(?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getNome());
		ps.executeUpdate();
	}

	@Override
	public List<Autor> pesquisarPorNome(String nome) throws SQLException {
		String sql = "SELECT * FROM autor WHERE nome like ?";
		
		List<Autor> autores = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			autores.add(a);
		}
		
		return autores;
	}

	@Override
	public List<Autor> listarTodosAutores() throws SQLException {
		String sql = "SELECT * FROM autor";
		
		List<Autor> autores = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			autores.add(a);
		}
		return autores;
	}

	@Override
	public void alterar(int id, Autor a) throws SQLException {
		String sql = "UPDATE autor SET nome = ? WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getNome());
		ps.setInt(2, a.getId());
		ps.executeUpdate();
	}

}
