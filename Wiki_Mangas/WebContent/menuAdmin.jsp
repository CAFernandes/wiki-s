<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserInfo" import="javax.servlet.http.HttpSession"%>
    
<%
	HttpSession sessao = request.getSession();
	UserInfo userInfo = (UserInfo)sessao.getAttribute("LOGADO"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Wiki_Mangá</title>
  
  <meta charset="utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  
</head>

<body id ="body" style="height:850px">
	<nav id ="navegacao" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top nav-brand-logado">
	 	<div id="navbar" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top nav-brand-logado">
	  		<a class="navbar-brand" href="#">Wiki Mangá</a>
	  		<ul class="navbar-nav ml-auto">
	    		<li class="nav-item">
	      			<a class="nav-link" href="./cadastroManga.jsp">Mangás</a>
	    		</li>
			    <li class="nav-item">
			    	<a class="nav-link" href="./cadastroAutor.jsp">Autor</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="./cadastroEditora.jsp">Editora</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="#">Lista de Mangás</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="#">Lista de Autores</a>
			    </li>
			    <li class="nav-item">
					<a class="nav-link" href="#">Lista de Editoras</a>
			    </li>
			   	<li class="nav-item">
			       	<a class ="nav-link" href="./logoff">Usuário:<strong>Administrador</strong></a>
			   	</li>	
			</ul>
  		</div>
	</nav>
	
	<style>
		#navegacao{
		 	font-family:cursive, monospace, sans-serif;
		}
		.h3{
			color: white;
		}
	</style>


</body>
</html>