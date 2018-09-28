package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AutorDao;
import DAO.DaoAutor;
import model.Autor;

@WebServlet("/AutorController")
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AutorController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		DaoAutor dAutor;
		HttpSession sessao = request.getSession();
		try {
			dAutor = new AutorDao();
			if("adicionar".equals(cmd)) {
				Autor a = new Autor();
				
				a.setNome(request.getParameter("nome"));
				
				try {
					dAutor.adicionar(a);
					msg = "Autor cadastrado com sucesso";
				} catch(SQLException e) {
					e.printStackTrace();
				}	
				
				sessao.setAttribute("MENSAGEM", msg);
				response.sendRedirect("cadastrarAutor.jsp");
				
			} else if("pesquisar".equals(cmd)) {
				try {
					List<Autor> lista = dAutor.pesquisarPorNome(request.getParameter("nome"));
					sessao.setAttribute("AUTORES", lista);
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				response.sendRedirect("./listarAutor");
				
			}else if("alterar".equals(cmd)) {
				String id = request.getParameter("autorid");
				Autor a = new Autor();
				
				a.setNome(request.getParameter("nome"));
				
				try {
					dAutor.alterar(Integer.parseInt(id), a);
					msg = "Autor alterado com sucesso!";
				} catch(SQLException e2) {
					e2.printStackTrace();
				}
				
				sessao.setAttribute("MENSAGEM", msg);
				response.sendRedirect("./alterar.jsp");
			}
				
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
