<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Wiki Mangás</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="./style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  
</head>

<body id ="body-index" style="height:850px">
	<nav id ="navegacao" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top nav-brand-logado">
	 	<div id="navbar" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top nav-brand-logado">
	  		<a class="navbar-brand" href="#">Wiki Mangá</a>
	  		<ul class="navbar-nav ml-auto">
	    	    <li class="nav-item">
			    	<a class="nav-link" href="./consulta.jsp">Lista de Mangás</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" href="#">Lista de Autores</a>
			    </li>
			    <li class="nav-item">
					<a class="nav-link" href="#">Lista de Editoras</a>
			    </li>
				<li class="nav-item">
			       	 <a class ="nav-link" href="./login.jsp">Usuário:<strong>Visitante</strong></a>
				</li>
			</ul>
  		</div>
	</nav>

</body>
</html>