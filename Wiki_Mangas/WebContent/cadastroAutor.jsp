<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body id="body-cadastro" style="height: 760px">
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top: 80px">
		<h2 style="color: white">
			<b>Cadastro de Autor</b>
		</h2>
	</div>
	<form id="form-cadastro" method="POST" action="./CadastroAutor">
		<div class="form-group col-md-6">
			<label for="inputNome" style="color: white">Nome</label> 
			<input type="text" class="form-control" id="inputNome">
		</div>
		<button id="submit" type="button" class="btn btn-primary btn-default">Cancelar</button>
		<button id="submit" type="button" class="btn btn-primary btn-default">Cadastrar</button>
	</form>
</body>
</html>