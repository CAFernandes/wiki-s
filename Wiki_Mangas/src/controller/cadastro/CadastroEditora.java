package controller.cadastro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Editora.EditoraDao;
import model.Editora;

@WebServlet("/CadastroEditora")
public class CadastroEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroEditora() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Editora e = new Editora(request.getParameter("inputNome"));
    	try {
			new EditoraDao().adicionar(e);;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
    	
    }

}
