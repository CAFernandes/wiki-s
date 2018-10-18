<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body id="body-cadastro" style="height: 1030px">
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top: 80px">
		<h2>
			<b>Alterar Mangá</b>
		</h2>
	</div>
	<form id="form-cadastro">
		<div class="form-group">
			<div class="form-group col-md-6">
				<label for="inputTitulo">Título</label> <input type="text"
					class="form-control" id="inputTitulo">
			</div>

			<div class="form-group col-md-6">
				<label for="inputGenero">Gênero</label> <input type="text"
					class="form-control" id="inputGenero">
			</div>
		</div>

		<div class="form-group col-md-6">
			<label for="inputAutor">Autor</label> <select id="inputAutor"
				class="form-control">
				<option selected></option>
				<option>...</option>
			</select>
		</div>

		<div class="form-group col-md-6">
			<label for="inputEditora">Editora</label> <select id="inputEditora"
				class="form-control">
				<option selected></option>
				<option>...</option>
			</select>
		</div>


		<div class="form-group col-md-4">
			<label for="inputVolume">Volume</label> <select id="inputVolume"
				class="form-control">
				<option selected></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
			</select>
		</div>

		<div class="form-group">
			<div class="form-group col-md-4">
				<label for="inputlancamento">Data de Lançamento</label> <input
					type="text" class="form-control" id="inputlancamento">
			</div>

			<div class="form-group col-md-4">
				<label for="inputState">Status</label> <select id="inputStatus"
					class="form-control">
					<option selected></option>
					<option>Em Andamento</option>
					<option>Completo</option>
					<option>Hiatus</option>
					<option>Abandonado</option>
				</select>
			</div>

			<div class="form-group col-md-6">
				<label for="inputLink">Link</label> <input type="text"
					class="form-control" id="inputlink">
			</div>
		</div>

		<button type="submit" class="btn btn-primary btn-default">Cancelar</button>
		<button type="submit" class="btn btn-primary btn-default">Cadastrar</button>

	</form>

</body>
</html>