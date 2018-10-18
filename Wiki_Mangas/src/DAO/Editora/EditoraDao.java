package DAO.Editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.connection.GenericDao;
import model.Editora;

public class EditoraDao implements DaoEditora{
	private Connection c;
	
	public EditoraDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void adicionar(Editora e) throws SQLException {
		String sql = "INSERT INTO editora VALUES (?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, e.getEditora());
		ps.executeUpdate();
		
	}

	@Override
	public List<Editora> pesquisarPorNome(String editora) throws SQLException {
		String sql = "SELECT * FROM editora WHERE  editora like ?";
		
		List<Editora> editoras = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + editora + "%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Editora e = new Editora();
			e.setId(rs.getInt("id"));
			e.setEditora(rs.getString("editora"));
			editoras.add(e);
		}
	
		return editoras;
	}

	@Override
	public List<Editora> listarTodasEditoras() throws SQLException {
		String sql = "SELECT * FROM editora";
		
		List<Editora> editoras = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Editora e = new Editora();
			e.setId(rs.getInt("id"));
			e.setEditora(rs.getString("editora"));
			editoras.add(e);
		}
		
		return editoras;
	}

	@Override
	public void alterar(int id, Editora e) throws SQLException {
		String sql = "UPDATE editora SET editora = ? WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, e.getId());
		ps.setString(2, e.getEditora());
		ps.executeUpdate();
	}

}
