package DAO.Editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.GenericDAOException;
import DAO.connection.GenericDao;
import model.Editora;

public class EditoraDao implements DaoEditora {
	private Connection c;

	public EditoraDao() {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void adicionar(Editora e) throws GenericDAOException {
		String sql = "INSERT INTO editora VALUES (?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getEditora());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Editora> pesquisarPorNome(String editora) throws GenericDAOException {
		String sql = "SELECT * FROM editora WHERE  editora like ?";

		List<Editora> editoras = new ArrayList<>();
		if(editora.equals("") || editora.isEmpty()) {
			return editoras;
		}else {
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, "%" + editora + "%");
				ResultSet rs = ps.executeQuery();
	
				while (rs.next()) {
					Editora e = new Editora();
					e.setId(rs.getInt("codigo"));
					e.setEditora(rs.getString("editora"));
					editoras.add(e);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return editoras;
		}
	}

	@Override
	public List<Editora> listarTodasEditoras() throws GenericDAOException {
		String sql = "SELECT * FROM editora";

		List<Editora> editoras = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Editora e = new Editora();
				e.setId(rs.getInt("codigo"));
				e.setEditora(rs.getString("editora"));
				editoras.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return editoras;
	}

	@Override
	public void alterar(Editora e) throws GenericDAOException {
		String sql = "UPDATE editora SET editora = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getEditora());
			ps.setInt(2, e.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
