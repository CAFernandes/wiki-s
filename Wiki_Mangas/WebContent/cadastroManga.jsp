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
color: white;
text-align: center;
font-size: 20px;
font-weight: bold;
text-align: center;

}


</style>

</head>

<body id ="body" style="height:1000px">
	<% if(userInfo != null && userInfo.isLogado()){ %>
		<jsp:include page="menuAdmin.jsp"></jsp:include>
		<div class="container-fluid" style="margin-top:80px">
			<h3><b>Você está logado como administrador</b></h3>
		</div>		
	<% }else{ %>
		<jsp:include page="menuVisitante.jsp"></jsp:include>
		<div class="container-fluid" style="margin-top:80px">
		</div>
	<% }%>

<div class="container-fluid" style="margin-top:80px">
</div>

<h2><b>Cadastro de Mangás</b></h2>



<form id="form">

  <div class="form-group">
    <div class="form-group col-md-6">
      <label for="inputTitulo">Título</label>
      <input type="text" class="form-control" id="inputTitulo">
    </div>
    
    <div class="form-group col-md-6">
      <label for="inputGenero">Gênero</label>
      <input type="text" class="form-control" id="inputGenero">
    </div>
  </div>
  
   <div class="form-group col-md-6">
      <label for="inputAutor">Autor</label>
      <select id="inputAutor" class="form-control">
        <option selected></option>
        <option>...</option>
      </select>
    </div>
  
  <div class="form-group col-md-6">
      <label for="inputEditora">Editora</label>
      <select id="inputEditora" class="form-control">
        <option selected></option>
        <option>...</option>
      </select>
    </div>
  
  
 <div class="form-group col-md-4">
  <label for="inputVolume">Volume</label>
  <select id="inputVolume" class="form-control">
  <option selected></option>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  </select>
 </div>
    
  <div class="form-group">
    <div class="form-group col-md-4">
      <label for="inputlancamento">Data de Lançamento</label>
      <input type="text" class="form-control" id="inputlancamento">
    </div>
    
    <div class="form-group col-md-4">
      <label for="inputState">Status</label>
      <select id="inputStatus" class="form-control">
        <option selected></option>
        <option>Em Andamento</option>
        <option>Completo</option>
        <option>Hiatus</option>
        <option>Abandonado</option>
      </select>
    </div>
    
    <div class="form-group col-md-6">
      <label for="inputLink">Link</label>
      <input type="text" class="form-control" id="inputlink">
    </div>
  </div>
  
  <button type="submit" class="btn btn-primary btn-default" >Cancelar</button>
  <button type="submit" class="btn btn-primary btn-default">Cadastrar</button>
  
</form>

</body>
</html>