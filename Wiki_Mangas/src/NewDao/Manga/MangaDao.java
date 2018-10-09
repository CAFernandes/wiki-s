package NewDao.Manga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import NewDao.GenericDAOException;
import NewDao.connection.GenericDao;
import NewDao.connection.iGenericDao;
import model.Autor;
import model.Editora;
import model.Manga;

public class MangaDao implements iMangaDao {
	
	private Connection c;
	private EntityManagerFactory emf;

	public MangaDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
		emf = Persistence.createEntityManagerFactory("wiki_manga");
	}

	@Override
	public void adicionar(Manga m) throws GenericDAOException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Manga> pesquisarPorNome(String titulo) throws GenericDAOException {
		String sql = "SELECT * FROM manga WHERE titulo like ?";
		List<Manga> mangas = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + titulo + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Manga m = new Manga();
				Autor a = new Autor();
				Editora e = new Editora();
				m.setId(rs.getInt("id"));
				a.setId(rs.getInt("autor_id"));
				a.setNome(rs.getString("editora_id"));
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
			throw new GenericDAOException( e );
		}
		return mangas;
	}

	@Override
	public List<Manga> listarTodosMangas() throws GenericDAOException {
		String sql = "SELECT * FROM manga";
		List<Manga> mangas = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Manga m = new Manga();
				Autor a = new Autor();
				Editora e = new Editora();
				m.setId(rs.getInt("id"));
				a.setId(rs.getInt("autor_id"));
				a.setNome(rs.getString("nome"));
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
			throw new GenericDAOException( e );
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
			throw new GenericDAOException( e );
		}
	}

	@Override
	public void alterar(int id, Manga m) throws GenericDAOException {
		String sql = "UPDATE manga "
				+ "SET autor_id = ?, editora_id = ?, titulo = ?, genero = ?, volume = ?, "
				+ "dt_lancamento = ?, status = ?, link = ? WHERE id = ?";

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
			ps.setInt(9, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}		
	}

	@Override
	public void setConnection(Connection connection) {
		this.c = connection;
	}

}
