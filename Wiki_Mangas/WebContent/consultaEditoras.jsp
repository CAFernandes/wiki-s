<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.UserInfo"
	import="javax.servlet.http.HttpSession"%>

<%
	HttpSession sessao = request.getSession();
	UserInfo userInfo = (UserInfo) sessao.getAttribute("LOGADO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Wiki_Mangá</title>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<style>
#navegacao {
	font-family: cursive, monospace, sans-serif;
}

#body {
	text-align: center;
	font-family: cursive, monospace, sans-serif;
	padding: 25px;
	background: url("https://images.alphacoders.com/380/38003.jpg")
		no-repeat center bottom;
	background-size: cover;
}

h2 {
	color: black;
	padding: 15px;
	bottom: 20px;
}
</style>



</head>

<body id="body" style="height: 1030px">
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
		<h2>
			<b>Lista de Editores</b>
		</h2>
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