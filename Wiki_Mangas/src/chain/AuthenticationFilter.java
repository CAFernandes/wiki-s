package chain;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;

/**
 * Servlet Filter implementation class PagesFilter
 */
@WebFilter({ "/alteracao.jsp", "/alterarAutor.jsp", "/alterarEditora.jsp", "/cadastroAutor.jsp",
	"/cadastroEditora.jsp", "/cadastroManga.jsp" })
public class AuthenticationFilter implements Filter {

   
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

    public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("Filtrando requisição " + req.getServletPath());
		HttpSession session = req.getSession();
		UserInfo userInfo = 
				(UserInfo)session.getAttribute("LOGADO"); 
		if ("/login.jsp".equals(req.getServletPath()) || "/index".equals(req.getServletPath()) || (userInfo != null && userInfo.isLogado())) {
			chain.doFilter(request, resp);		
		} else { 
			resp.sendRedirect("./login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
