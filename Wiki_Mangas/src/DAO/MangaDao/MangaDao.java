package DAO.MangaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.GenericDAOException;
import DAO.connection.GenericDao;
import model.Autor;
import model.Editora;
import model.Manga;

public class MangaDao implements DaoManga {
	private Connection c;

	public MangaDao() {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void adicionar(Manga m) throws GenericDAOException {
		String sql = "INSERT INTO manga "
				+ "(autor_id, editora_id, titulo, genero, volume, dt_lancamento, status, link) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, m.getAutor().getId());
			ps.setInt(2, m.getEditora().getId());
			ps.setString(3, m.getTitulo());
			ps.setString(4, m.getGenero());
			ps.setInt(5, m.getVolume());
			ps.setDate(6, m.getDt_lancamento());
			ps.setString(7, m.getStatus());
			ps.setString(8, m.getLink());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Manga> pesquisarPorNome(String titulo) throws GenericDAOException {
		String sql = "SELECT a.nome AS autor, e.editora, m.id, m.autor_id, m.editora_id, m.titulo, m.genero,"
				+ "m.volume, m.dt_lancamento AS data_publicacao, m.status, m.link FROM manga m "
				+ "INNER JOIN autor a  ON a.id = m.autor_id "
				+ "INNER JOIN editora e ON e.codigo = m.editora_id WHERE titulo like ?"; // tem que ter um inner join
																							// aqui

		List<Manga> mangas = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + titulo + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Manga m = new Manga();
				Autor a = new Autor();
				Editora e = new Editora();
				m.setId(rs.getInt("id"));
				a.setId(rs.getInt("autor_id"));
				a.setNome(rs.getString("autor"));
				m.setAutor(a);
				e.setId(rs.getInt("editora_id"));
				e.setEditora(rs.getString("editora"));
				m.setEditora(e);
				m.setTitulo(rs.getString("titulo"));
				m.setGenero(rs.getString("genero"));
				m.setVolume(rs.getInt("volume"));
				m.setDt_lancamento(rs.getDate("dt_lancamento"));
				m.setStatus(rs.getString("status"));
				m.setLink(rs.getString("link"));
				mangas.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mangas;
	}

	@Override
	public List<Manga> listarTodosMangas() throws GenericDAOException {
		String sql = "SELECT a.nome AS autor, e.editora, m.id, m.autor_id, m.editora_id, m.titulo, m.genero,"
				+ "m.volume, m.dt_lancamento AS data_publicacao, m.status, m.link FROM manga m "
				+ "INNER JOIN autor a  ON a.id = m.autor_id " + "INNER JOIN editora e ON e.codigo = m.editora_id"; // tem
																													// que
																													// fazer
																													// um
																													// inner
																													// join
																													// aqui

		List<Manga> mangas = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Manga m = new Manga();
				Autor a = new Autor();
				Editora e = new Editora();
				m.setId(rs.getInt("id"));
				a.setId(rs.getInt("autor_id"));
				a.setNome(rs.getString("autor"));
				m.setAutor(a);
				e.setId(rs.getInt("editora_id"));
				e.setEditora(rs.getString("editora"));
				m.setEditora(e);
				m.setTitulo(rs.getString("titulo"));
				m.setGenero(rs.getString("genero"));
				m.setVolume(rs.getInt("volume"));
				m.setDt_lancamento(rs.getDate("data_publicacao"));
				m.setStatus(rs.getString("status"));
				m.setLink(rs.getString("link"));
				mangas.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mangas;
	}

	@Override
	public void remover(int id) throws GenericDAOException {
		String sql = "DELETE FROM manga WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(int id, Manga m) throws GenericDAOException {
		String sql = "UPDATE manga " + "SET autor_id = ?, editora_id = ?, titulo = ?, genero = ?, volume = ?, "
				+ "dt_lancamento = ?, status = ?, link = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, m.getId());
			ps.setInt(2, m.getAutor().getId());
			ps.setInt(3, m.getEditora().getId());
			ps.setString(4, m.getTitulo());
			ps.setString(5, m.getGenero());
			ps.setInt(6, m.getVolume());
			ps.setDate(7, m.getDt_lancamento());
			ps.setString(8, m.getStatus());
			ps.setString(9, m.getLink());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
