<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User" import="javax.servlet.http.HttpSession"%>
    
<%
    	HttpSession sessao = request.getSession();
    User userInfo = (User)sessao.getAttribute("LOGADO");
    %>
<!DOCTYPE html>
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

<body class="body-index" style="height:850px;">
	<jsp:include page="menuVisitante.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top:80px">
		<form class="form" method="post">
			<div>
				<label for="titulo">Título</label>
				<input type="text" id="titulo" name="titulo" value="pesquisar">
				<button type="submit" name="cmd" value="pesquisar">Pesquisar</button>
			</div>
		</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Título</th>
					<th>Gênero</th>
					<th>Autor</th>
					<th>Editora</th>
					<th>Volume(s)</th>
					<th>Data de Lançamento</th>
					<th>Status</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>