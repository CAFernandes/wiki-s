package NewDao.Autor;

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

public class AutorDao implements iAutorDao {
	
	private Connection c;
	private EntityManagerFactory emf;

	public AutorDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
		emf = Persistence.createEntityManagerFactory("wiki_manga");
	}

	@Override
	public void adicionar(Autor a) throws GenericDAOException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Autor> pesquisarPorNome(String nome) throws GenericDAOException {
		String sql = "SELECT * FROM manga WHERE titulo like ?";
		List<Autor> autores = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Autor a = new Autor();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				autores.add(a);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return autores;
	}

	@Override
	public List<Autor> listarTodosAutores() throws GenericDAOException {
		String sql = "SELECT * FROM autor";
		List<Autor> autores = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Autor a = new Autor();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				autores.add(a);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return autores;
	}

	@Override
	public void alterar(int id, Autor a) throws GenericDAOException {
		String sql = "UPDATE autor SET nome = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getId());
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
