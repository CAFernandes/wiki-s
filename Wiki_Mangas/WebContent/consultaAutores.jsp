<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.User" import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.List" import="model.Autor" %>
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
	<!-- Nesta parte do código eu implemento uma regra de acesso onde eu crio
	o menu de acordo com o acesso ao site  -->
	<% if (userInfo != null && userInfo.isLogado()) { %>
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<% } else { %>
	<jsp:include page="menuVisitante.jsp"></jsp:include>
	<% } %>
	<!-- Até aqui -->
	<div class="container-fluid" style="margin-top: 100px">
		<h2> Lista de Autores </h2>
	</div>
	<!-- Nesta sessão eu válido se existe uma mensagem a ser exibida e a exibo -->
	<%if(sessao.getAttribute("msg") != null){ %>
	<div class="col-lg-12 alert">
		<h3 class="alert alert-primary"><%=sessao.getAttribute("msg") %></h3>
	</div>
	<!-- Depois de exibir eu removo a mensagem da sessão -->
	<% sessao.removeAttribute("msg");
	} %>
	<form action="./AutorController" method="POST">
		<div class="form-group col-md-8 text-center input-group">
			<div class="input-group-btn col-md-10 text-center">
				<input type="text" class="form-control" id="nome" name="nome"
					placeholder="Pesquisar por Nome">
				<button type="submit" name="cmd" class="btn btn-primary btn-default"
					placeholder="Pesquisar">Pesquisar</button>
			</div>
		</div>
		<table class="table table-striped ">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Autor(a)</th>
					<!-- Aqui eu válido o acesso para disponibilizar ações relacionadas ao autores -->
					<%if (userInfo != null && userInfo.isLogado()) {%>
					<th>Ações</th>
					<% } %>			
				</tr>
			</thead>
			<tbody>
				<!-- Aqui eu verifico se a minha lista está vazia, caso esteja vazia
				executo um doGet na servelet para listar os autores -->
				<% if(sessao.getAttribute("AUTORES") == null){ %>
				<jsp:include page="/AutorController"/>			
				<!-- nesta parte eu recupero a lista de autores e preencho elas na tela -->
				<% }
				List<Autor> list = (List<Autor>) sessao.getAttribute("AUTORES");
				for(Autor a : list){ %>
					<tr>
						<th><%=a.getId() %></th>
						<th><%=a.getNome() %></th>
						<!-- Aqui eu válido o acesso para disponibilizar ações relacionadas ao autores -->
						<%if (userInfo != null && userInfo.isLogado()) {%>
						<th><a href="./alterarAutor.jsp?id=<%=a.getId() %>">Editar</a></th>
						<% } %>			
					</tr>
				<% } %>
			</tbody>
		</table>
	</form>
</body>
</html>