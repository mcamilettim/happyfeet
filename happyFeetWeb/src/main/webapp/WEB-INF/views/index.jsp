<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cuido Mis Pies</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	<link rel="apple-touch-icon" sizes="57x57" href="${contextPath}/resources/icon/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${contextPath}/resources/icon/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="${contextPath}/resources/icon/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/resources/icon/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="${contextPath}/resources/icon/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="${contextPath}/resources/icon/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="${contextPath}/resources/icon/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="${contextPath}/resources/icon/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${contextPath}/resources/icon/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="${contextPath}/resources/icon/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${contextPath}/resources/icon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${contextPath}/resources/icon/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${contextPath}/resources/icon/favicon-16x16.png">
	<link rel="manifest" href="/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">	
    <!-- =======================================================
        Theme Name: Medilab
        Theme URL: https://bootstrapmade.com/medilab-free-medical-bootstrap-theme/
        Author: BootstrapMade.com
        Author URL: https://bootstrapmade.com
    ======================================================= -->
  </head>
    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
  	<!--banner-->
	<section id="banner" class="banner">
		<div class="bg-color">
			<nav class="navbar navbar-default navbar-fixed-top">
			  <div class="container">
			  	<div class="col-md-12">
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="#"><img src="${contextPath}/resources/img/logo2.png" class="img-responsive" style="width: 140px;"></a>
				    </div>
				    <div class="collapse navbar-collapse navbar-right" id="myNavbar">
				      <ul class="nav navbar-nav">
				        <li class="active"><a href="#banner">Inicio</a></li>
				        <li class=""><a href="#service">Servicios</a></li>
				        <li class=""><a href="#about">Nuestro equipo</a></li>
				      </ul>
				    </div>
				</div>
			  </div>
			</nav>
			<div class="container">
				<div class="row">
					<div class="banner-info">
						<div class="banner-logo text-center">
							<img src="${contextPath}/resources/img/logo2.png" class="img-responsive" style="width: 300px; margin-top: -16px;">
						</div>
						<div class="banner-text text-center">
							<h1 class="white">Podolog&iacute;a en tu casa</h1>
							<p>Reg&iacute;strate y pide un presupuesto para poder atenderte lo m&aacute;s pronto posible.</p>
							<a href="${contextPath}/login" class="btn btn-appoint">Entra aqu&iacute;!</a>
						</div>
						<div class="overlay-detail text-center">
			               <a href="#service"><i class="fa fa-angle-down"></i></a>
			             </div>		
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ banner-->
	<!--service-->
	<section id="service" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-4">
					<h2 class="ser-title">Servicio Confiable</h2>
					<hr class="botm-line">
					<p>Somos profesionales con mas de 10 a&ntilde;os de experiencia en el cuidado de tus pies, especializados en ayudar a pacientes en estado critico o con pie diab&eacute;tico. </p>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-stethoscope"></i>
						</div>
						<div class="icon-info">
							<h4>Atenci&oacute;n personalizada</h4>
							<p>Elige a tu pod&oacute;logo favorito.</p>
						</div>
					</div>
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-ambulance"></i>
						</div>
						<div class="icon-info">
							<h4>Servicio a tu casa</h4>
							<p>Incluye tu confirmaci&oacute;n de direcci&oacute;n para que el profesional pueda llega a tu hogar.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-user-md"></i>
						</div>
						<div class="icon-info">
							<h4>Pide tu presupuesto.</h4>
							<p>Sabes cuanto debes pagar antes de que llegue tu pod&oacute;logo.</p>
						</div>
					</div>
					<div class="service-info">
						<div class="icon">
							<i class="fa fa-medkit"></i>
						</div>
						<div class="icon-info">
							<h4>Servicios de alta calidad</h4>
							<p>Nos encargamos de que solucionen tus problemas con tus pies hasta el final.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ service-->
	<!--cta-->
	<section id="cta-1" class="section-padding">
		<div class="container">
			<div class="row">
			</div>
		</div>
	</section>
	<!--cta-->
	<!--about-->
	<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-4 col-xs-12">
			        <div class="section-title">
			          <h2 class="head-title lg-line">Nuestro Equipo en <br>CUIDO MIS PIES</h2>
			          <hr class="botm-line">
			          <p class="sec-para">Los pod&oacute;logos que estan registrados en la plataforma est&aacute;n titulados, con su respectivo n&uacute;mero en el Ministerio de Salud vigente y con trabajan con material esterilizado.</p>
			        </div>
			    </div>
			    <div class="col-md-9 col-sm-8 col-xs-12">
			       <div style="visibility: visible;" class="col-sm-9 more-features-box">
			          <div class="more-features-box-text">
			            <div class="more-features-box-text-icon"> <i class="fa fa-angle-right" aria-hidden="true"></i> </div>
			            <div class="more-features-box-text-description">
				            <h3>Cada Pod&oacute;logo registrado en el Ministerio de Salud de Chile</h3>
				            <p>Para su seguridad, contamos con un equipo titulado de la carrera de Podolog&iacute;a Cl&iacute;nica, los cuales se encuentran validados por el Ministerio de Salud, por lo que sus pies estar&aacute;n en las mejores manos.</p>
				        </div>
			          </div>
			          <div class="more-features-box-text">
			            <div class="more-features-box-text-icon"> <i class="fa fa-angle-right" aria-hidden="true"></i> </div>
			            <div class="more-features-box-text-description">
				            <h3>Trabajamos con Material Esterilizado</h3>
				            <p>Nos preocupamos por la limpieza de nuestro material de trabajo para evitar el contagio entre pacientes, es por esto que usamos maquinas para esterilizar material y dejarlo 100% libre de infecciones.</p>
				        </div>
                        </div>
			        </div>
			    </div>
			</div>
		</div>
	</section>
	<!--/ about-->
	<!--doctor team-->
	<section id="doctor-team" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="ser-title">Conoce a nuestros Pod&oacute;logos!</h2>
					<hr class="botm-line">
				</div>
				<div class="col-md-3 col-sm-3 col-xs-6">
			      <div class="thumbnail"> 
			      	<img src="${contextPath}/resources/img/foto_1.jpeg" alt="..." class="team-img">
			        <div class="caption">
			          <h3>Paola Mellado</h3>
			          <p>Pod&oacute;loga Cl&iacute;nica</p>
			          <ul class="list-inline">
			            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
			            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
			            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			          </ul>
			        </div>
			      </div>
			    </div>
			    <div class="col-md-3 col-sm-3 col-xs-6">
			      <div class="thumbnail"> 
			      	<img src="${contextPath}/resources/img/foto_2.jpeg" alt="..." class="team-img">
			        <div class="caption">
			          <h3>Paola Mellado</h3>
			             <p>Pod&oacute;loga Cl&iacute;nica</p>
			          <ul class="list-inline">
			            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
			            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
			            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			          </ul>
			        </div>
			      </div>
			    </div>
			    <div class="col-md-3 col-sm-3 col-xs-6">
			      <div class="thumbnail"> 
			      	<img src="${contextPath}/resources/img/foto_3.jpeg" alt="..." class="team-img">
			        <div class="caption">
			         <h3>Paola Mellado</h3>
			          <p>Pod&oacute;loga Cl&iacute;nica</p>
			          <ul class="list-inline">
			            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
			            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
			            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			          </ul>
			        </div>
			      </div>
			    </div>
			    <div class="col-md-3 col-sm-3 col-xs-6">
			      <div class="thumbnail"> 
			      	<img src="${contextPath}/resources/img/foto_4.jpeg" alt="..." class="team-img">
			        <div class="caption">
			           <h3>Paola Mellado</h3>
			          <p>Pod&oacute;loga Cl&iacute;nica</p>
			          <ul class="list-inline">
			            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
			            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
			            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			          </ul>
			        </div>
			      </div>
			    </div>
			</div>
		</div>
	</section>
	<!--/ doctor team-->
 
	<!--footer-->
	<footer id="footer">
		<div class="top-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4 marb20">
							<div class="ftr-tle">
								<h4 class="white no-padding">Acerca de Nosotros</h4>
							</div>
							<div class="info-sec">
								<p>Somos un grupo de Podólogos Clínicos comprometidos con el cuidado de Tus Pies.</p>
							</div>
					</div>
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">Links directos</h4>
						</div>
						<div class="info-sec">
							<ul class="quick-info">
								<li><a href="index.html"><i class="fa fa-circle"></i>Iniciar Sesion</a></li>
								<li><a href="#service"><i class="fa fa-circle"></i>Registrarme como Paciente</a></li>
								<li><a href="#contact"><i class="fa fa-circle"></i>Registrarme como Podólogo</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">Sigue nuestras Redes Sociales</h4>
						</div>
						<div class="info-sec">
							<ul class="social-icon">
								<li class="bglight-blue"><i class="fa fa-facebook"></i></li>
								<li class="bgred"><i class="fa fa-google-plus"></i></li>
								<li class="bgdark-blue"><i class="fa fa-linkedin"></i></li>
								<li class="bglight-blue"><i class="fa fa-twitter"></i></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-line">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">

					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--/ footer-->
    
    <script src="${contextPath}/resources/js/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/jquery.easing.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/js/custom.js"></script>
    <script src="${contextPath}/resources/contactform/contactform.js"></script>
  </body>
</html>