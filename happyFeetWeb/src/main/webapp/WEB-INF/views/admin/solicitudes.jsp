<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html lang="es">

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

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Navegaci�n</span> <span class="icon-bar"></span>
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
								class="fa fa-sign-out fa-fw"></i> Cerrar Sesi�n</a></li>
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
								class="fa fa-envelope fa-fw"></i><Strong>Solicitudes</Strong></a></li>
						<li><a href="${contextPath}/admin/pacientes"><i
								class="fa fa-wheelchair fa-fw"></i> Pacientes</a></li>
						<li><a href="${contextPath}/admin/podologos"><i
								class="fa fa-user-md fa-fw"></i>Pod�logos</a></li>
						<li><a href="${contextPath}/admin/patologias"><i
								class="fa fa-ambulance fa-fw"></i>Patolog�as</a></li>
						<li><a href="${contextPath}/admin/cuestionarios"><i
								class="fa fa-question-circle fa-fw"></i> Descuentos</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>


		<!-- Page Content -->
		<div id="page-wrapper">
			<br>

			<c:if
				test="${fn:length(solicitudesPendientes) == 0 && fn:length(solicitudesRespondidas) == 0}">
				<div class="alert alert-warning" align="center">
					<Strong>No existen solicitudes en el Sistema</Strong>
				</div>
			</c:if>
			 
			<c:if test="${not empty solicitudesPendientes}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Solicitudes Pendiendes <span class="badge">
										${solicitudesPendientes.size()}</span></strong>
							</div>
							<br>
							 
							<div class="table-responsive">

								<table class="table table-bordered">
									<tr>
										<th><div align="center">RUT</div></th>
										<th><div align="center">ID MINSAL</div></th>
										<th><div align="center">Acci�n</div></th>
									</tr>
									<c:forEach items="${solicitudesPendientes}"
										var="solicitudPendiente">
										<tr>
											<td align="center">${solicitudPendiente.rutPodologo}</td>
											<td align="center">${solicitudPendiente.idMinSal}</td>
											<td align="center"><button
													onclick="location.href='${contextPath}/admin/verCuestionario?id=${cuestionarioPaciente.id}'"
													type="submit" class="btn btn-primary">Ver</button></td>


										</tr>
									</c:forEach>
								</table>
							</div>

						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty solicitudesRespondidas}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Solicitudes Respondidas<span class="badge">
										${solicitudesRespondidas.size()}</span></strong>
							</div>
							<br>
							 
							<div class="table-responsive">

								<table class="table table-bordered">
									<tr>
										<th><div align="center">RUT</div></th>
										<th><div align="center">ID MINSAL</div></th>
										<th><div align="center">Acci�n</div></th>
									</tr>
									<c:forEach items="${solicitudesRespondidas}"
										var="solicitudRespondida">
										<tr>
											<td align="center">${solicitudRespondida.rutPodologo}</td>
											<td align="center">${solicitudRespondida.idMinSal}</td>
											<td align="center"><button
													onclick="location.href='${contextPath}/admin/verCuestionario?id=${cuestionarioPodologo.id}'"
													type="submit" class="btn btn-primary">Ver</button></td>


										</tr>
									</c:forEach>
								</table>
							</div>

						</div>
					</div>
				</div>
			</c:if>
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
</body>

</html>
