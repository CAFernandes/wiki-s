package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GenericDAOException;
import DAO.User.UserDao;
import model.User;

@WebServlet("/login")
public class Authenticor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Authenticor() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();// identifica a sessao que o usuário está acessado
		User user = new User(request.getParameter("user"), request.getParameter("senha"));
		try {
			user = new UserDao().autenticar(user);
			if(user.isLogado()) {
				sessao.setAttribute("LOGADO", user);
				response.sendRedirect("./index.jsp");;
			}
		} catch (GenericDAOException e) {
			System.err.println(e);
		}
	}

}
