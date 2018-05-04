<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link href="${contextPath}/resources/css/evaluacion/css/style.css"
	rel="stylesheet">

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
								class="fa fa-calendar-plus-o fa-fw"></i>Solicitudes de Atención</a></li>
						<li><a href="${contextPath}/paciente/misAtenciones"><i
								class="fa fa-user-md fa-fw"></i><Strong> Mis atenciones</Strong></a></li>
						<li><a href="${contextPath}/paciente/misMensajes"><i
								class="fa fa-comments fa-fw"></i> Mensajes</a></li>
						<li><a href="${contextPath}/paciente/misEvaluaciones"><i
								class="fa fa-star-half-o fa-fw"></i> Evaluaciones a
								Profesionales</a></li>
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

					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>Detalle de Atención Fecha
								${atencionForm.agenda.horario.fecha}
								${atencionForm.agenda.horario.hora} -
								${atencionForm.agenda.horario.horaFin}</strong>
						</div>


						<table class="table">
							<thead>
								<tr>
									<th style="background: #FAFAFA;"><div align="center">ANTES</div></th>
									<th style="background: #FAFAFA;"><div align="center">DESPUES</div></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><div align="center">
											<img class="img-responsive"
												src="data:image/png;base64,${atencionForm.agenda.fotoPiePath}"
												style="width: 200px; height: 200px;">
										</div></td>
									<td><div align="center">
											<img class="img-responsive"
												src="data:image/png;base64,${atencionForm.foto}"
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
											<img class="img-responsive"
												src="data:image/png;base64,${atencionForm.agenda.fotoViajePath}"
												style="width: 600px; height: 400px;">
										</div></td>

								</tr>
							</tbody>
						</table>
						<br>
						<form action="guardarAtencionParaEvaluar" method="post">
							<table class="table">

								<tr>
									<th class="bg-info">Patología tratada</th>
									<td style="background: #FAFAFA;">${atencionForm.agenda.patologia.nombre}</td>
								</tr>
								<tr>
									<th class="bg-info">Nombre Paciente</th>
									<td style="background: #FAFAFA;">${atencionForm.agenda.paciente.nombres}
										${solicitudAtencion.paciente.apellidos}</td>
								</tr>
								<tr>
									<th class="bg-info">Diabético</th>
									<c:if test="${not empty atencion.agenda.paciente.diabetico}">
										<td style="background: #FAFAFA;">SI</td>
									</c:if>
									<c:if test="${empty atencion.agenda.paciente.diabetico}">
										<td style="background: #FAFAFA;">NO</td>
									</c:if>

								</tr>
								<tr>
									<th class="bg-info">Ubicación</th>
									<td style="background: #FAFAFA;">${atencionForm.agenda.paciente.ubicacion.nombre}</td>
								</tr>
								<tr>
									<th class="bg-info">Tarifa por Kilómetro</th>
									<td style="background: #FAFAFA;">$<fmt:formatNumber
											value="${atencionForm.agenda.presupuesto.tarifaKM}"
											type="currency" pattern="#,##0" /></td>
								</tr>
								<tr>
									<th class="bg-info">Cantidad de Kilómetro</th>
									<td style="background: #FAFAFA;">${atencionForm.agenda.presupuesto.cantidadKM}</td>
								</tr>
								<tr>
									<th class="bg-info">Monto Viaje</th>
									<td style="background: #FAFAFA;">$<fmt:formatNumber
											value="${atencionForm.agenda.presupuesto.viajePodologo}"
											type="currency" pattern="#,##0" /></td>
								</tr>
								<tr>
									<th class="bg-info">Monto Patología</th>
									<td style="background: #FAFAFA;">$<fmt:formatNumber
											value="${atencionForm.agenda.patologia.costo}"
											type="currency" pattern="#,##0" /></td>
								</tr>
								<tr>
									<th class="bg-success" colspan="2"><div>
											Total por la Atención: $
											<fmt:formatNumber
												value="${atencionForm.agenda.presupuesto.total}"
												type="currency" pattern="#,##0" />
										</div></th>

								</tr>
								<tr>
									<th>Diagnóstico y/o Procedimiento</th>
									<td style="background: #FAFAFA;"><textarea
											class="form-control" name="diagnostico" readonly="readonly">${atencionForm.diagnostico}</textarea></td>
								</tr>
								<tr>
									<th>Indicaciones</th>
									<td style="background: #FAFAFA;"><textarea
											class="form-control" name="indicaciones" readonly="readonly">${atencionForm.indicaciones}</textarea></td>
								</tr>
								<tr>
									<td style="background: #FAFAFA;"><strong>Evaluación
											Podólogo</strong></td>
									<td align="left"><span class="rating"> <input
											type="radio" class="rating-input" id="evaluacionStar-5"
											name="evaluacionStar" value="5"> <label
											for="evaluacionStar-5" class="rating-star"></label> <input
											type="radio" value="4" class="rating-input"
											id="evaluacionStar-4" name="evaluacionStar"> <label
											for="evaluacionStar-4" class="rating-star"></label> <input
											type="radio" class="rating-input" value="3"
											id="evaluacionStar-3" name="evaluacionStar"> <label
											for="evaluacionStar-3" class="rating-star"></label> <input
											type="radio" class="rating-input" value="2"
											id="evaluacionStar-2" name="evaluacionStar"> <label
											for="evaluacionStar-2" class="rating-star"></label> <input
											type="radio" class="rating-input" id="evaluacionStar-1"
											name="evaluacionStar" value="1"> <label
											for="evaluacionStar-1" class="rating-star"></label>
									</span></td>

								</tr>
								<tr>
									<td style="background: #FAFAFA;"><strong>Comentario
											de la Atención </strong></td>
									<td style="background: #FAFAFA;" align="left"><textarea
											class="form-control" name="comentario">${atencionForm.agenda.comentarioPodologo}</textarea></td>
								</tr>

								<tr>
									<td align="right" colspan="2"><button type="button"
											class="btn btn-primary" data-toggle="modal"
											data-target="#exampleModal">Guardar Atención</button></td>

								</tr>

							</table>



							<!-- Modal Aceptar-->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title" id="exampleModalLabel">
												<strong>Confirmación de datos de Atención</strong>
											</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<p style="text-align: justify;">
												<b>Esta seguro que desea guardar la evaluaciòn del
													profesional?</b>
											</p>


										</div>
										<div class="modal-footer" align="left">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Cancelar</button>
											<button type="submit" class="btn btn-primary"
												name="respuesta" value="si">Si, estoy seguro</button>
										</div>
									</div>
								</div>
							</div>
							<!-- Modal Aceptar-->
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>



	<!-- /#page-wrapper -->


	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<script src="${contextPath}/resources/js/jquery-ui.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>
</body>

</html>
