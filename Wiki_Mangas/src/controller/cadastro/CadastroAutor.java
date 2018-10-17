package controller.cadastro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Autor.AutorDao;
import model.Autor;

@WebServlet("/CadastroAutor")
public class CadastroAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroAutor() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Autor a = new Autor(request.getParameter("nome"));
		try {
			new AutorDao().adicionar(a);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
