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
				<li class="dropdown" style="padding-left: 10px;"><Strong>Bienvenid<c:if
							test="${paciente.paramSexo.id==6}">o</c:if><c:if
							test="${paciente.paramSexo.id==7}">a</c:if> ${paciente.nombres}
				</Strong></li>
				<li class="dropdown"><c:if test="${empty mensajesNuevos}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
					</c:if> <c:if test="${not empty mensajesNuevos}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i><span
							class="badge">${mensajesNuevos.size()}</span>
						</a>
					</c:if>
					<ul class="dropdown-menu dropdown-messages">
						<c:if test="${not empty mensajesNuevos}">
							<c:forEach items="${mensajesNuevos}" var="mensajeNuevo">
								<li><a
									href="${contextPath}/paciente/enviarMensaje?rutPodologo=${mensajeNuevo.emisorRut}">
										<strong></strong> <span class="pull-right text-muted"><em>${mensajeNuevo.fecha}</em>
									</span>${mensajeNuevo.cuerpo}
								</a></li>
							</c:forEach>
						</c:if>
						 
						<li><a class="text-center"
							href="${contextPath}/paciente/misMensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> </li>
					<li class="dropdown"><c:if test="${empty notificaciones}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
					</c:if> <c:if test="${not empty notificaciones}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i><span
							class="badge">${notificaciones.size()}</span>
						</a>
					</c:if>
					<ul class="dropdown-menu dropdown-messages">
						<c:if test="${not empty notificaciones}">
							<c:forEach items="${notificaciones}" var="notificacion">
								<li><a
									href="${notificacion.url}&idNotificacion=${notificacion.id}">
										<strong></strong> <span class="pull-right text-muted"><em>${notificacion.fecha}</em>
									</span> ${notificacion.titulo}
								</a></li>
							</c:forEach>
						</c:if>

						<li><a class="text-center"
							href="${contextPath}/paciente/misNotificaciones"> <strong>Ver
									todas las notificaciones</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>

				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="${contextPath}/paciente/modificarDatos"><i
								class="fa fa-gear fa-fw"></i>Mis Datos</a></li>
						<li class="divider"></li>
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
								<c:choose>
									<c:when test="${empty paciente.foto}">
										<img src="${contextPath}/resources/img/sinfoto.jpg"
											class="img-responsive" style="width: 200px;">
									</c:when>
									<c:otherwise>
										<img src="data:image/png;base64,${paciente.foto}"
											class="img-responsive" style="width: 200px;">
									</c:otherwise>
								</c:choose>
								<br>
								<div align="center">
									<span class="text-info text-center"><b>${paciente.nombres}
											${paciente.apellidos}</b></span> <span class="text-info">Paciente</span>
								</div>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath}/paciente/index"><i
								class="fa fa-home fa-fw"></i>Inicio</a></li>
						<li><a href="${contextPath}/paciente/quizPatologia"><i
								class="fa fa-edit fa-fw"></i>Solicitar Atenci�n</a></li>
						<li><a href="${contextPath}/paciente/misSolicitudes"><i
								class="fa fa-calendar-plus-o fa-fw"></i>Solicitudes de Atenci�n</a></li>
						<li><a href="${contextPath}/paciente/misAtenciones"><i
								class="fa fa-user-md fa-fw"></i> Mis atenciones</a></li>
						<li><a href="${contextPath}/paciente/misMensajes"><i
								class="fa fa-comments fa-fw"></i> Mensajes</a></li>
						<li><a href="${contextPath}/paciente/misEvaluaciones"><i
								class="fa fa-star-half-o fa-fw"></i> Evaluaciones a
								Profesionales</a></li>
						<li><a href="${contextPath}/paciente/modificarDatos"><i
								class="fa fa-gear fa-fw"></i> Modificar mis datos</a></li>
						<li><a href="${contextPath}/paciente/cuestionarios"><i
								class="fa fa-question-circle fa-fw"></i> <Strong> Descuentos</Strong></a></li>
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
							<strong>Informaci�n</strong>
						</div>
						<br>
						<div align="center">
							<p
								style="text-align: justify; padding-left: 10px; padding-right: 10px;">Bienvenido
								a las encuestas de <strong>CUIDO MIS PIES</strong>, en esta secci�n usted podra
								responder preguntas para ayudar a futuras mejoras del sistema y
								con esto, obtener cupones de descuento para sus futuras
								atenciones.</p>
							<br>
						</div>
					</div>
				</div>
			</div>
			<c:if
				test="${fn:length(cuestionariosPendientes) == 0 && fn:length(cuestionariosRealizados) == 0}">
				<div class="alert alert-warning" align="center">
					<Strong>Usted no posee encuestas disponibles para
						responder</Strong>
				</div>
			</c:if>

			<c:if test="${not empty cuestionariosPendientes}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Mis Encuestas Pendientes <span class="badge">${cuestionariosPendientes.size()}</span></strong>
							</div>
							<br>
							<div align="center">
								<p
									style="text-align: justify; padding-left: 10px; padding-right: 10px;">A
									continuaci�n se detallan todas las encuestas del sistema
									pendientes que puede responder y obtener descuentos en
									atenciones.</p>
								<br>
							</div>
							<div class="table-responsive">

								<table class="table table-bordered">
									<tr>
										<th><div align="center">Nombre</div></th>
										<th><div align="center">Descuento %</div></th>
										<th><div align="center">Fecha</div></th>
										<th><div align="center">Acci�n</div></th>


									</tr>
									<c:forEach items="${cuestionariosPendientes}"
										var="cuestionarioPendiente">
										<tr>
											<td align="center">${cuestionarioPendiente.cuestionario.titulo}</td>
											<td align="center">${cuestionarioPendiente.cuestionario.descuento}</td>
											<td align="center">${cuestionarioPendiente.cuestionario.fecha}</td>
											<td align="center"><button
													onclick="location.href='${contextPath}/paciente/verCuestionario?id=${cuestionarioPendiente.id}'"
													type="submit" class="btn btn-primary">Responder</button></td>


										</tr>
									</c:forEach>
								</table>
							</div>

						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty cuestionariosRealizados}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Mis Encuestas Respondidas <span class="badge">${cuestionariosRealizados.size()}</span></strong>
							</div>
							<br>
							<div align="center">
								<p
									style="text-align: justify; padding-left: 10px; padding-right: 10px;">A
									continuaci�n se detallan todas las encuestas del sistema
									realizadas.</p>
								<br>
							</div>
							<div class="table-responsive">
								<table class="table table-bordered">
									<tr>
										<th><div align="center">Nombre</div></th>
										<th><div align="center">Estado Descuento</div></th>
										<th><div align="center">Descuento %</div></th>
										<th><div align="center">Fecha</div></th>
										<th><div align="center">Acci�n</div></th>


									</tr>
									<c:forEach items="${cuestionariosRealizados}"
										var="cuestionarioRealizado">
										<tr>
											<td align="center">${cuestionarioRealizado.cuestionario.titulo}</td>
											<td align="center">${cuestionarioRealizado.paramEstadoDescuento.valor}</td>
											<td align="center">${cuestionarioRealizado.cuestionario.descuento}</td>
											<td align="center">${cuestionarioRealizado.cuestionario.fecha}</td>
											<td align="center"><button
													onclick="location.href='${contextPath}/paciente/verCuestionario?id=${cuestionarioRealizado.id}'"
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
