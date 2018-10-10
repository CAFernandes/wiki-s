<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserInfo" import="javax.servlet.http.HttpSession"%>
    
<%
HttpSession sessao = request.getSession();
UserInfo userInfo = (UserInfo)sessao.getAttribute("LOGADO"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<title>Wiki de Mangás</title>

<style type="text/css">

 #navegacao{
 
 font-family:cursive, monospace, sans-serif;

 }

#body{

text-align: center;
font-family:cursive, monospace, sans-serif;
padding: 25px;
background: #000 url("https://images7.alphacoders.com/562/562640.jpg") no-repeat center bottom;
background-size: cover;

}

h2{
color: white;
text-align: center;
}

#form{
padding: 20px;
color: white;
}


</style>
</head>

<body id ="body" style="height:760px">
	<% if(userInfo != null && userInfo.isLogado()){ %>
		<jsp:include page="menuAdmin.jsp"></jsp:include>
		<div class="container-fluid" style="margin-top:80px">
			<h3><b>Você está logado como administrador</b></h3>
		</div>		
	<% }else{ %>
		<jsp:include page="menuVisitante.jsp"></jsp:include>
		<div class="container-fluid" style="margin-top:80px">
			<h3><b>Bem Vindo Visitante</b></h3>
		</div>
	<% }%>

<div class="container-fluid" style="margin-top:80px">
</div>

<h2><b>Alterar Autor</b></h2>

<form id="form">
 <div class="form-group col-md-6">
      <label for="inputNome">Nome</label>
      <input type="text" class="form-control" id="inputNome">
    </div>
  </div>



<button id="submit" type="button" class="btn btn-primary btn-default" >Cancelar</button>
<button id="submit" type="button" class="btn btn-primary btn-default" >Cadastrar</button>

</form>


</body>
</html>