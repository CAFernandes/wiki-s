package controller.cadastro;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MangaDao.MangaDao;
import model.Autor;
import model.Editora;
import model.Manga;

@WebServlet("/CadastroMangas")
public class CadastroMangas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroMangas() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//crio os objetos para adicionar no banco
		Autor a = new Autor(request.getParameter("inputAutor"));
		Editora e = new Editora(request.getParameter("inputEditora"));
		Manga m = new Manga();
		m.setTitulo(request.getParameter("inputTitulo"));
		m.setGenero(request.getParameter("inputGenero"));
		m.setAutor(a);
		m.setEditora(e);	
		m.setVolume(Integer.parseInt(request.getParameter("inputVolume")));
		m.setDt_lancamento(Date.valueOf(request.getParameter("inputlancamento")));
		m.setLink(request.getParameter("inputlink"));
		//entro no banco para adicionar 
		try {
			new MangaDao().adicionar(m);;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

}
