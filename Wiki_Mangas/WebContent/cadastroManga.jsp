<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="model.Manga, model.Autor, model.Editora, javax.servlet.http.HttpSession, java.util.List"%>
<%
	HttpSession sessao = request.getSession();
	sessao.setAttribute("opc", 1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="./style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<title>Wiki Mangás</title>
</head>
<body id="body-cadastro" style="height: 1000px">
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top: 80px">
		<h2 style="color: white">
			<b>Cadastro de Mangás</b>
		</h2>
	</div>

	<form id="form-cadastro" method="POST" action="./MangaController">
		<div class="row">
			<div class="container-fluid col-sm-6">
				<div class="form-group">
					<div class="form-group">
						<label for="inputTitulo">Título</label> <input
							name="titulo" type="text" class="form-control" id="inputTitulo">
					</div>
					<div class="form-group">
						<label for="inputGenero">Gênero</label> <input
							name="genero" type="text" class="form-control" id="inputGenero">
					</div>
				</div>
				<jsp:include page="./MangaController"></jsp:include>
				<div class="form-group">
					<label for="inputAutor">Autor</label> <select
						name="autor" id="inputAutor" class="form-control">
						<%
							List<Autor> listA = (List<Autor>) sessao.getAttribute("AUTORES");
							for (Autor a : listA) {
								if (a.getId() == 1) {
						%>
						<option select value="<%=a.getId()%>"><%=a.getNome()%></option>
						<%
							} else {
						%>
						<option value="<%=a.getId()%>"><%=a.getNome()%></option>
						<%
							}
							}
						%>
					</select>
					<div class="form-group">
						<label for="inputEditora">Editora</label> <select
							name="editora" id="inputEditora" class="form-control">
							<%
								List<Editora> listE = (List<Editora>) sessao.getAttribute("EDITORAS");
								for (Editora e : listE) {
									if (e.getId() == 1) {
							%>
							<option select value="<%=e.getId()%>"><%=e.getEditora()%></option>
							<%
								} else {
							%>
							<option value="<%=e.getId()%>"><%=e.getEditora()%></option>
							<%
								}
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<div class="form-group">
							<label for="inputlancamento">Data de
								Lançamento</label> <input name="data" type="date" class="form-control"
								id="inputlancamento">
						</div>
					</div>
				</div>
			</div>

			<div class="container-fluid col-sm-6">

				<div class="form-group">
					<label for="inputState">Status</label> <select
						name="status" id="inputStatus" class="form-control">
						<option selected></option>
						<option>Em Andamento</option>
						<option>Completo</option>
						<option>Hiatus</option>
						<option>Abandonado</option>
					</select>
				</div>

				<div class="form-group">
					<label for="inputLink">Link</label> <input name="link" type="url"
						class="form-control" id="inputlink">
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary btn-default">Cadastrar</button>
	</form>

</body>
</html>
