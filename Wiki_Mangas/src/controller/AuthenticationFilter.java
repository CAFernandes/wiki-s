package controller;

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

import model.User;

@WebFilter({"/index.jsp", "/alteracao.jsp"})
public class AuthenticationFilter implements Filter {

   
    public AuthenticationFilter() {
    }

    public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("LOGADO"); 
		if ("/login.jsp".equals(req.getServletPath()) || (user != null && user.isLogado())) {
			chain.doFilter(request, resp);		
		} else { 
			resp.sendRedirect("./login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
