<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"import="model.UserInfo" import="javax.servlet.http.HttpSession"%>
    
<%
HttpSession sessao = request.getSession();
UserInfo userInfo = (UserInfo)sessao.getAttribute("LOGADO"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wiki Mang�s</title>
</head>
<body>
	<jsp:include page="menuVisitante.jsp"></jsp:include>
	<form method="post">
		<div>
			<label for="titulo">T�tulo</label>
			<input type="text" id="titulo" name="titulo" value="pesquisar">
			<button type="submit" name="cmd" value="pesquisar">Pesquisar</button>
		</div>
	</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>T�tulo</th>
				<th>G�nero</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Volume(s)</th>
				<th>Data de Lan�amento</th>
				<th>Status</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>