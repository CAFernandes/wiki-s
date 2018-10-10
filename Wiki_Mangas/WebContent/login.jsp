<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Wiki_Mangá</title>
  
  <meta charset="utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  
</head>

<body id ="body" style="height:850px">

	<div class="container" id ="paglogin">
  	<div class="jumbotron">
    	<h3 class ="text-center"><strong>Wiki_Mangá</strong></h3>      
	 	<form id="form" method="post" action="./login">
	  		<div class="form-group">
	    		<label for="login">Login</label>
	   			<input name="inputLogin" type="text" class="form-control" id="inputlogin" aria-describedby="login" placeholder="">
	  		</div>
	  		<div class="form-group">
	    		<label for="senha">Senha</label>
	    		<input name="inputSenha" type="password" class="form-control" id="inputsenha" placeholder="">
	  		</div>
	    	<button type="submit" class="btn btn-primary">Entrar</button>
	 	</form>
    
	    <style>
	   		#paglogin {
	    		width: 550px;
			    padding: 100px;
			    font-family:cursive, monospace, sans-serif; 
		    }
		    #form {
			    color: white;
				background:#f0eff3;
				padding: 26px;
				border-radius: 5px;
				-moz-border-radius: 5px;
				-webkit-border-radius: 5px;
			    background: #000 url("https://images7.alphacoders.com/881/881074.jpg") top center no-repeat;
			}
		    #body {
			    color: white;
				background: gray;
				padding: 26px;
			    background: #000 url("https://images4.alphacoders.com/904/904104.jpg") top center no-repeat;
			}
		    .jumbotron{
			    background: #f0eff3;
			    box-shadow: 3px 3px 0 #450;
			   	background: #000 url("https://images7.alphacoders.com/881/881074.jpg") top center no-repeat;
		    }
	    </style>
	  </div>     
	</div>
</body>
</html>