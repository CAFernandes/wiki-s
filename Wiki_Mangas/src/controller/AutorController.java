package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GenericDAOException;
import DAO.Autor.AutorDao;
import DAO.Autor.DaoAutor;
import model.Autor;

@WebServlet("/AutorController")
public class AutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutorController() {
		super();
	}

	/*
	 * nesta funcção eu crio um doGet para gerar uma lista de autores e exibir na
	 * pág html
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoAutor dAutor;
		dAutor = new AutorDao();
		listar(request, response, dAutor);

	}

	/*
	 * Nesta função eu recupero um identificador do front e determino qual a função
	 * deve ser executada
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoAutor dAutor;
		int opc = (int) request.getSession().getAttribute("opc"); // nesta linha estou recuperando o indetificador da
																	// função e o convertendo para inteiro pra o usar
		/*
		 * 1 = Cadastro 2 = Consulta 3 = Alterar
		 */
		dAutor = new AutorDao(); // eu estabeleço uma Dao comum para as funções necessárias para o autor
		switch (opc) { // nesta linha estou fazendo a escolha da função que irá executar o que foi
						// solicitado no front pelo indetificador
		case 1:
			cadastrar(request, response, dAutor);
			break;
		case 2:
			consultar(request, response, dAutor);
			break;
		case 3:
			alterar(request, response, dAutor);
			break;
		default:
			break;
		}

	}

	/* Esta função me executa o cadastro do autor */
	private void cadastrar(HttpServletRequest request, HttpServletResponse response, DaoAutor dAutor)
			throws IOException {
		String msg = null;
		HttpSession sessao = request.getSession();
		Autor a = new Autor();
		a.setNome(request.getParameter("nome"));
		try {
			dAutor.adicionar(a);
			msg = "Autor cadastrado com sucesso";
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		sessao.setAttribute("MENSAGEM", msg);
	}

	/*
	 * nesta função eu solicito alguma alteração registro de autor no banco através
	 */
	private void alterar(HttpServletRequest request, HttpServletResponse response, DaoAutor dAutor) throws IOException {
		String msg = null;
		HttpSession sessao = request.getSession();
		String id = request.getParameter("id");
		Autor a = new Autor();

		a.setNome(request.getParameter("nome"));

		try {
			dAutor.alterar(Integer.parseInt(id), a);
			msg = "Autor alterado com sucesso!";
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}

		sessao.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./consultaAutores.jsp");
	}

	/* Esta função eu listo todos autores sem nem um filtro */
	private void listar(HttpServletRequest request, HttpServletResponse response, DaoAutor dAutor) throws IOException {
		HttpSession sessao = request.getSession();
		try {
			List<Autor> lista = dAutor.listarTodosAutores();
			sessao.setAttribute("AUTORES", lista);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}

		response.sendRedirect("./consultaAutores.jsp");
	}

	/*
	 * Nesta função eu consulto o banco atravéz de um nome para criar uma lista de
	 * autores que atenda os requisitos
	 */
	private void consultar(HttpServletRequest request, HttpServletResponse response, DaoAutor dAutor)
			throws IOException {
		HttpSession sessao = request.getSession();
		try {
			List<Autor> lista = dAutor.pesquisarPorNome(request.getParameter("nome"));
			if (lista.isEmpty()) {
				sessao.setAttribute("msg", "Não foi localizado nenhum autor");// Caso não encontre um autor eu passo uma
																				// mensagem de erro
				listar(request, response, dAutor);// e listo os autores novamente sem busca por nome
			} else {
				sessao.setAttribute("AUTORES", lista);
				response.sendRedirect("./consultaAutores.jsp");
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}

}
