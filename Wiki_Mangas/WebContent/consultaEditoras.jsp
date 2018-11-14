<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.User" import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List" import="model.Editora"%>
<%
	HttpSession sessao = request.getSession();
	sessao.setAttribute("opc", 2);
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

<body id="body-consultar">
	<% if (userInfo != null && userInfo.isLogado()) { %>
	<jsp:include page="menuAdmin.jsp"/>
	<% } else { %>
	<jsp:include page="menuVisitante.jsp"/>
	<% } %>
	<div class="container-fluid" style="margin-top: 80px">	
		<h2> Lista de Editores </h2>
	</div>
	<%if(sessao.getAttribute("msg") != null){ %>
	<div class="col-lg-12">
		<h3 class="alert alert-primary"><%=sessao.getAttribute("msg") %></h3>
	</div>
	<% sessao.removeAttribute("msg");
	} %>
	<form action="./EditoraController" method="POST">
		<div class="form-group col-md-8 text-center input-group">
			<div class="input-group-btn col-md-12 text-center">
				<input type="text" class="form-control" id="editora" name="editora" placeholder="Pesquisar por Nome">
				<button type="submit" name="cmd" class="btn btn-primary btn-default" value="Pesquisar">Pesquisar</button>
			</div>
		</div>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Código</th>
					<th>Editora</th>
					<%if (userInfo != null && userInfo.isLogado()) {%>
					<th>Ações</th>
					<% } %>	
				</tr>
			</thead>
			<tbody>
				<% if(sessao.getAttribute("EDITORAS") == null){ %>
					<jsp:include page="/EditoraController"/>
				<% }
				List<Editora> list = (List<Editora>) sessao.getAttribute("EDITORAS");
				for(Editora e : list){ %>
					<tr>
						<th><%=e.getId() %></th>
						<th><%=e.getEditora() %></th>
						<%if (userInfo != null && userInfo.isLogado()) {%>
						<th><a href="./alterarEditora.jsp?id=<%=e.getId() %>">Editar</a></th>
						<% } %>	
					</tr>
				<%} %>
			</tbody>
		</table>
	</form>
</body>
</html>