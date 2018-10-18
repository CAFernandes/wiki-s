<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.User" import="javax.servlet.http.HttpSession"%>

<%
	HttpSession sessao = request.getSession();
	User userInfo = (User) sessao.getAttribute("LOGADO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="./style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
	
	<title>Wiki Mangás</title>
</head>

<body id="body-consultar" style="height: 1030px">
	<%
		if (userInfo != null && userInfo.isLogado()) {
	%>
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="menuVisitante.jsp"></jsp:include>
	<%
		}
	%>
	<div class="container-fluid" style="margin-top: 80px">	
		<h2> Lista de Editores </h2>
	</div>
	
	<form>
		<div class="form-group col-md-8 text-center input-group">
			<label for="nome">Editora</label>
			<div class="input-group-btn col-md-12 text-center">
				<input type="text" class="form-control" id="editora" name="editora"
					value="Pesquisar">
				<button type="submit" name="cmd" class="btn btn-primary btn-default"
					value="Pesquisar">Pesquisar</button>
			</div>
		</div>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Código</th>
					<th>Editora</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</tbody>
		</table>
	</form>

	
</body>
</html>