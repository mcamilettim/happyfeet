<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
					<span class="sr-only">Navegación</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/paciente/index"><img
					src="${contextPath}/resources/img/logo1.png" class="img-responsive"
					style="width: 120px;"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown" style="padding-left: 10px;"><Strong>Bienvenid<c:if
							test="${paciente.paramSexo.id==6}">o</c:if> <c:if
							test="${paciente.paramSexo.id==7}">a</c:if> ${paciente.nombres}
				</Strong></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#"> <strong></strong> <span
								class="pull-right text-muted"> <em>Ahora</em>
							</span> Sin mensajes nuevos.
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center"
							href="${contextPath}/paciente/vermensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-messages --></li>

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
								class="fa fa-home fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/paciente/quizPatologia"><i
								class="fa fa-edit fa-fw"></i>Solicitar Atención</a></li>
						<li><a href="${contextPath}/paciente/misSolicitudes"><i
								class="fa fa-calendar-plus-o fa-fw"></i><Strong>Solicitudes
									de Atención</Strong></a></li>
						<li><a href="${contextPath}/paciente/misAtenciones"><i
								class="fa fa-user-md fa-fw"></i> Mis atenciones</a></li>
						<li><a href="${contextPath}/paciente/misMensajes"><i
								class="fa fa-comments fa-fw"></i> Mensajes</a></li>
						<li><a href="${contextPath}/paciente/calificar"><i
								class="fa fa-star-half-o fa-fw"></i> Calificar a profesional</a></li>
						<li><a href="${contextPath}/paciente/modificarDatos"><i
								class="fa fa-gear fa-fw"></i> Modificar mis datos</a></li>
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

					<c:if test="${mensaje != null}">
						<div class="alert alert-success alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">×</button>
							${mensaje}
						</div>
					</c:if>
					<c:if test="${mensajeError != null}">
						<div class="alert alert-danger alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">×</button>
							${mensajeError}
						</div>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">

					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>Detalle de Solicitud
								${solicitudAtencion.fechaSolicitud}</strong>
						</div>


						<table class="table">
							<thead>
								<tr>
									<th style="background: #FAFAFA;"><div align="center">Foto
											Enviada por Paciente</div></th>
									<th style="background: #FAFAFA;"><div align="center">Foto
											referencial Patología ${solicitudAtencion.patologia.nombre}</div></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><div align="center">
											<img class="img-responsive"
												src="data:image/png;base64,${solicitudAtencion.fotoPiePath}"
												style="width: 200px; height: 200px;">
										</div></td>
									<td><div align="center">
											<img class="img-responsive"
												src="data:image/png;base64,${solicitudAtencion.patologia.foto}"
												style="width: 200px; height: 200px;">
										</div></td>
								</tr>
							</tbody>
						</table>

						<table class="table">
							<thead>
								<tr>
									<th colspan="2" style="background: #FAFAFA;"><div
											align="center">
											Ruta Recomendada <img class="img-responsive"
												src="${contextPath}/resources/img/googleMaps.png"
												style="width: 25px; height: 25px;">
										</div></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="2"><div align="center">
											<c:choose>
												<c:when test="${empty solicitudAtencion.fotoViajePath}">
													<img src="${contextPath}/resources/img/working.png"
														class="img-responsive"
														style="width: 200px; height: 200px;">
												</c:when>
												<c:otherwise>
													<img
														src="data:image/png;base64,${solicitudAtencion.fotoViajePath}"
														class="img-responsive"
														style="width: 500px; height: 300px;">

												</c:otherwise>
											</c:choose>
										</div></td>

								</tr>
							</tbody>
						</table>
						<br>

						<table class="table">
							<tr>
								<th class="bg-info">Estado</th>
								<c:if
									test="${solicitudAtencion.paramEstadoSolicitudAtencion.valor eq 'Pendiente'}">
									<td style="background: #FAFAFA;"><button type="button"
											class="btn btn-warning">PENDIENTE</button></td>
								</c:if>
								<c:if
									test="${solicitudAtencion.paramEstadoSolicitudAtencion.valor eq 'Rechazada'}">
									<td style="background: #FAFAFA;"><button type="button"
											class="btn btn-danger">RECHAZADA</button></td>
								</c:if>
								<c:if
									test="${solicitudAtencion.paramEstadoSolicitudAtencion.valor eq 'Aceptada'}">
									<td style="background: #FAFAFA;"><button type="button"
											class="btn btn-success">ACEPTADA</button></td>
								</c:if>

							</tr>
							<tr>
								<th class="bg-info">Horario Solicitado</th>
								<td style="background: #FAFAFA;">${solicitudAtencion.horario.fecha}
									${solicitudAtencion.horario.hora} -
									${solicitudAtencion.horario.horaFin}</td>
							</tr>
							<tr>
								<th class="bg-info">Diagnóstico</th>
								<td style="background: #FAFAFA;">${solicitudAtencion.patologia.nombre}</td>
							</tr>
							<tr>
								<th class="bg-info">Nombre Podólogo</th>
								<td style="background: #FAFAFA;">${solicitudAtencion.podologo.nombres}
									${solicitudAtencion.podologo.apellidos}</td>
							</tr>
							<tr>
								<th class="bg-info">Diabético</th>
								<c:if test="${not empty solicitudAtencion.paciente.diabetico}">
									<td style="background: #FAFAFA;">SI</td>
								</c:if>
								<c:if test="${empty solicitudAtencion.paciente.diabetico}">
									<td style="background: #FAFAFA;">NO</td>
								</c:if>

							</tr>
							<tr>
								<th class="bg-info">Ubicación</th>
								<td style="background: #FAFAFA;">${solicitudAtencion.paciente.ubicacion.nombre}</td>
							</tr>
							<tr>
								<th class="bg-info">Tarifa por Kilómetro</th>
								<td style="background: #FAFAFA;">$<fmt:formatNumber
										value="${solicitudAtencion.presupuesto.tarifaKM}"
										type="currency" pattern="#,##0" /></td>
							</tr>
							<tr>
								<th class="bg-info">Cantidad de Kilómetro</th>
								<td style="background: #FAFAFA;">${solicitudAtencion.presupuesto.cantidadKM}</td>
							</tr>
							<tr>
								<th class="bg-info">Monto Viaje</th>
								<td style="background: #FAFAFA;">$<fmt:formatNumber
										value="${solicitudAtencion.presupuesto.viajePodologo}"
										type="currency" pattern="#,##0" /></td>
							</tr>
							<tr>
								<th class="bg-info">Monto Patología</th>
								<td style="background: #FAFAFA;">$<fmt:formatNumber
										value="${solicitudAtencion.patologia.costo}" type="currency"
										pattern="#,##0" /></td>
							</tr>

							<tr>
								<td style="background: #FAFAFA;"><strong> Mi
										Comentario</strong></td>
								<td style="background: #FAFAFA;" align="left"><textarea
										class="form-control" readonly="readonly">${solicitudAtencion.comentarioPaciente}</textarea></td>
							</tr>
							<c:if test="${solicitudAtencion.comentarioPodologo != null}">
								<tr>
									<td style="background: #FAFAFA;"><strong>
											Comentario Podólogo</strong></td>
									<td style="background: #FAFAFA;" align="left"><textarea
											class="form-control" readonly="readonly">${solicitudAtencion.comentarioPodologo}</textarea></td>
								</tr>
							</c:if>
							<tr>
								<th class="bg-success" colspan="2"><div align="center">
										Total por la Atención: $
										<fmt:formatNumber
											value="${solicitudAtencion.presupuesto.total}"
											type="currency" pattern="#,##0" />
									</div></th>
							</tr>
							<c:if
								test="${solicitudAtencion.paramEstadoSolicitudAtencion.valor eq 'Pendiente'}">
								<tr>
									<th colspan="2">No te preocupes, el profesional responderá
										tu solicitud en breve, sólo ten un poco más de paciecia.</th>
								</tr>
							</c:if>
							<c:if
								test="${solicitudAtencion.paramEstadoSolicitudAtencion.valor eq 'Rechazada'}">
								<tr>
									<th colspan="2">El profesional ha rechazado tu solicitud, sus motivos están en el comentario.</th>
								</tr>
							</c:if>
						</table>

					</div>
					<br>
				</div>

				<div>

					<div></div>
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
</body>

</html>
