package controller.chain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;

@WebServlet(name = "logoff", urlPatterns = { "/logoff" })
public class logoff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logoff() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserInfo uInfo = (UserInfo) session.getAttribute("LOGADO");
		uInfo.setLogado(false);
		session.setAttribute("LOGADO", uInfo);
		response.sendRedirect("./index.jsp");
	}

}
