<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" id ="paglogin">
  <div class="jumbotron">
    <h3 class ="text-center"><strong>Wiki_S</strong></h3>      
    <form>
  <div class="form-group">
    <label for="login">Login</label>
    <input type="login" class="form-control" id="inputlogin" aria-describedby="login" placeholder="">
  </div>
  <div class="form-group">
    <label for="senha">Senha</label>
    <input type="senha" class="form-control" id="inputsenha" placeholder="">
  </div>
    <button type="submit" class="btn btn-primary">Entrar</button>
</form>
    
    <style>
    
    #paglogin {
    width: 550px;
    padding: 100px;
    }
    
    </style>
    
  </div>     
</div>
</body>
</html>