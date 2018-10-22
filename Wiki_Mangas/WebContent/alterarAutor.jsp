<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.User, javax.servlet.http.HttpSession"%>

<%
	HttpSession sessao = request.getSession();
	sessao.setAttribute("opc", 3);
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

<body id="body-alterar">
	<jsp:include page="menuAdmin.jsp"></jsp:include>

	<div class="container-fluid" style="margin-top: 80px">
		<h2>
			<b>Alterar Autor</b>
		</h2>
	</div>
	<%if(sessao.getAttribute("msg") != null){ %>
	<div class="col-lg-12">
		<h3 class="alert alert-primary"><%=sessao.getAttribute("msg") %></h3>
	</div>
	<% sessao.removeAttribute("msg");
	} %>
	<form id="form">
		<div class="form-group col-md-6">
			<label for="inputNome"><b>Nome</b></label> <input type="text"
				class="form-control" id="inputNome">
		</div>

		<button id="submit" type="button" class="btn btn-primary btn-default">Cadastrar</button>
	</form>

</body>
</html>