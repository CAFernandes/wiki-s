package NewDao.Editora;

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
import model.Editora;

public class EditoraDao implements iEditoraDao {

	private Connection c;
	private EntityManagerFactory emf;

	public EditoraDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
		emf = Persistence.createEntityManagerFactory("wiki_manga");
	}
	
	@Override
	public void adicionar(Editora e) throws GenericDAOException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Editora> pesquisarPorNome(String editora) throws GenericDAOException {
		String sql = "SELECT * FROM manga WHERE titulo like ?";
		List<Editora> editoras = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + editora + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Editora e = new Editora();
				e.setId(rs.getInt("id"));
				e.setEditora(rs.getString("editora"));
				editoras.add(e);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return editoras;
	}

	@Override
	public List<Editora> listarTodasEditoras() throws GenericDAOException {
		String sql = "SELECT * FROM autor";
		List<Editora> editoras = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Editora e = new Editora();
				e.setId(rs.getInt("id"));
				e.setEditora(rs.getString("editora"));
				editoras.add(e);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return editoras;
	}

	@Override
	public void alterar(int id, Editora e) throws GenericDAOException {
		String sql = "UPDATE autor SET nome = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getEditora());
			ps.setInt(2, e.getId());
			ps.executeUpdate();
		} catch (SQLException err) {
			throw new GenericDAOException( err );
		}		
	}

	@Override
	public void setConnection(Connection connection) {
		this.c = connection;		
	}

}
