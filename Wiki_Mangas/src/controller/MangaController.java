package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GenericDAOException;
import DAO.MangaDao.DaoManga;
import DAO.MangaDao.MangaDao;
import model.Autor;
import model.Editora;
import model.Manga;

@WebServlet("/MangaController")
public class MangaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MangaController() {
        super();
    }
    
    /*No doGet para gerar uma lista de mangas e exibir na pág html*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DaoManga dManga;
		dManga = new MangaDao();
		listar(request, response, dManga);
    }
    
    /*No doPost recupero um identificador do front e determino qual a função deve ser executada*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoManga dManga;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int opc = (int) request.getSession().getAttribute("opc");//nesta linha estou recuperando o indetificador da função e o convertendo para inteiro pra o usar
		dManga = new MangaDao();//eu estabeleço uma Dao comum para as funções necessárias para o Mangá
		switch (opc) {//nesta linha estou fazendo a escolha da função que irá executar o que foi solicitado no front pelo indetificador
		case 1:
			cadastrar(request, response, dManga, sdf);
			break;
		case 2:
			consultar(request, response, dManga);
			break;
		case 3:
			alterar(request, response, dManga, sdf);
			break;
		default:
			remover(request, response, dManga);
			break;
		}
		
		
	}

	/*Esta função me executa o cadastro da editora*/
	private void cadastrar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga, SimpleDateFormat sdf) throws NumberFormatException, IOException {
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
		} catch(GenericDAOException e1) {
			e1.printStackTrace();
		}
		
		response.sendRedirect("./cadastrarMangas");
	}
	/*nesta função eu solicito alguma alteração no registro do mangas no banco*/
	private void alterar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga, SimpleDateFormat sdf) throws NumberFormatException, IOException {
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
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			dManga.alterar(Integer.parseInt(id), m);
		} catch(GenericDAOException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect("./consultaMangas.jsp");
	}
	
	/*Nesta funcação eu listo todoss os mangás sem filtro*/
	private void listar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws IOException {
		HttpSession sessao = request.getSession();
		try {
			
			List<Manga> lista = dManga.listarTodosMangas(); 
			sessao.setAttribute("MANGAS", lista); // coloca a lista na sessão para que a view tenha acesso a ela e possa exibir os dados da lista na tabela
			for (Manga m : lista) {
				m.getTitulo();
			}
		} catch(GenericDAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./consultaMangas.jsp");
	}
	
	/*Nesta função eu consulto o banco atravéz de um nome para criar uma lista de mangas que atenda os requisitos*/
	private void consultar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws IOException {
		HttpSession sessao = request.getSession();
		try {
			
			List<Manga> lista = dManga.pesquisarPorNome(request.getParameter("titulo")); // pega o que o usuario difitou no campo de busca pelo titulo e coloca numa lista de mangas
			if(lista.isEmpty()) {
				sessao.setAttribute("msg", "error");//Caso não encontre uma editora eu passo uma mensagem de erro
				listar(request, response, dManga);//e listo as editoras novamente sem busca por nome
			}else {
				sessao.setAttribute("MANGAS", lista); // coloca a lista na sessão para que a view tenha acesso a ela e possa exibir os dados da lista na tabela
				response.sendRedirect("./consultaAutores.jsp"); // redireciono para a tela de consulta
			}
		} catch(GenericDAOException e) {
			e.printStackTrace();
		}
		
	}
		
	/*Esta função ela remove algum registro de mangá do banco*/
	private void remover(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws NumberFormatException, IOException {
		HttpSession sessao = request.getSession();
		String id = request.getParameter("mangaid");
		try {
			dManga.remover(Integer.parseInt(id));
			List<Manga> lista = dManga.listarTodosMangas(); //depois de remover ele deve enviar a lista atual dos mangás, ou seja, o que foram excluídos não irão aparecer mais na lista
			sessao.setAttribute("MANGAS", lista);
		} catch(GenericDAOException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./consultaMangas.jsp");

	}
}
