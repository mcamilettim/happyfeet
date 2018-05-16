<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es" ng-app="myAppChart">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="apple-touch-icon" sizes="57x57"
	href="${contextPath}/resources/icon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="${contextPath}/resources/icon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${contextPath}/resources/icon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="${contextPath}/resources/icon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${contextPath}/resources/icon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="${contextPath}/resources/icon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="${contextPath}/resources/icon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${contextPath}/resources/icon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="${contextPath}/resources/icon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="${contextPath}/resources/icon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="${contextPath}/resources/icon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${contextPath}/resources/icon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="${contextPath}/resources/icon/favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<title>Cuido mis pies</title>

<!-- Bootstrap Core CSS -->
<link
	href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${contextPath}/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${contextPath}/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style>
 #chartDiv {
	height:100%;
	width:100%;
	min-height:150px;
}
.zc-ref {
	display:none;
}</style>
</head>

<body data-ng-controller="UserCtrlChart">

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Navegación</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/paciente/index"><img
					src="${contextPath}/resources/img/logo1.png" class="img-responsive"
					style="width: 120px;"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown" style="padding-left: 10px;"><Strong>Bienvenido</Strong></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="<c:url value="/logout" />"><i
								class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<img src="${contextPath}/resources/img/sinfoto.jpg"
									class="img-responsive" style="width: 200px;"> <br>
								<div align="center">
									<span class="text-info">Administrador</span>
								</div>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath}/admin/index"><i
								class="fa fa-home fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/admin/solicitudes"><i
								class="fa fa-envelope fa-fw"></i>Solicitudes de Atención</a></li>
						<li><a href="${contextPath}/admin/pacientes"><i
								class="fa fa-wheelchair fa-fw"></i> Pacientes</a></li>
						<li><a href="${contextPath}/admin/podologos"><i
								class="fa fa-user-md fa-fw"></i>Podólogos</a></li>
						<li><a href="${contextPath}/admin/patologias"><i
								class="fa fa-ambulance fa-fw"></i>Patologías</a></li>
						<li><a href="${contextPath}/admin/cuestionarios"><i
								class="fa fa-question-circle fa-fw"></i> <Strong>Descuentos</Strong></a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>


		<!-- Page Content -->
		<div id="page-wrapper">
			<br>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>${cuestionario.titulo}</strong>
						</div>
						<br>
						<div class="col-lg-9">
							<p
								style="text-align: justify; padding-left: 10px; padding-right: 10px;">${cuestionario.detalle}</p>
							<br>
						</div>
						<br>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col"><div align="right">Pregunta</div></th>
									<th><div align="center"></div></th>
									<th><div align="center">SI</div></th>
									<th><div align="center">NO</div></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row"><div align="center">1</div></th>
									<td>${cuestionario.preguntas.pregunta_uno}</td>
									<th><div align="center">{{cuestionario.total_respuesta_uno_si}}</div></th>
									<th><div align="center">{{cuestionario.total_respuesta_uno_no}}</div></th>
								</tr>
								<tr>
									<th scope="row"><div align="center">2</div></th>
									<td>${cuestionario.preguntas.pregunta_dos}</td>
									<th><div align="center">{{cuestionario.total_respuesta_dos_si}}</div></th>
									<th><div align="center">{{cuestionario.total_respuesta_dos_no}}</div></th>
								</tr>
								<tr>
									<th scope="row"><div align="center">3</div></th>
									<td>${cuestionario.preguntas.pregunta_tres}</td>
									<th><div align="center">{{cuestionario.total_respuesta_tres_si}}</div></th>
									<th><div align="center">{{cuestionario.total_respuesta_tres_no}}</div></th>
								</tr>
							</tbody>
						</table>
						<br>
						 
							<div id="chartDiv"></div>
							<br>
						 
						<br>
					</div>
				</div>
			</div>



		</div>
	</div>
	<!-- jQuery -->
	<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>

	<script src="https://cdn.zingchart.com/zingchart.min.js"></script>
	<script type="text/javascript"
		src="${contextPath}/resources/js/angular/angular.js"></script>
	<script type="text/javascript"
		src="${contextPath}/resources/js/angular/controller/controllerChart.js"></script>
</body>

</html>
