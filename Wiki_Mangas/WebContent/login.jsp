<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Wiki_Mangá</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel ="stylesheet" href ="WebContent/Resources/Bootstrap/css/estilo.css">
  <link rel="stylesheet" type="text/css" href="./style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body id = "body-login">
	<div class="container" id ="paglogin">
    <div class="jumbotron">
      <h3 class ="text-center"><strong>Wiki_Mangá</strong></h3>      
      <form id = "form-login" action="./login" method="POST">
        <div class="form-group">
          <label for="login">Login</label>
          <input type="login" class="form-control" id="inputLogin" aria-describedby="login" placeholder="">
        </div>
        <div class="form-group">
          <label for="senha">Senha</label>
          <input type="password" class="form-control" id="inputSenha" placeholder="">
        </div>
        <button type="submit" class="btn btn-primary">Entrar</button>
      </form>    
    </div>     
  </div>
</body>
</html>