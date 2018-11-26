<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.text.SimpleDateFormat, model.Manga, model.User, javax.servlet.http.HttpSession"%>

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
	<% if (userInfo != null && userInfo.isLogado()) {%>
		<jsp:include page="menuAdmin.jsp"/>
	<%} else { %>
		<jsp:include page="menuVisitante.jsp"/>
	<% } %>
	
	<div class="container-fluid" style="margin-top: 80px">
		<h2>Lista de Mangás</h2>
	</div>
	<%if(sessao.getAttribute("msg") != null && sessao.getAttribute("msg").equals("error")){ %>
	<div class="col-lg-12 alert">
		<h3 class="alert alert-primary">Não foi localizado manga(s)</h3>
	</div>
	<% sessao.removeAttribute("msg");
	} %>
	<form action = "./MangaController" method="get">
		<div class="form-group col-md-8 text-center input-group">
			<div class="input-group-btn col-md-12 text-center">
				<input type="text" class="form-control" id="titulo" name="titulo"
					placeholder="Pesquisar por Nome">
				<button type="submit" name="cmd" class="btn btn-primary btn-default"
					value="Pesquisar">Pesquisar</button>
			</div>
		</div>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Título</th>
					<th>Gênero</th>
					<th>Autor</th>
					<th>Editora</th>
					<th>Volume(s)</th>
					<th>Data de Lançamento</th>
					<th>Status</th>
					<th>Link</th>
					<%if (userInfo != null && userInfo.isLogado()) {%>
					<th>Ações</th>
					<% } %>	
				</tr>
			</thead>
			<% if(sessao.getAttribute("MANGAS") == null){ %>	
				<jsp:include page="/MangaController"/>			
			<% }
			List<Manga> list = (List<Manga>) sessao.getAttribute("MANGAS");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(list != null && list.size() > 0){ %>
			<tbody>
				<%for(Manga m : list) {
				%>
					<tr>
						<td><%= m.getId() %>
						<td><%= m.getTitulo() %></td>
						<td><%= m.getGenero() %></td>
						<td><%= m.getAutor().getNome() %></td>
						<td><%= m.getEditora().getEditora() %></td>
						<td><%= m.getVolume() %></td>
						<td><%= sdf.format(m.getDt_lancamento())%></td>
						<td><%= m.getStatus() %></td>
						<td><a href="<%= m.getLink() %>">Acesse Aqui</a></td>
						<%if (userInfo != null && userInfo.isLogado()) { %>
						<td><a href="./alterarMangas.jsp?id=<%=m.getId()%>">Editar</a></td>
						<% } %>
					</tr>
				<% } %>
			</tbody>
		</table>
		<% } %>
	</form>
</body>
</html>