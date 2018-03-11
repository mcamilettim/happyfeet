<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	<%@page session="true"%>
    <title>Cuido mis pies - Login</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top top-nav-collapse">
			  <div class="container">
			  	<div class="col-md-12">
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="#"><img src="/happyFeetWeb/resources/img/logo1.png" class="img-responsive" style="width: 140px; margin-top: -16px;"></a>
				    </div>
				    <div class="collapse navbar-collapse navbar-right" id="myNavbar">
				      <ul class="nav navbar-nav">
				        <li class=""><a href="#banner">Inicio</a></li>
				        <li class="active"><a href="#service">Servicios</a></li>
				        <li class=""><a href="#about">Nuestro equipo</a></li>
				        <li class=""><a href="#testimonial">Opiniones</a></li>
				        <li class=""><a href="#contact">Contáctanos</a></li>
				      </ul>
				    </div>
				</div>
			  </div>
			</nav>
<div class="container">

    <form method="POST" action="${contextPath}/login" name="loginForm" class="form-signin">
        <h2 class="form-heading">Log in</h2>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${mensaje}</span><br>
            <a href="${contextPath}/solicitud">Solicitar cuenta de podologo</a>           
            <h4>Email</h4><input name="email" type="email" class="form-control" 
                   autofocus="true"/>            
            <h4>Password</h4><input name="password" type="password" class="form-control"/>
            <span>${error}</span>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            <a href="${contextPath}/registrarPaciente">Registrarme</a>|<a href="${contextPath}/forgot">Olvidé mi contraseña</a>
        </div>
    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
