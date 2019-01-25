package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GenericDAOException;
import DAO.Autor.AutorDao;
import DAO.Editora.EditoraDao;
import DAO.MangaDao.DaoManga;
import DAO.MangaDao.MangaDao;
import model.Autor;
import model.Editora;
import model.Manga;

@WebServlet("/MangaController")
public class MangaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
    public MangaController() {
        super();
    }
    
    /*No doGet para gerar uma lista de mangas e exibir na pág html*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DaoManga dManga;
		dManga = new MangaDao();
		int opc = (int) request.getSession().getAttribute("opc");
		switch(opc) {
			case 2:
				listar(request, response, dManga);
				break;
			default:
				listAutEdi(request, response);
				break;
			
		}
    }
    
    /*No doPost recupero um identificador do front e determino qual a função deve ser executada*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoManga dManga;
		int opc = (int) request.getSession().getAttribute("opc");//nesta linha estou recuperando o indetificador da função e o convertendo para inteiro pra o usar
		dManga = new MangaDao();//eu estabeleço uma Dao comum para as funções necessárias para o Mangá
		switch (opc) {//nesta linha estou fazendo a escolha da função que irá executar o que foi solicitado no front pelo indetificador
		case 1:
			cadastrar(request, response, dManga);
			break;
		case 2:
			consultar(request, response, dManga);
			break;
		case 3:
			alterar(request, response, dManga);
			break;
		default:
			remover(request, response, dManga);
			break;
		}
		
		
	}

	/*Esta função me executa o cadastro da editora*/
	private void cadastrar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws NumberFormatException, IOException {
		Manga m = new Manga();
		Autor a = new Autor();
		Editora e= new Editora();
		
		m.setTitulo(request.getParameter("titulo")); //pega o que o usuario digitou no campo titulo e seta no atributo titulo da model Manga
		m.setGenero(request.getParameter("genero"));
		a.setId(Integer.parseInt(request.getParameter("autor")));
		m.setAutor(a);
		e.setId(Integer.parseInt(request.getParameter("editora")));
		m.setEditora(e);
		m.setVolume(Integer.parseInt(request.getParameter("volume")));
		m.setStatus(request.getParameter("status"));
		m.setLink(request.getParameter("link"));
		
		try {
			Date d = sdf.parse(request.getParameter("data"));
			m.setDt_lancamento(d);
			dManga.adicionar(m);
		} catch(GenericDAOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listar(request, response, dManga);
	}
	/*nesta função eu solicito alguma alteração no registro do mangas no banco*/
	private void alterar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws NumberFormatException, IOException {
		Manga m = new Manga();
		Autor a = new Autor();
		Editora e = new Editora();
		
		m.setId(Integer.parseInt(request.getParameter("id")));
		m.setTitulo(request.getParameter("titulo"));
		m.setGenero(request.getParameter("genero"));
		a.setId(Integer.parseInt(request.getParameter("autor")));
		m.setAutor(a);
		e.setId(Integer.parseInt(request.getParameter("editora")));
		m.setEditora(e);
		m.setVolume(Integer.parseInt(request.getParameter("volume")));
		m.setStatus(request.getParameter("status"));
		m.setLink(request.getParameter("link"));
		try {
			Date d = sdf.parse(request.getParameter("data"));
			m.setDt_lancamento(d);
			
			dManga.alterar(m);
		} catch (GenericDAOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		listar(request, response, dManga);
	}
	
	/*Nesta funcação eu listo todoss os mangás sem filtro*/
	private void listar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws IOException {
		HttpSession sessao = request.getSession();
		try {
			
			List<Manga> lista = dManga.listarTodosMangas(); 
			sessao.setAttribute("MANGAS", lista); // coloca a lista na sessão para que a view tenha acesso a ela e possa exibir os dados da lista na tabela

		} catch(GenericDAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./consultaMangas.jsp");
	}
	
	/*Nesta função eu consulto o banco atravéz de um nome para criar uma lista de mangas que atenda os requisitos*/
	private void consultar(HttpServletRequest request, HttpServletResponse response, DaoManga dManga) throws IOException {
		HttpSession sessao = request.getSession();
		try {
			System.out.println(request.getParameter("titulo"));
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
	private void listAutEdi(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sessao = request.getSession();
		try {
			List<Autor> lista = new AutorDao().listarTodosAutores();
			/* coloca a lista na sessão para que a view tenha acesso 
			*  a ela e possa exibir os dados da lista na tabela
			*/
			sessao.setAttribute("AUTORES", lista); 
			List<Editora> list = new EditoraDao().listarTodasEditoras();
			sessao.setAttribute("EDITORAS", list); // coloca a lista na sessão para que a view tenha acesso a ela e possa exibir os dados da lista na tabela
		} catch(GenericDAOException e) {
			e.printStackTrace();
		}
		
	}
}
