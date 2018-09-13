<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Wikis Mangás</title>
	<!-- Load an icon library -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Init Bootstrap 4 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<!-- Iniciar css estilo -->
	<link rel="stylesheet" type="text/css" href="style.css">
	
</head>

<body>
	<!-- The sidebar -->
	<div class="sidebar">
	  	<a href="#clients"><i class="fa fa-fw fa-user" ></i></a>
	  	<a href="#home"><i class="fa fa-fw fa-home"></i></a>
	  	<a href="#bookmark"><i class="fa fa-fw fa-bookmark"></i></a>
	</div>
	<div class="main">
		<div class="container welcome"> Welcome</div>
		<div class="carrousel jumbotron">
			<div id="demo" class="carousel slide" data-ride="carousel">
	
		 		<!-- Indicators -->
				<ul class="carousel-indicators">
			    	<li data-target="#demo" data-slide-to="0" class="active"></li>
			    	<li data-target="#demo" data-slide-to="1"></li>
			    	<li data-target="#demo" data-slide-to="2"></li>
			  	</ul>
		  
	 			<!-- The slideshow -->
		  		<div class="carousel-inner">
		    		<div class="carousel-item active">
		      			<img src="./images/crab.jpg" alt="Crab">
			    	</div>
			    	<div class="carousel-item">
			      		<img src="./images/hand.jpg" alt="Hand">
			    	</div>
			    	<div class="carousel-item">
			      		<img src="./images/vaca.jpg" alt="Vaca">
			    	</div>
			    	<div class="carousel-item">
						<div>
							<span class="fa fa-fw fa-home "></span>
						</div>
			    	</div>
		  		</div>
	  
			  	<!-- Left and right controls -->
			 	<a class="carousel-control-prev" href="#demo" data-slide="prev">
			    	<span class="carousel-control-prev-icon" style="background-color: #000000"></span>
			  	</a>
			  	<a class="carousel-control-next" href="#demo" data-slide="next">
			    	<span class="carousel-control-next-icon" style="background-color: #000000">></span>
			  	</a>
			  	
			</div>
		</div>
	</div>
</body>
</html>