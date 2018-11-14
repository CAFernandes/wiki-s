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
import DAO.Editora.DaoEditora;
import DAO.Editora.EditoraDao;
import model.Editora;

@WebServlet("/EditoraController")
public class EditoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditoraController() {
		super();
	}

	/*
	 * nesta func��o eu crio um doGet para gerar uma lista de editoras e exibir na
	 * p�g html
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoEditora dEditora;
		dEditora = new EditoraDao();
		listar(request, response, dEditora);
	}

	/*
	 * Nesta fun��o eu recupero um identificador do front e determino qual a fun��o
	 * deve ser executada
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoEditora dEditora;
		int opc = (int) request.getSession().getAttribute("opc");// nesta linha estou recuperando o indetificador da
																	// fun��o e o convertendo para inteiro pra o usar
		/*
		 * Este � o padr�o de escolha 1 = Cadastro 2 = Consulta 3 = Alterar
		 */
		dEditora = new EditoraDao(); // eu estabele�o uma Dao comum para as fun��es necess�rias para a editora
		switch (opc) { // nesta linha estou fazendo a escolha da fun��o que ir� executar o que foi
						// solicitado no front pelo indetificador
		case 1:
			cadastrar(request, response, dEditora);
			break;
		case 2:
			consultar(request, response, dEditora);
			break;
		case 3:
			alterar(request, response, dEditora);
			break;
		default:
			break;
		}

	}

	/* Esta fun��o me executa o cadastro da editora */
	private void cadastrar(HttpServletRequest request, HttpServletResponse response, DaoEditora dEditora)
			throws IOException {
		HttpSession sessao = request.getSession();
		Editora e = new Editora();

		e.setEditora(request.getParameter("editora"));
		try {
			dEditora.adicionar(e);
			List<Editora> lista = dEditora.listarTodasEditoras();
			sessao.setAttribute("EDITORAS", lista);
		} catch (GenericDAOException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect("./consultaEditoras.jsp");
	}

	/*
	 * nesta fun��o eu solicito alguma altera��o no registro da editora no banco
	 * atrav�s
	 */
	private void alterar(HttpServletRequest request, HttpServletResponse response, DaoEditora dEditora)
			throws NumberFormatException, IOException {
		HttpSession sessao = request.getSession();

		Editora e = new Editora();

		e.setEditora(request.getParameter("editora"));
		e.setId(Integer.parseInt(request.getParameter("id")));
		try {
			dEditora.alterar(e);
			List<Editora> lista = dEditora.listarTodasEditoras();
			sessao.setAttribute("EDITORAS", lista);
		} catch (GenericDAOException e1) {
			e1.printStackTrace();
		}

		response.sendRedirect("./alterarEditora.jsp");
	}

	/* Esta fun��o eu listo todas editoras sem nem um filtro */
	private void listar(HttpServletRequest request, HttpServletResponse response, DaoEditora dEditora)
			throws IOException {
		HttpSession sessao = request.getSession();
		try {
			List<Editora> lista = dEditora.listarTodasEditoras();
			sessao.setAttribute("EDITORAS", lista);
		} catch (GenericDAOException e2) {
			e2.printStackTrace();
		}

		response.sendRedirect("./consultaEditoras.jsp");
	}

	/*
	 * Nesta fun��o eu consulto o banco atrav�z de um nome para criar uma lista de
	 * autores que atenda os requisitos
	 */
	private void consultar(HttpServletRequest request, HttpServletResponse response, DaoEditora dEditora)
			throws IOException {
		HttpSession sessao = request.getSession();
		try {
			List<Editora> lista = dEditora.pesquisarPorNome(request.getParameter("editora"));
			if (lista.isEmpty()) {
				sessao.setAttribute("msg", "error");// Caso n�o encontre uma editora eu passo uma mensagem de erro
				listar(request, response, dEditora);// e listo as editoras novamente sem busca por nome
			} else {
				sessao.setAttribute("EDITORAS", lista);
				response.sendRedirect("./consultaAutores.jsp");
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}

}
