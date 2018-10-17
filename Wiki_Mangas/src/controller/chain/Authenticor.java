package controller.chain;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO.user.UserDao;
import model.UserInfo;

@WebServlet("/login")
public class Authenticor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Authenticor() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		UserInfo userInfo = new UserInfo(request.getParameter("inputLogin"), request.getParameter("inputSenha"));
		try {
			userInfo = new UserDao().aunteticar(userInfo);
			if(userInfo.isLogado()) {
				sessao.setAttribute("LOGADO", userInfo);
				response.sendRedirect("./index.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao logar");
				response.sendRedirect("./login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

}
