package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DaoManga;
import DAO.MangaDao;
import model.Autor;
import model.Editora;
import model.Manga;

@WebServlet("/MangaController")
public class MangaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MangaController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		DaoManga dManga;
		HttpSession sessao = request.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dManga = new MangaDao();
			if("adicionar".equals(cmd)) {
				Manga m = new Manga();
				Autor a = new Autor();
				Editora e= new Editora();
				
				m.setTitulo(request.getParameter("titulo")); //pega o que o usuario digitou no campo titulo e seta no atributo titulo da model Manga
				m.setGenero(request.getParameter("genero"));
				a.setNome(request.getParameter("autor"));
				m.setAutor(a);
				e.setEditora(request.getParameter("editora"));
				m.setEditora(e);
				m.setVolume(Integer.parseInt(request.getParameter("volume")));
				m.setStatus(request.getParameter("status"));
				m.setLink(request.getParameter("link"));
				try {
					m.setDt_lancamento((new java.sql.Date(sdf.parse(request.getParameter("data")).getTime())));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					
					dManga.adicionar(m);
					msg = "Mangá cadastrado com sucesso!";
					
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				sessao.setAttribute("MENSAGEM", msg);
				response.sendRedirect("./cadastrarMangas");	
				
			} else if("pesquisar".equals(cmd)) {
				try {
					
					List<Manga> lista = dManga.pesquisarPorNome(request.getParameter("titulo")); // pega o que o usuario difitou no campo de busca pelo titulo e coloca numa lista de mangas
					sessao.setAttribute("MANGAS", lista); // coloca a lista na sessão para que a view tenha acesso a ela e possa exibir os dados da lista na tabela
					
				} catch(SQLException e2) {
					e2.printStackTrace();
				}
				
				response.sendRedirect("./listarMangas");
					
			} else if("remover".equals(cmd)) { 
				String id = request.getParameter("mangaid");
				try {
					
					dManga.remover(Integer.parseInt(id));
					List<Manga> lista = dManga.listarTodosMangas(); //depois de remover ele deve enviar a lista atual dos mangás, ou seja, o que foram excluídos não irão aparecer mais na lista
					sessao.setAttribute("MANGAS", lista);
					
				} catch(SQLException e3) {
					e3.printStackTrace();
				}
				
				response.sendRedirect("./listarMangas");
				
			} else if("alterar".equals(cmd)) {
				String id = request.getParameter("mangaid");
				Manga m = new Manga();
				Autor a = new Autor();
				Editora e = new Editora();
				
				m.setTitulo(request.getParameter("titulo"));
				m.setGenero(request.getParameter("genero"));
				a.setNome(request.getParameter("autor"));
				m.setAutor(a);
				e.setEditora(request.getParameter("editora"));
				m.setEditora(e);
				m.setVolume(Integer.parseInt(request.getParameter("volume")));
				m.setStatus(request.getParameter("status"));
				m.setLink(request.getParameter("link"));
				try {
					m.setDt_lancamento((new java.sql.Date(sdf.parse(request.getParameter("data")).getTime())));
				} catch (ParseException e2) {

					e2.printStackTrace();
				}
				try {
					dManga.alterar(Integer.parseInt(id), m);
					msg = "Mangá alterado com sucesso!";
				} catch(SQLException e4) {
					e4.printStackTrace();
				}
				
				sessao.setAttribute("MENSAGEM", msg);
				response.sendRedirect("alterarManga.jsp");
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
