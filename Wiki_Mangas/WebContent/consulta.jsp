<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Manga" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wiki Mangás</title>
</head>
<body>
	<%List<Manga> mangas = (List<Manga>) session.getAttribute("MANGAS"); %>

	<form action = "./MangaController" method="post">
		<div>
			<label for="titulo">Título</label>
			<input type="text" id="titulo" name="titulo" value="pesquisar">
			<button type="submit" name="cmd" value="pesquisar">Pesquisar</button>
		</div>
	</form>
	
	<%if(mangas != null && mangas.size() > 0){ %>
		<table>
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
			<%for(Manga m : mangas) {%>
			<tr>
				<td><%= m.getTitulo() %></td>
				<td><%= m.getGenero() %></td>
				<td><%= m.getAutor() %></td>
				<td><%= m.getEditora() %></td>
				<td><%= m.getVolume() %></td>
				<td><%= m.getDt_lancamento() %></td>
				<td><%= m.getStatus() %></td>
				<td><%= m.getLink() %></td>
			</tr>
			<% } %>
		</table>
	<% } %>
</body>
</html>