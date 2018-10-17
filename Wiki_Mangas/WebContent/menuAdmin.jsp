<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserInfo" import="javax.servlet.http.HttpSession"%>
    
<%
	HttpSession sessao = request.getSession();
	UserInfo userInfo = (UserInfo)sessao.getAttribute("LOGADO"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Wiki Mang�s</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<nav id ="navegacao" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top nav-brand-logado">
	 	<div id="navbar" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top nav-brand-logado">
	  		<a class="navbar-brand" href="#">Wiki Mang�</a>
	  		<ul class="navbar-nav ml-auto">
	    		<li class="nav-item">
	      			<a class="nav-link" href="./cadastroManga.jsp">Mang�s</a>
	    		</li>
			    <li class="nav-item">
			    	<a class="nav-link" href="./cadastroAutor.jsp">Autor</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="./cadastroEditora.jsp">Editora</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="#">Lista de Mang�s</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="#">Lista de Autores</a>
			    </li>
			    <li class="nav-item">
					<a class="nav-link" href="#">Lista de Editoras</a>
			    </li>
			   	<li class="nav-item">
			       	<a class ="nav-link" href="./logoff">Usu�rio:<strong>Administrador</strong></a>
			   	</li>	
			</ul>
  		</div>
	</nav>
</body>
</html>