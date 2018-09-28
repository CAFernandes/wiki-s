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

import DAO.DaoEditora;
import DAO.EditoraDao;
import model.Editora;

@WebServlet("/EditoraController")
public class EditoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditoraController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		DaoEditora dEditora;
		HttpSession sessao = request.getSession();
		try {
			dEditora = new EditoraDao();
			if("adicionar".equals(cmd)) {
				Editora e = new Editora();
				
				e.setEditora(request.getParameter("editora"));
				
				try {
					dEditora.adicionar(e);
					List<Editora> lista = dEditora.listarTodasEditoras();
					sessao.setAttribute("EDITORAS", lista);
					msg = "Editora cadastrada com sucesso !";
				} catch(SQLException e1) {
					e1.printStackTrace();
				}	
				
				sessao.setAttribute("MENSAGEM", msg);
				response.sendRedirect("./cadastrarEditora.jsp");
				
			} else if("pesquisar".equals(cmd)) {
				try {
					List<Editora> lista = dEditora.pesquisarPorNome(request.getParameter("editora"));
					sessao.setAttribute("EDITORAS", lista);
				} catch(SQLException e2) {
					e2.printStackTrace();
				}
				
				response.sendRedirect("./listarEditora");
				
				
			} else if("alterar".equals(cmd)) {
				String id = request.getParameter("editoraid");
				
				Editora e = new Editora();
				
				e.setEditora(request.getParameter("editora"));
				
				try {
					dEditora.alterar(Integer.parseInt(id), e);
					List<Editora> lista = dEditora.listarTodasEditoras();
					sessao.setAttribute("EDITORAS", lista);
					msg = "Editora cadastrada com suceso";
				} catch(SQLException e3) {
					e3.printStackTrace();
				}
				
				sessao.setAttribute("MENSAGEM", msg);
				response.sendRedirect("./alterarEditora.jsp");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
	}

}
