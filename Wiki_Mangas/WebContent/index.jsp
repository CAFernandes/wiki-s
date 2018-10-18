<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.User" import="javax.servlet.http.HttpSession"%>

<%
	HttpSession sessao = request.getSession();
	User userInfo = (User) sessao.getAttribute("LOGADO");
%>
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

<body id="body-index" style="height: 850px;">
	<%
		if (userInfo != null && userInfo.isLogado()) {
	%>
	<jsp:include page="menuAdmin.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top: 80px">
		<h3>
			<b>Você está logado como administrador</b>
		</h3>
	</div>
	<%
		} else {
	%>
	<jsp:include page="menuVisitante.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top: 80px">
		<h3>
			<b>Bem Vindo Visitante</b>
		</h3>
	</div>
	<%
		}
	%>

	<div id="slidercaption" class="carousel slide" data-ride="carousel">

		<ol class="carousel-indicators">
			<li data-target="#slidercaption" data-slide-to="0" class="active"></li>
			<li data-target="#slidercaption" data-slide-to="1"></li>
			<li data-target="#slidercaption" data-slide-to="2"></li>
			<li data-target="#slidercaption" data-slide-to="3"></li>
		</ol>

		<div class="carousel-inner" role="listbox">
			<div class="carousel-item active">
				<img class="d-block img-fluid"
					src="https://images5.alphacoders.com/446/446872.jpg" alt="Slide1">
				<div class="carousel-caption d-none d-md-block">
					<h3>Bleach</h3>
					<p>Tóquio é assombrada por ghouls misteriosos que devoram
						humanos. Ichigo Kurosaki um garoto de 15 anos que tem uma estranha
						capacidade de ver, tocar e falar com espíritos de pessoas mortas.</p>
				</div>
			</div>

			<div class="carousel-item">
				<img class="d-block img-fluid"
					src="https://images7.alphacoders.com/567/567918.png" alt="Slide2">
				<div class="carousel-caption d-none d-md-block">
					<h3>Attack on Titan</h3>
					<p>A humanidade quase foi dizimada por seres humanoides
						gigantes, conhecidos como Titãs. Seres dotados de pouca
						inteligência que parecem devorar humanos por puro prazer</p>
				</div>
			</div>

			<div class="carousel-item">
				<img class="d-block img-fluid"
					src="https://images2.alphacoders.com/120/120600.png" alt="Slide3">
				<div class="carousel-caption d-none d-md-block">
					<h3>Naruto</h3>
					<p>Guiado pelo espírito demoníaco dentro dele, o órfão Naruto
						aprende a controlar seus poderes como um ninja em uma série de
						aventuras.</p>
				</div>
			</div>

			<div class="carousel-item">
				<img class="d-block img-fluid"
					src="https://images3.alphacoders.com/135/135559.jpg" alt="Slide3">
				<div class="carousel-caption d-none d-md-block">
					<h3>Touhou</h3>
					<p>Quando sua aldeia foi destruída há cinco anos, apenas Shino
						Inuzuka, Sosuke Inukawa, e a garota Hamaji, criada como irmã
						deles, sobreviveram.</p>
				</div>
			</div>


		</div>

		<a class="carousel-control-prev" href="#slidercaption" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#slidercaption" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>

	</div>

</body>
</html>